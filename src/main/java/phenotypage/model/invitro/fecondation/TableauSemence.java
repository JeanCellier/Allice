package phenotypage.model.invitro.fecondation;

import phenotypage.model.vache.Vache;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author fabien
 */

@Entity
public class TableauSemence implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_Taureau", referencedColumnName = "id")
	private Vache taureau;

	@Column
	private String numeroEjaculation;

	@Column
	private float volume;

	@Column
	private String etatFrais;

	@ManyToOne
	@JoinColumn(name = "id_Collecte", referencedColumnName = "id")
	private Fecondation fecondation;

	public TableauSemence()
	{
	}

	public TableauSemence(Vache taureau, String numeroEjaculation)
	{
		this.taureau = taureau;
		this.numeroEjaculation = numeroEjaculation;
	}

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

	public Fecondation getFecondation()
	{
		return fecondation;
	}

	public void setFecondation(Fecondation fecondation)
	{
		this.fecondation = fecondation;
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

	public String getEtatFrais()
	{
		return etatFrais;
	}

	public void setEtatFrais(String etatFrais)
	{
		this.etatFrais = etatFrais;
	}
}
