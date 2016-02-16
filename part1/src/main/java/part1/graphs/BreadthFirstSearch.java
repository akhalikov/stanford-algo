package part1.graphs;

import org.junit.Test;

import java.util.*;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * Breath-First Iterator
 *
 * @author Artur Khalikov
 */
class BreadthFirstSearch {

    private Graph graph;
    private boolean explored[];
    private Map<Integer, Integer> edgeTo;
    private int start;

    public BreadthFirstSearch(Graph graph, int start) {
        this.graph = graph;
        this.start = start;
        explored = new boolean[graph.size()];
        edgeTo = new TreeMap();
        search(start);
    }

    public Iterable<Integer> pathTo(int v) {
        if (!graph.hasVertex(v)) return null;
        if (!hasPathTo(v)) return null;
        Deque<Integer> path = new LinkedList();
        for (int x = v; x != start; x = edgeTo.get(x))
            path.push(x);
        path.push(start);
        return path;
    }

    public boolean hasPathTo(int v) {
        return explored[v-1];
    }

    /**
     * BFS routine
     * @param start
     */
    private void search(int start) {
        Queue<Integer> queue = new LinkedList();
        explored[start-1] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            Integer v = queue.remove();
            for (Integer w: graph.adj(v)) {
                if (!explored[w-1]) {
                    explored[w-1] = true;
                    edgeTo.put(w, v);
                    queue.add(w);
                }
            }
        }
    }

    /**** TESTS ****/

    @Test
    public void test1() throws Exception {
        System.out.println("Test graph 1");
        DiGraph g = new DiGraph(4);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 1);
        g.addEdge(3, 4);

        System.out.println("Test starting from 1");
        BreadthFirstSearch bfs = new BreadthFirstSearch(g, 1);
        Iterable<Integer> path0 = bfs.pathTo(6);
        assertNull(path0);

        Iterable<Integer> path4 = bfs.pathTo(4);
        assertNotNull(path4);
        print(path4);

        Iterable<Integer> path3 = bfs.pathTo(3);
        assertNotNull(path3);
        print(path3);

        Iterable<Integer> path2 = bfs.pathTo(2);
        assertNotNull(path2);
        print(path2);
    }

    @Test
    public void test2() throws Exception {
        System.out.println("Test graph 2");
        DiGraph g = new DiGraph(6);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 6);
        g.addEdge(3, 4);
        g.addEdge(3, 5);

        BreadthFirstSearch bfs = new BreadthFirstSearch(g, 1);
        print(bfs.pathTo(5));
        print(bfs.pathTo(4));
        print(bfs.pathTo(6));
    }

    private void print(Iterable<Integer> vertices) {
        for (Integer v: vertices)
            System.out.print(v + " ");
        System.out.println();
    }
}
