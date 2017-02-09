package phenotypage.model.donneExistante.destionationCulture;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author fabien
 */

@Entity
public class DestinationCulture implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String nom;
	//else echographie


	public DestinationCulture(String nom)
	{
		super();
		this.nom = nom;

	}

	public DestinationCulture()
	{
	}


	public Long getId()
	{
		return id;
	}


	public void setId(Long id)
	{
		this.id = id;
	}


	public String getNom()
	{
		return nom;
	}


	public void setNom(String nom)
	{
		this.nom = nom;
	}
}
