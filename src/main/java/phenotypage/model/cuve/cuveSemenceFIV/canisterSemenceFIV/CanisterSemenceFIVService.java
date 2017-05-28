package phenotypage.model.cuve.cuveSemenceFIV.canisterSemenceFIV;

import phenotypage.model.cuve.cuveSemenceFIV.canisterSemenceFIV.visoTubeSemenceFIV.VisoTubeSemenceFIV;

import java.util.List;
import java.util.Optional;

/**
 * Created by Loick on 27/05/2017.
 */
public interface CanisterSemenceFIVService {

    List<CanisterSemenceFIV> findAllCanisterSemence();

    CanisterSemenceFIV createCanisterSemence(List<VisoTubeSemenceFIV> visoTubeSemenceList);

    CanisterSemenceFIV addCanisterSemence(CanisterSemenceFIV canisterSemence);

    CanisterSemenceFIV newCanisterSemence();

    void delete(CanisterSemenceFIV canisterSemence);

    Optional<CanisterSemenceFIV> findOne(long id);
}
