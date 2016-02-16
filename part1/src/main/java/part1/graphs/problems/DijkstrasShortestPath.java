package part1.graphs.problems;

import part1.graphs.WeightedDiGraph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.PriorityQueue;

/**
 * Dijkstra's Shortest Path problem
 *
 * TODO: implement your own Priority queue data structure
 *
 * @author Artur Khalikov
 */
public class DijkstrasShortestPath {
    /**
     * Input graph
     */
    private WeightedDiGraph graph;
    /**
     * Computed shortest path distances
     */
    private int[] dist;
    /**
     * Priority queue to
     */
    private PriorityQueue<VertexScore> pq;

    public static final int UNDEFINED_DEST = 1000000;

    public DijkstrasShortestPath(String fileName, int source) {
        WeightedDiGraph graph = readGraph(fileName);
        this.graph = graph;
        find(source);
    }

    public static void main(String[] args) {
        if (args.length == 0)
            throw new IllegalArgumentException("Path to input file expected");
        DijkstrasShortestPath sp = new DijkstrasShortestPath(args[0], 1);
        int[] vertices = {7,37,59,82,99,115,133,165,188,197};
        for (int v: vertices) {
            System.out.print(sp.getDist(v) + ",");
        }
    }

    private void find(int source) {
        dist = new int[graph.size()+1];
        pq = new PriorityQueue();
        // Init dist
        for (int v = 1; v <= graph.size(); v++)
            dist[v] = UNDEFINED_DEST;
        dist[source] = 0;
        // FizzBuzz loop
        pq.add(new VertexScore(source, 0));
        while (!pq.isEmpty())
            relax(pq.remove());
    }

    private void relax(VertexScore vs) {
        int v = vs.v;
        for (Integer w: graph.adj(v)) {
            if (dist[w] > dist[v] + graph.weight(v,  w)) {
                dist[w] = dist[v] + graph.weight(v,  w);
                VertexScore ws = new VertexScore(w, dist[w]);
                if (pq.contains(ws))
                    pq.remove(ws);
                pq.add(ws);
            }
        }
    }

    public static WeightedDiGraph readGraph(String fileName) {
        return readGraph(new File(fileName));
    }

    public static WeightedDiGraph readGraph(File file) {
        try {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));

                // number of vertices
                String line = reader.readLine();
                int vertices = Integer.parseInt(line);
                WeightedDiGraph g = new WeightedDiGraph(vertices);

                // reading vertices
                while ((line = reader.readLine()) != null) {
                    String[] split = line.split("\\t");
                    int u = Integer.parseInt(split[0]); // tail
                    for (int i = 1; i < split.length; i++) {
                        String[] vertex = split[i].split(",");
                        int v = Integer.parseInt(vertex[0]); // head
                        int w = Integer.parseInt(vertex[1]); // weight or length
                        g.addEdge(u, v, w);
                    }
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

    public int getDist(int v) {
        return dist[v];
    }

    public int[] getDist() {
        return dist;
    }

    /**
     * Class represents a vertex of a graph with distance
     */
    private static class VertexScore implements Comparable<VertexScore> {
        public int v;
        public int weight;

        private VertexScore(int v) {
            this.v = v;
        }

        private VertexScore(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(VertexScore o) {
            return weight - o.weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            VertexScore that = (VertexScore) o;

            if (v != that.v) return false;

            return true;
        }
    }
}

/**
 * In this programming problem you'll code up Dijkstra's shortest-path algorithm.
 * Download the text file here. (Right click and save link as).
 * The file contains an adjacency list representation of an undirected weighted graph with 200 vertices labeled 1 to 200.
 * Each row consists of the node tuples that are adjacent to that particular vertex along with the length of that edge.
 * For example, the 6th row has 6 as the first entry indicating that this row corresponds to the vertex labeled 6.
 * The next entry of this row "141,8200" indicates that there is an edge between vertex 6 and vertex 141 that has length 8200.
 * The rest of the pairs of this row indicate the other vertices adjacent to vertex 6 and the lengths of the corresponding edges.
 *
 * Your task is to run Dijkstra's shortest-path algorithm on this graph, using 1 (the first vertex) as the source vertex,
 * and to compute the shortest-path distances between 1 and every other vertex of the graph.
 * If there is no path between a vertex v and vertex 1, we'll define the shortest-path distance between 1 and v to be 1000000.
 *
 * You should report the shortest-path distances to the following ten vertices, in order: 7,37,59,82,99,115,133,165,188,197.
 * You should encode the distances as a comma-separated string of integers. So if you find that all ten of these vertices
 * except 115 are at distance 1000 away from vertex 1 and 115 is 2000 distance away,
 * then your answer should be 1000,1000,1000,1000,1000,2000,1000,1000,1000,1000.
 *
 * Remember the order of reporting DOES MATTER, and the string should be in the same order in which the above ten vertices
 * are given. Please type your answer in the space provided.
 *
 * IMPLEMENTATION NOTES: This graph is small enough that the straightforward O(mn) time implementation of Dijkstra's
 * algorithm should work fine.
 *
 * OPTIONAL: For those of you seeking an additional challenge, try implementing the heap-based version.
 * Note this requires a heap that supports deletions, and you'll probably need to maintain some kind of mapping
 * between vertices and their positions in the heap.
 *
 */
