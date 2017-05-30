package phenotypage.model.cuve.cuveSomatique.canisterSomatique;

import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.VisoTubeSomatique;

import java.util.List;
import java.util.Optional;

/**
 * Created by Loick on 23/05/2017.
 */
public interface CanisterSomatiqueService {

    List<CanisterSomatique> findAllCanisterSomatique();

    CanisterSomatique createCanisterSomatique(List<VisoTubeSomatique> visoTubeSomatiquesList);

    CanisterSomatique addCanisterSomatique(CanisterSomatique canisterSomatique);

    CanisterSomatique newCanisterSomatique();

    void delete(CanisterSomatique canisterSomatique);

    Optional<CanisterSomatique> findOne(long id);

    CanisterSomatique updateCanisterSomatique(CanisterSomatique canisterSomatique, String nom, int numero, List<VisoTubeSomatique> visoTubeSomatiqueList);
}
