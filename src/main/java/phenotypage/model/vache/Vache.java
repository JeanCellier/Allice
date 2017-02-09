package phenotypage.model.vache;

import phenotypage.model.embryonsTransferes.EmbryonsTransferes;
import phenotypage.model.fiche.ficheCarriere.FicheCarriere;
import phenotypage.model.fiche.ficheCol.FicheCol;
import phenotypage.model.fiche.ficheIa.FicheIa;
import phenotypage.model.fiche.ficheOpu.FicheOpu;
import phenotypage.model.fiche.ficheTra.FicheTra;
import phenotypage.model.insemination.Insemination;
import phenotypage.model.invitro.fecondation.TableauSemence;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Vache implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String proprietaire;

	@Column
	private String nom;

	@Column
	private String num_elevage;

	@Column(unique = true)
	private String num_identification;

	@Column
	private long num_travail;

	@Column
	private int race;

	@Column
	private boolean male = false;

	@Column
	private String parite;

	@OneToMany(mappedBy = "taureau")
	private List<TableauSemence> tableau_semences;

	@OneToMany(mappedBy = "taureau")
	private List<Traitement_Donneuse> traitementDonneuseList;

	@OneToMany(mappedBy = "taureau")
	private List<Insemination> inseminationList;

	@OneToMany(mappedBy = "taureau")
	private List<EmbryonsTransferes> embryonsTransferesList;

	@OneToMany(mappedBy = "vache")
	private List<FicheOpu> ficheOpuList;

	@OneToMany(mappedBy = "vache")
	private List<FicheCol> ficheColList;

	@OneToMany(mappedBy = "vache")
	private List<FicheIa> ficheIaList;

	@OneToMany(mappedBy = "vache")
	private List<FicheTra> ficheTraList;

	@OneToOne
	private FicheCarriere ficheCarriere;

	public Vache()
	{
	}


	public Vache(String proprietaire, String num_elevage, String num_identification, long num_travail, int race)
	{
		super();
		this.proprietaire = proprietaire;
		this.num_elevage = num_elevage;
		this.num_identification = num_identification;
		this.num_travail = num_travail;
		this.race = race;
	}


	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getProprietaire()
	{
		return proprietaire;
	}

	public void setProprietaire(String proprietaire)
	{
		this.proprietaire = proprietaire;
	}

	public String getNum_elevage()
	{
		return num_elevage;
	}

	public void setNum_elevage(String num_elevage)
	{
		this.num_elevage = num_elevage;
	}

	public String getNum_identification()
	{
		return num_identification;
	}

	public void setNum_identification(String num_identification)
	{
		this.num_identification = num_identification;
	}

	public long getNum_travail()
	{
		return num_travail;
	}

	public void setNum_travail(long num_travail)
	{
		this.num_travail = num_travail;
	}

	public int getRace()
	{
		return race;
	}

	public void setRace(int race)
	{
		this.race = race;
	}

	public List<FicheOpu> getFicheOpuList()
	{
		return ficheOpuList;
	}

	public void setFicheOpuList(List<FicheOpu> ficheOpuList)
	{
		this.ficheOpuList = ficheOpuList;
	}

	public List<FicheCol> getFicheColList()
	{
		return ficheColList;
	}

	public void setFicheColList(List<FicheCol> ficheColList)
	{
		this.ficheColList = ficheColList;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public boolean isMale()
	{
		return male;
	}

	public void setMale(boolean male)
	{
		this.male = male;
	}

	public List<FicheIa> getFicheIaList()
	{
		return ficheIaList;
	}

	public void setFicheIaList(List<FicheIa> ficheIaList)
	{
		this.ficheIaList = ficheIaList;
	}

	public List<FicheTra> getFicheTraList()
	{
		return ficheTraList;
	}

	public void setFicheTraList(List<FicheTra> ficheTraList)
	{
		this.ficheTraList = ficheTraList;
	}

	public List<TableauSemence> getTableau_semences()
	{
		return tableau_semences;
	}

	public void setTableau_semences(List<TableauSemence> tableau_semences)
	{
		this.tableau_semences = tableau_semences;
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

	public String getParite()
	{
		return parite;
	}

	public void setParite(String parite)
	{
		this.parite = parite;
	}

	public FicheCarriere getFicheCarriere()
	{
		return ficheCarriere;
	}

	public void setFicheCarriere(FicheCarriere ficheCarriere)
	{
		this.ficheCarriere = ficheCarriere;
	}

	public List<EmbryonsTransferes> getEmbryonsTransferesList()
	{
		return embryonsTransferesList;
	}

	public void setEmbryonsTransferesList(List<EmbryonsTransferes> embryonsTransferesList)
	{
		this.embryonsTransferesList = embryonsTransferesList;
	}
}
