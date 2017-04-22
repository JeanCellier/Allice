package phenotypage.model.invitro.culture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.donneesExistantes.sanitaire.Sanitaire;

import java.util.Date;
import java.util.List;

@Component
public class CultureServiceImpl implements CultureService {
    @Autowired
    private CultureRepository cultureRepository;

    @Override
    public List<Culture> findAll() {
        return cultureRepository.findAll();
    }

    @Override
    public Culture newCulture() {
        return new Culture();
    }

    @Override
    public Culture createCulture(Date date, String remarques, List<Sanitaire> sanitaireList, List<TableauCulture> tableauCultureList) {
        Culture culture = new Culture();
        culture.setDate(date);
        culture.setRemarques(remarques);
        culture.setSanitaireList(sanitaireList);
        culture.setTableauCultureList(tableauCultureList);
        return culture;
    }

    @Override
    public Culture addCulture(Culture culture) {
        return cultureRepository.save(culture);
    }

    @Override
    public void delete(Culture culture) {
        cultureRepository.delete(culture);
    }

}
