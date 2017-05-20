package phenotypage.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

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
    public static XSSFCell writeCell(XSSFSheet sheet, int row, int column, String value) {
        return writeCell(sheet, row, column, value, CellType.STRING);
    }

    /**
     * Writes a value into a sheet cell
     *
     * @param sheet  sheet
     * @param row    row index
     * @param column column index
     * @param value  value
     */
    public static XSSFCell writeCell(XSSFSheet sheet, int row, int column, Double value) {
        return writeCell(sheet, row, column, value, CellType.NUMERIC);
    }


    /**
     * Writes a value into a sheet cell
     *
     * @param sheet  sheet
     * @param row    row index
     * @param column column index
     * @param value  value
     */
    public static XSSFCell writeCell(XSSFSheet sheet, int row, int column, Boolean value) {
        return writeCell(sheet, row, column, value, CellType.BOOLEAN);
    }


    /**
     * Writes a value into a sheet cell
     *
     * @param sheet  sheet
     * @param row    row index
     * @param column column index
     * @param value  value
     */
    public static XSSFCell writeFormula(XSSFSheet sheet, int row, int column, String value) {
        return writeCell(sheet, row, column, value, CellType.FORMULA);
    }

    /**
     * Writes a value into a sheet cell
     *
     * @param sheet  sheet
     * @param row    row index
     * @param column column index
     * @param value  value
     */
    public static XSSFCell writeCell(XSSFSheet sheet, int row, int column, Object value, CellType type) {
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
        return cell;
    }

    public static void mergeColumn(XSSFSheet sheet, int row, int col1, int col2) {
        sheet.addMergedRegion(new CellRangeAddress(row, row, col1, col2));
    }

    public static void mergeRowAndColumn(XSSFSheet sheet, int row1, int row2, int col1, int col2) {
        sheet.addMergedRegion(new CellRangeAddress(row1, row2, col1, col2));
    }

    public static XSSFCellStyle getTitleStyle(XSSFWorkbook workbook) {
        XSSFFont boldUnderlinedFont = workbook.createFont();
        boldUnderlinedFont.setBold(true);
        boldUnderlinedFont.setUnderline(XSSFFont.U_SINGLE);

        XSSFCellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setFont(boldUnderlinedFont);

        return titleStyle;

    }

    public static XSSFCellStyle getTableHeaderStyle(XSSFWorkbook workbook) {
        XSSFFont boldFont = workbook.createFont();
        boldFont.setBold(true);

        XSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(boldFont);
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);
        headerStyle.setBorderTop(BorderStyle.THIN);

        return headerStyle;
    }

    public static XSSFCellStyle getTableBodyStyle(XSSFWorkbook workbook) {
        XSSFCellStyle bodyStyle = workbook.createCellStyle();
        bodyStyle.setAlignment(CellStyle.ALIGN_CENTER);
        bodyStyle.setBorderBottom(BorderStyle.THIN);
        bodyStyle.setBorderLeft(BorderStyle.THIN);
        bodyStyle.setBorderRight(BorderStyle.THIN);
        bodyStyle.setBorderTop(BorderStyle.THIN);

        return bodyStyle;
    }
}