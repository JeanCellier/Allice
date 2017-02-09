package phenotypage.model.fiche.ficheCarriere;

import org.hibernate.validator.constraints.NotEmpty;
import phenotypage.model.cryoconservation.Cryoconservation;
import phenotypage.model.fiches.traitement.header.Header;
import phenotypage.model.informationsPIV.Informations_PIV;
import phenotypage.model.invitro.collecte.Collecte;
import phenotypage.model.invitro.collecte.Tableau_Collecte;
import phenotypage.model.invitro.culture.Culture;
import phenotypage.model.invitro.fecondation.Fecondation;
import phenotypage.model.vache.Vache;

import java.util.List;

import javax.persistence.*;

/**
 * @author fabien
 */

@Entity
public class FicheCarriere
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String nom;

	@OneToOne
	private Vache vache;
	
	@OneToMany(mappedBy = "fichecarriere")
	private List<Tableau_Carriere> tableauCarriereList;
	

	public FicheCarriere(Long id, String nom, Vache vache, List<Tableau_Carriere> tableauCarriereList)
	{
		super();
		this.id = id;
		this.nom = nom;
		this.vache = vache;
		this.tableauCarriereList = tableauCarriereList;
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

	public FicheCarriere()
	{
	}

	public FicheCarriere(String nom)
	{
		this.nom = nom;
	}

	
}


