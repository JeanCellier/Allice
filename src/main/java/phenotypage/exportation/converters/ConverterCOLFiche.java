package phenotypage.exportation.converters;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

/**
 * Created with magic
 * User: simoe
 * Date: 03/05/2017 23:55
 * Project: appPhenotypage
 */
@Component("Col")
public class ConverterCOLFiche implements ConverterFiche {

    @Override
    public XSSFWorkbook toWorkbook(String ficheNom) {
        //TODO: convert a fiche to a workbook
        return null;
    }
}
