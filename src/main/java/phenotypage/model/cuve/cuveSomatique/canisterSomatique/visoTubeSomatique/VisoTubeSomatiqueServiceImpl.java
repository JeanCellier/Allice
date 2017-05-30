package phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.celluleSomatique.CelluleSomatique;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.celluleSomatique.CelluleSomatiqueService;

import java.util.List;

/**
 * Created by Loick on 23/05/2017.
 */
@Component
public class VisoTubeSomatiqueServiceImpl implements  VisoTubeSomatiqueService{
    @Autowired
    private VisoTubeSomatiqueRepository visoTubeSomatiqueRepository;

    @Autowired
    private CelluleSomatiqueService celluleSomatiqueService;


    @Override
    public List<VisoTubeSomatique> findAllVisoTubeSomatique() {
        return visoTubeSomatiqueRepository.findAll();
    }

    @Override
    public VisoTubeSomatique createVisoTubeSomatique(CelluleSomatique celluleSomatique) {
        return visoTubeSomatiqueRepository.save(new VisoTubeSomatique(celluleSomatique));
    }

    @Override
    public VisoTubeSomatique addVisoTubeSomatique(VisoTubeSomatique visoTubeSomatique) {
        return visoTubeSomatiqueRepository.save(visoTubeSomatique);
    }

    @Override
    public VisoTubeSomatique newVisoTubeSomatique() {
        return new VisoTubeSomatique();
    }

    @Override
    public void delete(VisoTubeSomatique visoTubeSomatique) {
        visoTubeSomatiqueRepository.delete(visoTubeSomatique);
    }

    @Override
    public VisoTubeSomatique updatevisoTubeSomatique(VisoTubeSomatique visoTubeSomatique) {
        return null;
    }

    @Override
    public VisoTubeSomatique updatevisoTubeSomatique(VisoTubeSomatique visoTubeSomatique, String couleur, CelluleSomatique celluleSomatique) {

        VisoTubeSomatique newVisoTubeSomatique = new VisoTubeSomatique();

        visoTubeSomatiqueRepository.delete(visoTubeSomatique);

        newVisoTubeSomatique.setCouleur(couleur);
        newVisoTubeSomatique.setCelluleSomatique(celluleSomatique);

        return visoTubeSomatiqueRepository.save(newVisoTubeSomatique);
    }
}
