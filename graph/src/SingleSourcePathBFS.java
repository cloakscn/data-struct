import graph.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先遍历实现单源路径搜索
 */
public class SingleSourcePathBFS extends GraphDFS implements SingleSourcePath {

    private Graph G;
    private ArrayList<Integer> order = new ArrayList<>();

    private int source;
    
    private int[] pre;

    private int[] dis;

    public SingleSourcePathBFS(Graph G, int source) {
        G.validateVertex(source);
        this.G = G;
        this.source = source;

        pre = new int[G.V()];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = -1;
        }

        dis = new int[G.V()];
        for (int i = 0; i < dis.length; i++) {
            dis[i] = -1;
        }

        bfs(source);
    }

    private void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        pre[s] = 0;
        dis[s] = 0;

        while(!queue.isEmpty()) {
            int v = queue.remove();
            order.add(v);
            for (int w : G.adj(v)) {
                if (pre[w] == -1) {
                    queue.add(w);
                    pre[w] = v;
                    dis[w] = dis[v] + 1;
                }
            }
        }
    }

    public int dis(int t) {
        G.validateVertex(t);
        return dis[t];
    }

    /**
     * 判断该点是否和 source 联通
     * @return
     */
    @Override
    public boolean isConnectedTo(int t) {
        G.validateVertex(t);
        return pre[t] != -1;
    }

    /**
     * 返回顶点 t 和 source 的联通路径
     * @param t
     * @return
     */
    @Override
    public Iterable<Integer> path(int t) {
        List<Integer> result = new ArrayList<>();

        if (!isConnectedTo(t)) return result;

        result.add(0, t);
        while (pre[t] != source) {
            t = pre[t];
            result.add(0, t);
        }
        result.add(0, source);
        return result;
    }
}
