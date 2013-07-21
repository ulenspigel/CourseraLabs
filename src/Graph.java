import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kovalevd
 * Date: 18.07.13
 * Time: 11:30
 * To change this template use File | Settings | File Templates.
 */
public class Graph {
    int vertexCount;

    Graph(int verticies) {
        vertexCount = verticies;
    }

    public void printGraph(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public int[][] mergeVertices(int[][] graph, int firstVertex, int secondVertex) {
        int[][] mergedGraph = new int[graph.length - 1][];
        int mi = 0, mj = 0;
        int firstVertexInd = -1, secondVertexInd = -1;

        for (int i = 0; i < graph.length; i++) {
            if (graph[i][0] == firstVertex) {
                firstVertexInd = i;
            } else if (graph[i][0] == secondVertex) {
                secondVertexInd = i;
            } else {
                ArrayList<Integer> tempVertexStack = new ArrayList<Integer>();
                mergedGraph[mi] = new int[graph[i].length];
                for (int j = 0; j < graph[i].length; j++) {
                    if (graph[i][j] == secondVertex) {
                        tempVertexStack.add(Integer.valueOf(firstVertex));
                    } else {
                        tempVertexStack.add(Integer.valueOf(graph[i][j]));
                    }
                }
                mergedGraph[mi] = DataLoader.listToArray(tempVertexStack);
                mi++;
            }
        }
        ArrayList<Integer> tempVertexStack = new ArrayList<Integer>();
        for (int j = 0; j < graph[firstVertexInd].length; j++) {
            if (graph[firstVertexInd][j] != secondVertex) {
                tempVertexStack.add(Integer.valueOf(graph[firstVertexInd][j]));
            }
        }
        for (int j = 1; j < graph[secondVertexInd].length; j++) {
            if (graph[secondVertexInd][j] != firstVertex) {
                tempVertexStack.add(Integer.valueOf(graph[secondVertexInd][j]));
            }
        }
        mergedGraph[mi] = DataLoader.listToArray(tempVertexStack);

        return mergedGraph;
    }

    public int findMinCuts(int[][] graph) {
        int minCuts = vertexCount * vertexCount;
        int iterations = vertexCount * vertexCount /** ((int) Math.round(Math.log(vertexCount)))*/;

        for (int i = 0; i < iterations; i++) {
            int[][] processedGraph = graph;
            while (processedGraph.length > 2) {
                int firstVertexIndex = (int) Math.round((processedGraph.length - 1) * Math.random());
                int firstVertexValue = processedGraph[firstVertexIndex][0];
                int secondVertexIndex = (int) Math.round((processedGraph[firstVertexIndex].length - 1) * Math.random());
                if (secondVertexIndex == 0) {
                    secondVertexIndex++;
                }
                int secondVertexValue = processedGraph[firstVertexIndex][secondVertexIndex];
                //try {
                processedGraph = mergeVertices(processedGraph, firstVertexValue, secondVertexValue);
                /*} catch (ArrayIndexOutOfBoundsException aie) {
                    System.err.println("Vertex left: " + processedGraph.length);
                     System.err.println("Vertices index: (" + firstVertexIndex + "; " + secondVertexIndex + ")");
                    System.err.println("Merge vertices values: " + firstVertexValue + "; " + secondVertexValue);
                    printGraph(processedGraph);
                    //throw aie;
                } */
            }
            //printGraph(processedGraph);
            int iterationMinCuts = Math.min(processedGraph[0].length, processedGraph[1].length) - 1;
            if (i%100 == 0) {
              System.out.println("Iteration " + i + " min cuts = " + iterationMinCuts);
            }

            if (minCuts > iterationMinCuts) {
                minCuts = iterationMinCuts;
            }
        }
        return minCuts;
    }

}
