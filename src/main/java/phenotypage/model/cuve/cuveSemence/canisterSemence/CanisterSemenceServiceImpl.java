package phenotypage.model.cuve.cuveSemence.canisterSemence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.VisoTubeSemence;
import phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.VisoTubeSemenceService;

import java.util.List;
import java.util.Optional;

/**
 * Created by Loick on 23/05/2017.
 */
@Component
public class CanisterSemenceServiceImpl implements CanisterSemenceService {

    @Autowired
    private CanisterSemenceRepository canisterSemenceRepository;

    @Autowired
    private VisoTubeSemenceService visoTubeSemenceService;


    @Override
    public List<CanisterSemence> findAllCanisterSemence() {
        return canisterSemenceRepository.findAll();
    }

    @Override
    public CanisterSemence createCanisterSemence(List<VisoTubeSemence> visoTubeSemenceList) {
        return canisterSemenceRepository.save(new CanisterSemence(visoTubeSemenceList));
    }

    @Override
    public CanisterSemence addCanisterSemence(CanisterSemence canisterSemence) {
        return canisterSemenceRepository.save(canisterSemence);
    }

    @Override
    public CanisterSemence newCanisterSemence() {
        return new CanisterSemence();
    }

    @Override
    public void delete(CanisterSemence canisterSemence) {
        canisterSemenceRepository.delete(canisterSemence);
    }

    @Override
    public Optional<CanisterSemence> findOne(long id) {
        return Optional.ofNullable(canisterSemenceRepository.findOne(id));
    }
}
