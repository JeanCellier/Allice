package phenotypage.importation.parsers;

import phenotypage.model.fiche.Fiche;

import java.io.File;
import java.util.List;

/**
 * Created with magic
 * User: simoe
 * Date: 18/04/2017 20:07
 * Project: appPhenotypage
 */
public interface ParserFiche {

    /**
     * Parses a file
     *
     * @param file file
     * @return fiche
     */
    List<Fiche> parse(File file);

}
