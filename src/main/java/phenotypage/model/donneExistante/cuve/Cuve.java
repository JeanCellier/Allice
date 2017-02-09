package phenotypage.model.donneExistante.cuve;

import phenotypage.model.cryoconservation.TableauDetail;
import phenotypage.model.donneExistante.cuve.canister.Canister;
import phenotypage.model.invitro.collecte.Tableau_Collecte;

import javax.persistence.*;
import java.util.List;

/**
 * @author fabien
 */

@Entity
public class Cuve
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String nom;

	@Column
	private String designation;

	@OneToMany(mappedBy = "cuve")
	private List<TableauDetail> tableauDetailList;
	
	@OneToMany(mappedBy = "cuve")
	private List<Canister> tableauCanisterList;

	public Cuve()
	{
	}

	public Cuve(String nom, String designation)
	{
		this.nom = nom;
		this.designation = designation;
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

	public String getDesignation()
	{
		return designation;
	}

	public void setDesignation(String designation)
	{
		this.designation = designation;
	}

	public List<TableauDetail> getTableauDetailList()
	{
		return tableauDetailList;
	}

	public void setTableauDetailList(List<TableauDetail> tableauDetailList)
	{
		this.tableauDetailList = tableauDetailList;
	}
}
