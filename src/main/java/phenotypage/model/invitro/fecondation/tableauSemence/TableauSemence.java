package phenotypage.model.invitro.fecondation.tableauSemence;

import phenotypage.model.vache.Vache;

import javax.persistence.*;

/**
 * @author fabien
 */

@Entity
public class TableauSemence
{
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Vache taureau;

	@Column
	private String numeroEjaculation;

	@Column
	private float volume;

	@Column
	private int etatFrais;

	public TableauSemence() {}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Vache getTaureau()
	{
		return taureau;
	}

	public void setTaureau(Vache taureau)
	{
		this.taureau = taureau;
	}

	public String getSemence()
	{
		return numeroEjaculation;
	}

	public void setSemence(String semence)
	{
		this.numeroEjaculation = semence;
	}

	public String getNumeroEjaculation()
	{
		return numeroEjaculation;
	}

	public void setNumeroEjaculation(String numeroEjaculation)
	{
		this.numeroEjaculation = numeroEjaculation;
	}

	public float getVolume()
	{
		return volume;
	}

	public void setVolume(float volume)
	{
		this.volume = volume;
	}

	public int getEtatFrais()
	{
		return etatFrais;
	}

	public void setEtatFrais(int etatFrais)
	{
		this.etatFrais = etatFrais;
	}
}
