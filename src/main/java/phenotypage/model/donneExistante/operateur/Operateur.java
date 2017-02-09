package phenotypage.model.donneExistante.operateur;

import org.hibernate.validator.constraints.NotEmpty;
import phenotypage.model.cryoconservation.Cryoconservation;
import phenotypage.model.fiche.ficheCarriere.Tableau_Carriere;
import phenotypage.model.fiches.traitement.header.Header;
import phenotypage.model.informationsPIV.Informations_PIV;
import phenotypage.model.insemination.Insemination;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author fabien
 */

@Entity
public class Operateur implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	@NotEmpty(message = "**")
	private String nom;

	@Column
	@NotEmpty(message = "**")
	private String prenom;

	@ManyToMany
	@JoinTable(name = "InformationPIV_ListeOperateur",
			joinColumns = {@JoinColumn(name = "idOperateur",
					referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "idInformations_piv",
					referencedColumnName = "id")})
	private List<Informations_PIV> informations_pivList;

	@OneToMany(mappedBy = "operateur")
	private List<Cryoconservation> cryoconservationList;

	@OneToMany(mappedBy = "operateur")
	private List<Header> headerList;

	@OneToMany(mappedBy = "operateur")
	private List<Traitement_Donneuse> traitementDonneuseList;

	@OneToMany(mappedBy = "operateur")
	private List<Insemination> inseminationList;

	@OneToMany(mappedBy = "operateur")
	private List<Tableau_Carriere> tableau_carrieres;

	public Operateur()
	{
	}

	public Operateur(String nom, String prenom)
	{
		this.nom = nom;
		this.prenom = prenom;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	public List<Informations_PIV> getInformations_pivList()
	{
		return informations_pivList;
	}

	public void setInformations_pivList(List<Informations_PIV> informations_pivList)
	{
		this.informations_pivList = informations_pivList;
	}

	public List<Cryoconservation> getCryoconservationList()
	{
		return cryoconservationList;
	}

	public void setCryoconservationList(List<Cryoconservation> cryoconservationList)
	{
		this.cryoconservationList = cryoconservationList;
	}

	public List<Header> getHeaderList()
	{
		return headerList;
	}

	public void setHeaderList(List<Header> headerList)
	{
		this.headerList = headerList;
	}

	public List<Traitement_Donneuse> getTraitementDonneuseList()
	{
		return traitementDonneuseList;
	}

	public void setTraitementDonneuseList(List<Traitement_Donneuse> traitementDonneuseList)
	{
		this.traitementDonneuseList = traitementDonneuseList;
	}

	public List<Insemination> getInseminationList()
	{
		return inseminationList;
	}

	public void setInseminationList(List<Insemination> inseminationList)
	{
		this.inseminationList = inseminationList;
	}

	public List<Tableau_Carriere> getTableau_carrieres()
	{
		return tableau_carrieres;
	}

	public void setTableau_carrieres(List<Tableau_Carriere> tableau_carrieres)
	{
		this.tableau_carrieres = tableau_carrieres;
	}
}
