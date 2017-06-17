import gettingArrays.FilledArray;
import org.junit.Before;
import org.junit.Test;
import sortingAlgorithm.MergeSortRecursive;

import static junit.framework.TestCase.assertFalse;

/**
 * @author Bulgakov
 * @since 01.12.2016
 */
public class MergeSortRecursiveTest {
    int[] array;
    MergeSortRecursive mergeSortRecursive;

    @Before
    public void initArray() {
        array = FilledArray.getFilledArray(10000);
        mergeSortRecursive = new MergeSortRecursive();
    }

    @Test
    public void testSort() {
        int[] sortedArray = mergeSortRecursive.sort(array);
        for (int i = 1; i < sortedArray.length; i++) {
            assertFalse(sortedArray[i - 1] > sortedArray[i]);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSortOnIllegalArgument() {
        int[] sortedArray = mergeSortRecursive.sort(null);
    }

    @Test(timeout = 30)
    public void testSortOnTime() {
        int[] sortedArray = mergeSortRecursive.sort(array);
    }

    @Test
    public void testSortWithEmptyArray() {
        int[] arr = new int[100];
        int[] sortedArray = mergeSortRecursive.sort(arr);
    }
}