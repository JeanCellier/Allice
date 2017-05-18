package phenotypage.model.traitementDonneuse;

import phenotypage.model.traitementDonneuse.tableau_donneuse.Tableau_Donneuse;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author fabien
 */

@Entity
public class Traitement_Donneuse
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Date date_ref_chaleur;

	@Column
	private String typeChaleur;

	@OneToMany
	private List<Tableau_Donneuse> tableauDonneuse;

	public Traitement_Donneuse() {}

	public Date getDate_ref_chaleur()
	{
		return date_ref_chaleur;
	}

	public void setDate_ref_chaleur(Date date_ref_chaleur)
	{
		this.date_ref_chaleur = date_ref_chaleur;
	}

	public String getTypeChaleur() {
		return typeChaleur;
	}

	public void setTypeChaleur(String typeChaleur) {
		this.typeChaleur = typeChaleur;
	}

	public List<Tableau_Donneuse> getTableauDonneuse() {
		return tableauDonneuse;
	}

	public void setTableauDonneuse(List<Tableau_Donneuse> tableauDonneuse) {
		this.tableauDonneuse = tableauDonneuse;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

}
