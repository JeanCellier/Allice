package phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.embryonsInVivo;

import phenotypage.model.cryoconservation.embryon.Embryon;
import phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.semence.Semence;

import java.util.List;

/**
 * Created by Loick on 22/05/2017.
 */
public class EmbryonsInVivoServiceImpl implements EmbryonsInVivoService {

    private EmbryonsInVivoRepository embryonsInVivoRepository;

    @Override
    public List<EmbryonsInVivo> findAllCuveInVivo() {
        return embryonsInVivoRepository.findAll();
    }

    @Override
    public EmbryonsInVivo createCuveInVitro(Embryon embryon, String couleur, Semence semence, String biopsie, String remarques) {
        return embryonsInVivoRepository.save(new EmbryonsInVivo(embryon, couleur, semence, biopsie, remarques));
    }

    @Override
    public EmbryonsInVivo addCuveInVitro(EmbryonsInVivo embryonsInVivo) {
        return embryonsInVivoRepository.save(embryonsInVivo);
    }

    @Override
    public EmbryonsInVivo newCuveInVitro() {
        return new EmbryonsInVivo();
    }
}
