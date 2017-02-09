package phenotypage.model.fiche.ficheOpu;

import org.hibernate.validator.constraints.NotEmpty;
import phenotypage.model.cryoconservation.Cryoconservation;
import phenotypage.model.fiches.traitement.header.Header;
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
public class FicheOpu
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
	private Echo imageEcho;
	
	@OneToOne
	private OvocytesCollectes ovocytesCollectes;

	@OneToOne
	private Informations_PIV informations_piv;

	@OneToOne
	private Collecte collecte;

	@OneToOne
	private Fecondation fecondation;

	@OneToOne
	private Culture culture;

	@OneToOne
	private Cryoconservation cryoconservation;

	public FicheOpu()
	{
	}

	public FicheOpu(String nom)
	{
		this.nom = nom;
	}

	public FicheOpu(String nom, Header header, Vache vache, Traitement_Donneuse traitement_donneuse, Echo imageEcho,
	                OvocytesCollectes ovocytesCollectes, Informations_PIV informations_piv, Collecte collecte,
	                Fecondation fecondation, Culture culture, Cryoconservation cryoconservation)
	{
		super();
		this.nom = nom;
		this.header = header;
		this.vache = vache;
		this.traitement_donneuse = traitement_donneuse;
		this.imageEcho = imageEcho;
		this.ovocytesCollectes = ovocytesCollectes;
		this.informations_piv = informations_piv;
		this.collecte = collecte;
		this.fecondation = fecondation;
		this.culture = culture;
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

	public Informations_PIV getInformations_piv()
	{
		return informations_piv;
	}

	public void setInformations_piv(Informations_PIV informations_piv)
	{
		this.informations_piv = informations_piv;
	}

	public Collecte getCollecte()
	{
		return collecte;
	}

	public void setCollecte(Collecte collecte)
	{
		this.collecte = collecte;
	}

	public Fecondation getFecondation()
	{
		return fecondation;
	}

	public void setFecondation(Fecondation fecondation)
	{
		this.fecondation = fecondation;
	}

	public Culture getCulture()
	{
		return culture;
	}

	public void setCulture(Culture culture)
	{
		this.culture = culture;
	}

	public Cryoconservation getCryoconservation()
	{
		return cryoconservation;
	}

	public void setCryoconservation(Cryoconservation cryoconservation)
	{
		this.cryoconservation = cryoconservation;
	}

	public OvocytesCollectes getOvocytesCollectes()
	{
		return ovocytesCollectes;
	}

	public void setOvocytesCollectes(OvocytesCollectes ovocytesCollectes)
	{
		this.ovocytesCollectes = ovocytesCollectes;
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

	public Echo getImageEcho()
	{
		return imageEcho;
	}

	public void setImageEcho(Echo imageEcho)
	{
		this.imageEcho = imageEcho;
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


