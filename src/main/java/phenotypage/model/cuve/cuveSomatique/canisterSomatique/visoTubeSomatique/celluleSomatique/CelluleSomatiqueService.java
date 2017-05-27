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

    void delete(CelluleSomatique celluleSomatique);

    CelluleSomatique updatecelluleSomatique(CelluleSomatique celluleSomatique);

    CelluleSomatique updatecelluleSomatique(CelluleSomatique celluleSomatique, String type, String couleurPaillette, int nbPaillettes, Date date, String remarques);
}
