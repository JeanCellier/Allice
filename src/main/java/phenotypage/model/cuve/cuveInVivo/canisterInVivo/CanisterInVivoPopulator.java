package phenotypage.model.cuve.cuveInVivo.canisterInVivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cuve.canister.visoTube.VisoTube;
import phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.VisoTubeInVivo;
import phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.VisoTubeInVivoService;
import phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.embryonsInVivo.EmbryonsInVivo;
import phenotypage.model.fiche.ficheCol.FicheColService;
import phenotypage.model.operateur.OperateurService;
import phenotypage.model.programme.ProgrammeService;
import phenotypage.model.vache.VacheService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolas on 18/05/17.
 */
@Component
public class CanisterInVivoPopulator {
    @Autowired
    private CanisterInVivoService canisterInVivoService;

    @Autowired
    private VisoTubeInVivoService visoTubeInVivoService;

    @PostConstruct
    void init()
    {
//        List<VisoTubeInVivo> listViso = new ArrayList<>();
//        List<VisoTubeInVivo> listViso2 = new ArrayList<>();
//        List<VisoTubeInVivo> listViso3 = new ArrayList<>();
//        List<EmbryonsInVivo> listEmbryons = new ArrayList<>();
//        listViso.add(visoTubeInVivoService.createVisoTubeInVivo("vert", listEmbryons));
//        listViso.add(visoTubeInVivoService.createVisoTubeInVivo("rouge", listEmbryons));
//        listViso.add(visoTubeInVivoService.createVisoTubeInVivo("bleu", listEmbryons));
//
//        canisterInVivoService.createCanisterInVivo(1, "canister1", listViso);
//
//        listViso2.add(visoTubeInVivoService.createVisoTubeInVivo("rose", listEmbryons));
//        listViso2.add(visoTubeInVivoService.createVisoTubeInVivo("orange", listEmbryons));
//        listViso2.add(visoTubeInVivoService.createVisoTubeInVivo("rouge", listEmbryons));
//
//        canisterInVivoService.createCanisterInVivo(2, "canister2", listViso2);
//
//        listViso3.add(visoTubeInVivoService.createVisoTubeInVivo("gris", listEmbryons));
//        listViso3.add(visoTubeInVivoService.createVisoTubeInVivo("noir", listEmbryons));
//        listViso3.add(visoTubeInVivoService.createVisoTubeInVivo("jaune", listEmbryons));
//
//        canisterInVivoService.createCanisterInVivo(3, "canister3", listViso3);
    }
}