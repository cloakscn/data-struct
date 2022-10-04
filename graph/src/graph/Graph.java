package graph;

public interface Graph{

    void validateVertex(int v);

    int V();

    int E();

    void removeEdge(int v, int w);

    boolean hasEdge(int v, int w);

    Iterable<Integer> adj(int v);

    int degree(int v);
}
