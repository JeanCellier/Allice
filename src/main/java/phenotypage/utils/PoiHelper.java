package phenotypage.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 * Created with magic
 * User: simoe
 * Date: 19/04/2017 14:01
 * Project: appPhenotypage
 */
public class PoiHelper {

    private static DataFormatter formatter = new DataFormatter();

    /**
     * Reads the content of a cell in a sheet
     *
     * @param sheet  sheet
     * @param row    row starting from 0
     * @param column column starting from 0
     * @return content
     */
    public static String readCell(XSSFSheet sheet, int row, int column) {
        if (row < 0 || column < 0) {
            return null;
        }
        Cell cell = sheet.getRow(row).getCell(column);
        FormulaEvaluator evaluator = new XSSFFormulaEvaluator(sheet.getWorkbook());
        return formatter.formatCellValue(cell, evaluator);
    }

    /**
     * Writes a value into a sheet cell
     *
     * @param sheet  sheet
     * @param row    row index
     * @param column column index
     * @param value  value
     */
    public static void writeCell(XSSFSheet sheet, int row, int column, String value) {
        writeCell(sheet, row, column, value, CellType.STRING);
    }

    /**
     * Writes a value into a sheet cell
     *
     * @param sheet  sheet
     * @param row    row index
     * @param column column index
     * @param value  value
     */
    public static void writeCell(XSSFSheet sheet, int row, int column, Double value) {
        writeCell(sheet, row, column, value, CellType.NUMERIC);
    }


    /**
     * Writes a value into a sheet cell
     *
     * @param sheet  sheet
     * @param row    row index
     * @param column column index
     * @param value  value
     */
    public static void writeCell(XSSFSheet sheet, int row, int column, Boolean value) {
        writeCell(sheet, row, column, value, CellType.BOOLEAN);
    }


    /**
     * Writes a value into a sheet cell
     *
     * @param sheet  sheet
     * @param row    row index
     * @param column column index
     * @param value  value
     */
    public static void writeFormula(XSSFSheet sheet, int row, int column, String value) {
        writeCell(sheet, row, column, value, CellType.FORMULA);
    }

    /**
     * Writes a value into a sheet cell
     *
     * @param sheet  sheet
     * @param row    row index
     * @param column column index
     * @param value  value
     */
    public static void writeCell(XSSFSheet sheet, int row, int column, Object value, CellType type) {
        XSSFRow xssfRow = sheet.getRow(row);
        if (xssfRow == null) {
            xssfRow = sheet.createRow(row);
        }
        XSSFCell cell = xssfRow.createCell(column, type);
        switch (type) {
            case STRING:
                cell.setCellValue((String) value);
                break;
            case BOOLEAN:
                cell.setCellValue((Boolean) value);
                break;
            case NUMERIC:
                cell.setCellValue((Double) value);
                break;
            case FORMULA:
                cell.setCellFormula((String) value);
        }
    }
}