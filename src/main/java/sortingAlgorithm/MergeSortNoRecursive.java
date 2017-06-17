package sortingAlgorithm;

import java.util.Arrays;

/**
 * @author Bulgakov
 * @since 21.11.2016
 */
public class MergeSortNoRecursive extends MergeSort {

    /**
     * Merge Sort without using recursive.
     *
     * @param arr Unsorted array
     * @throws IllegalArgumentException
     * @return Sorted array
     * @see Arrays#copyOfRange(int[], int, int)
     */
    public int[] sort(int[] arr) throws IllegalArgumentException{
        if(arr != null) {
            int len = arr.length;
            int n = 1;
            int shift;
            int two_size;
            int[] arr2;
            while (n < len) {
                shift = 0;
                while (shift < len) {
                    if (shift + n >= len) break;
                    two_size = (shift + n * 2 > len) ? (len - (shift + n)) : n;
                    arr2 = merge(Arrays.copyOfRange(arr, shift, shift + n),
                            Arrays.copyOfRange(arr, shift + n, shift + n + two_size));
                    for (int i = 0; i < n + two_size; ++i)
                        arr[shift + i] = arr2[i];
                    shift += n * 2;
                }
                n *= 2;
            }
        }else{
            throw new IllegalArgumentException();
        }
        return arr;
    }
}
