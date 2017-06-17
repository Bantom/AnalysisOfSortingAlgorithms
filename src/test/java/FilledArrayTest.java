import org.junit.Before;
import org.junit.Test;

import static gettingArrays.FilledArray.*;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Bulgakov
 * @since 01.12.2016
 */
public class FilledArrayTest {
    Integer quantityOfElements = 934;

    // tests on length of result array
    @Test
    public void getFilledArrayTest() {
        assertTrue(getFilledArray(quantityOfElements).length == quantityOfElements);
    }

    @Test
    public void getSortedArrayTest() {
        assertTrue(getSortedArray(quantityOfElements).length == quantityOfElements);
    }

    @Test
    public void getSortedArrayPlusRandomElementInTheEndTest() {
        assertTrue(getSortedArrayPlusRandomElementInTheEnd(quantityOfElements).length == quantityOfElements + 1);
    }

    @Test
    public void getSortedInversionArrayTest() {
        assertTrue(getSortedInversionArray(quantityOfElements).length == quantityOfElements);
    }

    // tests on NULL argument

    @Test(expected = IllegalArgumentException.class)
    public void getFilledArrayArgumentNullTest() {
        getFilledArray(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSortedArrayArgumentNullTest() {
        getSortedArray(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSortedArrayPlusRandomElementInTheEndArgumentNullTest() {
        getSortedArrayPlusRandomElementInTheEnd(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSortedInversionArrayArgumentNullTest() {
        getSortedInversionArray(null);
    }

    // other tests

    @Test
    public void getSortedArrayOnSortedTest() {
        int[] sortedArray = getSortedArray(quantityOfElements);
        for (int i = 1; i < sortedArray.length; i++) {
            assertFalse(sortedArray[i - 1] > sortedArray[i]);
        }
    }

    @Test
    public void getSortedInversionArrayOnInversionTest() {
        int[] sortedArray = getSortedInversionArray(quantityOfElements);
        for (int i = 1; i < sortedArray.length; i++) {
            assertFalse(sortedArray[i - 1] < sortedArray[i]);
        }
    }
}
