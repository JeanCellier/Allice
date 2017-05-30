package phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique;

import phenotypage.model.cuve.canister.visoTube.VisoTube;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.CanisterSomatique;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.celluleSomatique.CelluleSomatique;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolas on 20/05/17.
 */
@Entity
public class VisoTubeSomatique extends VisoTube {

    public VisoTubeSomatique(CelluleSomatique celluleSomatique) {
        this.celluleSomatique = celluleSomatique;
    }

    public CelluleSomatique getCelluleSomatique() {
        return celluleSomatique;
    }

    public void setCelluleSomatique(CelluleSomatique celluleSomatique) {
        this.celluleSomatique = celluleSomatique;
    }

    public VisoTubeSomatique() {

    }

    @OneToOne
    private CelluleSomatique celluleSomatique;

}
