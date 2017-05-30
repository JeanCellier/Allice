package phenotypage.model.cuve.cuveInVitro.canisterInVitro.visoTubeInVitro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cuve.cuveInVitro.canisterInVitro.visoTubeInVitro.embryonsInVitro.EmbryonsInVitro;

import java.util.List;

/**
 * Created by Loick on 22/05/2017.
 */
@Component
public class VisoTubeInVitroServiceImpl implements VisoTubeInVitroService
{
    @Autowired
    private VisoTubeInVitroRepository visoTubeInVitroRepository;


    @Override
    public List<VisoTubeInVitro> findAllVisoTubeInVitro() {
        return visoTubeInVitroRepository.findAll();
    }

    @Override
    public VisoTubeInVitro createVisoTubeInVitro(EmbryonsInVitro embryonsInVitro) {
        return visoTubeInVitroRepository.save(new VisoTubeInVitro(embryonsInVitro));
    }

    @Override
    public VisoTubeInVitro addVisoTubeInVitro(VisoTubeInVitro visoTubeInVitro) {
        return visoTubeInVitroRepository.save(visoTubeInVitro);
    }

    @Override
    public VisoTubeInVitro newVisoTubeInVitro() {
        return new VisoTubeInVitro();
    }

    @Override
    public void delete(VisoTubeInVitro visoTubeInVitro) {
        visoTubeInVitroRepository.delete(visoTubeInVitro);
    }
}
