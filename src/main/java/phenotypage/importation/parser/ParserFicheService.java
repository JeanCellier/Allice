package phenotypage.importation.parser;

import phenotypage.model.fiche.Fiche;

import java.io.File;
import java.util.List;

/**
 * Created with magic
 * User: simoe
 * Date: 18/04/2017 23:44
 * Project: appPhenotypage
 */
public interface ParserFicheService {

    /**
     * Parses a file
     *
     * @param file file
     * @param type type of fiche
     * @return list of fiches
     */
    List<Fiche> parse(File file, String type);

    /**
     * Is it a valid file
     *
     * @param file file
     * @return valid or not
     */
    boolean isValidFile(File file);

    /**
     * Is it a valid type
     *
     * @param type type of fiche
     * @return valid or not
     */
    boolean isValidType(String type);
}
