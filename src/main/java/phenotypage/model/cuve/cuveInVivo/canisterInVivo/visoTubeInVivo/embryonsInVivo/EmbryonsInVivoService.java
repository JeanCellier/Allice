package phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.embryonsInVivo;

import phenotypage.model.cryoconservation.embryon.Embryon;
import phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.semence.Semence;

import java.util.List;

/**
 * Created by Loick on 22/05/2017.
 */
public interface EmbryonsInVivoService {

    List<EmbryonsInVivo> findAllCuveInVivo();

    EmbryonsInVivo createCuveInVitro(Embryon embryon, String couleur, Semence semence, String biopsie, String remarques);

    EmbryonsInVivo addCuveInVitro(EmbryonsInVivo embryonsInVivo);

    EmbryonsInVivo newCuveInVitro();

    void delete(EmbryonsInVivo embryonsInVivo);
}
