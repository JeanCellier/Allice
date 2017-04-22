package phenotypage.model.invitro.culture;

import phenotypage.model.donneesExistantes.sanitaire.Sanitaire;

import java.util.Date;
import java.util.List;

public interface CultureService {
    List<Culture> findAll();

    Culture newCulture();

    Culture createCulture(Date date, String remarques, List<Sanitaire> sanitaireList, List<TableauCulture> tableauCultureList);

    Culture addCulture(Culture culture);

    void delete(Culture culture);
}
