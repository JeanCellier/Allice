package phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo;

import phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.embryonsInVivo.EmbryonsInVivo;

import java.util.List;
import java.util.Optional;

/**
 * Created by Loick on 22/05/2017.
 */
public interface VisoTubeInVivoService {

    List<VisoTubeInVivo> findAll();

    VisoTubeInVivo createVisoTubeInVivo(String couleur, List<EmbryonsInVivo> embryonsInVivo);

    VisoTubeInVivo update(VisoTubeInVivo visoTubeInVivo, String couleur, List<EmbryonsInVivo> embryonsInVivo);

    VisoTubeInVivo save(VisoTubeInVivo visoTubeInVivo);

    void delete(VisoTubeInVivo visoTubeInVivo);

    Optional<VisoTubeInVivo> findOne(long id);

    Optional<VisoTubeInVivo> findByEmbryonsInVivo(EmbryonsInVivo embryonsInVivo);
}
