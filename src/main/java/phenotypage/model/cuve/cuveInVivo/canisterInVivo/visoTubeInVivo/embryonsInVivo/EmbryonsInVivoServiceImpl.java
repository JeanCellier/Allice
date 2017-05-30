package phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.embryonsInVivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cryoconservation.embryon.Embryon;
import phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.semence.Semence;

import java.util.List;
import java.util.Optional;

/**
 * Created by Loick on 22/05/2017.
 */
@Component
public class EmbryonsInVivoServiceImpl implements EmbryonsInVivoService {

    @Autowired
    private EmbryonsInVivoRepository embryonsInVivoRepository;

    @Override
    public List<EmbryonsInVivo> findAll() {
        return embryonsInVivoRepository.findAll();
    }

    @Override
    public EmbryonsInVivo create(Embryon embryon, String couleur, Semence semence, String biopsie, String remarques) {
        EmbryonsInVivo embryonsInVivo = new EmbryonsInVivo();
        embryonsInVivo.setBiopsie(biopsie);
        embryonsInVivo.setCouleur(couleur);
        embryonsInVivo.setRemarques(remarques);
        embryonsInVivo.setSemence(semence);
        embryonsInVivo.setEmbryon(embryon);
        return save(embryonsInVivo);
    }

    @Override
    public EmbryonsInVivo save(EmbryonsInVivo embryonsInVivo) {
        return embryonsInVivoRepository.save(embryonsInVivo);
    }

    @Override
    public void delete(EmbryonsInVivo embryonsInVivo) {
        embryonsInVivoRepository.delete(embryonsInVivo);
    }

    @Override
    public Optional<EmbryonsInVivo> findByEmbryon(Embryon embryon) {
        return embryonsInVivoRepository.findByEmbryon(embryon);
    }
}
