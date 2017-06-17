package sortingAlgorithm;

/**
 * @author Bulgakov
 * @since 28.11.2016
 */
@SortingAlgorithm
public abstract class Sort {
    /**
     * Sort method.
     *
     * @param arr Unsorted array
     * @return Sorted array
     * @throws IllegalArgumentException
     */
    public abstract int[] sort(int[] arr) throws IllegalArgumentException;
}
