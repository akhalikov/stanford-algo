package part1.graphs;

import part1.graphs.problems.Top5SCC;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Depth-First Ordering
 *
 * @author Artur Khalikov
 */
public class DepthFirstOrder {
    /**
     * Input graph
     */
    private Graph graph;
    /**
     * Array for tracking explored vertices
     */
    private boolean explored[];
    /**
     * Vertices in post order
     */
    private Queue<Integer> postOrder;
    /**
     * Vertices in reverse post order
     */
    private Deque<Integer> reversePostOrder;

    public DepthFirstOrder(Graph graph) {
        this.graph = graph;
        explored = new boolean[graph.size()+1];
        postOrder = new LinkedList();
        reversePostOrder = new LinkedList();
        for (int v = 1; v <= graph.size(); v++) {
            if (!explored[v])
                orderNonRecursively(v);
        }
    }

    /**
     * Non recursive Depth-First ordering
     * @param root
     */
    private void orderNonRecursively(int root) {
        Deque<Integer> stack = new LinkedList();
        stack.push(root);
        explored[root] = true;
        while (!stack.isEmpty()) {
            int v = stack.peek();
            Integer w = getUnexploredAdj(v);
            if (w != null) {
                explored[w] = true;
                stack.push(w);
            } else {
                postOrder.add(v);
                reversePostOrder.push(v);
                stack.pop();
            }
        }
    }

    /**
     * Recursive Depth-First ordering routine
     * @param v
     */
    private void order(int v) {
        explored[v] = true;
        for (Integer w: graph.adj(v)) {
            if (!explored[w])
                order(w);
        }
        postOrder.add(v);
        reversePostOrder.push(v);
    }

    private Integer getUnexploredAdj(int v) {
        for (Integer w: graph.adj(v)) {
            if (!explored[w])
                return w;
        }
        return null;
    }

    public Iterable<Integer> getPostOrder() {
        return postOrder;
    }

    public Iterable<Integer> getReversePostOrder() {
        return reversePostOrder;
    }

    /**** TEST ****/

    private static final String DATA_DIR = "data/";
    private static final String[] TESTS = {"scc0", "scc1", "scc2", "scc3", "scc4"};
    private static final int[][] EXPECTED_POST = {
            {4, 3, 5, 2, 8, 6, 9, 7, 1},
            {2, 3, 1, 8, 7, 6, 5, 4},
            {2, 3, 1, 5, 7, 8, 6, 4},
            {2, 5, 7, 8, 6, 4, 3, 1},
            {1, 4, 5, 2, 6, 3, 8, 11, 12, 10, 9, 7}
    };
    private static final int[][] EXPECTED_REVERSED_POST = {
            {1, 7, 9, 6, 8, 2, 5, 3, 4},
            {4, 5, 6, 7, 8, 1, 3, 2},
            {4, 6, 8, 7, 5, 1, 3, 2},
            {1, 3, 4, 6, 8, 7, 5, 2},
            {7, 9, 10, 12, 11, 8, 3, 6, 2, 5, 4, 1}
    };

    @Test
    public void test() throws Exception {
        for (int i=0; i < TESTS.length; i++) {
            String fileName = DATA_DIR + "scc" + i + ".txt";
            System.out.print("Testing: " + fileName);
            Graph graph = Top5SCC.readGraph(fileName);
            assertNotNull("graph is null", graph);

            Graph reverse = graph.reverse();
            DepthFirstOrder order = new DepthFirstOrder(reverse);
            assertTrue(equals(order.getPostOrder(), EXPECTED_POST[i]));
            assertTrue(equals(order.getReversePostOrder(), EXPECTED_REVERSED_POST[i]));
            System.out.println("...OK");
        }
    }

    private boolean equals(Iterable<Integer> iterable, int[] array) {
        int i = 0;
        for (int item: iterable) {
            if (item != array[i])
                return false;
            i++;
        }
        return true;
    }
}
