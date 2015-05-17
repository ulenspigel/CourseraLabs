import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: kovalevd
 * Date: 11.07.13
 * Time: 11:54
 * To change this template use File | Settings | File Templates.
 */
public class QuickSort {

    private int comparisons;

    QuickSort() {
        comparisons = 0;
    }

    private int choosePivotElement(int arrayLength) {
        //return (int) Math.floor((arrayLength - 1) / 2);
        //return 0;
        return arrayLength - 1;
    }

    public int choosePivotElement(int[] array) {
        int first  = 0;
        int middle = (int) Math.ceil((double) array.length / 2) - 1;
        int last   = array.length - 1;
        int k      = 0;

        if (array[first] <= array[middle]) {
            if (array[last] <= array[first]) {
                k = first;
            } else if ((array[first] <= array[last]) && (array[last] <= array[middle])) {
                k = last;
            } else if (array[last] >= array[middle]) {
                k = middle;
            }
        } else {
            if (array[last] <= array[middle]) {
                k = middle;
            } else if ((array[middle] <= array[last]) && (array[last] <= array[first])) {
                k = last;
            } else if (array[last] <= array[first]) {
                k = first;
            }
        }
        return k;
    }

    public int[] quickSort(int[] array) {
        int n = array.length;
        if (n <= 1) {
            return array;
        }
        comparisons += (n - 1);
        int k = choosePivotElement(array); // index of pivoting element
        if (k != 0) {
            int swap = array[0];
            array[0] = array[k];
            array[k] = swap;
        }

        int i = 0;
        int swap;
        for (int j = 1; j < n; j++) {
            if (array[j] < array[0]) {
                i++;
                swap = array[j];
                array[j] = array[i];
                array[i] = swap;
            }
        }
        swap = array[0];
        array[0] = array[i];
        array[i] = swap;

        int[] mergedArray = new int[n];

        int[] left = quickSort(Arrays.copyOfRange(array, 0, i));
        int[] right = quickSort(Arrays.copyOfRange(array, i + 1, n));

        System.arraycopy(left, 0, mergedArray, 0, left.length);
        mergedArray[i] = array[i];
        System.arraycopy(right, 0, mergedArray, i + 1, right.length);

        return mergedArray;
    }

    public int getComparisons() {
        return comparisons;
    }

}
