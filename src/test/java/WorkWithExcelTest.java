import excel.WorkWithExcel;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Bulgakov
 * @since 01.12.2016
 */
public class WorkWithExcelTest {

    @Test
    public void createNewExcelDocumentTest() {
        WorkWithExcel excel = new WorkWithExcel();
        excel.createNewExcelDocument();
        File folder = new File("D:\\");

        String[] files = folder.list(new FilenameFilter() {
            public boolean accept(File folder, String name) {
                return name.endsWith(".xlsx");
            }
        });

        assertTrue(contains(files));
    }

    private boolean contains(String[] files) {
        if (files == null) {
            return false;
        }
        Pattern p = Pattern.compile("^statisticsOfSortMethods\\d*.xlsx$");
        Matcher m;
        for (String fileName : files) {
            if (p.matcher(fileName).matches()) {
                return true;
            }
        }
        return false;
    }
}
