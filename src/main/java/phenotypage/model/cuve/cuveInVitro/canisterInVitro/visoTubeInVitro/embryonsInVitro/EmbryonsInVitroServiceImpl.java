package phenotypage.model.cuve.cuveInVitro.canisterInVitro.visoTubeInVitro.embryonsInVitro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cryoconservation.embryon.Embryon;
import phenotypage.model.cryoconservation.embryon.EmbryonRepository;
import phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.semence.Semence;

import java.util.List;

/**
 * Created by Loick on 22/05/2017.
 */
@Component
public class EmbryonsInVitroServiceImpl implements EmbryonsInVitroService {

    @Autowired
    private EmbryonsInVitroRepository embryonsInVitroRepository;


    @Override
    public List<EmbryonsInVitro> findAllEmbryonsInVitro() {
        return embryonsInVitroRepository.findAll();
    }

    @Override
    public EmbryonsInVitro createEmbryonsInVitro(Embryon embryon, String couleur, Semence semence, int nbPaillettes, String remarques) {
        return embryonsInVitroRepository.save(new EmbryonsInVitro(embryon, couleur, semence, nbPaillettes, remarques));
    }

    @Override
    public EmbryonsInVitro addEmbryonsInVitro(EmbryonsInVitro embryonsInVitro) {
        return embryonsInVitroRepository.save(embryonsInVitro);
    }

    @Override
    public EmbryonsInVitro newEmbryonsInVitro() {
        return new EmbryonsInVitro();
    }

    @Override
    public void delete(EmbryonsInVitro embryonsInVitro) {
        embryonsInVitroRepository.delete(embryonsInVitro);
    }
}
