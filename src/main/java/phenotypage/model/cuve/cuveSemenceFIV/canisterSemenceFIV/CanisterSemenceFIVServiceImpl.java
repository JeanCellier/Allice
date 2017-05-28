package phenotypage.model.cuve.cuveSemenceFIV.canisterSemenceFIV;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cuve.cuveSemenceFIV.canisterSemenceFIV.visoTubeSemenceFIV.VisoTubeSemenceFIV;
import phenotypage.model.cuve.cuveSemenceFIV.canisterSemenceFIV.visoTubeSemenceFIV.VisoTubeSemenceFIVService;

import java.util.List;
import java.util.Optional;

/**
 * Created by Loick on 27/05/2017.
 */
@Component
public class CanisterSemenceFIVServiceImpl implements CanisterSemenceFIVService {

    @Autowired
    private CanisterSemenceFIVRepository canisterSemenceRepository;

    @Autowired
    private VisoTubeSemenceFIVService visoTubeSemenceService;


    @Override
    public List<CanisterSemenceFIV> findAllCanisterSemence() {
        return canisterSemenceRepository.findAll();
    }

    @Override
    public CanisterSemenceFIV createCanisterSemence(List<VisoTubeSemenceFIV> visoTubeSemenceList) {
        return canisterSemenceRepository.save(new CanisterSemenceFIV(visoTubeSemenceList));
    }

    @Override
    public CanisterSemenceFIV addCanisterSemence(CanisterSemenceFIV canisterSemence) {
        return canisterSemenceRepository.save(canisterSemence);
    }

    @Override
    public CanisterSemenceFIV newCanisterSemence() {
        return new CanisterSemenceFIV();
    }

    @Override
    public void delete(CanisterSemenceFIV canisterSemence) {
        canisterSemenceRepository.delete(canisterSemence);
    }

    @Override
    public Optional<CanisterSemenceFIV> findOne(long id) {
        return Optional.ofNullable(canisterSemenceRepository.findOne(id));
    }
}
