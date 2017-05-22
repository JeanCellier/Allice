package phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo;

import phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.embryonsInVivo.EmbryonsInVivo;

import java.util.List;

/**
 * Created by Loick on 22/05/2017.
 */
public class VisoTubeInVivoServiceImpl implements VisoTubeInVivoService {

    VisoTubeInVivoRepository visoTubeInVivoRepository;

    @Override
    public List<VisoTubeInVivo> findAllVisoTubeInVivo() {
        return visoTubeInVivoRepository.findAll();
    }

    @Override
    public VisoTubeInVivo createVisoTubeInVivo(List<EmbryonsInVivo> embryonsInVivoList) {
        return visoTubeInVivoRepository.save(new VisoTubeInVivo(embryonsInVivoList));
    }

    @Override
    public VisoTubeInVivo addVisoTubeInVivo(VisoTubeInVivo visoTubeInVivo) {
        return visoTubeInVivoRepository.save(visoTubeInVivo);
    }

    @Override
    public VisoTubeInVivo newVisoTubeInVivo() {
        return new VisoTubeInVivo();
    }
}
