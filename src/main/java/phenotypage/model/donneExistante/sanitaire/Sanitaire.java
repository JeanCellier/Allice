package phenotypage.model.donneExistante.sanitaire;

import phenotypage.model.invitro.collecte.resultat.Resultat;
import phenotypage.model.invitro.culture.Culture;
import phenotypage.model.invitro.fecondation.Fecondation;
import phenotypage.model.ovocytesCollecte.OvocytesCollectes;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author fabien
 */

@Entity
public class Sanitaire implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String nom;

	@OneToMany(mappedBy = "sanitaire")
	private List<Resultat> resultatList;

	@ManyToMany
	@JoinTable(name = "Fecondation_Sanitaire",
			joinColumns = {@JoinColumn(name = "idSanitaire",
					referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "idFecondation",
					referencedColumnName = "id")})
	private List<Fecondation> fecondationList;

	@ManyToMany
	@JoinTable(name = "Culture_Sanitaire",
			joinColumns = {@JoinColumn(name = "idSanitaire",
					referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "idCulture",
					referencedColumnName = "id")})
	private List<Culture> cultureList;

	@OneToMany(mappedBy = "sanitaire")
	private List<OvocytesCollectes> ovocytesCollectesList;

	public Sanitaire()
	{
	}

	public Sanitaire(String nom)
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

	public List<OvocytesCollectes> getOvocytesCollectesList()
	{
		return ovocytesCollectesList;
	}

	public void setOvocytesCollectesList(List<OvocytesCollectes> ovocytesCollectesList)
	{
		this.ovocytesCollectesList = ovocytesCollectesList;
	}

	public List<Resultat> getResultatList()
	{

		return resultatList;
	}

	public void setResultatList(List<Resultat> resultatList)
	{
		this.resultatList = resultatList;
	}

	public List<Fecondation> getFecondationList()
	{
		return fecondationList;
	}

	public void setFecondationList(List<Fecondation> fecondationList)
	{
		this.fecondationList = fecondationList;
	}

	public List<Culture> getCultureList()
	{
		return cultureList;
	}

	public void setCultureList(List<Culture> cultureList)
	{
		this.cultureList = cultureList;
	}
}
