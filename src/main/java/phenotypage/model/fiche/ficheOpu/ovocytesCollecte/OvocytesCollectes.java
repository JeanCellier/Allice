package phenotypage.model.fiche.ficheOpu.ovocytesCollecte;

import phenotypage.model.sanitaire.Sanitaire;
import phenotypage.model.fiche.ficheOpu.ovocytesCollecte.tableauOvocytesCollectes.TableauOvocytesCollectes;

import java.util.List;
import javax.persistence.*;

@Entity
public class OvocytesCollectes
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String remarques;

	@ManyToOne
	private Sanitaire sanitaire;

	@OneToMany
	private List<TableauOvocytesCollectes> tableauOvocytes_collectesList;

	public OvocytesCollectes() {}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getRemarques()
	{
		return remarques;
	}

	public void setRemarques(String remarques)
	{
		this.remarques = remarques;
	}

	public Sanitaire getSanitaire()
	{
		return sanitaire;
	}

	public void setSanitaire(Sanitaire sanitaire)
	{
		this.sanitaire = sanitaire;
	}

	public List<TableauOvocytesCollectes> getTableauOvocytes_collectesList()
	{
		return tableauOvocytes_collectesList;
	}

	public void setTableauOvocytes_collectesList(List<TableauOvocytesCollectes> tableauOvocytes_collectesList)
	{
		this.tableauOvocytes_collectesList = tableauOvocytes_collectesList;
	}
}