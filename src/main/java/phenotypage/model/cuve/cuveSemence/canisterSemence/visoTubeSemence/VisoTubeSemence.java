package phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence;

import phenotypage.model.cuve.canister.visoTube.VisoTube;
import phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.semence.Semence;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * Created by nicolas on 20/05/17.
 */
@Entity
public class VisoTubeSemence extends VisoTube {
    public VisoTubeSemence(Semence semence) {
        this.semence = semence;
    }

    public VisoTubeSemence() {
    }

    public Semence getSemence() {
        return semence;
    }

    public void setSemence(Semence semence) {
        this.semence = semence;
    }

    @OneToOne
    private Semence semence;
}
