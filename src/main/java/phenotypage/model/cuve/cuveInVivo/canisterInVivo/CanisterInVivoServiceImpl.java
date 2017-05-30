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

    @Override
    public List<CanisterInVivo> findAllCanisterInVivo() {
        return canisterInVivoRepository.findAll();
    }

    @Override
    public CanisterInVivo createCanisterInVivo(int numero, String nom, List<VisoTubeInVivo> visoTubeList) {
        CanisterInVivo canisterInVivo = new CanisterInVivo();
        canisterInVivo.setVisoTubeList(visoTubeList);
        canisterInVivo.setNumero(numero);
        canisterInVivo.setNom(nom);
        return save(canisterInVivo);
    }

    @Override
    public CanisterInVivo save(CanisterInVivo canisterInVivo) {
        return canisterInVivoRepository.save(canisterInVivo);
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
