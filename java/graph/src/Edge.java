public class Edge {

    private int v;
    private int w;
    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "v=" + v +
                ", w=" + w +
                '}';
    }
}
