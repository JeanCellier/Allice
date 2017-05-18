package phenotypage.model.fiche.ficheCol;

import phenotypage.model.cryoconservation.Cryoconservation;
import phenotypage.model.cryoconservation.tableauDetail.TableauDetail;
import phenotypage.model.operateur.Operateur;
import phenotypage.model.fiche.Fiche;
import phenotypage.model.invitro.collecte.resultat.Resultat;
import phenotypage.model.tableauTraitement.TableauTraitement;
import phenotypage.model.infoTraitementDonneuse.InfoTraitementDonneuse;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;
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
	private Resultat resultat_collecte;

	@OneToOne
	private Cryoconservation cryoconservation;

	@OneToMany
	private List<TableauTraitement> tableauTraitements;

	@OneToOne
	private InfoTraitementDonneuse infoTraitementDonneuse;

	@OneToMany
	private List<TableauDetail> tableauDetails;

	public FicheCol() { super(); }

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

	public List<TableauTraitement> getTableauTraitements() {
		return tableauTraitements;
	}

	public void setTableauTraitements(List<TableauTraitement> tableauTraitements) {
		this.tableauTraitements = tableauTraitements;
	}

	public InfoTraitementDonneuse getInfoTraitementDonneuse() {
		return infoTraitementDonneuse;
	}

	public void setInfoTraitementDonneuse(InfoTraitementDonneuse infoTraitementDonneuse) {
		this.infoTraitementDonneuse = infoTraitementDonneuse;
	}

	public List<TableauDetail> getTableauDetails() {
		return tableauDetails;
	}

	public void setTableauDetails(List<TableauDetail> tableauDetails) {
		this.tableauDetails = tableauDetails;
	}
}


