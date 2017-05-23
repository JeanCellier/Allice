package phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique;

import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.celluleSomatique.CelluleSomatique;

import java.util.List;

/**
 * Created by Loick on 23/05/2017.
 */
public interface VisoTubeSomatiqueService {

    List<VisoTubeSomatique> findAllVisoTubeSomatique();

    VisoTubeSomatique createVisoTubeSomatique(List<CelluleSomatique> canisterList);

    VisoTubeSomatique addVisoTubeSomatique(VisoTubeSomatique visoTubeSomatique);

    VisoTubeSomatique newVisoTubeSomatique();
}
