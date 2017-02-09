package phenotypage.model.invitro.collecte.resultat;

import phenotypage.model.fiche.ficheCol.FicheCol;
import phenotypage.model.donneExistante.sanitaire.Sanitaire;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Resultat implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private int nombre_Embryons_Viables;

	@Column
	private int nombre_Embryons_Degeneres;

	@Column
	private int nombre_Embryons_NonFecondes;

	@Column
	private int nombre_Embryons_Total;

	@Column
	private int nombre_CorpsJ_droite;

	@Column
	private int nombre_CorpsJ_gauche;

	@Column
	private float taux_de_collecte;

	@ManyToOne
	@JoinColumn(name = "idSanitaire", referencedColumnName = "id")
	private Sanitaire sanitaire;

	@Column
	private String remarques;


	@OneToOne
	@JoinColumn(name = "idFicheCol", referencedColumnName = "id", unique = true)
	private FicheCol ficheCol;


	public Resultat()
	{
	}

	public Resultat(int nombre_Embryons_Viables, int nombre_Embryons_Degeneres, int nombre_Embryons_NonFecondes,
	                int nombre_CorpsJ_droite, int nombre_CorpsJ_gauche, Sanitaire sanitaire, String remarques,
	                FicheCol ficheCol)
	{
		super();
		this.nombre_Embryons_Viables = nombre_Embryons_Viables;
		this.nombre_Embryons_Degeneres = nombre_Embryons_Degeneres;
		this.nombre_Embryons_NonFecondes = nombre_Embryons_NonFecondes;
		this.nombre_CorpsJ_droite = nombre_CorpsJ_droite;
		this.nombre_CorpsJ_gauche = nombre_CorpsJ_gauche;
		this.sanitaire = sanitaire;
		this.remarques = remarques;
		this.ficheCol = ficheCol;

		this.nombre_Embryons_Total = this.nombre_Embryons_Degeneres + this.nombre_Embryons_NonFecondes + this.nombre_Embryons_Viables;
	}


	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public int getNombre_Embryons_Viables()
	{
		return nombre_Embryons_Viables;
	}

	public void setNombre_Embryons_Viables(int nombre_Embryons_Viables)
	{
		this.nombre_Embryons_Viables = nombre_Embryons_Viables;
	}

	public int getNombre_Embryons_Degeneres()
	{
		return nombre_Embryons_Degeneres;
	}

	public void setNombre_Embryons_Degeneres(int nombre_Embryons_Degeneres)
	{
		this.nombre_Embryons_Degeneres = nombre_Embryons_Degeneres;
	}

	public int getNombre_Embryons_NonFecondes()
	{
		return nombre_Embryons_NonFecondes;
	}

	public void setNombre_Embryons_NonFecondes(int nombre_Embryons_NonFecondes)
	{
		this.nombre_Embryons_NonFecondes = nombre_Embryons_NonFecondes;
	}

	public int getNombre_Embryons_Total()
	{
		return nombre_Embryons_Total;
	}

	public void setNombre_Embryons_Total(int nombre_Embryons_Total)
	{
		this.nombre_Embryons_Total = nombre_Embryons_Total;
	}

	public int getNombre_CorpsJ_droite()
	{
		return nombre_CorpsJ_droite;
	}

	public void setNombre_CorpsJ_droite(int nombre_CorpsJ_droite)
	{
		this.nombre_CorpsJ_droite = nombre_CorpsJ_droite;
	}

	public int getNombre_CorpsJ_gauche()
	{
		return nombre_CorpsJ_gauche;
	}

	public void setNombre_CorpsJ_gauche(int nombre_CorpsJ_gauche)
	{
		this.nombre_CorpsJ_gauche = nombre_CorpsJ_gauche;
	}

	public float getTaux_de_collecte()
	{
		return taux_de_collecte;
	}

	public void setTaux_de_collecte(float taux_de_collecte)
	{
		this.taux_de_collecte = taux_de_collecte;
	}

	public Sanitaire getSanitaire()
	{
		return sanitaire;
	}

	public void setSanitaire(Sanitaire sanitaire)
	{
		this.sanitaire = sanitaire;
	}

	public String getRemarques()
	{
		return remarques;
	}

	public void setRemarques(String remarques)
	{
		this.remarques = remarques;
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
