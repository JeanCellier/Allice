package phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.embryonsInVivo;

import phenotypage.model.cryoconservation.embryon.Embryon;
import phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.semence.Semence;

import java.util.List;
import java.util.Optional;

/**
 * Created by Loick on 22/05/2017.
 */
public interface EmbryonsInVivoService {

    List<EmbryonsInVivo> findAll();

    EmbryonsInVivo create(Embryon embryon, String couleur, Semence semence, String biopsie, String remarques);

    EmbryonsInVivo save(EmbryonsInVivo embryonsInVivo);

    void delete(EmbryonsInVivo embryonsInVivo);

    Optional<EmbryonsInVivo> findByEmbryon(Embryon embryon);
}
