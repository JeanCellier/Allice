package phenotypage.model.traitementDonneuse;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.filter.OncePerRequestFilter;
import phenotypage.model.donneExistante.operateur.Operateur;
import phenotypage.model.fiche.ficheCol.FicheCol;
import phenotypage.model.fiche.ficheIa.FicheIa;
import phenotypage.model.fiche.ficheOpu.FicheOpu;
import phenotypage.model.fiche.ficheTra.FicheTra;
import phenotypage.model.traitementDonneuse.tableauPharmacie.Tableau_Pharmacie;
import phenotypage.model.vache.Vache;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author fabien
 */

@Entity
public class Traitement_Donneuse implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date date_ref_chaleur;

	@Column
	private boolean naturel;

	@OneToMany(mappedBy = "traitement_donneuse", cascade = CascadeType.REMOVE)
	private List<Tableau_Pharmacie> tableau_pharmacie;

	@Column
	private int nb_follicules;

	@Column
	private int nb_droite;

	@Column
	private int nb_gauche;

	@Column
	private boolean superovulation;

	@Column
	private String typeFSH;

	@Column
	private float pourc_dose;

	@OneToMany(mappedBy = "traitement_donneuseSuper", cascade = CascadeType.REMOVE)
	private List<Tableau_Pharmacie> tableau_pharmacie_superovulation_medicament;

	@ManyToOne
	@JoinColumn(name = "idOperateur", referencedColumnName = "id")
	private Operateur operateur;

	@Column
	private boolean semenceSexe;

	@ManyToOne
	@JoinColumn(name = "idTaureau", referencedColumnName = "id")
	private Vache taureau;

	@OneToOne
	@JoinColumn(name = "idFicheOpu", referencedColumnName = "id", unique = true)
	private FicheOpu ficheOpu;

	@OneToOne
	@JoinColumn(name = "idFicheCol", referencedColumnName = "id", unique = true)
	private FicheCol ficheCol;

	@OneToOne
	@JoinColumn(name = "idFicheIa", referencedColumnName = "id", unique = true)
	private FicheIa ficheIa;

	@OneToOne
	@JoinColumn(name = "idFicheTra", referencedColumnName = "id", unique = true)
	private FicheTra ficheTra;

	public Traitement_Donneuse()
	{
		date_ref_chaleur = Calendar.getInstance().getTime();
	}

	public Traitement_Donneuse(Date date_ref_chaleur, boolean naturel, List<Tableau_Pharmacie> tableau_pharmacie,
	                           int nb_follicules, int nb_droite, int nb_gauche, boolean superovulation, String typeFSH, float pourc_dose,
	                           List<Tableau_Pharmacie> tableau_pharmacie_superovulation_medicament,
	                           List<String> tableau_pharmacie_superovulation_actes)
	{
		super();
		this.date_ref_chaleur = date_ref_chaleur;
		this.naturel = naturel;
		this.tableau_pharmacie = tableau_pharmacie;
		this.nb_follicules = nb_follicules;
		this.nb_droite = nb_droite;
		this.nb_gauche = nb_gauche;
		this.superovulation = superovulation;
		this.typeFSH = typeFSH;
		this.pourc_dose = pourc_dose;
		this.tableau_pharmacie_superovulation_medicament = tableau_pharmacie_superovulation_medicament;
		//this.tableau_pharmacie_superovulation_actes = tableau_pharmacie_superovulation_actes;
	}

	public Date getDate_ref_chaleur()
	{
		return date_ref_chaleur;
	}

	public void setDate_ref_chaleur(Date date_ref_chaleur)
	{
		this.date_ref_chaleur = date_ref_chaleur;
	}

	public boolean isNaturel()
	{
		return naturel;
	}

	public void setNaturel(boolean naturel)
	{
		this.naturel = naturel;
	}

	public List<Tableau_Pharmacie> getTableau_pharmacie()
	{
		return tableau_pharmacie;
	}

	public void setTableau_pharmacie(List<Tableau_Pharmacie> tableau_pharmacie)
	{
		this.tableau_pharmacie = tableau_pharmacie;
	}

	public int getNb_follicules()
	{
		return nb_follicules;
	}

	public void setNb_follicules(int nb_follicules)
	{
		this.nb_follicules = nb_follicules;
	}

	public int getNb_droite()
	{
		return nb_droite;
	}

	public void setNb_droite(int nb_droite)
	{
		this.nb_droite = nb_droite;
	}

	public int getNb_gauche()
	{
		return nb_gauche;
	}

	public void setNb_gauche(int nb_gauche)
	{
		this.nb_gauche = nb_gauche;
	}

	public boolean isSuperovulation()
	{
		return superovulation;
	}

	public void setSuperovulation(boolean superovulation)
	{
		this.superovulation = superovulation;
	}

	public String getTypeFSH()
	{
		return typeFSH;
	}

	public void setTypeFSH(String typeFSH)
	{
		this.typeFSH = typeFSH;
	}

	public float getPourc_dose()
	{
		return pourc_dose;
	}

	public void setPourc_dose(float pourc_dose)
	{
		this.pourc_dose = pourc_dose;
	}

	public List<Tableau_Pharmacie> getTableau_pharmacie_superovulation_medicament()
	{
		return tableau_pharmacie_superovulation_medicament;
	}

	public void setTableau_pharmacie_superovulation_medicament(
			List<Tableau_Pharmacie> tableau_pharmacie_superovulation_medicament)
	{
		this.tableau_pharmacie_superovulation_medicament = tableau_pharmacie_superovulation_medicament;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public FicheOpu getFicheOpu()
	{
		return ficheOpu;
	}

	public void setFicheOpu(FicheOpu ficheOpu)
	{
		this.ficheOpu = ficheOpu;
	}

	public FicheCol getFicheCol()
	{
		return ficheCol;
	}

	public void setFicheCol(FicheCol ficheCol)
	{
		this.ficheCol = ficheCol;
	}

	public FicheIa getFicheIa()
	{
		return ficheIa;
	}

	public void setFicheIa(FicheIa ficheIa)
	{
		this.ficheIa = ficheIa;
	}

	public FicheTra getFicheTra()
	{
		return ficheTra;
	}

	public void setFicheTra(FicheTra ficheTra)
	{
		this.ficheTra = ficheTra;
	}

	public Operateur getOperateur()
	{
		return operateur;
	}

	public void setOperateur(Operateur operateur)
	{
		this.operateur = operateur;
	}

	public boolean isSemenceSexe()
	{
		return semenceSexe;
	}

	public void setSemenceSexe(boolean semenceSexe)
	{
		this.semenceSexe = semenceSexe;
	}

	public Vache getTaureau()
	{
		return taureau;
	}

	public void setTaureau(Vache taureau)
	{
		this.taureau = taureau;
	}
}
