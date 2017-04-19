package phenotypage.importation.parser;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * Created with magic
 * User: simoe
 * Date: 19/04/2017 14:01
 * Project: appPhenotypage
 */
public class PoiHelper {

    static DataFormatter formatter = new DataFormatter();

    /**
     * Reads the content of a cell in a sheet
     *
     * @param sheet  sheet
     * @param row    row starting from 0
     * @param column column starting from 0
     * @return content
     */
    public static String readCell(Sheet sheet, int row, int column) {
        if (row < 0 || column < 0) {
            return null;
        }
        return formatter.formatCellValue(sheet.getRow(4).getCell(1));
    }
}
