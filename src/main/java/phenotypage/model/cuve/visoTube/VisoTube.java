package phenotypage.model.cuve.visoTube;

import phenotypage.model.cryoconservation.tableauDetail.TableauDetail;
import phenotypage.model.cuve.canister.Canister;

import javax.persistence.*;
import java.util.List;

/**
 * @author fabien
 */

@Entity
public class VisoTube
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private int numero;

	@Column
	private String couleur;

	@OneToMany(mappedBy = "visoTube")
	private List<TableauDetail> tableauDetailList;
	
	@ManyToOne
	@JoinColumn(name = "id_VisoTube", referencedColumnName = "id")
	private Canister canister;

	public VisoTube()
	{
	}

	public VisoTube(int numero, String couleur)
	{
		this.numero = numero;
		this.couleur = couleur;
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

	public String getCouleur()
	{
		return couleur;
	}

	public void setCouleur(String couleur)
	{
		this.couleur = couleur;
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
