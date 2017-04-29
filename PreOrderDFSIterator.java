package util;

import java.util.*;

public class PreOrderDFSIterator implements Iterator<String> {
    private Set<String> visited = new HashSet<String>();
    private Deque<Iterator<String>> stack = new LinkedList<Iterator<String>>();
    private Graph graph;
    private String next;

    public PreOrderDFSIterator(Graph g, String startingVertex) {
        this.stack.push(g.getNeighbors(startingVertex).iterator());
        this.graph = g;
        this.next = startingVertex;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasNext() {
        return this.next != null;
    }

    @Override
    public String next() {
        if (this.next == null) {
            throw new NoSuchElementException();
        }
        try {
            this.visited.add(this.next);
            return this.next;
        } finally {
            this.advance();
        }
    }

    private void advance() {
        Iterator<String> neighbors = this.stack.peek();
        do {
            while (!neighbors.hasNext()) {  // No more nodes -> back out a level
                this.stack.pop();
                if (this.stack.isEmpty()) { // All done!
                    this.next = null;
                    return;
                }
                neighbors = this.stack.peek();
            }

            this.next = neighbors.next();
        } while (this.visited.contains(this.next));
        this.stack.push(this.graph.getNeighbors(this.next).iterator());
    }
}