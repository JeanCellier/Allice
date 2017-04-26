package phenotypage.model.fiche.ficheIa.insemination;

import javax.persistence.*;

import phenotypage.model.fiche.ficheCol.FicheCol;
import phenotypage.model.operateur.Operateur;
import phenotypage.model.vache.Vache;

/**
 * @author fabien
 */

@Entity
public class Insemination
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private boolean semenceSexee;

	@ManyToOne
	private Operateur operateur;

	@ManyToOne
	private Vache taureau;
	
	@OneToOne
	private FicheCol collecte;
	//true si cadre collecte

	@Column
	private String lieuDepot;

	@Column
	private String progression;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Operateur getOperateur()
	{
		return operateur;
	}

	public void setOperateur(Operateur operateur)
	{
		this.operateur = operateur;
	}

	public Vache getTaureau()
	{
		return taureau;
	}

	public void setTaureau(Vache taureau)
	{
		this.taureau = taureau;
	}

	public FicheCol getCollecte() {
		return collecte;
	}

	public void setCollecte(FicheCol ficheCol) {
		this.collecte = ficheCol;
	}

	public boolean isSemenceSexee() {
		return semenceSexee;
	}

	public void setSemenceSexee(boolean semenceSexee) {
		this.semenceSexee = semenceSexee;
	}

	public String getLieuDepot() {
		return lieuDepot;
	}

	public void setLieuDepot(String lieuDepot) {
		this.lieuDepot = lieuDepot;
	}

	public String getProgression()
	{
		return progression;
	}

	public void setProgression(String progression)
	{
		this.progression = progression;
	}

	public Insemination() {}
}