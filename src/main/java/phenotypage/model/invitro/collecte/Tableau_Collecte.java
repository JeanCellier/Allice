package phenotypage.model.invitro.collecte;

import phenotypage.model.vache.Vache;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Tableau_Collecte implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private int race_Ovaires;

	@Column
	private int nombre_Ovaires;

	@Column
	private int nombre_Ovocytes;

	@Column
	private float taux_Collecte;

	@Column
	private Vache vache;

	@Column
	private boolean pool;

	@ManyToOne
	@JoinColumn(name = "id_Collecte", referencedColumnName = "id")
	private Collecte collecte;

	public Tableau_Collecte()
	{
	}

	Tableau_Collecte(int race_Ovaires, int nombre_Ovaires, int nombre_Ovocytes)
	{
		this.race_Ovaires = race_Ovaires;
		this.nombre_Ovaires = nombre_Ovaires;
		this.nombre_Ovocytes = nombre_Ovocytes;
		this.taux_Collecte = nombre_Ovaires / nombre_Ovocytes;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public int getRace_Ovaires()
	{
		return race_Ovaires;
	}

	public void setRace_Ovaires(int race_Ovaires)
	{
		this.race_Ovaires = race_Ovaires;
	}

	public int getNombre_Ovaires()
	{
		return nombre_Ovaires;
	}

	public void setNombre_Ovaires(int nombre_Ovaires)
	{
		this.nombre_Ovaires = nombre_Ovaires;
	}

	public int getNombre_Ovocytes()
	{
		return nombre_Ovocytes;
	}

	public void setNombre_Ovocytes(int nombre_Ovocytes)
	{
		this.nombre_Ovocytes = nombre_Ovocytes;
	}

	public float getTaux_Collecte()
	{
		return taux_Collecte;
	}

	public void setTaux_Collecte(float taux_Collecte)
	{
		this.taux_Collecte = taux_Collecte;
	}

	public Collecte getCollecte()
	{
		return collecte;
	}

	public void setCollecte(Collecte collecte)
	{
		this.collecte = collecte;
	}

	public Vache getVache()
	{
		return vache;
	}

	public void setVache(Vache vache)
	{
		this.vache = vache;
	}

	public boolean isPool()
	{
		return pool;
	}

	public void setPool(boolean pool)
	{
		this.pool = pool;
	}
}
