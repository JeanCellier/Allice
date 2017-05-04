package phenotypage.exportation.converters;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

/**
 * Created with magic
 * User: simoe
 * Date: 03/05/2017 23:56
 * Project: appPhenotypage
 */
@Component("Opu")
public class ConverterOPUFiche implements ConverterFiche {

    @Override
    public XSSFWorkbook toWorkbook(String ficheNom) {
        //TODO: convert a fiche to a workbook
        return null;
    }
}
