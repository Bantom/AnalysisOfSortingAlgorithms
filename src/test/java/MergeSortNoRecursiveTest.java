import gettingArrays.FilledArray;
import org.junit.Before;
import org.junit.Test;
import sortingAlgorithm.MergeSortNoRecursive;

import static junit.framework.TestCase.assertFalse;

/**
 * @author Bulgakov
 * @since 01.12.2016
 */
public class MergeSortNoRecursiveTest {
    int[] array;
    MergeSortNoRecursive mergeSortNoRecursive;

    @Before
    public void initArray() {
        array = FilledArray.getFilledArray(10000);
        mergeSortNoRecursive = new MergeSortNoRecursive();
    }

    @Test
    public void testSort() {
        int[] sortedArray = mergeSortNoRecursive.sort(array);
        for (int i = 1; i < sortedArray.length; i++) {
            assertFalse(sortedArray[i - 1] > sortedArray[i]);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSortOnIllegalArgument() {
        int[] sortedArray = mergeSortNoRecursive.sort(null);
    }

    @Test(timeout = 30)
    public void testSortOnTime() {
        int[] sortedArray = mergeSortNoRecursive.sort(array);
    }

    @Test
    public void testSortWithEmptyArray() {
        int[] arr = new int[100];
        int[] sortedArray = mergeSortNoRecursive.sort(arr);
    }
}
