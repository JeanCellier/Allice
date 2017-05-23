package phenotypage.model.cuve.cuveSomatique.canisterSomatique;

import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.VisoTubeSomatique;

import java.util.List;

/**
 * Created by Loick on 23/05/2017.
 */
public class CanisterSomatiqueServiceImpl implements CanisterSomatiqueService {

    private CanisterSomatiqueRepository canisterSomatiqueRepository;

    @Override
    public List<CanisterSomatique> findAllCanisterSomatique() {
        return canisterSomatiqueRepository.findAll();
    }

    @Override
    public CanisterSomatique createCanisterSomatique(List<VisoTubeSomatique> visoTubeSomatiquesList) {
        return canisterSomatiqueRepository.save(new CanisterSomatique(visoTubeSomatiquesList));
    }

    @Override
    public CanisterSomatique addCanisterSomatique(CanisterSomatique canisterSomatique) {
        return canisterSomatique;
    }

    @Override
    public CanisterSomatique newCanisterSomatique() {
        return new CanisterSomatique();
    }
}
