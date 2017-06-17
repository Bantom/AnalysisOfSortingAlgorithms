package sortingAlgorithm;

import java.util.Arrays;

/**
 * @author Bulgakov
 * @since 21.11.2016
 */
@SortingAlgorithm
public class ArraySort extends Sort{

    /**
     * Native method Arrays.sort()
     *
     * @param arr Unsorted array
     * @throws IllegalArgumentException
     * @return Sorted array
     * @see Arrays#sort(int[])
     */
    public int[] sort(int[] arr) throws IllegalArgumentException{
        if(arr != null) {
            Arrays.sort(arr);
        }else{
            throw new IllegalArgumentException();
        }
        return arr;
    }
}
