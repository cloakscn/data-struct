/**
 * 二分图检测
 */
public class BiPartitionDetection {

    private Graph G;

    private int[] visited;

    private boolean isBipartite = true;

    public BiPartitionDetection() {
    }

    public BiPartitionDetection(Graph G) {
        this.G = G;
        visited = new int[G.V()];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = -1;
        }

        // 保证非连通图遍历不遗漏
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == -1) {
                if (!dfs(i, 0)) {
                    isBipartite = false;
                    break;
                }
            }
        }
    }

    private boolean dfs(int v, int parent) {
        visited[v] = parent;
        for (int w : G.adj(v)) {
            if (visited[w] == -1) {
                return !dfs(w, 1 - visited[v]) ? false : true;
            } else if (visited[w] == visited[v]) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite() {
        return isBipartite;
    }
}
