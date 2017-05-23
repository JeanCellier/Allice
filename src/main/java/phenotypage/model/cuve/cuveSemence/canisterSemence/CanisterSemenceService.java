package phenotypage.model.cuve.cuveSemence.canisterSemence;

import phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.VisoTubeSemence;

import java.util.List;

/**
 * Created by Loick on 23/05/2017.
 */
public interface CanisterSemenceService {

    List<CanisterSemence> findAllCanisterSemence();

    CanisterSemence createCanisterSemence(List<VisoTubeSemence> visoTubeSemenceList);

    CanisterSemence addCanisterSemence(CanisterSemence canisterSemence);

    CanisterSemence newCanisterSemence();
}
