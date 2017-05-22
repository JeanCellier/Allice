package phenotypage.model.cuve.cuveInVivo.canisterInVivo;

import phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.VisoTubeInVivo;

import java.util.List;

/**
 * Created by Loick on 22/05/2017.
 */
public class CanisterInVivoServiceImpl implements CanisterInVivoService {

    private CanisterInVivoRepository canisterInVivoRepository;

    @Override
    public List<CanisterInVivo> findAllCanisterInVivo() {
        return canisterInVivoRepository.findAll();
    }

    @Override
    public CanisterInVivo createCanisterInVivo(List<VisoTubeInVivo> visoTubeList) {
        return canisterInVivoRepository.save(new CanisterInVivo(visoTubeList));
    }

    @Override
    public CanisterInVivo addCanisterInVivo(CanisterInVivo canisterInVivo) {
        return canisterInVivoRepository.save(canisterInVivo);
    }

    @Override
    public CanisterInVivo newCanisterInVivo() {
        return new CanisterInVivo();
    }
}
