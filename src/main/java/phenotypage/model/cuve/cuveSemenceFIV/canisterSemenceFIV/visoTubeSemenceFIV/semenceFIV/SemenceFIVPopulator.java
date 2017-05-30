package phenotypage.model.cuve.cuveSemenceFIV.canisterSemenceFIV.visoTubeSemenceFIV.semenceFIV;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by Loick on 27/05/2017.
 */
public class SemenceFIVPopulator {

    @Autowired
    private SemenceFIVService semenceService;

    @PostConstruct
    void init()
    {
//        semenceService.createSemence("66", "1020FR0125", 5, "jaune", true, "lol", true);
//        semenceService.createSemence("66", "1020FR0126", 5, "jaune", true, "lol", true);
    }
}
