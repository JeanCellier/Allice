package phenotypage.model.cuve.embryonsVivo.Canister;

import phenotypage.model.cuve.canister.Canister;
import phenotypage.model.cuve.visoTube.VisoTube;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by Loick on 18/05/2017.
 */
@Entity
public class EmbryonsVivoCanister extends Canister {

//    @ManyToOne
//    private VisoTube visoTube;

    @Column
    private String refCollecte;

    @Column
    private int numEmbryon;

    @Column
    private String couleurBouchon;

    @Column
    private String projet;

    @Column
    private String numAgrement;

    @Column
    private String raceFemelle;

    @Column
    private String numFemelle;

    @Column
    private String raceTaureau;

//    public VisoTube getVisoTube() {
//        return visoTube;
//    }

    public EmbryonsVivoCanister() {
        super();
    }

//    public void setVisoTube(VisoTube visoTube) {
//        this.visoTube = visoTube;
//
//    }

    public String getRefCollecte() {
        return refCollecte;
    }

    public void setRefCollecte(String refCollecte) {
        this.refCollecte = refCollecte;
    }

    public int getNumEmbryon() {
        return numEmbryon;
    }

    public void setNumEmbryon(int numEmbryon) {
        this.numEmbryon = numEmbryon;
    }

    public String getCouleurBouchon() {
        return couleurBouchon;
    }

    public void setCouleurBouchon(String couleurBouchon) {
        this.couleurBouchon = couleurBouchon;
    }

    public String getProjet() {
        return projet;
    }

    public void setProjet(String projet) {
        this.projet = projet;
    }

    public String getNumAgrement() {
        return numAgrement;
    }

    public void setNumAgrement(String numAgrement) {
        this.numAgrement = numAgrement;
    }

    public String getRaceFemelle() {
        return raceFemelle;
    }

    public void setRaceFemelle(String raceFemelle) {
        this.raceFemelle = raceFemelle;
    }

    public String getNumFemelle() {
        return numFemelle;
    }

    public void setNumFemelle(String numFemelle) {
        this.numFemelle = numFemelle;
    }

    public String getRaceTaureau() {
        return raceTaureau;
    }

    public void setRaceTaureau(String raceTaureau) {
        this.raceTaureau = raceTaureau;
    }

    public String getNumTaureau() {
        return numTaureau;
    }

    public void setNumTaureau(String numTaureau) {
        this.numTaureau = numTaureau;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    @Column

    private String numTaureau;

    @Column
    private String remarques;
}
