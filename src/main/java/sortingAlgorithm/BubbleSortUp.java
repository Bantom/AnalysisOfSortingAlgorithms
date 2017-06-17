package sortingAlgorithm;

/**
 * @author Bulgakov
 * @since 21.11.2016
 */
public class BubbleSortUp extends BubbleSort {

    @Override
    /**
     * Bubble Sort which begin sorting from first element.
     * @param arr Unsorted array
     * @throws IllegalArgumentException
     * @return Sorted array
     */
    public int[] sort(int[] arr) throws IllegalArgumentException {

        if(arr != null) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        swap(arr,j,j+1);
                    }
                }
            }
        }else{
            throw new IllegalArgumentException();
        }
        return arr;
    }
}
