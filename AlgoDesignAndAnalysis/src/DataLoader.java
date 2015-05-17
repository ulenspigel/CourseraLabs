import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kovalevd
 * Date: 11.07.13
 * Time: 13:02
 * To change this template use File | Settings | File Templates.
 */
public class DataLoader {

    DataLoader() {}

    public static int[] loadTestArray() {
        //int[] array = {3, 8, 2, 5, 1, 4, 7, 6};
        int[] array = {8,2,4,5,7};
        return array;
    }

    public static int[] loadIntArray(String fileName, int arrayLength) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        int i = 0;
        int[] array = new int[arrayLength];
        String fileRow = new String("");
        while (((fileRow = fileReader.readLine()) != null) && i < arrayLength) {
            array[i] = Integer.valueOf(fileRow).intValue();
            i++;
        }
        return array;
    }

    public static int[][] loadTestGraph() {
        int[][] graph = //{{1, 2, 3}, {2, 1, 3, 4}, {3, 1, 2, 4}, {4, 2, 3}};
                {{1, 2, 3, 4},
                 {2, 1, 3, 4},
                        {3, 1, 2, 4, 7},
                        {4, 1, 2, 3, 5, 7},
                        {5, 4, 6, 7, 8},
                        {6, 5, 7},
                        {7, 3, 4, 5, 6, 8},
                        {8, 5, 7}};
        return graph;
    }

    public static int[][] loadGraph(String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> fileRows = new ArrayList<String>();
        String fileRow = new String("");
        while ((fileRow = fileReader.readLine()) != null) {
            fileRows.add(fileRow);
        }
        int[][] graph = new int[fileRows.size()][];
        for (int i = 0; i < fileRows.size(); i++) {
            List<String> vertices = Arrays.asList(fileRows.get(i).split("\\t"));
            graph[i] = new int[vertices.size()];
            for (int j = 0; j < vertices.size(); j++) {
                graph[i][j] = Integer.valueOf(vertices.get(j));
            }
        }
        return graph;
    }

    public static int[] listToArray(ArrayList<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
