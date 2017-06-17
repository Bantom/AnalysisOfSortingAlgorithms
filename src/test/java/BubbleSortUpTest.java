import gettingArrays.FilledArray;
import org.junit.*;
import sortingAlgorithm.BubbleSortUp;

import static junit.framework.TestCase.assertFalse;

/**
 * @author Bulgakov
 * @since 01.12.2016
 */
public class BubbleSortUpTest {
    int[] array;
    BubbleSortUp bubbleSortUp;

    @Before
    public void initArray() {
        array = FilledArray.getFilledArray(10000);
        bubbleSortUp = new BubbleSortUp();
    }

    @Test
    public void testSort() {
        int[] sortedArray = bubbleSortUp.sort(array);
        for (int i = 1; i < sortedArray.length; i++) {
            assertFalse(sortedArray[i - 1] > sortedArray[i]);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSortOnIllegalArgument() {
        int[] sortedArray = bubbleSortUp.sort(null);
    }

    @Test(timeout = 1000)
    public void testSortOnTime() {
        int[] sortedArray = bubbleSortUp.sort(array);
    }

    @Test
    public void testSortWithEmptyArray() {
        int[] arr = new int[100];
        int[] sortedArray = bubbleSortUp.sort(arr);
    }
}
