import java.util.ArrayList;
import java.util.TreeSet;

public class CC {

    private Graph G;

    private int[] visited;

    private int CCCount = 0;

    public CC(Graph G) {
        this.G = G;
        visited = new int[G.V()];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = -1;
        }

        // 保证非连通图遍历不遗漏
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == -1) {
                dfs(i, CCCount++);
            }
        }
    }

    private void dfs(int v, int CCCount) {
        visited[v] = CCCount;
        for (int w : G.adj(v)) {
            if (visited[w] == -1) {
                dfs(w, CCCount);
            }
        }
    }

    public int count() {
        for(int item : visited) {
            System.out.print(item + "\t");
        }
        return CCCount;
    }

}
