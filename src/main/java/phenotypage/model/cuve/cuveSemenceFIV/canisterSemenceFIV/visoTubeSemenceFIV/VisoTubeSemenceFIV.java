package phenotypage.model.cuve.cuveSemenceFIV.canisterSemenceFIV.visoTubeSemenceFIV;

import phenotypage.model.cuve.canister.visoTube.VisoTube;
import phenotypage.model.cuve.cuveSemenceFIV.canisterSemenceFIV.visoTubeSemenceFIV.semenceFIV.SemenceFIV;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * Created by Loick on 27/05/2017.
 */
@Entity
public class VisoTubeSemenceFIV extends VisoTube {

    public VisoTubeSemenceFIV(SemenceFIV semence) {
        this.semence = semence;
    }

    public VisoTubeSemenceFIV() {
    }

    public SemenceFIV getSemence() {
        return semence;
    }

    public void setSemence(SemenceFIV semence) {
        this.semence = semence;
    }

    @OneToOne
    private SemenceFIV semence;
}
