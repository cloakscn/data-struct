import graph.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS implements BFS {

    private Graph G;

    private boolean[] visited;

    private ArrayList<Integer> order = new ArrayList<>();

    public GraphBFS(Graph G) {
        this.G = G;

        visited = new boolean[G.V()];

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                bfs(i);
            }
        }
    }

    /**
     * 广度优先遍历
     * @param s
     */
    @Override
    public void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        
        while(!queue.isEmpty()) {
            int v = queue.remove();
            order.add(v);
            for (int w : G.adj(v)) {
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                }
            }
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

}
