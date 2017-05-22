package phenotypage.model.invitro.culture;

import java.util.List;

public interface CultureService {
    List<Culture> findAll();

    Culture newCulture();

    Culture addCulture(Culture culture);

    void delete(Culture culture);
}