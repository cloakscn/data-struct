import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!\n");
        Graph adjSet = new AdjSet("graph/src/sources/AdjSet.txt");
        System.out.println(adjSet);

        System.out.println("\nGraphDFS:\n");
        GraphDFS graphDFS = new GraphDFS(adjSet);
        Iterable<Integer> pre = graphDFS.pre();
        Iterable<Integer> post = graphDFS.post();
        System.out.println("pre dfs is " + pre);
        System.out.println("post dfs is " + post);

        System.out.println("\nCC:\n");
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

        System.out.println("\nCC path:\n");
        SingleSourcePath singleSourcePath = new SingleSourcePath(adjSet, 0);
        System.out.println(String.format("6 is connected to 0: %b", singleSourcePath.isConnectedTo(6)));
        System.out.println("the path is " + singleSourcePath.path(6));
        System.out.println(String.format("4 is connected to 0: %b", singleSourcePath.isConnectedTo(4)));
        System.out.println("the path is " + singleSourcePath.path(4));

        System.out.println("\nPath\n");
        Path path = new Path(adjSet, 0, 2);
        System.out.println(String.format("0 -> 2: %b", path.isConnected()));
        System.out.println("the path is " + path.path());

        System.out.println("\nCycleDetection:\n");
        CycleDetection cycleDetection = new CycleDetection(adjSet);
        System.out.println("hasCycle: " + cycleDetection.hasCycle());

        System.out.println("\nBFS\n");
        Graph graph = new AdjSet("graph/src/sources/GraphBFS.txt");
        System.out.println(adjSet);
        GraphBFS graphBFS = new GraphBFS(graph);
        System.out.println("order is " + graphBFS.order());


        System.out.println("\nByPartitionDetection:\n");
        BiPartitionDetection biPartitionDetection = new BiPartitionDetection(adjSet);
        System.out.println("isBipartite: " + biPartitionDetection.isBipartite());
        AdjSet biPartition = new AdjSet("graph/src/sources/BiPartitionDetection.txt");
        BiPartitionDetection biPartitionDetection1 = new BiPartitionDetection(biPartition);
        System.out.println("isBipartite: " + biPartitionDetection1.isBipartite());


        System.out.println();
        Graph adjMatrix = new AdjMatrix("graph/src/sources/AdjMatrix.txt");
        System.out.println(adjMatrix);

        AdjList adjList = new AdjList("graph/src/sources/AdjList.txt");
        System.out.println(adjList);
    }
}