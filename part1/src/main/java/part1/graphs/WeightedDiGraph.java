package part1.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Directed Weighted Graph
 *
 * @author Artur Khalikov
 */
public class WeightedDiGraph {
    /**
     * Graph representation
     */
    private int[][] graph;
    /**
     * Number of vertices
     */
    private int size;

    public WeightedDiGraph(int size) {
        this.size = size;
        this.graph = new int[size+1][size+1];
    }

    public int size() {
        return size;
    }

    public List<Integer> adj(int v) {
        List<Integer> adj = new ArrayList();
        for (int i = 0; i < graph[v].length; i++)
            if (graph[v][i] > 0)
                adj.add(i);
        return adj;
    }

    public void addEdge(int v, int w, int weight) {
        graph[v][w] = weight;
    }

    public int weight(int v, int w) {
        return graph[v][w];
    }


    @Override
    public String toString() {
        String s = "";
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph[i].length; j++) {
                s += graph[i][j] + ((j == graph[i].length-1) ? "\n" : " ");
            }
        }
        return s;
    }
}