public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Graph adjSet = new AdjSet("graph/src/sources/AdjSet.txt");
        System.out.println(adjSet);
        GraphDFS graphDFS = new GraphDFS(adjSet);
        Iterable<Integer> pre = graphDFS.pre();
        Iterable<Integer> post = graphDFS.post();
        System.out.println(pre);
        System.out.println(post);

        Graph adjMatrix = new AdjMatrix("graph/src/sources/AdjMatrix.txt");
        System.out.println(adjMatrix);

        AdjList adjList = new AdjList("graph/src/sources/AdjList.txt");
        System.out.println(adjList);
    }
}