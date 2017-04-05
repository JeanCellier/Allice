package phenotypage.model.fiche.ficheAba;

import phenotypage.model.cryoconservation.Cryoconservation;
import phenotypage.model.fiche.Fiche;
import phenotypage.model.fiches.traitement.header.Header;
import phenotypage.model.informationsPIV.Informations_PIV;
import phenotypage.model.invitro.collecte.Collecte;
import phenotypage.model.invitro.culture.Culture;
import phenotypage.model.invitro.fecondation.Fecondation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author fabien
 */

@Entity
public class
FicheAba extends Fiche {
    @Column
    private boolean snig;

    @OneToOne
    private Header header;

    @OneToOne
    private Informations_PIV informations_piv;

    @OneToOne
    private Collecte collecte;

    @OneToOne
    private Fecondation fecondation;

    @OneToOne
    private Culture culture;

    @OneToOne
    private Cryoconservation cryoconservation;

    public FicheAba() {
    }

    public FicheAba(String nom) {
        super(nom);
    }

    public FicheAba(Header header, Informations_PIV informations_piv, Collecte collecte, Fecondation fecondation, Culture culture, Cryoconservation cryoconservation) {
        this.header = header;
        this.informations_piv = informations_piv;
        this.collecte = collecte;
        this.fecondation = fecondation;
        this.culture = culture;
        this.cryoconservation = cryoconservation;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
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

    public boolean isSnig() {
        return snig;
    }

    public void setSnig(boolean snig) {
        this.snig = snig;
    }
}


