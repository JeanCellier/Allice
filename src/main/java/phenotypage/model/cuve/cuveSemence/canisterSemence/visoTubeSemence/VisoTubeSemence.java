package phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique;

import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.celluleSomatique.CelluleSomatique;
import phenotypage.model.cuve.visoTube.VisoTube;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by nicolas on 20/05/17.
 */
@Entity
public class VisoTubeSomatique extends VisoTube{
    @OneToMany
    List<CelluleSomatique> celluleSomatiqueList;
}
