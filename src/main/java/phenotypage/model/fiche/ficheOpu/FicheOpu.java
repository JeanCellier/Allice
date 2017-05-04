package phenotypage.model.fiche.ficheOpu;

import phenotypage.model.cryoconservation.Cryoconservation;
import phenotypage.model.cryoconservation.TableauDetail;
import phenotypage.model.donneesExistantes.operateur.Operateur;
import phenotypage.model.fiche.Fiche;
import phenotypage.model.imageEcho.Echo;
import phenotypage.model.informationsPIV.Informations_PIV;
import phenotypage.model.invitro.culture.Culture;
import phenotypage.model.invitro.fecondation.Fecondation;
import phenotypage.model.maturationInVitro.MaturationInVitro;
import phenotypage.model.ovocytesCollecte.OvocytesCollectes;
import phenotypage.model.tableauTraitement.TableauTraitement;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;
import phenotypage.model.typeOpu.TypeOpu;
import phenotypage.model.vache.Vache;

import javax.persistence.*;
import java.util.List;

/**
 * @author fabien
 */

@Entity
public class FicheOpu extends Fiche {
    @Column
    private String numeroAgrement;

    @Column
    private String lieu;

    @ManyToOne
    private Operateur operateur;

    @ManyToOne
    private TypeOpu typeOpu;

    @ManyToOne
    private Vache vache;

    @OneToOne
    private Traitement_Donneuse traitement_donneuse;

    @OneToOne
    private Echo imageEcho;

    @OneToOne
    private OvocytesCollectes ovocytesCollectes;

    @OneToOne
    private Informations_PIV informations_piv;

    @OneToOne
    private MaturationInVitro maturationInVitro;

    @OneToOne
    private Fecondation fecondation;

    @OneToOne
    private Culture culture;

    @OneToOne
    private Cryoconservation cryoconservation;

    @OneToMany
    private List<TableauTraitement> tableauTraitements;

    @OneToMany
    private List<TableauDetail> tableauDetails;

    public FicheOpu() {
        super("Opu");
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

    public void setTypeOpu(TypeOpu typeOpu) {
        this.typeOpu = typeOpu;
    }

    public Informations_PIV getInformations_piv() {
        return informations_piv;
    }

    public void setInformations_piv(Informations_PIV informations_piv) {
        this.informations_piv = informations_piv;
    }

    public MaturationInVitro getMaturationInVitro() {
        return maturationInVitro;
    }

    public void setMaturationInVitro(MaturationInVitro maturationInVitro) {
        this.maturationInVitro = maturationInVitro;
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

    public OvocytesCollectes getOvocytesCollectes() {
        return ovocytesCollectes;
    }

    public void setOvocytesCollectes(OvocytesCollectes ovocytesCollectes) {
        this.ovocytesCollectes = ovocytesCollectes;
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

    public Echo getImageEcho() {
        return imageEcho;
    }

    public void setImageEcho(Echo imageEcho) {
        this.imageEcho = imageEcho;
    }

    public TypeOpu getTypeOpu() {
        return typeOpu;
    }

    public void setTypeOpuList(TypeOpu typeOpu) {
        this.typeOpu = typeOpu;
    }

    public List<TableauTraitement> getTableauTraitements() {
        return tableauTraitements;
    }

    public void setTableauTraitements(List<TableauTraitement> tableauTraitements) {
        this.tableauTraitements = tableauTraitements;
    }

    public List<TableauDetail> getTableauDetails() {
        return tableauDetails;
    }

    public void setTableauDetails(List<TableauDetail> tableauDetails) {
        this.tableauDetails = tableauDetails;
    }
}


