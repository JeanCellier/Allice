package phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence;

import phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.semence.Semence;

import java.util.List;

/**
 * Created by Loick on 23/05/2017.
 */
public class VisoTubeSemenceServiceImpl implements VisoTubeSemenceService {
    private VisoTubeSemenceRepository visoTubeSemenceRepository;

    @Override
    public List<VisoTubeSemence> findAllVisoTubeSemence() {
        return visoTubeSemenceRepository.findAll();
    }

    @Override
    public VisoTubeSemence createVisoTubeSemence(List<Semence> SemanceList) {
        return visoTubeSemenceRepository.save(new VisoTubeSemence(SemanceList));
    }

    @Override
    public VisoTubeSemence addVisoTubeSemence(VisoTubeSemence visoTubeSemance) {
        return visoTubeSemenceRepository.save(visoTubeSemance);
    }

    @Override
    public VisoTubeSemence newVisoTubeSemence() {
        return new VisoTubeSemence();
    }
}
