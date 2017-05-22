package phenotypage.model.fiche.ficheAba;

import phenotypage.model.cryoconservation.Cryoconservation;
import phenotypage.model.cryoconservation.embryon.Embryon;
import phenotypage.model.fiche.Fiche;
import phenotypage.model.fiche.ficheAba.abattoir.Abattoir;
import phenotypage.model.informationsPIV.Informations_PIV;
import phenotypage.model.invitro.collecte.Collecte;
import phenotypage.model.invitro.culture.Culture;
import phenotypage.model.invitro.fecondation.Fecondation;
import phenotypage.model.operateur.Operateur;

import javax.persistence.*;
import java.util.List;

/**
 * @author fabien
 */

@Entity
public class FicheAba extends Fiche {
    @Column
    private String numeroAgrement;

    @ManyToOne
    private Abattoir abattoir;

    @ManyToOne
    @JoinColumn
    private Operateur operateur;

    @Column
    private float temperatureArrivee;

    @OneToOne
    private Informations_PIV informations_piv;

    @OneToOne
    private Collecte collecte;

    @OneToOne
    private Fecondation fecondation;

    @OneToOne(cascade = CascadeType.ALL)
    private Culture culture;

    @OneToOne
    private Cryoconservation cryoconservation;

    @OneToMany
    private List<Embryon> embryons;

    public FicheAba() {
        super("Aba");
    }

    public String getNumeroAgrement() {
        return numeroAgrement;
    }

    public void setNumeroAgrement(String numeroAgrement) {
        this.numeroAgrement = numeroAgrement;
    }

    public Abattoir getAbattoir() {
        return abattoir;
    }

    public void setAbattoir(Abattoir abattoir) {
        this.abattoir = abattoir;
    }

    public Operateur getOperateur() {
        return operateur;
    }

    public void setOperateur(Operateur operateur) {
        this.operateur = operateur;
    }

    public float getTemperatureArrivee() {
        return temperatureArrivee;
    }

    public void setTemperatureArrivee(float temperatureArrivee) {
        this.temperatureArrivee = temperatureArrivee;
    }

    public Informations_PIV getInformations_piv() {
        return informations_piv;
    }

    public void setInformations_piv(Informations_PIV informations_piv) {
        this.informations_piv = informations_piv;
    }

    public Collecte getCollecte() {
        return collecte;
    }

    public void setCollecte(Collecte collecte) {
        this.collecte = collecte;
    }

    public Fecondation getFecondation() {
        return fecondation;
    }

    public void setFecondation(Fecondation fecondation) {
        this.fecondation = fecondation;
    }

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }

    public Cryoconservation getCryoconservation() {
        return cryoconservation;
    }

    public void setCryoconservation(Cryoconservation cryoconservation) {
        this.cryoconservation = cryoconservation;
    }

    public List<Embryon> getEmbryons() {
        return embryons;
    }

    public void setEmbryons(List<Embryon> Embryons) {
        this.embryons = Embryons;
    }
}


