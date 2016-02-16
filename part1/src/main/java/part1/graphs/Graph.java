package part1.graphs;

import java.util.List;

/**
 * Graph interface
 *
 * @author Artur Khalikov
 */
public interface Graph {

    int size();

    Graph reverse();

    List<Integer> adj(int v);

    void addEdge(int u, int v);

    boolean hasVertex(int v);
}
