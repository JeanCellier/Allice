package phenotypage.model.fiche.ficheTra;

import org.hibernate.validator.constraints.NotEmpty;

import phenotypage.model.corpsJaune.CorpsJaune;
import phenotypage.model.cryoconservation.Cryoconservation;
import phenotypage.model.embryonsTransferes.EmbryonsTransferes;
import phenotypage.model.fiches.traitement.header.Header;
import phenotypage.model.gestation.Gestation;
import phenotypage.model.imageEcho.Echo;
import phenotypage.model.informationsPIV.Informations_PIV;
import phenotypage.model.invitro.collecte.Collecte;
import phenotypage.model.invitro.culture.Culture;
import phenotypage.model.invitro.fecondation.Fecondation;
import phenotypage.model.ovocytesCollecte.OvocytesCollectes;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;
import phenotypage.model.vache.Vache;

import javax.persistence.*;

/**
 * @author fabien
 */

@Entity
public class FicheTra
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
	private CorpsJaune corpsJaune;
	
	@OneToOne
	private EmbryonsTransferes embryonsTransferes;

	@OneToOne
	private Gestation gestation;

	public FicheTra()
	{
	}

	public FicheTra(String nom)
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

	public Traitement_Donneuse getTraitement_donneuse()
	{
		return traitement_donneuse;
	}

	public void setTraitement_donneuse(Traitement_Donneuse traitement_donneuse)
	{
		this.traitement_donneuse = traitement_donneuse;
	}

	public CorpsJaune getCorpsJaune()
	{
		return corpsJaune;
	}

	public void setCorpsJaune(CorpsJaune corpsJaune)
	{
		this.corpsJaune = corpsJaune;
	}

	public EmbryonsTransferes getEmbryonsTransferes()
	{
		return embryonsTransferes;
	}

	public void setEmbryonsTransferes(EmbryonsTransferes embryonsTransferes)
	{
		this.embryonsTransferes = embryonsTransferes;
	}

	public Gestation getGestation()
	{
		return gestation;
	}

	public void setGestation(Gestation gestation)
	{
		this.gestation = gestation;
	}

	public boolean isSnig()
	{
		return snig;
	}

	public void setSnig(boolean snig)
	{
		this.snig = snig;
	}

	public FicheTra(String nom, Header header, Vache vache, Traitement_Donneuse traitement_donneuse,
	                CorpsJaune corpsJaune, EmbryonsTransferes embryonsTransferes, Gestation gestation)
	{
		super();
		this.nom = nom;
		this.header = header;
		this.vache = vache;
		this.traitement_donneuse = traitement_donneuse;
		this.corpsJaune = corpsJaune;
		this.embryonsTransferes = embryonsTransferes;
		this.gestation = gestation;
	}


}


