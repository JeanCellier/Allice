package phenotypage.model.fiche.ficheTra;

import phenotypage.model.corpsJaune.CorpsJaune;
import phenotypage.model.embryonsTransferes.EmbryonsTransferes;
import phenotypage.model.fiche.Fiche;
import phenotypage.model.fiches.traitement.header.Header;
import phenotypage.model.gestation.Gestation;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;
import phenotypage.model.vache.Vache;

import javax.persistence.*;

/**
 * @author fabien
 */

@Entity
public class FicheTra extends Fiche {
    @Column
    private boolean snig;

    @OneToOne
    private Header header;

    @ManyToOne
    @JoinColumn(name = "id_Vache", referencedColumnName = "id")
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
    }

    public FicheTra(String nom) {
        super(nom);
    }

    public FicheTra(String nom, Header header, Vache vache, Traitement_Donneuse traitement_donneuse,
                    CorpsJaune corpsJaune, EmbryonsTransferes embryonsTransferes, Gestation gestation) {
        super(nom);
        this.header = header;
        this.vache = vache;
        this.traitement_donneuse = traitement_donneuse;
        this.corpsJaune = corpsJaune;
        this.embryonsTransferes = embryonsTransferes;
        this.gestation = gestation;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
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

    public boolean isSnig() {
        return snig;
    }

    public void setSnig(boolean snig) {
        this.snig = snig;
    }
}


