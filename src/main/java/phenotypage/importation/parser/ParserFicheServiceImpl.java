package phenotypage.importation.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phenotypage.model.fiche.Fiche;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created with magic
 * User: simoe
 * Date: 18/04/2017 23:47
 * Project: appPhenotypage
 */
@Service
public class ParserFicheServiceImpl implements ParserFicheService {

    private final Map<String, ParserFiche> parsers;

    @Autowired
    public ParserFicheServiceImpl(Map<String, ParserFiche> parsers) {
        this.parsers = parsers;
    }

    @Override
    public List<Fiche> parse(File file, String type) {
        if (isValidFile(file) && isValidType(type)) {
            return parsers.get(type).parse(file);
        }
        return null;
    }

    @Override
    public boolean isValidFile(File file) {
        return file.exists() && file.canRead() && file.isFile();
    }

    @Override
    public boolean isValidType(String type) {
        return parsers.get(type) != null;
    }
}
