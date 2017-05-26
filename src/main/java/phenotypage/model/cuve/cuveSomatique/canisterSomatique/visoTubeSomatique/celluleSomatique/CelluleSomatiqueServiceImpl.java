package phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.celluleSomatique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by Loick on 23/05/2017.
 */
@Component
public class CelluleSomatiqueServiceImpl implements CelluleSomatiqueService {

    @Autowired
    private CelluleSomatiqueRepository celluleSomatiqueRepository;


    @Override
    public List<CelluleSomatique> findAllCelluleSomatique() {
        return celluleSomatiqueRepository.findAll();
    }

    @Override
    public CelluleSomatique createCelluleSomatique(String typeCellulaire, String couleurPaillette, int nbPaillettes, Date dateCongelation, String remarques) {
        return celluleSomatiqueRepository.save(new CelluleSomatique(typeCellulaire, couleurPaillette, nbPaillettes, dateCongelation, remarques));
    }

    @Override
    public CelluleSomatique addCelluleSomatique(CelluleSomatique celluleSomatique) {
        return celluleSomatiqueRepository.save(celluleSomatique);
    }

    @Override
    public CelluleSomatique newCelluleSomatique() {
        return new CelluleSomatique();
    }

    @Override
    public void delete(CelluleSomatique celluleSomatique) {
        celluleSomatiqueRepository.delete(celluleSomatique);
    }
}
