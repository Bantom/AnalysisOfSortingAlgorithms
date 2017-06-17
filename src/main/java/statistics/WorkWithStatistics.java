package statistics;

import gettingArrays.FilledArray;
import reflection.WorkWithAnnotatedMethods;
import reflection.WorkWithReflection;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Bulgakov
 * @since 28.11.2016
 */
public class WorkWithStatistics {
    /**
     * Method get all filling array methods. Each this method starts one by one all the sorting methods.<br>
     * Each sorting method starts with 100 arrays of different lengths.<br>
     * Quantity of elements in arrays increases by 100 elements every iteration from 100 to 10.000.
     *
     * @param packageName Name of package
     * @param methodSortName Name of sort method
     * @param annotationClassName Name of annotation, which annotate classes from package
     * @return Map(Filling array method name, Map Sorting method name, Map Quantity elements, Quantity milliseconds)
     * @see sun.reflect.Reflection
     */
    public static Map<String, Map<String, Map<Integer, Long>>> getStatisticsOfSortingMethods(String packageName, String methodSortName, String annotationClassName) {
        Map<String, Map<String, Map<Integer, Long>>> inputMethodSortNameQuantityElementsAndTime = new HashMap<String, Map<String, Map<Integer, Long>>>();
        try {
            Map<String, Map<Integer, Long>> sortNameQuantityElementsAndTime;
            SortedMap<Integer, Long> quantityElementsAndTime = null;
            // get Methods for filling arrays
            List<Method> methodsFillingArray = new WorkWithAnnotatedMethods().getMethodsWithAnnotation();
            // get all class from package
            Class[] classes = WorkWithReflection.getClasses(packageName);
            // choose filling array method
            for (int j = 0; j < methodsFillingArray.size(); j++) {
                sortNameQuantityElementsAndTime = new HashMap<String, Map<Integer, Long>>();
                //choose sort method
                for (int i = 0; i < classes.length; i++) {
                    if (classes[i].isAnnotation()) {
                        break;
                    }
                    quantityElementsAndTime = new TreeMap<Integer, Long>();
                    Integer arrayLength = 100;
                    Boolean abstractClass = false;
                    // invoke sort method with different length of array
                    while (arrayLength <= 10000) {
                        Annotation[] arrayAnnotations = classes[i].getAnnotations();
                        if (contains(arrayAnnotations, annotationClassName)) {
                            try {
                                Class[] paramTypes = new Class[]{int[].class};
                                Method method = classes[i].getMethod(methodSortName, paramTypes);
                                Object[] argumentForFillingArrayMethods = new Object[]{arrayLength};
                                Object[] argumentsForSortMethods = new Object[]{
                                        (int[]) methodsFillingArray.get(j).invoke(new FilledArray(), argumentForFillingArrayMethods)
                                };
                                Long startTime = System.currentTimeMillis();
                                int[] resultArray = (int[]) method.invoke(classes[i].newInstance(), argumentsForSortMethods);
                                Long timeSpent = System.currentTimeMillis() - startTime;
                                quantityElementsAndTime.put(arrayLength, timeSpent);
                            } catch (NoSuchMethodException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e) {
                                abstractClass = true;
                                break;
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                        arrayLength += 100;
                    }
                    if (!abstractClass) {
                        sortNameQuantityElementsAndTime.put(classes[i].getSimpleName(), quantityElementsAndTime);
                    }
                }
                inputMethodSortNameQuantityElementsAndTime.put(methodsFillingArray.get(j).getName(), sortNameQuantityElementsAndTime);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputMethodSortNameQuantityElementsAndTime;
    }

    /**
     * Method find annotation in array of annotation and return boolean result of searching.
     *
     * @param nameAnnotation   Array of annotations
     * @param arrayAnnotations Name of needs annotation
     * @return Boolean working method result
     * @throws IllegalArgumentException
     */
    private static Boolean contains(Annotation[] arrayAnnotations, String nameAnnotation) throws IllegalArgumentException {
        Boolean flag = false;
        if (arrayAnnotations != null || !nameAnnotation.equals("")) {
            for (int i = 0; i < arrayAnnotations.length; i++) {
                if (arrayAnnotations[i].annotationType().getSimpleName().equals(nameAnnotation)) {
                    flag = true;
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
        return flag;
    }

    /**
     * Method statistics about sorting algorithms.<br>
     * It use {@link statistics.WorkWithStatistics#getStatisticsOfSortingMethods(String, String, String)} with params:<br>
     * {@code  String methodSortName = "sort";
     * String annotationClassName = "SortingAlgorithm";
     * String packageName = "sortingAlgorithm";}
     *
     * @return Data about statistic of sorting methods
     * @see statistics.WorkWithStatistics#getStatisticsOfSortingMethods(String, String, String)
     */
    public static Map<String, Map<String, Map<Integer, Long>>> getStatisticsForSortMethodsForExcel() {
        WorkWithReflection reflection = new WorkWithReflection();
        String methodSortName = "sort";
        String annotationClassName = "SortingAlgorithm";
        String packageName = "sortingAlgorithm";
        Map<String, Map<String, Map<Integer, Long>>> statistics = getStatisticsOfSortingMethods(packageName, methodSortName, annotationClassName);
        return statistics;
    }
}
