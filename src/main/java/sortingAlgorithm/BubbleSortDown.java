package sortingAlgorithm;

/**
 * @author Bulgakov
 * @since 21.11.2016
 */
public class BubbleSortDown extends BubbleSort {


    /**
     * Bubble Sort which begin sorting from last element.
     *
     * @param arr Unsorted array
     * @return Sorted array
     * @throws IllegalArgumentException
     */
    @Override
    public int[] sort(int[] arr) throws IllegalArgumentException {
        if (arr != null) {
            for (int i = arr.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        swap(arr,j,j+1);
                    }
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
        return arr;
    }
}
