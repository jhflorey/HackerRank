package util;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.*;

// javac -cp .:junit.jar GraphTest.java
// java -cp .:junit.jar:hamcrest-core.jar org.junit.runner.JUnitCore GraphTest

@RunWith(JUnit4.class)
public class GraphTest {

    public static Graph graph1;

    @BeforeClass
    public static void makeGraphs() {
        Graph g = graph1 = new Graph();
        g.addEdge("A", "B");
        g.addEdge("B", "C");
        g.addEdge("B", "D");
        g.addEdge("B", "A");
        g.addEdge("B", "E");
        g.addEdge("B", "F");
        g.addEdge("C", "A");
        g.addEdge("D", "C");
        g.addEdge("E", "B");
        g.addEdge("F", "B");
    }

    private void expectIteration(String answer, Iterator<String> it) {
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(' ').append(it.next());
        }
        assertEquals(answer, sb.substring(1));
    }

    @Test
    public void preOrderIterationOfIsolatedVertex() {
        expectIteration("Z", new PreOrderDFSIterator(graph1, "Z"));
    }

    @Test
    public void preOrderIterationFromA() {
        expectIteration("A B C D E F", new PreOrderDFSIterator(graph1, "A"));
    }

    @Test
    public void preOrderIterationFromB() {
        expectIteration("B C A D E F", new PreOrderDFSIterator(graph1, "B"));
    }

    @Test
    public void BreadthFirstIterationOfIsolatedVertex() {
        expectIteration("Z", new BreadthFirstIterator(graph1, "Z"));
    }

    @Test
    public void BreadthFirstIterationFromA() {
        expectIteration("A B C D E F", new BreadthFirstIterator(graph1, "A"));
    }

    @Test
    public void BreadthFirstIterationFromB() {
        expectIteration("B C D A E F", new BreadthFirstIterator(graph1, "B"));
    }
}