package phenotypage.exportation;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * Created with magic
 * User: simoe
 * Date: 03/05/2017 13:12
 * Project: appPhenotypage
 */
public interface ExportService {

    /**
     * Exports a fiche
     *
     * @param ficheNom nom de fiche
     * @param type     type de fiche
     */
    Workbook export(String ficheNom, String type);

}
