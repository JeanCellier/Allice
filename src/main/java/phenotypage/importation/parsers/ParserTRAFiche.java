package phenotypage.importation.parsers;

import org.springframework.stereotype.Component;
import phenotypage.model.fiche.Fiche;

import java.io.File;
import java.util.List;

/**
 * Created with magic
 * User: simoe
 * Date: 19/04/2017 20:17
 * Project: appPhenotypage
 */
@Component("TRA")
public class ParserTRAFiche implements ParserFiche {

    @Override
    public List<Fiche> parse(File file) {
        //TODO: parse the file
        return null;
    }
}
