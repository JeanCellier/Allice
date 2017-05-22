package phenotypage.model.cuve.cuveInVitro;

import phenotypage.model.cuve.cuveInVitro.canisterInVitro.CanisterInVitro;

import java.util.List;

/**
 * Created by Loick on 22/05/2017.
 */
public class CuveInVitroServiceImpl implements CuveInVitroService {

    CuveInVtroRepository cuveInVtroRepository;
    @Override
    public List<CuveInVitro> findAllCuveInVitro() {
        return cuveInVtroRepository.findAll();
    }

    @Override
    public CuveInVitro createCuveInVitro(List<CanisterInVitro> canisterList) {
        return cuveInVtroRepository.save(new CuveInVitro(canisterList));
    }

    @Override
    public CuveInVitro addCuveInVitro(CuveInVitro cuveInVitro) {
        return cuveInVtroRepository.save(cuveInVitro);
    }

    @Override
    public CuveInVitro newCuveInVitro() {
        return new CuveInVitro();
    }
}
