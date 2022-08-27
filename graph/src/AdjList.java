import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class AdjList implements Graph<Integer> {

    private int V;
    private int E;
    private LinkedList<Integer>[] adj;

    public AdjList(String filename) {
        File file = new File(filename);

        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            if (V < 0) throw new IllegalArgumentException("V must be non-negative");
            E = scanner.nextInt();
            if (E < 0) throw new IllegalArgumentException("E must be non-negative");
            adj = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList<Integer>();
            }

            // todo 构造邻接矩阵
            for (int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                validateVertex(a);
                int b = scanner.nextInt();
                validateVertex(b);

                // 无向无权图自环边和平行边是不允许的
                if (a == b) throw new IllegalArgumentException("Self Loop is Detected!");
                if (adj[a].contains(b)) throw new IllegalArgumentException("Parallel Edge are Detected!");
                adj[a].add(b);
                adj[b].add(a);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();

        sb.append(String.format("V = %d, E = %d\n", V, E));
        for (int v = 0; v < V; v++) {
            sb.append(String.format("%d : ", v));
            for (int w : adj[v]) {
                sb.append(String.format("%d ", w));
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    @Override
    public void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is invalid");
        }
    }

    // 对外开放接口
    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    // 是否有邻边
    @Override
    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return adj[v].contains(w);
    }

    // 获取邻边接口
    @Override
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    // 获取顶点的度
    @Override
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

}
