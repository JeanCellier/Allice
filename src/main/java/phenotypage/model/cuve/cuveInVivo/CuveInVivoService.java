package phenotypage.model.cuve.cuveInVivo;

import phenotypage.model.cuve.cuveInVivo.canisterInVivo.CanisterInVivo;

import java.util.List;

/**
 * Created by Loick on 22/05/2017.
 */
public interface CuveInVivoService {

    List<CuveInVivo> findAllCuveInVivo();

    CuveInVivo createCuveInVivo(List<CanisterInVivo> canisterList);

    CuveInVivo addCuveInVivo(CuveInVivo cuveInVivo);

    CuveInVivo newCuveInVitro();
}
