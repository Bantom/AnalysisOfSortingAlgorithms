import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

import java.io.IOException;

import static reflection.WorkWithReflection.*;

/**
 * @author Bulgakov
 * @since 01.12.2016
 */
public class WorkWithReflectionTest {

    @Test
    public void getClassesTest() throws IOException, ClassNotFoundException {
        Class[] classes = getClasses("statistics");
        for (Class classTmp : classes) {
            assertTrue(classTmp.getSimpleName().equals("WorkWithStatistics"));
        }
    }

    @Test(expected = ClassNotFoundException.class)
    public void getClassesNotFoundTest() throws IOException, ClassNotFoundException {
        Class[] classes = getClasses("");
    }
}
