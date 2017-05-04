package phenotypage.exportation.converters;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Created with magic
 * User: simoe
 * Date: 03/05/2017 22:43
 * Project: appPhenotypage
 */
public interface ConverterFiche {

    /**
     * Converts a fiche to a file
     *
     * @param ficheNom Nom de fiche
     * @return workbook
     */
    XSSFWorkbook toWorkbook(String ficheNom);
}
