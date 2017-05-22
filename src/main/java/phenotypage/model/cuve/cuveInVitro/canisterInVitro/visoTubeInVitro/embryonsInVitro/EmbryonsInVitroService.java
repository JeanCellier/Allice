package phenotypage.model.cuve.cuveInVitro.canisterInVitro.visoTubeInVitro.embryonsInVitro;

import phenotypage.model.cryoconservation.embryon.Embryon;
import phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.semence.Semence;

import java.util.List;

/**
 * Created by Loick on 22/05/2017.
 */
public interface EmbryonsInVitroService {


    List<EmbryonsInVitro> findAllEmbryonsInVitro();

    EmbryonsInVitro createEmbryonsInVitro(Embryon embryon, String couleur, Semence semence, int nbPaillettes, String remarques);

    EmbryonsInVitro addEmbryonsInVitro(EmbryonsInVitro embryonsInVitro);

    EmbryonsInVitro newEmbryonsInVitro();
}
