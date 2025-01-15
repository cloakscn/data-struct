import graph.AdjList;
import graph.AdjSet;
import graph.Graph;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

public class EulerLoop extends CC implements DFS, Cloneable {

    private AdjSet G;

    public EulerLoop(Graph G) {
        super(G);
        this.G = (AdjSet) G;
    }

    public boolean hasEulerLoop() {
        if (count() > 1) {
            return false;
        }
        for (int i = 0; i < G.V(); i++) {
            if (G.degree(i) % 2 != 0)
                return false;
        }
        return true;
    }

    @Override
    public void dfs(int v) {

    }

    public ArrayList<Integer> result() {
        ArrayList<Integer> res = new ArrayList<>();
        if (!hasEulerLoop()) return res;

        Graph g = (Graph) G.clone();

        Stack<Integer> stack = new Stack<>();
        int curV = 0;
        stack.push(curV);

        while (!stack.isEmpty()) {
            if (g.degree(curV) != 0) {
                stack.push(curV);
                int w = g.adj(curV).iterator().next();
                g.removeEdge(curV, w);
                curV = w;
            } else {
                res.add(curV);
                curV = stack.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        EulerLoop eulerLoop = new EulerLoop(new AdjSet("graph/src/sources/EulerLoop.txt"));
        System.out.println(eulerLoop.hasEulerLoop());
        System.out.println(eulerLoop.result().toString());
    }
}
