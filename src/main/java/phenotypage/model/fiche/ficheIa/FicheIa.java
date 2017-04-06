package phenotypage.model.fiche.ficheIa;

import phenotypage.model.donneesExistantes.operateur.Operateur;
import phenotypage.model.fiche.Fiche;
import phenotypage.model.gestation.Gestation;
import phenotypage.model.insemination.Insemination;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;
import phenotypage.model.vache.Vache;

import javax.persistence.*;

/**
 * @author fabien
 */

@Entity
public class FicheIa extends Fiche {
	@Column
	private String lieu;

	@ManyToOne
	private Operateur operateur;

	@ManyToOne
	private Vache vache;

	@Column
	private String numIpe;

	@Column
	private String numDepotSemence;

	@OneToOne
	private Insemination insemination;
	
	@OneToOne
	private Traitement_Donneuse traitement_donneuse;
	
	@OneToOne
	private Gestation gestation;

	@Column
	private String remarque;

	public FicheIa() { super(); }

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

	public Insemination getInsemination()
	{
		return insemination;
	}

	public void setInsemination(Insemination insemination)
	{
		this.insemination = insemination;
	}

	public Traitement_Donneuse getTraitement_donneuse()
	{
		return traitement_donneuse;
	}

	public void setTraitement_donneuse(Traitement_Donneuse traitement_donneuse) {this.traitement_donneuse = traitement_donneuse;}

	public Gestation getGestation()
	{
		return gestation;
	}

	public void setGestation(Gestation gestation)
	{
		this.gestation = gestation;
	}

	public String getRemarque()
	{
		return remarque;
	}

	public void setRemarque(String remarque)
	{
		this.remarque = remarque;
	}

	public String getNumIpe() {
		return numIpe;
	}

	public void setNumIpe(String numIpe) {
		this.numIpe = numIpe;
	}

	public String getNumDepotSemence() {
		return numDepotSemence;
	}

	public void setNumDepotSemence(String numDepotSemence) {
		this.numDepotSemence = numDepotSemence;
	}
}


