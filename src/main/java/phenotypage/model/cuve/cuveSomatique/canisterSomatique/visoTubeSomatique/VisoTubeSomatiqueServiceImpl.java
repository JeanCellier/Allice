package phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.celluleSomatique.CelluleSomatique;

import java.util.List;

/**
 * Created by Loick on 23/05/2017.
 */
@Component
public class VisoTubeSomatiqueServiceImpl implements  VisoTubeSomatiqueService{
    @Autowired
    private VisoTubeSomatiqueRepository visoTubeSomatiqueRepository;


    @Override
    public List<VisoTubeSomatique> findAllVisoTubeSomatique() {
        return visoTubeSomatiqueRepository.findAll();
    }

    @Override
    public VisoTubeSomatique createVisoTubeSomatique(List<CelluleSomatique> canisterList) {
        return visoTubeSomatiqueRepository.save(new VisoTubeSomatique(canisterList));
    }

    @Override
    public VisoTubeSomatique addVisoTubeSomatique(VisoTubeSomatique visoTubeSomatique) {
        return visoTubeSomatique;
    }

    @Override
    public VisoTubeSomatique newVisoTubeSomatique() {
        return new VisoTubeSomatique();
    }
}
