package phenotypage.model.cuve.semancesElevage.Canister;

import phenotypage.model.cuve.canister.Canister;
import phenotypage.model.cuve.visoTube.VisoTube;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by Loick on 18/05/2017.
 */
@Entity
public class SemancesElevageCanister extends Canister {

//    @ManyToOne
//    private VisoTube visoTube;

    @Column
    private String raceTaureau;

    @Column
    private String numTaureau;

    @Column
    private String nomTaureau;

    @Column
    private int nbPaillettes;

    @Column
    private String couleurPaillette;

//    public VisoTube getVisoTube() {
//        return visoTube;
//    }

    public SemancesElevageCanister() {
        super();
    }

//    public void setVisoTube(VisoTube visoTube) {
//        this.visoTube = visoTube;
//    }

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

    public String getRamarques() {
        return ramarques;
    }

    public void setRamarques(String ramarques) {
        this.ramarques = ramarques;
    }

    @Column
    private boolean sexee;

    @Column
    private String ramarques;
}
