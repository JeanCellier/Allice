package phenotypage.model.cuve.semancesFIV.Canister;

import phenotypage.model.cuve.canister.Canister;
import phenotypage.model.cuve.visoTube.VisoTube;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Loick on 18/05/2017.
 */
@Entity
public class SemancesFIVCanister extends Canister{
//    @Column
//    private VisoTube visoTube;

    @Column
    private String raceTaureau;

    @Column
    private String numTaureau;

    @Column
    private String nomTaureau;

    @Column
    private int nbPaillettes;

//    public VisoTube getVisoTube() {
//        return visoTube;
//    }

//    public void setVisoTube(VisoTube visoTube) {
//        this.visoTube = visoTube;
//    }

    public String getRaceTaureau() {
        return raceTaureau;
    }

    public void setRaceTaureau(String raceTaureau) {
        this.raceTaureau = raceTaureau;
    }

    public SemancesFIVCanister() {
        super();
    }

    public String getNumTaureau() {
        return numTaureau;

    }

    public void setNumTaureau(String numTaureau) {
        this.numTaureau = numTaureau;
    }

    public String getNomTaureau() {
        return nomTaureau;
    }

    public void setNomTaureau(String nomTaureau) {
        this.nomTaureau = nomTaureau;
    }

    public int getNbPaillettes() {
        return nbPaillettes;
    }

    public void setNbPaillettes(int nbPaillettes) {
        this.nbPaillettes = nbPaillettes;
    }

    public String getCouleurPaillette() {
        return couleurPaillette;
    }

    public void setCouleurPaillette(String couleurPaillette) {
        this.couleurPaillette = couleurPaillette;
    }

    public boolean isSexee() {
        return sexee;
    }

    public void setSexee(boolean sexee) {
        this.sexee = sexee;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    @Column
    private String couleurPaillette;

    @Column
    private boolean sexee;

    @Column
    private String remarques;
}
