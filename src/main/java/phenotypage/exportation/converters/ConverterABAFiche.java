package phenotypage.exportation;

import org.springframework.stereotype.Component;
import phenotypage.model.fiche.Fiche;

import java.io.File;

/**
 * Created with magic
 * User: simoe
 * Date: 03/05/2017 22:46
 * Project: appPhenotypage
 */
@Component("Aba")
public class ConverterABAFiche implements ConverterFiche {
    @Override
    public File toFile(Fiche fiche) {
        return null;
    }
}
