package LiveClass.day04.graph;

public class UndirectedGraph {
    private final int[][] adjacencyMatrix;
    private final int numOfNodes;

    public UndirectedGraph(int numOfNodes) {
        this.adjacencyMatrix = new int[numOfNodes][numOfNodes];
        this.numOfNodes = numOfNodes;
    }

    public void addEdge(int start, int end){
        adjacencyMatrix[start][end] = 1;
        adjacencyMatrix[end][start] = 1;
    }

    public void printGraph(){
        for (int i = 0; i < numOfNodes; i++) {
            for (int j = 0; j < numOfNodes; j++) {
                System.out.print(adjacencyMatrix[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,4);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.printGraph();
    }
}
