package phenotypage.model.cuve.canister.visoTube.contenuVisoTube.contenuVisoTubeSemence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by nicolas on 19/05/17.
 */
@Entity
public class ContenuVisoTubeSemence {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String race;

    @Column
    private String numTaureau;

    @Column
    private String nomTaureau;

    @Column
    private int nbPaillette;

    @Column
    private String couleurPaillette;

    @Column
    private boolean semenceSexee;

    @Column
    private String remarques;

    @Column
    private boolean elevage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
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

    public int getNbPaillette() {
        return nbPaillette;
    }

    public void setNbPaillette(int nbPaillette) {
        this.nbPaillette = nbPaillette;
    }

    public String getCouleurPaillette() {
        return couleurPaillette;
    }

    public void setCouleurPaillette(String couleurPaillette) {
        this.couleurPaillette = couleurPaillette;
    }

    public boolean isSemenceSexee() {
        return semenceSexee;
    }

    public void setSemenceSexee(boolean semenceSexee) {
        this.semenceSexee = semenceSexee;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    public boolean isElevage() {
        return elevage;
    }

    public void setElevage(boolean elevage) {
        this.elevage = elevage;
    }
}
