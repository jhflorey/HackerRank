package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Graph {
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

    public Iterable<String> getNeighbors(String vertex) {
        List<String> neighbors = this.edges.get(vertex);
        if (neighbors == null) {
            return Collections.emptyList();
        } else {
            return Collections.unmodifiableList(neighbors);
        }
    }

    public String toString(){
        return edges.toString();
    }
}