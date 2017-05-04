package phenotypage.exportation;

import phenotypage.model.fiche.Fiche;

import java.io.File;

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
     * @param fiche fiche
     * @return file
     */
    File toFile(Fiche fiche);
}
