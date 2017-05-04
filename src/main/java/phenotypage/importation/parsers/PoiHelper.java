package phenotypage.importation.parser;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Created with magic
 * User: simoe
 * Date: 19/04/2017 14:01
 * Project: appPhenotypage
 */
class PoiHelper {

    private static DataFormatter formatter = new DataFormatter();

    /**
     * Reads the content of a cell in a sheet
     *
     * @param sheet  sheet
     * @param row    row starting from 0
     * @param column column starting from 0
     * @return content
     */
    static String readCell(Sheet sheet, int row, int column) {
        if (row < 0 || column < 0) {
            return null;
        }
        Cell cell = sheet.getRow(row).getCell(column);
        FormulaEvaluator evaluator = new XSSFFormulaEvaluator((XSSFWorkbook) sheet.getWorkbook());
        return formatter.formatCellValue(cell, evaluator);
    }
}