package sortingAlgorithm;

import java.util.Arrays;

/**
 * @author Bulgakov
 * @since 21.11.2016
 */
public class MergeSortRecursive extends MergeSort {

    /**
     * Merge Sort with using recursive.
     *
     * @param arr Unsorted array
     * @throws IllegalArgumentException
     * @return Sorted array
     * @see Arrays#copyOfRange(int[], int, int)
     */
    public int[] sort(int[] arr) throws IllegalArgumentException{
        if(arr == null) {
            throw new IllegalArgumentException();
        }
        int len = arr.length;
        if (len < 2) return arr;
        int middle = len / 2;
        return merge(sort(Arrays.copyOfRange(arr, 0, middle)),
                sort(Arrays.copyOfRange(arr, middle, len)));
    }
}
