package phenotypage.model.programme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.operateur.OperateurService;

import javax.annotation.PostConstruct;

/**
 * Created by nicolas on 26/04/17.
 */
@Component
public class ProgrammePopulator {
    @Autowired
    private ProgrammeService programmeService;

    @PostConstruct
    void init()
    {
        programmeService.createProgramme("Bovomega3");
    }
}
