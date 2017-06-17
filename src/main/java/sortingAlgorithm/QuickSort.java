package sortingAlgorithm;

import java.util.Random;

/**
 * @author Bulgakov
 * @since 21.11.2016
 */
@SortingAlgorithm
public class QuickSort extends Sort{

    /**
     * Quick Sort
     *
     * @param array Unsorted array
     * @param l Lower border for chose base element.
     * @param r Upper border for chose base element.
     * @return Sorted array
     * @throws IllegalArgumentException
     * @see sortingAlgorithm.QuickSort#sort(int[]) method with default begining params l = 0, r = array.length - 1
     */
    public int[] sort(int[] array, int l, int r) throws IllegalArgumentException {
        if (array != null) {
            if (l < 0 || r > array.length - 1 || l > r || r < 0) {
                throw new IllegalArgumentException();
            }
            int i = l;
            int j = r;
            Random rand = new Random();
            int x = array[l + rand.nextInt(r - l + 1)];
            while (i <= j) {
                while (array[i] < x) {
                    i++;
                }
                while (array[j] > x) {
                    j--;
                }
                if (i <= j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    i++;
                    j--;
                }
            }
            if (l < j) {
                sort(array, l, j);
            }
            if (i < r) {
                sort(array, i, r);
            }
        } else {
            throw new IllegalArgumentException();
        }
        return array;
    }

    /**
     * Quick Sort with default begining params l = 0, r = array.length - 1.
     *
     * @param arr Unsorted array
     * @return Sorted array
     * @throws IllegalArgumentException
     * @see sortingAlgorithm.QuickSort#sort(int[], int, int)
     */
    public int[] sort(int[] arr) throws IllegalArgumentException{
        if (arr != null) {
            return sort(arr, 0, arr.length - 1);
        }else{
            throw new IllegalArgumentException();
        }
    }
}
