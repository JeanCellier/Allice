package phenotypage.importation.parser;

import org.springframework.stereotype.Component;
import phenotypage.model.fiche.Fiche;

import java.io.File;
import java.util.List;

/**
 * Created with magic
 * User: simoe
 * Date: 19/04/2017 20:16
 * Project: appPhenotypage
 */
@Component("COL")
public class ParserCOLFiche implements ParserFiche {

    @Override
    public List<Fiche> parse(File file) {
        //TODO parse the file
        return null;
    }
}
