package phenotypage.model.cuve.cuveSemence.canisterSemence;

import phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.VisoTubeSemence;

import java.util.List;
import java.util.Optional;

/**
 * Created by Loick on 23/05/2017.
 */
public interface CanisterSemenceService {

    List<CanisterSemence> findAllCanisterSemence();

    CanisterSemence createCanisterSemence(List<VisoTubeSemence> visoTubeSemenceList);

    CanisterSemence addCanisterSemence(CanisterSemence canisterSemence);

    CanisterSemence newCanisterSemence();

    void delete(CanisterSemence canisterSemence);

    Optional<CanisterSemence> findOne(long id);
}
