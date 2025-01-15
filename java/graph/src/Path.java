import graph.Graph;

import java.util.ArrayList;

public class Path extends GraphDFS {

    private Graph G;
    private int source;
    private int destination;
    private int[] pre;

    public Path(Graph G, int source, int destination) {
        G.validateVertex(source);
        this.G = G;
        this.source = source;
        this.destination = destination;

        pre = new int[G.V()];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = -1;
        }

        dfs(source, source);
    }

    /**
     * 深度优先遍历算法
     * @param source 源节点
     */
    private boolean dfs(int v, int source) {
        // fixme 继承父类之后如何使用父类的一些方法
        pre[v] = source;
        if (v == destination) return true;
        for (int w : G.adj(v)) {
            if (pre[w] == -1) {
                if (dfs(w, v)) return true;
            }
        }
        return false;
    }

    /**
     * 判断该点是否和 source 联通
     * @return
     */
    public boolean isConnected() {
        G.validateVertex(destination);
        return pre[destination] != -1;
    }

    /**
     * 返回顶点 t 和 source 的联通路径
     * @return
     */
    public Iterable<Integer> path() {
        ArrayList<Integer> result = new ArrayList<>();

        if (!isConnected()) return result;

        result.add(0, destination);
        while (pre[destination] != source) {
            destination = pre[destination];
            result.add(0, destination);
        }
        result.add(0, source);
        return result;
    }
}
