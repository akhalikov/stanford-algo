package part1.graphs;

/**
 * Class representing a weighted edge of a graph
 *
 * @author Artur Khalikov
 */
public class Edge implements Comparable<Edge> {

    private int from;
    private int to;
    private int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return weight - o.getWeight();
    }

    @Override
    public String toString() {
        return from + "->" + to + "[" + weight + "]";
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
