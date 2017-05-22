package phenotypage.model.cuve.cuveInVitro.canisterInVitro;

import phenotypage.model.cuve.cuveInVitro.canisterInVitro.visoTubeInVitro.VisoTubeInVitro;

import java.util.List;

/**
 * Created by Loick on 22/05/2017.
 */
public interface CanisterInVitroService {

    List<CanisterInVitro> findAllCanisterInVitro();

    CanisterInVitro createCanisterInVitro(List<VisoTubeInVitro> visoTubeInVitroList);

    CanisterInVitro addCanisterInVitro(CanisterInVitro canisterInVitro);

    CanisterInVitro newCanisterInVitro();
}
