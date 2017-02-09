package phenotypage.model.methodeCongelation;

import phenotypage.model.cryoconservation.Cryoconservation;
import phenotypage.model.fiches.traitement.header.Header;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author fabien
 */

@Entity
public class MethodeCongelation implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String nom;

	@OneToMany(mappedBy = "methodeCongelation")
	private List<Cryoconservation> cryoconservationList;

	public MethodeCongelation()
	{
	}

	public MethodeCongelation(String nom)
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

	public List<Cryoconservation> getHeaderList()
	{
		return cryoconservationList;
	}

	public void setHeaderList(List<Cryoconservation> cryoconservationList)
	{
		this.cryoconservationList = cryoconservationList;
	}
}
