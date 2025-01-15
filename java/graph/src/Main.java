import graph.AdjList;
import graph.AdjMatrix;
import graph.AdjSet;
import graph.Graph;

import java.util.ArrayList;

public class Main {

    private final static Graph adjSet = new AdjSet("graph/src/sources/graph.AdjSet.txt");

    private final static Graph graphBFS_test_data = new AdjSet("graph/src/sources/GraphBFS.txt");

    private final static Graph adjMatrix = new AdjMatrix("graph/src/sources/graph.AdjMatrix.txt");

    private final static Graph adjList = new AdjList("graph/src/sources/graph.AdjList.txt");

    public static void main(String[] args) {
        System.out.println("Hello world!\n");

        // 图的存储方式的实现
//        testGraph("adjSet", adjSet);
//        testGraph("adjMatrix", adjMatrix);
//        testGraph("adjList", adjList);
//        testGraph("graphBFS_test_data", graphBFS_test_data);

        // 图的遍历方式的实现
//        testGraphBFS();
//        testGraphDFS();

        // 图的单源路径的实现
//        testSingleSourcePathDFS();
        testSingleSourcePathBFS();
    }

    private static void testGraph(String msg, Graph graph) {
        System.out.println("\n" + msg + ":\n");
        System.out.println(graph);
    }

    private static void testGraphDFS() {
        System.out.println("\ntestGraphDFS:\n");
        GraphDFS graphDFS = new GraphDFS(adjSet);
        Iterable<Integer> pre = graphDFS.pre();
        Iterable<Integer> post = graphDFS.post();
        System.out.println("pre dfs is " + pre);
        System.out.println("post dfs is " + post);
    }

    private static void testGraphBFS() {
        System.out.println("\ntestGraphBFS\n");
        GraphBFS graphBFS = new GraphBFS(graphBFS_test_data);
        System.out.println("order is " + graphBFS.order());
    }

    private void testDFSCC() {
        System.out.println("\ntestDFSCC:\n");
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
    }

    private void testDFSPath() {
        System.out.println("\ntestDFSPath\n");
        Path path = new Path(adjSet, 0, 2);
        System.out.println(String.format("0 -> 2: %b", path.isConnected()));
        System.out.println("the path is " + path.path());
    }

    private void testCycleDetection() {
        System.out.println("\ntestCycleDetection:\n");
        CycleDetection cycleDetection = new CycleDetection(adjSet);
        System.out.println("hasCycle: " + cycleDetection.hasCycle());
    }

    private void testBiPartitionDFS() {
        System.out.println("\nByPartitionDetection:\n");
        BiPartitionDetection biPartitionDetection = new BiPartitionDetection(adjSet);
        System.out.println("isBipartite: " + biPartitionDetection.isBipartite());
        AdjSet biPartition = new AdjSet("graph/src/sources/BiPartitionDetection.txt");
        BiPartitionDetection biPartitionDetection1 = new BiPartitionDetection(biPartition);
        System.out.println("isBipartite: " + biPartitionDetection1.isBipartite());
    }

    private static void testSingleSourcePathBFS() {
        System.out.println("\ntestSingleSourcePathBFS:\n");
        SingleSourcePathBFS singleSourcePathBFS = new SingleSourcePathBFS(adjSet, 0);
        System.out.println(String.format("6 is connected to 0: %b", singleSourcePathBFS.isConnectedTo(6)));
        System.out.println("6->0 " + singleSourcePathBFS.path(6));
        System.out.println("6->0 " + singleSourcePathBFS.dis(6));
        System.out.println(String.format("4 is connected to 0: %b", singleSourcePathBFS.isConnectedTo(4)));
        System.out.println("4->0" + singleSourcePathBFS.path(4));
        System.out.println("4->0" + singleSourcePathBFS.dis(4));
    }

    private static void testSingleSourcePathDFS() {
        System.out.println("\ntestSingleSourcePathBFS:\n");
        SingleSourcePathDFS singleSourcePathDFS = new SingleSourcePathDFS(adjSet, 0);
        System.out.println(String.format("6 is connected to 0: %b", singleSourcePathDFS.isConnectedTo(6)));
        System.out.println("the path is " + singleSourcePathDFS.path(6));
        System.out.println(String.format("4 is connected to 0: %b", singleSourcePathDFS.isConnectedTo(4)));
        System.out.println("the path is " + singleSourcePathDFS.path(4));
    }
}