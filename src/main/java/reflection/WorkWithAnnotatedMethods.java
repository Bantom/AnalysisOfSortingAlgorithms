package reflection;

import gettingArrays.FilledArray;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bulgakov
 * @since 23.11.2016
 */
public class WorkWithAnnotatedMethods {

    /**
     * Method find all methods from class {@link gettingArrays.FilledArray}.
     * @return array of methods
     */
    private Method[] getAllClassMethods() {
        FilledArray filledArrayObj = new FilledArray();
        Class classTmp = filledArrayObj.getClass();
        Method[] methods = classTmp.getMethods();
        return methods;
    }

    /**
     * Method find all methods with annotation(param) from class {@link gettingArrays.FilledArray}. This method use {@link WorkWithAnnotatedMethods#getAllClassMethods()} method.
     * @param annotationName Name of annotation
     * @return List of methods with annotation
     */
    public List<Method> getMethodsWithAnnotation(String annotationName){
        if(annotationName == null){
            throw new IllegalArgumentException("Null");
        }
        Method[] methods = getAllClassMethods();
        List<Method> resultAnntotations = new ArrayList<Method>();
        for (int i = 0; i < methods.length; i++) {
            Annotation[] arrayAnnotations = methods[i].getAnnotations();
            for (Annotation annotation : arrayAnnotations) {
                if(annotation.annotationType().getSimpleName().equals(annotationName)){
                    resultAnntotations.add(methods[i]);
                    continue;
                }
            }
        }
        return resultAnntotations;
    }

    /**
     * Method use {@link WorkWithAnnotatedMethods#getMethodsWithAnnotation(String)} method with default param = "FillingArrays".
     * @return List of methods with annotation "FillingArrays"
     */
    public List<Method> getMethodsWithAnnotation(){
        String annotationName = "FillingArrays";
        List<Method> resultAnntotations = getMethodsWithAnnotation(annotationName);
        return resultAnntotations;
    }
}
