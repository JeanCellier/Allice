package phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.semence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by nicolas on 20/05/17.
 */
@Entity
public class Semence {
    @Id
    @GeneratedValue
    private Long id;

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

    @Column
    private boolean sexee;

    @Column
    private String remarques;

    @Column
    private boolean FIV;

    public Semence() {}

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

    public boolean isFIV() {
        return FIV;
    }

    public void setFIV(boolean FIV) {
        this.FIV = FIV;
    }
}
