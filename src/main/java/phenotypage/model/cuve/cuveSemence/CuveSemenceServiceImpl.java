package phenotypage.model.cuve.cuveSemence;

import phenotypage.model.cuve.cuveSemence.canisterSemence.CanisterSemence;

import java.util.List;

/**
 * Created by Loick on 23/05/2017.
 */
public class CuveSemenceServiceImpl implements CuveSemenceService {
    private CuveSemenceRepository cuveSemenceRepository;

    @Override
    public List<CuveSemence> findAllCuveSemence() {
        return cuveSemenceRepository.findAll();
    }

    @Override
    public CuveSemence createCuveSemence(List<CanisterSemence> canisterList) {
        return cuveSemenceRepository.save(new CuveSemence(canisterList));
    }

    @Override
    public CuveSemence addCuveSemence(CuveSemence cuveInVitro) {
        return cuveSemenceRepository.save(cuveInVitro);
    }

    @Override
    public CuveSemence newCuveSemence() {
        return new CuveSemence();
    }
}
