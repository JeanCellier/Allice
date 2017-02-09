package phenotypage.model.fiche.ficheCol;

import org.hibernate.validator.constraints.NotEmpty;
import phenotypage.model.cryoconservation.Cryoconservation;
import phenotypage.model.fiches.traitement.header.Header;
import phenotypage.model.insemination.Insemination;
import phenotypage.model.invitro.collecte.resultat.Resultat;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;
import phenotypage.model.vache.Vache;

import javax.persistence.*;
import java.util.List;

/**
 * @author fabien
 */

@Entity
public class FicheCol
{
	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	@NotEmpty
	private String nom;

	@Column
	private boolean snig;

	@OneToOne
	private Header header;

	@ManyToOne
	@JoinColumn(name = "id_Vache", referencedColumnName = "id")
	private Vache vache;

	@OneToOne
	private Traitement_Donneuse traitement_donneuse;

	@OneToOne
	private Resultat resultat_collecte;

	@OneToOne
	private Cryoconservation cryoconservation;

	@OneToMany(mappedBy = "ficheCol")
	private List<Insemination> inseminationList;

	public FicheCol()
	{
	}

	public FicheCol(String nom)
	{
		this.nom = nom;
	}

	public FicheCol(String nom, Header header, Vache vache, Traitement_Donneuse traitement_donneuse,
	                Resultat resultat_collecte, Cryoconservation cryoconservation)
	{
		super();
		this.nom = nom;
		this.header = header;
		this.vache = vache;
		this.traitement_donneuse = traitement_donneuse;
		this.resultat_collecte = resultat_collecte;
		this.cryoconservation = cryoconservation;
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

	public Header getHeader()
	{
		return header;
	}

	public void setHeader(Header header)
	{
		this.header = header;
	}

	public Vache getVache()
	{
		return vache;
	}

	public void setVache(Vache vache)
	{
		this.vache = vache;
	}

	public Traitement_Donneuse getTraitement_donneuse()
	{
		return traitement_donneuse;
	}

	public void setTraitement_donneuse(Traitement_Donneuse traitement_donneuse)
	{
		this.traitement_donneuse = traitement_donneuse;
	}

	public Resultat getResultat_collecte()
	{
		return resultat_collecte;
	}

	public void setResultat_collecte(Resultat resultat_collecte)
	{
		this.resultat_collecte = resultat_collecte;
	}

	public Cryoconservation getCryoconservation()
	{
		return cryoconservation;
	}

	public void setCryoconservation(Cryoconservation cryoconservation)
	{
		this.cryoconservation = cryoconservation;
	}

	public List<Insemination> getInseminationList()
	{
		return inseminationList;
	}

	public void setInseminationList(List<Insemination> inseminationList)
	{
		this.inseminationList = inseminationList;
	}

	public boolean isSnig()
	{
		return snig;
	}

	public void setSnig(boolean snig)
	{
		this.snig = snig;
	}
}


