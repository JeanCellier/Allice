package phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.semence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by nicolas on 21/05/17.
 */
@Component
public class SemencePopulator {

    @Autowired
    private SemenceService semenceService;

    @PostConstruct
    void init()
    {
//        semenceService.createSemence("66", "1020FR0125", 5, "jaune", true, "lol", true);
//        semenceService.createSemence("66", "1020FR0126", 5, "jaune", true, "lol", true);
    }
}
