package phenotypage.model.cuve.cuveSomatique;

import phenotypage.model.cuve.cuveSomatique.canisterSomatique.CanisterSomatique;

import java.util.List;

/**
 * Created by Loick on 23/05/2017.
 */
public class CuveSomatiqueServiceImpl implements CuveSomatiqueService {

    private CuveSomatiqueRepository cuveSomatiqueRepository;

    @Override
    public List<CuveSomatique> findAllCuveSomatique() {
        return cuveSomatiqueRepository.findAll();
    }

    @Override
    public CuveSomatique createCuveSomatique(List<CanisterSomatique> canisterList) {
        return cuveSomatiqueRepository.save(new CuveSomatique(canisterList));
    }

    @Override
    public CuveSomatique addCuveSomatique(CuveSomatique cuveInVitro) {
        return cuveInVitro;
    }

    @Override
    public CuveSomatique newCuveSomatique() {
        return new CuveSomatique();
    }
}
