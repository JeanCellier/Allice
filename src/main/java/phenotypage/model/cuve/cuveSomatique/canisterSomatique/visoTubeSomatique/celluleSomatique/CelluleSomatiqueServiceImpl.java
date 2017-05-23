package phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.celluleSomatique;

import java.util.Date;
import java.util.List;

/**
 * Created by Loick on 23/05/2017.
 */
public class CelluleSomatiqueServiceImpl implements CelluleSomatiqueService {

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
}
