package phenotypage.model.cuve.cuveInVitro.canisterInVitro.visoTubeInVitro;

import phenotypage.model.cuve.cuveInVitro.canisterInVitro.visoTubeInVitro.embryonsInVitro.EmbryonsInVitro;

import java.util.List;

/**
 * Created by Loick on 22/05/2017.
 */
public interface VisoTubeInVitroService {

    List<VisoTubeInVitro> findAllVisoTubeInVitro();

    VisoTubeInVitro createVisoTubeInVitro(List<EmbryonsInVitro> embryonsInVitroList);

    VisoTubeInVitro addVisoTubeInVitro(VisoTubeInVitro visoTubeInVitro);

    VisoTubeInVitro newVisoTubeInVitro();
}
