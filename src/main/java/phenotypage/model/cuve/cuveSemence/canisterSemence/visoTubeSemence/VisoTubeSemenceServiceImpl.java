package phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.semence.Semence;

import java.util.List;

/**
 * Created by Loick on 23/05/2017.
 */
@Component
public class VisoTubeSemenceServiceImpl implements VisoTubeSemenceService {

    @Autowired
    private VisoTubeSemenceRepository visoTubeSemenceRepository;

    @Override
    public List<VisoTubeSemence> findAllVisoTubeSemence() {
        return visoTubeSemenceRepository.findAll();
    }

    @Override
    public VisoTubeSemence createVisoTubeSemence(Semence Semence) {
        return visoTubeSemenceRepository.save(new VisoTubeSemence(Semence));
    }

    @Override
    public VisoTubeSemence addVisoTubeSemence(VisoTubeSemence visoTubeSemance) {
        return visoTubeSemenceRepository.save(visoTubeSemance);
    }

    @Override
    public VisoTubeSemence newVisoTubeSemence() {
        return new VisoTubeSemence();
    }

    @Override
    public void delete(VisoTubeSemence visoTubeSemence) {
        visoTubeSemenceRepository.delete(visoTubeSemence);
    }
}
