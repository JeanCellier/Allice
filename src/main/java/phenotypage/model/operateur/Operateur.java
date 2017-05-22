package phenotypage.model.operateur;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;

/**
 * @author fabien
 */

@Entity
public class Operateur
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	@NotEmpty(message = "**")
	private String nom;

	@Column
	@NotEmpty(message = "**")
	private String prenom;

	public Operateur() {}

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

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}
}
