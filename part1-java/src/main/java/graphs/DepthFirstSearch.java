package graphs;

import org.junit.Test;

import java.util.*;

import static junit.framework.Assert.assertNull;

/**
 * DeptFirstSearch algorithm
 *
 * @author: Artur Khalikov
 */
class DepthFirstSearch {

    private Graph graph;
    private int start;
    private boolean explored[];
    private Map<Integer, Integer> edgeTo;

    public DepthFirstSearch(Graph graph, int start) {
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
     * DFS recoursive routine
     * @param v Vertex
     */
    private void search(int v) {
        explored[v-1] = true;
        for (Integer w: graph.adj(v)) {
            if (!explored[w-1]) {
                edgeTo.put(w, v);
                search(w);
            }
        }
    }

    /***** TEST *****/

    @Test
    public void test1() throws Exception {
        Graph g = new DiGraph(4);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 1);
        g.addEdge(3, 4);

        System.out.println("Test starting from 1");
        DepthFirstSearch bfs = new DepthFirstSearch(g, 1);
        Iterable<Integer> path0 = bfs.pathTo(6);
        assertNull(path0);

        Iterable<Integer> path4 = bfs.pathTo(4);
        print(path4);
    }

    private void print(Iterable<Integer> vertices) {
        for (Integer v: vertices)
            System.out.print(v + " ");
        System.out.println();
    }
}
