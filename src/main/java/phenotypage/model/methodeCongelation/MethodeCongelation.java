package phenotypage.model.methodeCongelation;

import javax.persistence.*;

/**
 * @author fabien
 */

@Entity
public class MethodeCongelation
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String nom;

	public MethodeCongelation() {}

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
