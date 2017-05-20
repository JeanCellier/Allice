package phenotypage.model.fiche.ficheCol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.operateur.Operateur;
import phenotypage.model.operateur.OperateurService;
import phenotypage.model.programme.Programme;
import phenotypage.model.programme.ProgrammeService;
import phenotypage.model.vache.Vache;
import phenotypage.model.vache.VacheService;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * Created by nicolas on 18/05/17.
 */
@Component
public class FicheColPopulator {
    @Autowired
    private FicheColService ficheColService;

    @Autowired
    private VacheService vacheService;

    @Autowired
    private ProgrammeService programmeService;

    @Autowired
    private OperateurService operateurService;

    @PostConstruct
    void init()
    {
        Operateur operateur = operateurService.createOperateur("Denoes", "Oliver");
        Programme programme = programmeService.createProgramme("Bovomega3");
        Vache vache = vacheService.createVache(true, "Allice", "vache1", "FR37175336", "fr5638962543", 66, 'F', new Date(), "parite", 20.5F, "fr5638962542", "fr5638962544");
        ficheColService.createFicheCol("17COL0004", programme, new Date(), "FR TB 370", "Allice", operateur, vache, null, null, null, null, null, null);
    }
}