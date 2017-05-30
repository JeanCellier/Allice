package phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.embryonsInVivo.EmbryonsInVivo;

import java.util.List;

/**
 * Created by Loick on 22/05/2017.
 */
@Component
public class VisoTubeInVivoServiceImpl implements VisoTubeInVivoService {

    @Autowired
    private VisoTubeInVivoRepository visoTubeInVivoRepository;

    @Override
    public List<VisoTubeInVivo> findAllVisoTubeInVivo() {
        return visoTubeInVivoRepository.findAll();
    }

    @Override
    public VisoTubeInVivo createVisoTubeInVivo(EmbryonsInVivo embryonsInVivo) {
        return visoTubeInVivoRepository.save(new VisoTubeInVivo(embryonsInVivo));
    }

    @Override
    public VisoTubeInVivo addVisoTubeInVivo(VisoTubeInVivo visoTubeInVivo) {
        return visoTubeInVivoRepository.save(visoTubeInVivo);
    }

    @Override
    public VisoTubeInVivo newVisoTubeInVivo() {
        return new VisoTubeInVivo();
    }

    @Override
    public void delete(VisoTubeInVivo visoTubeInVivo) {
        visoTubeInVivoRepository.delete(visoTubeInVivo);
    }
}
