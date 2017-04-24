package phenotypage.model.donneesExistantes.programme;

import javax.persistence.*;


/**
 * @author fabien
 */

@Entity
public class Programme
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String nom;

	public Programme() {}

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
