import graph.AdjList;
import graph.Graph;

import java.util.ArrayList;

public class Bridge {

    private Graph G;
    private boolean[] visited;
    private int[] ord;
    private int[] low;
    private int count;
    private ArrayList<Edge> res;

    public Bridge(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];

        res = new ArrayList<>();
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

        for (int w : G.adj(v)) {
            if (!visited[w]) {
                dfs(w, v);
                low[v] = Math.min(low[v], low[w]);
                if (low[w] > ord[v]) {
                    res.add(new Edge(v, w));
                }
            } else if (w != parent) {
                low[v] = Math.min(low[v], low[w]);
            }
        }
    }

    public ArrayList<Edge> result() {
        return res;
    }

    public static void main(String[] args) {
        Graph graph = new AdjList("graph/src/sources/GraphBFS.txt");
        Bridge bridge = new Bridge(graph);
        System.out.println(bridge.result());
    }

}
