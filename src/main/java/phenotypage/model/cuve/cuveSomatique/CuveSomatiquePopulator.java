package phenotypage.model.cuve.cuveSomatique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.CanisterSomatique;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.CanisterSomatiqueService;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.VisoTubeSomatique;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.VisoTubeSomatiqueService;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.celluleSomatique.CelluleSomatique;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.celluleSomatique.CelluleSomatiqueService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Loick on 24/05/2017.
 */
@Component
public class CuveSomatiquePopulator {
    @Autowired
    private CuveSomatiqueService cuveSomatiqueService;

    @Autowired
    private CanisterSomatiqueService canisterSomatiqueService;

    @Autowired
    private VisoTubeSomatiqueService visoTubeSomatiqueService;

    @Autowired
    private CelluleSomatiqueService celluleSomatiqueService;

    @PostConstruct
    void init()
    {

//            CuveSomatique cuveSomatique = new CuveSomatique();
//            cuveSomatique.setNom("Cuve Somatique");
//            cuveSomatique.setDesignation("Cuve Somatique");
//            cuveSomatiqueService.addCuveSomatique(cuveSomatique);

    }
}
