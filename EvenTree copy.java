package algorithm.graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class EvenTree {
    // Alternatively, use a Multimap:
    // http://google-collections.googlecode.com/svn/trunk/javadoc/com/google/common/collect/Multimap.html
    private Map<String, List<String>> edges = new HashMap<String, List<String>>();

    public void addEdge(String src, String dest) {
        List<String> srcNeighbors = this.edges.get(src);
        if (srcNeighbors == null) {
            this.edges.put(src,
                    srcNeighbors = new ArrayList<String>()
            );
        }
        srcNeighbors.add(dest);
    }

    public String getSource(String dest){
        Iterator it = edges.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            List<String> list = (List<String>) pair.getValue();
            if(list.contains(dest))
                return pair.getKey() + "";
        }

        return "";
    }

    public int getNumEdges(String src) {
        List<String> srcNeighbours = this.edges.get(src);
        if (srcNeighbours == null) {
            return 0;
        }
        return srcNeighbours.size();
    }

    public int getNumChildren(String src) {
        List<String> srcNeighbours = this.edges.get(src);
        int num = 0;
        if (srcNeighbours == null)
            return 0;

        num += srcNeighbours.size();

        for (String s : srcNeighbours) {
            num += getNumChildren(s);
        }

        return num;
    }


    public void removeEdge(String src, String dest) {
        List<String> srcNeighbors = this.edges.get(src);
        srcNeighbors.remove(dest);

        if (srcNeighbors.size() == 0) {
            this.edges.remove(src);
        }
    }

    //BFS start point is s
    public void BFS(String startingVertex) {

        int count = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(startingVertex);
        visited.add(startingVertex);

        HashMap<String, String> hm = new HashMap<>();


        Iterator it = edges.entrySet().iterator();
        while (it.hasNext()) {
            if (queue.size() == 0)
                break;
            String next = queue.remove();

            // Get the number of children based on this current node.
            int numChild = getNumChildren(next);
            //System.out.print("At vertice: " + next + " : " + numChild + "\n");

            // Check if the number of children are even. If they are add the counter.
            if ((numChild & 1) != 0 && numChild != 0 && next != 1 + "") {
                count++;
                String source = getSource(next);
                removeEdge(source, next);
                //System.out.println("Edge removed: " + source + " " + next);
            }

            for (String neighbour : getNeighbors(next)) {
                if (!visited.contains(neighbour)) {
                    queue.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }

        System.out.println(count);

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it = edges.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            sb.append(pair.getKey());
            sb.append(" ");
            sb.append(pair.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }

    public Iterable<String> getNeighbors(String vertex) {
        List<String> neighbors = this.edges.get(vertex);
        if (neighbors == null) {
            return Collections.emptyList();
        } else {
            return Collections.unmodifiableList(neighbors);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));

        int noOfVerticies = sc.nextInt();
        int noOfEdges = sc.nextInt();

        EvenTree g = new EvenTree();

        for (int i = 0; i < noOfEdges; i++) {
            int end = sc.nextInt();
            int origin = sc.nextInt();
            g.addEdge(origin + "", end + "");
        }

        g.BFS("1");
    }
}