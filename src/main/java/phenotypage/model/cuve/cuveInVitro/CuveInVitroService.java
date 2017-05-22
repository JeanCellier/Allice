package phenotypage.model.cuve.cuveInVitro;

import phenotypage.model.cuve.cuveInVitro.canisterInVitro.CanisterInVitro;

import java.util.List;

/**
 * Created by Loick on 22/05/2017.
 */
public interface CuveInVitroService {

    List<CuveInVitro> findAllCuveInVitro();

    CuveInVitro createCuveInVitro(List<CanisterInVitro> canisterList);

    CuveInVitro addCuveInVitro(CuveInVitro cuveInVitro);

    CuveInVitro newCuveInVitro();
}
