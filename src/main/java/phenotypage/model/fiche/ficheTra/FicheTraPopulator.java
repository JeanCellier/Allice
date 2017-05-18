package phenotypage.model.fiche.ficheTra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.operateur.OperateurService;
import phenotypage.model.programme.ProgrammeService;
import phenotypage.model.vache.VacheService;


/**
 * Created by nicolas on 06/04/17.
 */
@Component
public class FicheTraPopulator {
    @Autowired
    private FicheTraService ficheTraService;

    @Autowired
    private VacheService vacheService;

    @Autowired
    private ProgrammeService programmeService;

    @Autowired
    private OperateurService operateurService;

//    @PostConstruct
//    void init()
//    {
//        Operateur operateur = operateurService.createOperateur("Denoes", "Oliver");
//        Programme programme = programmeService.createProgramme("Bovomega3");
//        Vache vache = vacheService.createVache(true, "Allice", "vache1", "FR37175336", "fr5638962543", 66, 'F', new Date(), "parite", 20.5F, "fr5638962542", "fr5638962544");
//        ficheTraService.createFicheTra("16TRA0004", programme, new Date(), "FR TB 370", "Allice", operateur, vache, null, null, null, null);
//    }
}
