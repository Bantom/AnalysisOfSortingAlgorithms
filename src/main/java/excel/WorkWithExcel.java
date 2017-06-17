package excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import statistics.WorkWithStatistics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

/**
 * @author Bulgakov
 * @since 25.11.2016
 */
public class WorkWithExcel {

    /**
     * Method create excel document with data obtained from {@link statistics.WorkWithStatistics#getStatisticsForSortMethodsForExcel()} method.<br>
     * It uses {@link WorkWithExcel#drawChart(XSSFSheet, Integer)} method for drawing charts in excel document.
     *
     * @see org.apache.poi
     */
    public void createNewExcelDocument() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Map<String, Map<String, Map<Integer, Long>>> statisticsOfSortMethods = WorkWithStatistics.getStatisticsForSortMethodsForExcel();
        for (Map.Entry<String, Map<String, Map<Integer, Long>>> pair : statisticsOfSortMethods.entrySet()) {
            XSSFSheet sheet = workbook.createSheet(pair.getKey());
            sheet = createTitlesForColumns(sheet, pair.getValue());
            Integer columnNumber = 0;
            Integer rowNumber = 1;
            for (Map.Entry<String, Map<Integer, Long>> pair1 : pair.getValue().entrySet()) {
                columnNumber = 0;
                Row row = sheet.createRow(rowNumber++);
                Cell cell = row.createCell(columnNumber++);
                cell.setCellValue(pair1.getKey());
                for (Map.Entry<Integer, Long> pair2 : pair1.getValue().entrySet()) {
                    cell = row.createCell(columnNumber++);
                    cell.setCellValue(pair2.getValue());
                }
            }
            sheet = drawChart(sheet, columnNumber);
        }
        writeInExcelFile(workbook, "statisticsOfSortMethods");
    }

    /**
     * Method write data in excel file.
     * @param workbook XSSFWorkbook
     * @param fileName name of excel file
     */
    private static void writeInExcelFile(XSSFWorkbook workbook, String fileName) {
        try {
            FileOutputStream out;
            out = new FileOutputStream(new File("D:\\"+ fileName +".xlsx"));
            workbook.write(out);
            out.close();
            assert true;
        } catch (FileNotFoundException e) {
            writeInExcelFile(workbook,fileName + new Random().nextInt());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method draw chart using sheet with data and numbers of columns.
     *
     * @param sheet        Excel sheet
     * @param columnNumber Quantity of columns in table with data for building chart
     * @return Excel sheet with chart
     * @see org.apache.poi
     */
    private XSSFSheet drawChart(XSSFSheet sheet, Integer columnNumber) {
        Drawing drawing = sheet.createDrawingPatriarch();
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 10, 11, 23);

        Chart chart = drawing.createChart(anchor);
        ChartLegend legend = chart.getOrCreateLegend();
        legend.setPosition(LegendPosition.RIGHT);

        LineChartData data = chart.getChartDataFactory().createLineChartData();

        ChartAxis bottomAxis = chart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
        ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
        leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

        ChartDataSource<Number> xs = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(0, 0, 1, columnNumber - 1));
        for (int i = 1; i <= 6; i++) {
            ChartDataSource<Number> ys = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(i, i, 1, columnNumber - 1));
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0);
            data.addSeries(xs, ys).setTitle(cell.getStringCellValue());
        }

        chart.plot(data, bottomAxis, leftAxis);
        return sheet;
    }

    /**
     * Method write titles of table with data in sheet of excel document.
     *
     * @param sheet                   Excel sheet
     * @param statisticsOfSortMethods Data about statistic of sorting methods
     * @return Excel sheet with titles
     * @see org.apache.poi
     */
    private XSSFSheet createTitlesForColumns(XSSFSheet sheet, Map<String, Map<Integer, Long>> statisticsOfSortMethods) {
        Integer rowNumber = 0;
        Integer columnNumber = 0;
        Row row = sheet.createRow(rowNumber);
        Cell cell = row.createCell(columnNumber);
        cell.setCellValue("Sorting Method");
        for (Map.Entry<String, Map<Integer, Long>> pair1 : statisticsOfSortMethods.entrySet()) {
            for (Map.Entry<Integer, Long> pair3 : pair1.getValue().entrySet()) {
                cell = row.createCell(++columnNumber);
                cell.setCellValue(pair3.getKey().toString());
            }
            break;
        }
        return sheet;
    }


}
