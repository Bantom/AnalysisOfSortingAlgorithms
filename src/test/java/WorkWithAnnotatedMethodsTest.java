import org.junit.Before;
import org.junit.Test;
import reflection.WorkWithAnnotatedMethods;

import static junit.framework.TestCase.assertTrue;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author Bulgakov
 * @since 01.12.2016
 */
public class WorkWithAnnotatedMethodsTest {
    WorkWithAnnotatedMethods workWithAnnotatedMethods;

    @Before
    public void init() {
        workWithAnnotatedMethods = new WorkWithAnnotatedMethods();
    }

    @Test
    public void getMethodsWithAnnotationTest() {
        List<Method> methodList = workWithAnnotatedMethods.getMethodsWithAnnotation("FillingArrays");
        for (int i = 0; i < methodList.size(); i++) {
            assertTrue(methodList.get(i) instanceof Method);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void getMethodsWithAnnotationNullArgumentTest() {
        List<Method> methodList = workWithAnnotatedMethods.getMethodsWithAnnotation(null);
    }
}
