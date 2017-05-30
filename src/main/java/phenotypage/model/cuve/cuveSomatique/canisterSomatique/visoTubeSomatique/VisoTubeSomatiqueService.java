package phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique;

import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.celluleSomatique.CelluleSomatique;

import java.util.List;

/**
 * Created by Loick on 23/05/2017.
 */
public interface VisoTubeSomatiqueService {

    List<VisoTubeSomatique> findAllVisoTubeSomatique();

    VisoTubeSomatique createVisoTubeSomatique(CelluleSomatique celluleSomatique);

    VisoTubeSomatique addVisoTubeSomatique(VisoTubeSomatique visoTubeSomatique);

    VisoTubeSomatique newVisoTubeSomatique();

    void delete(VisoTubeSomatique visoTubeSomatique);

    VisoTubeSomatique updatevisoTubeSomatique(VisoTubeSomatique visoTubeSomatique);

    VisoTubeSomatique updatevisoTubeSomatique(VisoTubeSomatique visoTubeSomatique, String couleur, CelluleSomatique celluleSomatique);
}
