package phenotypage.model.cuve.cuveInVitro.canisterInVitro;

import phenotypage.model.cuve.cuveInVitro.canisterInVitro.visoTubeInVitro.VisoTubeInVitro;

import java.util.List;

/**
 * Created by Loick on 22/05/2017.
 */
public class CanisterInVitroServiceImpl implements CanisterInVitroService {

    CanisterInVitroRepository canisterInVitroRepository;

    @Override
    public List<CanisterInVitro> findAllCanisterInVitro() {
        return canisterInVitroRepository.findAll();
    }

    @Override
    public CanisterInVitro createCanisterInVitro(List<VisoTubeInVitro> visoTubeInVitroList) {
        return canisterInVitroRepository.save(new CanisterInVitro(visoTubeInVitroList));
    }

    @Override
    public CanisterInVitro addCanisterInVitro(CanisterInVitro canisterInVitro) {
        return canisterInVitroRepository.save(canisterInVitro);
    }

    @Override
    public CanisterInVitro newCanisterInVitro() {
        return new CanisterInVitro();
    }
}
