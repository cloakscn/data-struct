import graph.Graph;

public class CycleDetection {

    private Graph G;

    private boolean[] visited;

    private boolean hasCycle = false;

    public CycleDetection() {}

    public CycleDetection(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        // 保证非连通图遍历不遗漏
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                hasCycle = dfs(i, i) ? true : false;
                break;
            }
        }
    }

    /**
     * 从顶点 v 开始 判断是否有环
     * @param v
     * @param parent
     * @return
     */
    private boolean dfs(int v, int parent) {
        visited[v] = true;
        for (int w : G.adj(v)) {
            if (!visited[w]) {
                return dfs(w, v) ? true : false;
            } else if (w != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle() {
        return hasCycle;
    }

}
