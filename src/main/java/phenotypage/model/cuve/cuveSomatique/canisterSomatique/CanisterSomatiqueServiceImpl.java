package phenotypage.model.cuve.cuveSomatique.canisterSomatique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.VisoTubeSomatique;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.celluleSomatique.CelluleSomatique;

import java.util.List;
import java.util.Optional;

/**
 * Created by Loick on 23/05/2017.
 */
@Component
public class CanisterSomatiqueServiceImpl implements CanisterSomatiqueService {

    @Autowired
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
        return canisterSomatiqueRepository.save(canisterSomatique);
    }

    @Override
    public CanisterSomatique newCanisterSomatique() {
        return new CanisterSomatique();
    }

    @Override
    public void delete(CanisterSomatique canisterSomatique) {
        canisterSomatiqueRepository.delete(canisterSomatique);
    }

    @Override
    public Optional<CelluleSomatique> findOne(long id) {
        //TODO
        return null;
    }
}
