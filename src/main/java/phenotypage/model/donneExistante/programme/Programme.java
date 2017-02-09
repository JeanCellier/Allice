package phenotypage.model.donneExistante.programme;

import phenotypage.model.fiches.traitement.header.Header;

import javax.persistence.*;
import java.util.List;

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

	@OneToMany(mappedBy = "programme")
	private List<Header> headerList;

	public Programme()
	{
	}

	public Programme(String nom)
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

	public List<Header> getHeaderList()
	{
		return headerList;
	}

	public void setHeaderList(List<Header> headerList)
	{
		this.headerList = headerList;
	}
}
