import graph.AdjList;
import graph.Graph;

import java.util.HashSet;

public class CutPoint {

    private Graph G;
    private boolean[] visited;
    private int[] ord;
    private int[] low;
    private int count;
    private HashSet<Integer> res;

    public CutPoint(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];

        res = new HashSet<>();
        ord = new int[G.V()];
        low = new int[G.V()];
        count = 0;

        for (int v = 0; v < G.V(); v++) {
            if (!visited[v]) {
                dfs(v, v);
            }
        }
    }

    private void dfs(int v, int parent) {
        visited[v] = true;
        ord[v] = count;
        low[v] = ord[v];
        count++;

        int child = 0;
        for (int w : G.adj(v)) {
            if (!visited[w]) {
                dfs(w, v);
                low[v] = Math.min(low[v], low[w]);
                if (v != parent && low[w] >= ord[v]) {
                    res.add(v);
                }
                // todo 根顶点判断
                child++;
                if (v == parent && child > 1) {
                    res.add(v);
                }
            } else if (w != parent) {
                low[v] = Math.min(low[v], low[w]);
            }
        }
    }

    public HashSet<Integer> result() {
        return res;
    }

    public static void main(String[] args) {
        Graph graph = new AdjList("graph/src/sources/GraphBFS.txt");
        CutPoint bridge = new CutPoint(graph);
        System.out.println(bridge.result());
    }

}
