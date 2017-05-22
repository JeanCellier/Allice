package phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence;

import phenotypage.model.cuve.canister.visoTube.VisoTube;
import phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.semence.Semence;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by nicolas on 20/05/17.
 */
@Entity
public class VisoTubeSemence extends VisoTube {
    @OneToMany
    List<Semence> semenceList;
}
