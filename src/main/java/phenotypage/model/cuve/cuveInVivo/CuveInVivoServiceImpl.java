package phenotypage.model.cuve.cuveInVivo;

import phenotypage.model.cuve.cuveInVivo.canisterInVivo.CanisterInVivo;

import java.util.List;

/**
 * Created by Loick on 22/05/2017.
 */
public class CuveInVivoServiceImpl implements CuveInVivoService {

    private CuveInVivoRepository cuveInVivoRepository;

    @Override
    public List<CuveInVivo> findAllCuveInVivo() {
        return cuveInVivoRepository.findAll();
    }

    @Override
    public CuveInVivo createCuveInVivo(List<CanisterInVivo> canisterList) {
        return cuveInVivoRepository.save(new CuveInVivo(canisterList));
    }

    @Override
    public CuveInVivo addCuveInVivo(CuveInVivo cuveInVivo) {
        return cuveInVivoRepository.save(cuveInVivo);
    }

    @Override
    public CuveInVivo newCuveInVitro() {
        return new CuveInVivo();
    }
}
