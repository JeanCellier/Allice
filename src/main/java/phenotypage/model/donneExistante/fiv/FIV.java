package phenotypage.model.donneExistante.fiv;

import phenotypage.model.informationsPIV.Informations_PIV;

import javax.persistence.*;
import java.util.List;

/**
 * @author fabien
 */

@Entity
public class FIV
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String nom;

	@Column
	private String numeroLot;

	@OneToMany(mappedBy = "fiv")
	private List<Informations_PIV> informations_pivList;

	public FIV()
	{
	}

	public FIV(String nom, String numeroLot)
	{
		this.nom = nom;
		this.numeroLot = numeroLot;
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

	public String getNumeroLot()
	{
		return numeroLot;
	}

	public void setNumeroLot(String numeroLot)
	{
		this.numeroLot = numeroLot;
	}

	public List<Informations_PIV> getInformations_pivList()
	{
		return informations_pivList;
	}

	public void setInformations_pivList(List<Informations_PIV> informations_pivList)
	{
		this.informations_pivList = informations_pivList;
	}
}
