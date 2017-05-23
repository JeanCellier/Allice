package phenotypage.model.cuve.cuveSemence;

import phenotypage.model.cuve.cuveSemence.canisterSemence.CanisterSemence;

import java.util.List;

/**
 * Created by Loick on 23/05/2017.
 */
public interface CuveSemenceService {

    List<CuveSemence> findAllCuveSemence();

    CuveSemence createCuveSemence(List<CanisterSemence> canisterList);

    CuveSemence addCuveSemence(CuveSemence cuveInVitro);

    CuveSemence newCuveSemence();
}
