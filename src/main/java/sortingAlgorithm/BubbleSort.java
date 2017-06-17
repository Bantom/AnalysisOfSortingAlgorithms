package sortingAlgorithm;

/**
 * @author Bulgakov
 * @since 21.11.2016
 */
@SortingAlgorithm
public abstract class BubbleSort extends Sort {

    /**
     * Utility method to swap two numbers in array
     */
    public static void swap(int[] array, int from, int to) {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }
}
