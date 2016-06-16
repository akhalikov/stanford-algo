package graphs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * A representation of directed graph
 *
 * @author: Artur Khalikov
 */
public class DiGraph implements Graph {
    /**
     * Map of LinkedLists representing vertices and edges
     */
    private TreeMap<Integer, LinkedList<Integer>> graph;

    /**
     * Number of vertices
     */
    private int vertices = 0;

    /**
     * Number of edges
     */
    private int edges = 0;

    /**
     * Create empty directed graph
     * @param numberOfVertices
     */
    public DiGraph(int numberOfVertices) {
        this.vertices = numberOfVertices;
        initMap();
    }

    /**
     * Create directed graph from file
     *
     * Example input:
     *
     * 3
     * 1 4
     * 2 8
     * 3 6
     *
     * @param file Input file
     */
    public DiGraph(File file) {
        readFromFile(file);
    }

    /**
     * Add the edge v -> w to the graph
     * @param v tail
     * @param w head
     */
    @Override
    public void addEdge(int v, int w) {
        graph.get(v).add(w);
        edges++;
    }

    /**
     * Return number of vertices of the graph
     */
    @Override
    public int size() {
        return vertices;
    }

    /**
     * Return the reverse if the graph
     */
    @Override
    public DiGraph reverse() {
        DiGraph reverse = new DiGraph(vertices);
        for (Integer v: graph.keySet()) {
            for (Integer w: adj(v))
                reverse.addEdge(w, v);
        }
        return reverse;
    }

    /**
     * Return vertices adjacent (adj) to the given vertex
     */
    @Override
    public List<Integer> adj(int v) {
        if (!graph.containsKey(v))
            throw new IllegalArgumentException("v is not in Graph");
        return graph.get(v);
    }

    @Override
    public boolean hasVertex(int v) {
        return graph.containsKey(v);
    }

    public int getLastVertex() {
        return graph.lastKey();
    }

    public void print() {
        for (Integer v: graph.keySet()) {
            List<Integer> edges = graph.get(v);
            System.out.print(v + " ");
            for (Integer w: edges)
                System.out.print(w + " ");
            System.out.println();
        }
    }

    private void initMap() {
        graph = new TreeMap();
        for (int i = 0; i < vertices; i++) {
            Integer v = new Integer(i + 1);
            graph.put(v, new LinkedList());
        }
    }

    private void readFromFile(File file) {
        try {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));

                // number of vertices
                String line = reader.readLine();
                vertices = Integer.parseInt(line);
                initMap();

                // reading vertices
                while ((line = reader.readLine()) != null) {
                    String[] split = line.split(" ");
                    Integer tail = Integer.valueOf(split[0]);
                    Integer head = Integer.valueOf(split[1]);
                    addEdge(tail, head);
                }
            } finally {
                if (reader != null)
                    reader.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
