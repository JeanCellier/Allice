package phenotypage.model.fiche.ficheIa;

import org.hibernate.validator.constraints.NotEmpty;
import phenotypage.model.fiche.ficheCol.FicheCol;
import phenotypage.model.fiches.traitement.header.Header;
import phenotypage.model.gestation.Gestation;
import phenotypage.model.insemination.Insemination;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;
import phenotypage.model.vache.Vache;

import javax.persistence.*;

/**
 * @author fabien
 */

@Entity
public class FicheIa
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
	private Insemination insemination;
	
	@OneToOne
	private Traitement_Donneuse traitement_donneuse;
	
	@OneToOne
	private Gestation gestation;

	@Column
	private String remarque;

	public FicheIa()
	{
	}

	public FicheIa(String nom, Header header, Vache vache, Insemination insemination,
	               Traitement_Donneuse traitement_donneuse, Gestation gestation)
	{
		super();
		this.nom = nom;
		this.header = header;
		this.vache = vache;
		this.insemination = insemination;
		this.traitement_donneuse = traitement_donneuse;
		this.gestation = gestation;
	}

	public FicheIa(String nom)
	{
		this.nom = nom;
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

	public Insemination getInsemination()
	{
		return insemination;
	}

	public void setInsemination(Insemination insemination)
	{
		this.insemination = insemination;
	}

	public Traitement_Donneuse getTraitement_donneuse()
	{
		return traitement_donneuse;
	}

	public void setTraitement_donneuse(Traitement_Donneuse traitement_donneuse)
	{
		this.traitement_donneuse = traitement_donneuse;
	}

	public Gestation getGestation()
	{
		return gestation;
	}

	public void setGestation(Gestation gestation)
	{
		this.gestation = gestation;
	}

	public String getRemarque()
	{
		return remarque;
	}

	public void setRemarque(String remarque)
	{
		this.remarque = remarque;
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


