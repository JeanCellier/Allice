package phenotypage.model.cuve.cuveSomatique;

import phenotypage.model.cuve.cuveSomatique.canisterSomatique.CanisterSomatique;

import java.util.List;

/**
 * Created by Loick on 23/05/2017.
 */
public interface CuveSomatiqueService {

    List<CuveSomatique> findAllCuveSomatique();

    CuveSomatique createCuveSomatique(List<CanisterSomatique> canisterList);

    CuveSomatique addCuveSomatique(CuveSomatique cuveInVitro);

    CuveSomatique newCuveSomatique();
}
