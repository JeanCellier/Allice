package phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cuve.canister.visoTube.VisoTube;
import phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.embryonsInVivo.EmbryonsInVivo;

import java.util.List;
import java.util.Optional;

/**
 * Created by Loick on 22/05/2017.
 */
@Component
public class VisoTubeInVivoServiceImpl implements VisoTubeInVivoService {

    @Autowired
    private VisoTubeInVivoRepository visoTubeInVivoRepository;

    @Override
    public List<VisoTubeInVivo> findAll() {
        return visoTubeInVivoRepository.findAll();
    }

    @Override
    public VisoTubeInVivo createVisoTubeInVivo(String couleur, List<EmbryonsInVivo> embryonsInVivo) {
        VisoTubeInVivo visoTubeInVivo = new VisoTubeInVivo();
        visoTubeInVivo.setEmbryonsInVivo(embryonsInVivo);
        visoTubeInVivo.setCouleur(couleur);
        return save(visoTubeInVivo);
    }

    @Override
    public VisoTubeInVivo update(VisoTubeInVivo visoTubeInVivo, String couleur, List<EmbryonsInVivo> embryonsInVivo) {
        visoTubeInVivo.setCouleur(couleur);
        visoTubeInVivo.setEmbryonsInVivo(embryonsInVivo);
        return save(visoTubeInVivo);
    }

    @Override
    public VisoTubeInVivo save(VisoTubeInVivo visoTubeInVivo) {
        return visoTubeInVivoRepository.save(visoTubeInVivo);
    }

    @Override
    public void delete(VisoTubeInVivo visoTubeInVivo) {
        visoTubeInVivoRepository.delete(visoTubeInVivo);
    }

    @Override
    public Optional<VisoTubeInVivo> findOne(long id) {
        return Optional.ofNullable(visoTubeInVivoRepository.findOne(id));
    }

    @Override
    public  Optional<VisoTubeInVivo> findByEmbryonsInVivo(EmbryonsInVivo embryonsInVivo) {
        return Optional.ofNullable(visoTubeInVivoRepository.findByEmbryonsInVivo(embryonsInVivo));
    }
}
