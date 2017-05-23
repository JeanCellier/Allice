package phenotypage.model.cuve.cuveSomatique.canisterSomatique;

import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.VisoTubeSomatique;

import java.util.List;

/**
 * Created by Loick on 23/05/2017.
 */
public interface CanisterSomatiqueService {

    List<CanisterSomatique> findAllCanisterSomatique();

    CanisterSomatique createCanisterSomatique(List<VisoTubeSomatique> visoTubeSomatiquesList);

    CanisterSomatique addCanisterSomatique(CanisterSomatique canisterSomatique);

    CanisterSomatique newCanisterSomatique();
}
