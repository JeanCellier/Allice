package phenotypage.model.donneesExistantes.sanitaire;

import javax.persistence.*;

/**
 * @author fabien
 */

@Entity
public class Sanitaire
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String nom;

	public Sanitaire() {}

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
