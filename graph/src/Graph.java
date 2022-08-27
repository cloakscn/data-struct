public interface Graph<T> {

    void validateVertex(int v);

    int V();

    int E();

    boolean hasEdge(int v, int w);

    Iterable<T> adj(int v);

    int degree(int v);

    // 深度优先遍历
    void dfs(int v);
}
