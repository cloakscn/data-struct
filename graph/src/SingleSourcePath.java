import java.util.ArrayList;

public class SingleSourcePath extends GraphDFS {

    private Graph G;
    private int source;
    private int[] pre;

    public SingleSourcePath(Graph G, int source) {
        G.validateVertex(source);
        this.G = G;
        this.source = source;

        pre = new int[G.V()];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = -1;
        }

        dfs(source, source);
    }

    /**
     * 深度优先遍历算法
     * @param parent 当前遍历到的父节点
     */
    private void dfs(int v, int parent) {
        // fixme 继承父类之后如何使用父类的一些方法
        pre[v] = parent;
        for (int w : G.adj(v)) {
            if (pre[w] == -1) {
                dfs(w, v);
            }
        }
    }

    /**
     * 判断该点是否和 source 联通
     * @return
     */
    public boolean isConnectedTo(int t) {
        G.validateVertex(t);
        return pre[t] != -1;
    }

    /**
     * 返回顶点 t 和 source 的联通路径
     * @param t
     * @return
     */
    public Iterable<Integer> path(int t) {
        ArrayList<Integer> result = new ArrayList<>();

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
