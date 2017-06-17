package sortingAlgorithm;

/**
 * @author Bulgakov
 * @since 21.11.2016
 */
@SortingAlgorithm
public abstract class MergeSort extends Sort{
    /**
     * Method merge two arrays for algorithm Merge Sort.
     *
     * @param arr_1 First array for merging
     * @param arr_2 Second array for merging
     * @throws IllegalArgumentException
     * @return Merged array
     */
    protected int[] merge(int[] arr_1, int[] arr_2) throws IllegalArgumentException{
        if(arr_1 == null || arr_2 == null){
            throw new IllegalArgumentException();
        }
        int len_1 = arr_1.length, len_2 = arr_2.length;
        int a = 0, b = 0, len = len_1 + len_2; // a, b - counters in arrays
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (b < len_2 && a < len_1) {
                if (arr_1[a] > arr_2[b]) result[i] = arr_2[b++];
                else result[i] = arr_1[a++];
            } else if (b < len_2) {
                result[i] = arr_2[b++];
            } else {
                result[i] = arr_1[a++];
            }
        }
        return result;
    }
}
