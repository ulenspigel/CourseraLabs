import java.io.IOException;
import java.util.Arrays;

public class Main {

    private static void testQuickSort() throws IOException {
        QuickSort sorter = new QuickSort();
        int[] sortedArray = sorter.quickSort(DataLoader.loadIntArray("C:/Projects/IDEA/CourseraLabs/input/QuickSort.txt", 10000));
        //int[] sortedArray = sorter.quickSort(DataLoader.loadTestArray());
        for (int i = 1; i <= 100; i++) {
            System.out.println(i + " " + sortedArray[i * 100 - 1]);
        }
        System.out.println(sorter.getComparisons());
    }

    private static void testGraph() throws IOException {
        int[][] initGraph = DataLoader.loadGraph("c:/Projects/IDEA/CourseraLabs/input/MinCut.txt");
        Graph graphProcessor = new Graph(initGraph.length);
        //graphProcessor.printGraph(initGraph);
        /*System.out.println("====================================");
        int[][] mergedGraph;
        mergedGraph = graphProcessor.mergeVertices(initGraph, 1, 2);
        graphProcessor.printGraph(mergedGraph);
        System.out.println("====================================");
        mergedGraph = graphProcessor.mergeVertices(mergedGraph, 3, 4);
        graphProcessor.printGraph(mergedGraph);*/
        int minCuts = graphProcessor.findMinCuts(initGraph);
        System.out.println("\n\nMin cuts = " + minCuts);
    }

    public static void main(String[] args) throws IOException {
        //testQuickSort();
        testGraph();
    }
}
