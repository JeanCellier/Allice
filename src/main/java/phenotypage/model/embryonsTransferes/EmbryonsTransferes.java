package phenotypage.model.embryonsTransferes;

import javax.persistence.*;

import phenotypage.model.fiche.ficheTra.FicheTra;
import phenotypage.model.vache.Vache;

import java.io.Serializable;

/**
 * @author fabien
 */

@Entity
public class EmbryonsTransferes implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private boolean sexe;
	//true X, false Y, 

	@Column
	private String refExperience;

	@Column
	private String refEmbryons;

	@ManyToOne
	@JoinColumn(name = "id_Taureau", referencedColumnName = "id")
	private Vache taureau;
	
	@Column
	private boolean cote;
	//true cote droit//false cote gauche

	@Column
	private int tiers;
	//1 : 1/3 ...jusqua 3

	@Column
	private String faciliteprogression;

	@OneToOne
	@JoinColumn(name = "idFicheTra", referencedColumnName = "id", unique = true)
	private FicheTra ficheTra;


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


	public String getRefExperience()
	{
		return refExperience;
	}


	public void setRefExperience(String refExperience)
	{
		this.refExperience = refExperience;
	}


	public Vache getTaureau()
	{
		return taureau;
	}


	public void setTaureau(Vache taureau)
	{
		this.taureau = taureau;
	}


	public boolean isCote()
	{
		return cote;
	}


	public void setCote(boolean cote)
	{
		this.cote = cote;
	}


	public int getTiers()
	{
		return tiers;
	}


	public void setTiers(int tiers)
	{
		this.tiers = tiers;
	}

	public String getFaciliteprogression()
	{
		return faciliteprogression;
	}

	public void setFaciliteprogression(String faciliteprogression)
	{
		this.faciliteprogression = faciliteprogression;
	}

	public EmbryonsTransferes()
	{
		super();
	}

	public FicheTra getFicheTra()
	{
		return ficheTra;
	}

	public void setFicheTra(FicheTra ficheTra)
	{
		this.ficheTra = ficheTra;
	}

	public String getRefEmbryons()
	{
		return refEmbryons;
	}

	public void setRefEmbryons(String refEmbryons)
	{
		this.refEmbryons = refEmbryons;
	}

	public EmbryonsTransferes(boolean sexe, String refEmbryons, Vache taureau, boolean cote, int tiers, String faciliteprogression)
	{
		super();
		this.sexe = sexe;
		this.refExperience = refEmbryons;
		this.taureau = taureau;
		this.cote = cote;
		this.tiers = tiers;
		this.faciliteprogression = faciliteprogression;
	}


}
