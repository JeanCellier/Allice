package phenotypage.model.cuve.cuveInVitro.canisterInVitro.visoTubeInVitro;

import phenotypage.model.cuve.cuveInVitro.canisterInVitro.visoTubeInVitro.embryonsInVitro.EmbryonsInVitro;

import java.util.List;

/**
 * Created by Loick on 22/05/2017.
 */
public class VisoTubeInVitroServiceImpl implements VisoTubeInVitroService
{
    private VisoTubeInVitroRepository visoTubeInVitroRepository;


    @Override
    public List<VisoTubeInVitro> findAllVisoTubeInVitro() {
        return visoTubeInVitroRepository.findAll();
    }

    @Override
    public VisoTubeInVitro createVisoTubeInVitro(List<EmbryonsInVitro> embryonsInVitroList) {
        return visoTubeInVitroRepository.save(new VisoTubeInVitro(embryonsInVitroList));
    }

    @Override
    public VisoTubeInVitro addVisoTubeInVitro(VisoTubeInVitro visoTubeInVitro) {
        return visoTubeInVitroRepository.save(visoTubeInVitro);
    }

    @Override
    public VisoTubeInVitro newVisoTubeInVitro() {
        return new VisoTubeInVitro();
    }
}
