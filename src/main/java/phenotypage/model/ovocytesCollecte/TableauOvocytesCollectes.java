package phenotypage.model.ovocytesCollecte;

import phenotypage.model.donneExistante.qualite.Qualite;

import javax.persistence.*;

/**
 * @author fabien
 */

@Entity
public class TableauOvocytesCollectes
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private int nb_cocs;

	/*Vrai pour mature et faux pour immature*/
	@Column
	private boolean mature;

	@Column
	private boolean fiv;
	
	@Column
	private String utilisation;

	@ManyToOne
	@JoinColumn(name = "idOvocytesCollectes", referencedColumnName = "id")
	private OvocytesCollectes ovocytes_collectes;

	@ManyToOne
	@JoinColumn(name = "idQualite", referencedColumnName = "id")
	private Qualite qualite;

	public TableauOvocytesCollectes()
	{
	}

	public int getNb_cocs()
	{
		return nb_cocs;
	}


	public void setNb_cocs(int nb_cocs)
	{
		this.nb_cocs = nb_cocs;
	}


	public Qualite getQualite()
	{
		return qualite;
	}


	public void setQualite(Qualite qualite)
	{
		this.qualite = qualite;
	}


	public boolean isFiv()
	{
		return fiv;
	}


	public void setFiv(boolean fiv)
	{
		this.fiv = fiv;
	}


	public String getUtilisation()
	{
		return utilisation;
	}


	public void setUtilisation(String utilisation)
	{
		this.utilisation = utilisation;
	}


	public OvocytesCollectes getOvocytes_collectes()
	{
		return ovocytes_collectes;
	}


	public void setOvocytes_collectes(OvocytesCollectes ovocytes_collectes)
	{
		this.ovocytes_collectes = ovocytes_collectes;
	}

	public boolean isMature()
	{
		return mature;
	}

	public void setMature(boolean mature)
	{
		this.mature = mature;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}
}
