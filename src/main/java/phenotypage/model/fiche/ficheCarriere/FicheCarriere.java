package phenotypage.model.fiche.ficheCarriere;

import phenotypage.model.vache.Vache;

import java.util.List;
import javax.persistence.*;

/**
 * @author fabien
 */

@Entity
public class FicheCarriere{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String nom;

	@OneToOne
	private Vache vache;
	
	@OneToMany(mappedBy = "fichecarriere")
	private List<Tableau_Carriere> tableauCarriereList;

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public Vache getVache()
	{
		return vache;
	}

	public void setVache(Vache vache)
	{
		this.vache = vache;
	}

	public List<Tableau_Carriere> getTableauCarriereList()
	{
		return tableauCarriereList;
	}

	public void setTableauCarriereList(List<Tableau_Carriere> tableauCarriereList)
	{
		this.tableauCarriereList = tableauCarriereList;
	}

	public FicheCarriere() { super(); 	}
}


