package phenotypage.model.ovocytesCollecte;

import phenotypage.model.fiche.ficheOpu.FicheOpu;
import phenotypage.model.donneExistante.sanitaire.Sanitaire;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class OvocytesCollectes implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String remarques;

	@ManyToOne
	@JoinColumn(name = "idSanitaire", referencedColumnName = "id")
	private Sanitaire sanitaire;

	@OneToMany(mappedBy = "ovocytes_collectes", cascade = CascadeType.REMOVE)
	private List<TableauOvocytesCollectes> tableauOvocytes_collectesList;

	@OneToOne
	@JoinColumn(name = "idFicheOpu", referencedColumnName = "id", unique = true)
	private FicheOpu ficheOpu;

	public OvocytesCollectes()
	{
	}

	public OvocytesCollectes(Long id, String remarques, Sanitaire sanitaire, List<TableauOvocytesCollectes> tableauOvocytes_collectesList)
	{
		this.id = id;
		this.remarques = remarques;
		this.sanitaire = sanitaire;
		this.tableauOvocytes_collectesList = tableauOvocytes_collectesList;
	}

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

	public FicheOpu getFicheOpu()
	{
		return ficheOpu;
	}

	public void setFicheOpu(FicheOpu ficheOpu)
	{
		this.ficheOpu = ficheOpu;
	}
}
