package phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo;

import phenotypage.model.cuve.cuveInVitro.CuveInVitro;
import phenotypage.model.cuve.cuveInVitro.canisterInVitro.CanisterInVitro;
import phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.embryonsInVivo.EmbryonsInVivo;

import java.util.List;

/**
 * Created by Loick on 22/05/2017.
 */
public interface VisoTubeInVivoService {

    List<VisoTubeInVivo> findAllVisoTubeInVivo();

    VisoTubeInVivo createVisoTubeInVivo(List<EmbryonsInVivo> embryonsInVivoList);

    VisoTubeInVivo addVisoTubeInVivo(VisoTubeInVivo visoTubeInVivo);

    VisoTubeInVivo newVisoTubeInVivo();

}
