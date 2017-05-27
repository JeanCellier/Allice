package phenotypage.model.cuve.cuveSomatique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.CanisterSomatique;

import java.util.List;

/**
 * Created by Loick on 23/05/2017.
 */
@Component
public class CuveSomatiqueServiceImpl implements CuveSomatiqueService {
    @Autowired
    private CuveSomatiqueRepository cuveSomatiqueRepository;

    @Override
    public List<CuveSomatique> findAllCuveSomatique() {
        return cuveSomatiqueRepository.findAll();
    }

    @Override
    public CuveSomatique createCuveSomatique(List<CanisterSomatique> canisterList) {
//        return cuveSomatiqueRepository.save(new CuveSomatique(canisterList));
        return null;
    }

    @Override
    public CuveSomatique addCuveSomatique(CuveSomatique cuveSomatique) {
        return cuveSomatiqueRepository.save(cuveSomatique);
    }

    @Override
    public CuveSomatique newCuveSomatique() {
        return new CuveSomatique();
    }
}
