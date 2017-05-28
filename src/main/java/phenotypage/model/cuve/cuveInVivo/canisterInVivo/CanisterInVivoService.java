package phenotypage.model.cuve.cuveInVivo.canisterInVivo;

import phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.VisoTubeInVivo;

import java.util.List;
import java.util.Optional;

/**
 * Created by Loick on 22/05/2017.
 */
public interface CanisterInVivoService {

    List<CanisterInVivo> findAllCanisterInVivo();

    CanisterInVivo createCanisterInVivo(List<VisoTubeInVivo> visoTubeList);

    CanisterInVivo addCanisterInVivo(CanisterInVivo canisterInVivo);

    CanisterInVivo newCanisterInVivo();

    void delete(CanisterInVivo canisterInVivo);

    Optional<CanisterInVivo> findOne(long id);
}
