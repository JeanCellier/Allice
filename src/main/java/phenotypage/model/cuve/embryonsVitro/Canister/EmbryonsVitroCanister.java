package phenotypage.model.cuve.embryonsVitro.Canister;

import phenotypage.model.cuve.canister.Canister;
import phenotypage.model.cuve.visoTube.VisoTube;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by Loick on 18/05/2017.
 */
@Entity
public class EmbryonsVitroCanister extends Canister {

//    @ManyToOne
//    private VisoTube visuoTube;

    @Column
    private String refManip;

    @Column
    private int nbEmbryons;

    @Column
    private String numEmbryon;

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

    @Column
    private String numTaureau;

    @Column
    private int nbPaillettes;

//    public VisoTube getVisuoTube() {
//        return visuoTube;
//    }

    public EmbryonsVitroCanister() {
        super();
    }

//    public void setVisuoTube(VisoTube visuoTube) {
//
//        this.visuoTube = visuoTube;
//    }

    public String getRefManip() {
        return refManip;
    }

    public void setRefManip(String refManip) {
        this.refManip = refManip;
    }

    public int getNbEmbryons() {
        return nbEmbryons;
    }

    public void setNbEmbryons(int nbEmbryons) {
        this.nbEmbryons = nbEmbryons;
    }

    public String getNumEmbryon() {
        return numEmbryon;
    }

    public void setNumEmbryon(String numEmbryon) {
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

    public int getNbPaillettes() {
        return nbPaillettes;
    }

    public void setNbPaillettes(int nbPaillettes) {
        this.nbPaillettes = nbPaillettes;
    }

    public String getStadeEmbrillon() {
        return stadeEmbrillon;
    }

    public void setStadeEmbrillon(String stadeEmbrillon) {
        this.stadeEmbrillon = stadeEmbrillon;
    }

    public int getQualiteEmbryon() {
        return qualiteEmbryon;
    }

    public void setQualiteEmbryon(int qualiteEmbryon) {
        this.qualiteEmbryon = qualiteEmbryon;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    @Column
    private String stadeEmbrillon;

    @Column
    private int qualiteEmbryon;

    @Column
    private String remarques;
}
