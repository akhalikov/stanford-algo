package part1.graphs.problems;

import part1.graphs.DepthFirstOrder;
import part1.graphs.DiGraph;
import part1.graphs.Graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * Assignment 4
 * Input: A directed graph
 * Output: Sizes of top 5 Strongly Connected Components
 *
 * @author: Artur Khalikov
 */
public class Top5SCC {

    private Graph graph;
    private boolean explored[];
    private int leader;
    private int[] sccSizes;

    public Top5SCC(Graph graph) {
        this.graph = graph;
        explored = new boolean[graph.size()+1];
        sccSizes = new int[graph.size()+1];

        Graph reverse = graph.reverse();
        DepthFirstOrder order = new DepthFirstOrder(reverse);
        for (int v: order.getReversePostOrder()) {
            if (!explored[v]) {
                leader = v;
                searchNonRecursively(v);
            }
        }
    }

    public static Graph readGraph(String fileName) {
        return readGraph(new File(fileName));
    }

    /**
     * Read directed graph from file
     * Example input:
     *
     * 3
     * 1 4
     * 2 8
     * 3 6
     *
     * @param file Input file
     */
    public static Graph readGraph(File file) {
        try {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));

                // number of vertices
                String line = reader.readLine();
                int vertices = Integer.parseInt(line);
                DiGraph g = new DiGraph(vertices);

                // reading vertices
                while ((line = reader.readLine()) != null) {
                    String[] split = line.split(" ");
                    Integer tail = Integer.valueOf(split[0]);
                    Integer head = Integer.valueOf(split[1]);
                    g.addEdge(tail, head);
                }

                return g;
            } finally {
                if (reader != null)
                    reader.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Non-recirsive DFS
     * @param root
     */
    private void searchNonRecursively(int root) {
        Deque<Integer> stack = new LinkedList();
        stack.push(root);
        sccSizes[leader]++;
        explored[root] = true;
        while (!stack.isEmpty()) {
            int v = stack.peek();
            Integer w = getUnexploredAdj(v);
            if (w != null) {
                explored[w] = true;
                sccSizes[leader]++;
                stack.push(w);
            } else {
                stack.pop();
            }
        }
    }

    /**
     * Recursive DFS
     * @param v
     */
    private void search(int v) {
        sccSizes[leader]++;
        explored[v] = true;
        for (int w: graph.adj(v)) {
            if (!explored[w])
                search(w);
        }
    }

    private Integer getUnexploredAdj(int v) {
        for (Integer w: graph.adj(v)) {
            if (!explored[w])
                return w;
        }
        return null;
    }

    public int[] getTop5SccSizes() {
        Arrays.sort(sccSizes);
        int[] res = new int[5];
        for (int i = 0; i < 5; i++)
            res[i] = sccSizes[sccSizes.length-i-1];
        return res;
    }

    public int[] getSccSizes() {
        return sccSizes;
    }
}

/***
 * Question
 *
Download the text file here. Zipped version here. (Right click and save link as)
The file contains the edges of a directed graph. Vertices are labeled as positive integers from 1 to 875714.
Every row indicates an edge, the vertex label in first column is the tail and the vertex label in second column is the
head (recall the graph is directed, and the edges are directed from the first column vertex to the second column vertex).
So for example, the 11th row looks liks : "2 47646".
This just means that the vertex with label 2 has an outgoing edge to the vertex with label 47646

Your task is to code up the algorithm from the video lectures for computing strongly connected components (SCCs),
and to run this algorithm on the given graph.

Output Format: You should output the sizes of the 5 largest SCCs in the given graph, in decreasing order of sizes,
separated by commas (avoid any spaces).
So if your algorithm computes the sizes of the five largest SCCs to be 500, 400, 300, 200 and 100, then your answer
should be "500,400,300,200,100". If your algorithm finds less than 5 SCCs, then write 0 for the remaining terms.
Thus, if your algorithm computes only 3 SCCs whose sizes are 400, 300, and 100, then your answer should be "400,300,100,0,0".

WARNING: This is the most challenging programming assignment of the course. Because of the size of the graph you may
have to manage memory carefully. The best way to do this depends on your programming language and environment,
and we strongly suggest that you exchange tips for doing this on the discussion forums.

 ***/
