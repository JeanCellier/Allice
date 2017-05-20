package phenotypage.model.invitro.collecte.resultat;

import javax.persistence.*;

@Entity
public class Resultat
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

	@Column
	private String sanitaire;

	@Column
	private String remarques;

	public Resultat() {}

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

	public String getSanitaire()
	{
		return sanitaire;
	}

	public void setSanitaire(String sanitaire)
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
}
