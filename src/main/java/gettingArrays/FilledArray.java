package gettingArrays;

import java.lang.annotation.*;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Bulgakov
 * @since 21.11.2016
 */
public class FilledArray {

    /**
     * Method fills array elements using {@link gettingArrays.FilledArray#getElements(Integer)} method.
     *
     * @param length Quantity of element in array
     * @throws IllegalArgumentException
     * @return Filled array by elements
     */
    @FillingArrays
    public static int[] getFilledArray(Integer length) throws IllegalArgumentException{
        int[] array = null;
        if(length != null && length > 0 && length instanceof Integer) {
            array = getElements(length);
        }else{
            throw new IllegalArgumentException();
        }
        return array;
    }

    /**
     * Method create array with fixed length and fills it elements by. For sorting native method Arrays.sort(int[]) is used.
     *
     * @param length Quantity of element in array
     * @throws IllegalArgumentException
     * @return Sorted array
     * @see Arrays#sort(int[])
     */
    @FillingArrays
    public static int[] getSortedArray(Integer length) throws IllegalArgumentException{
        int[] array = null;
        if(length != null && length > 0 && length instanceof Integer) {
            array = getElements(length);
            Arrays.sort(array);
        }else{
            throw new IllegalArgumentException();
        }
        return array;
    }

    /**
     * Method create array with fixed length and fills it elements by. For sorting native method Arrays.sort(int[]) is used.
     * The last random element adds to array without sorting array again.
     *
     * @param length Quantity of element in array
     * @throws IllegalArgumentException
     * @return Sorted array
     * @see Arrays#sort(int[])
     */
    @FillingArrays
    public static int[] getSortedArrayPlusRandomElementInTheEnd(Integer length) throws IllegalArgumentException{
        int[] array = null;
        if(length != null && length > 0 && length instanceof Integer) {
            array = new int[length + 1];
            System.arraycopy(getElements(length), 0, array, 0, length);
            Arrays.sort(array);
            array[length] = new Random().nextInt();
        }else{
            throw new IllegalArgumentException();
        }
        return array;
    }

    /**
     * Method create array with fixed length and fills it by using method {@link gettingArrays.FilledArray#getSortedArray(Integer)}.
     * The resulting array is inverted.
     *
     * @param length Quantity of element in array
     * @throws IllegalArgumentException
     * @return Sorted inverted array
     */
    @FillingArrays
    public static int[] getSortedInversionArray(Integer length) throws IllegalArgumentException{
        int[] array = null;
        if(length != null && length > 0 && length instanceof Integer) {
            array = getSortedArray(length);
            for (int i = 0; i < array.length / 2; i++) {
                int tmp = array[i];
                array[i] = array[array.length - i - 1];
                array[array.length - i - 1] = tmp;
            }
        }else{
            throw new IllegalArgumentException();
        }
        return array;
    }

    /**
     * Method fills array elements.
     *
     * @param length quantity of element in array
     * @throws IllegalArgumentException
     * @return Filled array by elements
     */
    private static int[] getElements(Integer length) throws IllegalArgumentException{
        int[] array = null;
        if(length > 0 && length != null && length instanceof Integer) {
            array = new int[length];
            for (int i = 0; i < length; i++) {
                array[i] = new Random().nextInt();
            }
        }else{
            throw new IllegalArgumentException();
        }
        return array;
    }

    @Retention(value = RetentionPolicy.RUNTIME)
    @Target(value = ElementType.METHOD)
    private @interface FillingArrays {
    }
}
