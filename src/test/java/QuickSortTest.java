import gettingArrays.FilledArray;
import org.junit.Before;
import org.junit.Test;
import sortingAlgorithm.QuickSort;

import static junit.framework.TestCase.assertFalse;

/**
 * @author Bulgakov
 * @since 01.12.2016
 */
public class QuickSortTest {
    int[] array;
    QuickSort quickSort;

    @Before
    public void initArray() {
        array = FilledArray.getFilledArray(10000);
        quickSort = new QuickSort();
    }

    @Test
    public void testSort() {
        int[] sortedArray = quickSort.sort(array);
        for (int i = 1; i < sortedArray.length; i++) {
            assertFalse(sortedArray[i - 1] > sortedArray[i]);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSortOnIllegalArgument() {
        int[] sortedArray = quickSort.sort(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSortWithBorderArgumentR() {
        int[] sortedArray = quickSort.sort(array, 0, array.length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSortWithBorderArgumentL() {
        int[] sortedArray = quickSort.sort(array, -11, array.length - 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSortWithBorderArgumentLbiggerR() {
        int[] sortedArray = quickSort.sort(array, 1, 0);
    }

    @Test(timeout = 30)
    public void testSortOnTime() {
        int[] sortedArray = quickSort.sort(array);
    }

    @Test
    public void testSortWithEmptyArray() {
        int[] arr = new int[100];
        int[] sortedArray = quickSort.sort(arr);
    }
}
