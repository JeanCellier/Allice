package phenotypage.model.fiche.ficheCol;

import phenotypage.model.cryoconservation.Cryoconservation;
import phenotypage.model.cryoconservation.embryon.Embryon;
import phenotypage.model.fiche.Fiche;
import phenotypage.model.infoTraitementDonneuse.InfoTraitementDonneuse;
import phenotypage.model.invitro.collecte.resultat.Resultat;
import phenotypage.model.operateur.Operateur;
import phenotypage.model.tableauTraitement.TableauTraitement;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;
import phenotypage.model.traitementDonneuse.tableau_donneuse.Tableau_Donneuse;
import phenotypage.model.vache.Vache;

import javax.persistence.*;
import java.util.List;

/**
 * @author fabien
 */

@Entity
public class FicheCol extends Fiche {
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
    private InfoTraitementDonneuse infoTraitementDonneuse;

    @OneToOne
    private Traitement_Donneuse tableauSuperOv;

    @OneToOne
    private Resultat resultat_collecte;

    @OneToMany(mappedBy="ficheCol")
    private List<Embryon> detailsEmbryonsViables;

    @OneToOne
    private Cryoconservation cryoconservation;

    @Column
    private boolean LC;

    @Column
    private boolean LL;

    @Column
    private boolean ED;

    public FicheCol() {
        super("Col");
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

    public Vache getVache()
    {
        return vache;
    }

    public void setVache(Vache vache)
    {
        this.vache = vache;
    }

    public Traitement_Donneuse getTraitement_donneuse()
    {
        return traitement_donneuse;
    }

    public void setTraitement_donneuse(Traitement_Donneuse traitement_donneuse) {
        this.traitement_donneuse = traitement_donneuse;
    }

    public Resultat getResultat_collecte()
    {
        return resultat_collecte;
    }

    public void setResultat_collecte(Resultat resultat_collecte)
    {
        this.resultat_collecte = resultat_collecte;
    }

    public Cryoconservation getCryoconservation()
    {
        return cryoconservation;
    }

    public void setCryoconservation(Cryoconservation cryoconservation)
    {
        this.cryoconservation = cryoconservation;
    }

    public InfoTraitementDonneuse getInfoTraitementDonneuse() {
        return infoTraitementDonneuse;
    }

    public void setInfoTraitementDonneuse(InfoTraitementDonneuse infoTraitementDonneuse) {
        this.infoTraitementDonneuse = infoTraitementDonneuse;
    }

    public Traitement_Donneuse getTableauSuperOv() {
        return tableauSuperOv;
    }

    public void setTableauSuperOv(Traitement_Donneuse tableauSuperOv) {
        this.tableauSuperOv = tableauSuperOv;
    }

    public List<Embryon> getDetailsEmbryonsViables() {
        return detailsEmbryonsViables;
    }

    public void setDetailsEmbryonsViables(List<Embryon> detailsEmbryonsViables) {
        this.detailsEmbryonsViables = detailsEmbryonsViables;
    }

    public boolean isLC() {
        return LC;
    }

    public void setLC(boolean LC) {
        this.LC = LC;
    }

    public boolean isLL() {
        return LL;
    }

    public void setLL(boolean LL) {
        this.LL = LL;
    }

    public boolean isED() {
        return ED;
    }

    public void setED(boolean ED) {
        this.ED = ED;
    }
}


