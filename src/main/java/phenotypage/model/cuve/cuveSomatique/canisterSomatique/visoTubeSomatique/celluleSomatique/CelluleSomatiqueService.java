package phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.celluleSomatique;

import java.util.Date;
import java.util.List;

/**
 * Created by Loick on 23/05/2017.
 */
public interface CelluleSomatiqueService {

    List<CelluleSomatique> findAllCelluleSomatique();

    CelluleSomatique createCelluleSomatique(String typeCellulaire, String couleurPaillette, int nbPaillettes, Date dateCongelation, String remarques);

    CelluleSomatique addCelluleSomatique(CelluleSomatique celluleSomatique);

    CelluleSomatique newCelluleSomatique();
}
