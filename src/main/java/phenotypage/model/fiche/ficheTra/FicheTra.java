package phenotypage.model.fiche.ficheTra;

import phenotypage.model.fiche.ficheTra.corpsJaune.CorpsJaune;
import phenotypage.model.operateur.Operateur;
import phenotypage.model.fiche.ficheTra.embryonsTransferes.EmbryonsTransferes;
import phenotypage.model.fiche.Fiche;
import phenotypage.model.gestation.Gestation;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;
import phenotypage.model.vache.Vache;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author fabien
 */

@Entity
public class FicheTra extends Fiche {
    @Column
    private String numeroAgrement;

    @Column
    private String lieu;

    @ManyToOne
    private Operateur operateur;

    @ManyToOne
    private Vache vache;

    @OneToOne
    private Traitement_Donneuse traitement_donneuse;

    @OneToOne
    private CorpsJaune corpsJaune;

    @OneToOne
    private EmbryonsTransferes embryonsTransferes;

    @OneToOne
    private Gestation gestation;

    public FicheTra() {
        super("Tra");
    }

    public String getNumeroAgrement() {
        return numeroAgrement;
    }

    public void setNumeroAgrement(String numeroAgrement) {
        this.numeroAgrement = numeroAgrement;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Operateur getOperateur() {
        return operateur;
    }

    public void setOperateur(Operateur operateur) {
        this.operateur = operateur;
    }

    public Vache getVache() {
        return vache;
    }

    public void setVache(Vache vache) {
        this.vache = vache;
    }

    public Traitement_Donneuse getTraitement_donneuse() {
        return traitement_donneuse;
    }

    public void setTraitement_donneuse(Traitement_Donneuse traitement_donneuse) {
        this.traitement_donneuse = traitement_donneuse;
    }

    public CorpsJaune getCorpsJaune() {
        return corpsJaune;
    }

    public void setCorpsJaune(CorpsJaune corpsJaune) {
        this.corpsJaune = corpsJaune;
    }

    public EmbryonsTransferes getEmbryonsTransferes() {
        return embryonsTransferes;
    }

    public void setEmbryonsTransferes(EmbryonsTransferes embryonsTransferes) {
        this.embryonsTransferes = embryonsTransferes;
    }

    public Gestation getGestation() {
        return gestation;
    }

    public void setGestation(Gestation gestation) {
        this.gestation = gestation;
    }

}


