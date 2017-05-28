package phenotypage.model.cuve.cuveSemenceFIV.canisterSemenceFIV.visoTubeSemenceFIV;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cuve.cuveSemenceFIV.canisterSemenceFIV.visoTubeSemenceFIV.semenceFIV.SemenceFIV;

import java.util.List;

/**
 * Created by Loick on 27/05/2017.
 */
@Component
public class VisoTubeSemenceFIVServiceImpl implements VisoTubeSemenceFIVService {

    @Autowired
    private VisoTubeSemenceFIVRepository visoTubeSemenceRepository;

    @Override
    public List<VisoTubeSemenceFIV> findAllVisoTubeSemence() {
        return visoTubeSemenceRepository.findAll();
    }

    @Override
    public VisoTubeSemenceFIV createVisoTubeSemence(SemenceFIV Semence) {
        return visoTubeSemenceRepository.save(new VisoTubeSemenceFIV(Semence));
    }

    @Override
    public VisoTubeSemenceFIV addVisoTubeSemence(VisoTubeSemenceFIV visoTubeSemance) {
        return visoTubeSemenceRepository.save(visoTubeSemance);
    }

    @Override
    public VisoTubeSemenceFIV newVisoTubeSemence() {
        return new VisoTubeSemenceFIV();
    }

    @Override
    public void delete(VisoTubeSemenceFIV visoTubeSemence) {
        visoTubeSemenceRepository.delete(visoTubeSemence);
    }
}
