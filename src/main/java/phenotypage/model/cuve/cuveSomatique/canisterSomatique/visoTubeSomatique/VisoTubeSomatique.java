package phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique;

import phenotypage.model.cuve.canister.visoTube.VisoTube;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.celluleSomatique.CelluleSomatique;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by nicolas on 20/05/17.
 */
@Entity
public class VisoTubeSomatique extends VisoTube {
    public VisoTubeSomatique(List<CelluleSomatique> celluleSomatiqueList) {
        this.celluleSomatiqueList = celluleSomatiqueList;
    }

    public VisoTubeSomatique() {
    }

    @OneToMany


    List<CelluleSomatique> celluleSomatiqueList;
}
