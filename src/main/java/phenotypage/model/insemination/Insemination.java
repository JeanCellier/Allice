package phenotypage.model.insemination;

import javax.persistence.*;

import phenotypage.model.donneExistante.operateur.Operateur;
import phenotypage.model.donneExistante.qualite.Qualite;
import phenotypage.model.fiche.ficheCol.FicheCol;
import phenotypage.model.fiche.ficheIa.FicheIa;
import phenotypage.model.fiche.ficheTra.FicheTra;
import phenotypage.model.vache.Vache;

import java.io.Serializable;

/**
 * @author fabien
 */

@Entity
public class Insemination implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private boolean sexe;
	//true X, false Y, 

	@ManyToOne
	@JoinColumn(name = "idOperateur", referencedColumnName = "id")
	private Operateur operateur;

	@ManyToOne
	@JoinColumn(name = "id_Taureau", referencedColumnName = "id")
	private Vache taureau;
	
	@Column
	private boolean collecte;
	//true cote droit//false cote gauche

	@Column
	private int tiers;
	//1 : 1/3 ...jusqua 3

	@Column
	private String progression;

	@ManyToOne
	@JoinColumn(name = "idFicheCol", referencedColumnName = "id")
	private FicheCol ficheCol;


	@OneToOne
	@JoinColumn(name = "idFicheTra", referencedColumnName = "id", unique = true)
	private FicheTra ficheTra;

	@OneToOne
	@JoinColumn(name = "idFicheIa", referencedColumnName = "id", unique = true)
	private FicheIa ficheIa;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public boolean isSexe()
	{
		return sexe;
	}

	public void setSexe(boolean sexe)
	{
		this.sexe = sexe;
	}

	public Operateur getOperateur()
	{
		return operateur;
	}

	public void setOperateur(Operateur operateur)
	{
		this.operateur = operateur;
	}

	public Vache getTaureau()
	{
		return taureau;
	}

	public void setTaureau(Vache taureau)
	{
		this.taureau = taureau;
	}

	public boolean isCollecte()
	{
		return collecte;
	}

	public void setCollecte(boolean collecte)
	{
		this.collecte = collecte;
	}

	public int getTiers()
	{
		return tiers;
	}

	public void setTiers(int tiers)
	{
		this.tiers = tiers;
	}

	public String getProgression()
	{
		return progression;
	}

	public void setProgression(String progression)
	{
		this.progression = progression;
	}

	public FicheTra getFicheTra()
	{
		return ficheTra;
	}

	public void setFicheTra(FicheTra ficheTra)
	{
		this.ficheTra = ficheTra;
	}

	public Insemination(boolean sexe, Operateur operateur, Vache taureau, boolean collecte,
	                    int tiers, String progression, FicheTra ficheTra)
	{
		super();
		this.sexe = sexe;
		this.operateur = operateur;
		this.taureau = taureau;
		this.collecte = collecte;
		this.tiers = tiers;
		this.progression = progression;
		this.ficheTra = ficheTra;
	}

	public Insemination()
	{
	}

	public FicheIa getFicheIa()
	{
		return ficheIa;
	}

	public void setFicheIa(FicheIa ficheIa)
	{
		this.ficheIa = ficheIa;
	}

	public FicheCol getFicheCol()
	{
		return ficheCol;
	}

	public void setFicheCol(FicheCol ficheCol)
	{
		this.ficheCol = ficheCol;
	}
}
