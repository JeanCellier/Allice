package phenotypage.model.cuve.cuveInVitro.canisterInVitro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cuve.cuveInVitro.canisterInVitro.visoTubeInVitro.VisoTubeInVitro;
import phenotypage.model.cuve.cuveInVitro.canisterInVitro.visoTubeInVitro.VisoTubeInVitroService;

import java.util.List;
import java.util.Optional;

/**
 * Created by Loick on 22/05/2017.
 */
@Component
public class CanisterInVitroServiceImpl implements CanisterInVitroService {

    @Autowired
    private CanisterInVitroRepository canisterInVitroRepository;

    @Autowired
    private VisoTubeInVitroService visoTubeInVitroService;

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

    @Override
    public void delete(CanisterInVitro canisterInVitro) {
        canisterInVitroRepository.delete(canisterInVitro);
    }

    @Override
    public Optional<CanisterInVitro> findOne(long id) {
       return Optional.ofNullable(canisterInVitroRepository.findOne(id));
    }
}
