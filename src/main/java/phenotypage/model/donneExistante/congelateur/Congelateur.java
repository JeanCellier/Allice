package phenotypage.model.donneExistante.congelateur;

import phenotypage.model.cryoconservation.Cryoconservation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author fabien
 */

@Entity
public class Congelateur implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String nom;

	@OneToMany(mappedBy = "congelateur")
	private List<Cryoconservation> cryoconservationList;

	public Congelateur()
	{
	}

	public Congelateur(String nom)
	{
		this.nom = nom;
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

	public List<Cryoconservation> getCryoconservationList()
	{
		return cryoconservationList;
	}

	public void setCryoconservationList(List<Cryoconservation> cryoconservationList)
	{
		this.cryoconservationList = cryoconservationList;
	}
}
