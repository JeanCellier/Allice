package phenotypage.model.donneExistante.qualite;

import phenotypage.model.cryoconservation.TableauDetail;
import phenotypage.model.ovocytesCollecte.TableauOvocytesCollectes;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author fabien
 */

@Entity
public class Qualite implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private int numero;

	@Column
	private String nom;

	@OneToMany(mappedBy = "qualite")
	private List<TableauDetail> tableauDetailList;

	@OneToMany(mappedBy = "qualite")
	private List<TableauOvocytesCollectes> tableauOvocytesCollectesList;

	public Qualite()
	{
	}

	public Qualite(String nom, int numero)
	{
		this.nom = nom;
		this.numero = numero;
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

	public int getNumero()
	{
		return numero;
	}

	public void setNumero(int numero)
	{
		this.numero = numero;
	}

	public List<TableauDetail> getTableauDetailList()
	{
		return tableauDetailList;
	}

	public void setTableauDetailList(List<TableauDetail> tableauDetailList)
	{
		this.tableauDetailList = tableauDetailList;
	}

	public List<TableauOvocytesCollectes> getTableauOvocytesCollectesList()
	{
		return tableauOvocytesCollectesList;
	}

	public void setTableauOvocytesCollectesList(List<TableauOvocytesCollectes> tableauOvocytesCollectesList)
	{
		this.tableauOvocytesCollectesList = tableauOvocytesCollectesList;
	}
}
