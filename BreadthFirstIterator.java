package util;

import java.util.*;

public class BreadthFirstIterator implements Iterator<String> {
    private Set<String> visited = new HashSet<String>();
    private Queue<String> queue = new LinkedList<String>();
    private Graph graph;

    public BreadthFirstIterator(Graph g, String startingVertex) {
        this.graph = g;
        this.queue.add(startingVertex);
        this.visited.add(startingVertex);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasNext() {
        return !this.queue.isEmpty();
    }

    @Override
    public String next() {
        //removes from front of queue
        String next = queue.remove();
        for (String neighbor : this.graph.getNeighbors(next)) {
            if (!this.visited.contains(neighbor)) {
                this.queue.add(neighbor);
                this.visited.add(neighbor);
            }
        }
        return next;
    }
}