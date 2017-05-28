package phenotypage.model.cuve.cuveInVivo.canisterInVivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.VisoTubeInVivo;
import phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.VisoTubeInVivoService;

import java.util.List;
import java.util.Optional;

/**
 * Created by Loick on 22/05/2017.
 */
@Component
public class CanisterInVivoServiceImpl implements CanisterInVivoService {

    @Autowired
    private CanisterInVivoRepository canisterInVivoRepository;

    @Autowired
    private VisoTubeInVivoService visoTubeInVivoService;

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

    @Override
    public void delete(CanisterInVivo canisterInVivo) {
        canisterInVivoRepository.delete(canisterInVivo);
    }

    @Override
    public Optional<CanisterInVivo> findOne(long id) {
        return Optional.ofNullable(canisterInVivoRepository.findOne(id));
    }
}
