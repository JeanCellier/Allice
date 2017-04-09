package phenotypage.model.cuve.canister;

import phenotypage.model.cryoconservation.tableauDetail.TableauDetail;
import phenotypage.model.cuve.Cuve;
import phenotypage.model.cuve.visoTube.VisoTube;

import javax.persistence.*;
import java.util.List;

/**
 * @author fabien
 */

@Entity
public class Canister
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private int numero;

	@OneToMany(mappedBy = "canister")
	private List<TableauDetail> tableauDetailList;
	
	@ManyToOne
	@JoinColumn(name = "id_Cuve", referencedColumnName = "id")
	private Cuve cuve;
	
	@OneToMany(mappedBy = "canister")
	private List<VisoTube> tableauVisoTubeList;

	public Canister()
	{
	}

	public Canister(int numero)
	{
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
}
