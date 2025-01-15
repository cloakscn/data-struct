import graph.Graph;

import java.util.ArrayList;

public class GraphDFS implements DFS {

    private Graph G;

    private boolean[] visited;

    private ArrayList<Integer> pre = new ArrayList<Integer>();
    private ArrayList<Integer> post = new ArrayList<Integer>();

    public GraphDFS() {}

    public GraphDFS(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];

        // 保证非连通图遍历不遗漏
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    @Override
    public void dfs(int v) {
        visited[v] = true;
        pre.add(v);
        for (int w : G.adj(v)) {
            if (!visited[w]) {
                dfs(w);
            }
        }
        post.add(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }
    public Iterable<Integer> post() {
        return post;
    }
}
