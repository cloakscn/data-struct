import java.util.ArrayList;
import java.util.Collections;

public class HamiltonLoop {
    private Graph G;

    private boolean[] visited;

    private int[] pre;

    private int end;
    public HamiltonLoop() {}

    public HamiltonLoop(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        pre = new int[G.V()];
        end = -1;
        // 保证非连通图遍历不遗漏
        dfs(0, 0, G.V());
    }

    private boolean dfs(int v, int parent, int left) {
        visited[v] = true;
        pre[v] = parent;
        left--;
        if (left == 0 && G.hasEdge(v, 0)) {
            end = v;
            return true;
        }
        for (int w : G.adj(v)) {
            if (!visited[w]) {
                if (dfs(w, v, left)) return true;
            }
        }
        visited[v] = false;
        return false;
    }

    public  ArrayList<Integer> result() {
        ArrayList<Integer> result = new ArrayList<>();
        if (end == -1) {
            return result;
        }
        int cur = end;
        while (cur != 0) {
            result.add(cur);
            cur = pre[cur];
        }
        result.add(0);
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        Graph graph = new AdjList("graph/src/sources/HamiltonLoop.txt");
        HamiltonLoop hamiltonLoop = new HamiltonLoop(graph);
        System.out.println(hamiltonLoop.result());
        Graph graph1 = new AdjList("graph/src/sources/HamiltonLoop1.txt");
        HamiltonLoop hamiltonLoop1 = new HamiltonLoop(graph1);
        System.out.println(hamiltonLoop1.result());
    }
}
