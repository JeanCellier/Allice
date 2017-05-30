package phenotypage.model.cuve.cuveSemenceFIV.canisterSemenceFIV.visoTubeSemenceFIV.semenceFIV;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Loick on 27/05/2017.
 */
@Entity
public class SemenceFIV {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String raceTaureau;

    @Column
    private String numTaureau;

    public SemenceFIV(String raceTaureau, String numTaureau, String nomTaureau, int nbPaillettes, String couleurPaillette, boolean sexee, String remarques) {
        this.raceTaureau = raceTaureau;
        this.numTaureau = numTaureau;
        this.nomTaureau = nomTaureau;
        this.nbPaillettes = nbPaillettes;
        this.couleurPaillette = couleurPaillette;
        this.sexee = sexee;
        this.remarques = remarques;
    }

    @Column
    private String nomTaureau;

    @Column
    private int nbPaillettes;

    @Column
    private String couleurPaillette;

    @Column
    private boolean sexee;

    @Column
    private String remarques;

    public SemenceFIV() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
