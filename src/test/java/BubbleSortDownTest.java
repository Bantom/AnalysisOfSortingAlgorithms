import gettingArrays.FilledArray;
import org.junit.Before;
import org.junit.Test;
import sortingAlgorithm.BubbleSortDown;

import static junit.framework.TestCase.assertFalse;

/**
 * @author Bulgakov
 * @since 01.12.2016
 */
public class BubbleSortDownTest {
    int[] array;
    BubbleSortDown bubbleSortDown;

    @Before
    public void initArray() {
        array = FilledArray.getFilledArray(10000);
        bubbleSortDown = new BubbleSortDown();
    }

    @Test
    public void testSort() {
        int[] sortedArray = bubbleSortDown.sort(array);
        for (int i = 1; i < sortedArray.length; i++) {
            assertFalse(sortedArray[i - 1] > sortedArray[i]);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSortOnIllegalArgument() {
        int[] sortedArray = bubbleSortDown.sort(null);
    }

    @Test(timeout = 1000)
    public void testSortOnTime() {
        int[] sortedArray = bubbleSortDown.sort(array);
    }

    @Test
    public void testSortWithEmptyArray() {
        int[] arr = new int[100];
        int[] sortedArray = bubbleSortDown.sort(arr);
    }
}
