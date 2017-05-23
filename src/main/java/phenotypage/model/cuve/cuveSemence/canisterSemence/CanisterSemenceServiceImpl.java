package phenotypage.model.cuve.cuveSemence.canisterSemence;

import phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.VisoTubeSemence;

import java.util.List;

/**
 * Created by Loick on 23/05/2017.
 */
public class CanisterSemenceServiceImpl implements CanisterSemenceService {

    CanisterSemenceRepository canisterSemenceRepository;


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
}
