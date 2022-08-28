import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!\n");
        Graph adjSet = new AdjSet("graph/src/sources/AdjSet.txt");
        System.out.println(adjSet);
        System.out.println();

        GraphDFS graphDFS = new GraphDFS(adjSet);
        Iterable<Integer> pre = graphDFS.pre();
        Iterable<Integer> post = graphDFS.post();
        System.out.println("pre dfs is " + pre);
        System.out.println("post dfs is " + post);
        System.out.println();

        CC cc = new CC(adjSet);
        int count = cc.count();
        boolean connected = cc.isConnected(0, 6);
        ArrayList<Integer>[] components = cc.components();
        System.out.println(String.format("CCCount is %d.", count));
        System.out.println(String.format("Is Connect %b.", connected));
        System.out.println(String.format("Components is %s.", components));

        for (int i = 0; i < count; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < components.length; j++) {
                if (i == j) {
                    System.out.print(components[j] + " ");
                }
            }
            System.out.println();
        }

        System.out.println();
        Graph adjMatrix = new AdjMatrix("graph/src/sources/AdjMatrix.txt");
        System.out.println(adjMatrix);

        AdjList adjList = new AdjList("graph/src/sources/AdjList.txt");
        System.out.println(adjList);
    }
}