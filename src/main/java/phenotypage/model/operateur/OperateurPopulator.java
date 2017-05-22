package phenotypage.model.operateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by nicolas on 26/04/17.
 */
@Component
public class OperateurPopulator {
    @Autowired
    private OperateurService operateurService;

    @PostConstruct
    void init()
    {
//        operateurService.createOperateur("Denoës", "Olivier");
    }
}
