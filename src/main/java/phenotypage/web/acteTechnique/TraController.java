package phenotypage.web.acteTechnique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import phenotypage.model.corpsJaune.CorpsJaune;
import phenotypage.model.corpsJaune.CorpsJauneService;
import phenotypage.model.donneExistante.abattoir.AbattoirService;
import phenotypage.model.donneExistante.operateur.OperateurService;
import phenotypage.model.donneExistante.programme.ProgrammeService;
import phenotypage.model.donneExistante.qualite.QualiteService;
import phenotypage.model.embryonsTransferes.EmbryonsTransferes;
import phenotypage.model.embryonsTransferes.EmbryonsTransferesService;
import phenotypage.model.fiche.ficheTra.FicheTra;
import phenotypage.model.fiche.ficheTra.FicheTraService;
import phenotypage.model.fiches.traitement.header.Header;
import phenotypage.model.fiches.traitement.header.HeaderService;
import phenotypage.model.gestation.Gestation;
import phenotypage.model.gestation.GestationService;
import phenotypage.model.gestation.Tableau_Gestation;
import phenotypage.model.gestation.Tableau_GestationService;
import phenotypage.model.pharmacie.produit.ProduitService;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;
import phenotypage.model.traitementDonneuse.Traitement_DonneuseService;
import phenotypage.model.traitementDonneuse.tableauPharmacie.Tableau_Pharmacie;
import phenotypage.model.traitementDonneuse.tableauPharmacie.Tableau_PharmacieService;
import phenotypage.model.vache.Vache;
import phenotypage.model.vache.VacheService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author fabien
 */

@Controller
@RequestMapping("/acteTechnique/tra")
public class TraController
{
	@Autowired
	private HeaderService headerService;

	@Autowired
	private FicheTraService ficheTraService;

	@Autowired
	private OperateurService operateurService;

	@Autowired
	private ProgrammeService programmeService;

	@Autowired
	private AbattoirService abattoirService;

	@Autowired
	private CorpsJauneService corpsJauneService;

	@Autowired
	private QualiteService qualiteService;

	@Autowired
	private EmbryonsTransferesService embryonsTransferesService;

	@Autowired
	private GestationService gestationService;

	@Autowired
	private Tableau_GestationService tableau_gestationService;

	@Autowired
	private VacheService vacheService;

	@Autowired
	private Traitement_DonneuseService traitement_donneuseService;

	@Autowired
	private ProduitService produitService;

	@Autowired
	private Tableau_PharmacieService tableau_pharmacieService;


	@RequestMapping(value = "/traNew", method = RequestMethod.GET)
	public String traNew()
	{
		FicheTra ficheTra = ficheTraService.createFichieTra(Calendar.getInstance().get(Calendar.YEAR) + "TRA-" + ficheTraService.countFicheTra());
		return "redirect:/acteTechnique/tra/enteteTra/" + ficheTra.getNom();
	}

	@RequestMapping(value = "/enteteTra/{nom}", method = RequestMethod.GET)
	public String enteteTra(@PathVariable String nom, Model model)
	{
		FicheTra ficheTra = ficheTraService.findByNom(nom);

		if (ficheTra.getHeader() != null)
		{
			model.addAttribute("header", ficheTra.getHeader());
		}
		else
		{
			model.addAttribute("header", headerService.newHeader());
		}

		model.addAttribute("programmeList", programmeService.findAllProgramme());
		model.addAttribute("abattoirList", abattoirService.findAllAbattoir());
		model.addAttribute("operateurList", operateurService.findAllOperateur());
		model.addAttribute("nom", nom);

		return "acteTechnique/tra/enteteTra";
	}

	@RequestMapping(value = "/enteteTra/{nom}", method = RequestMethod.POST)
	public String enteteTra(@PathVariable String nom, @Valid Header header, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("programmeList", programmeService.findAllProgramme());
			model.addAttribute("abatoirList", abattoirService.findAllAbattoir());
			model.addAttribute("operateurList", operateurService.findAllOperateur());
			model.addAttribute("nom", nom);
			return "/acteTechnique/tra/enteteTra";
		}
		FicheTra ficheTra = ficheTraService.findByNom(nom);
		if (ficheTra.getHeader() != null)
		{
			Header headerDeleted = ficheTra.getHeader();
			ficheTra.setHeader(null);
			headerService.delete(headerDeleted);
		}
		if (header.isSnig())
		{
			ficheTra.setSnig(true);
		}
		header.setFicheTra(ficheTra);
		ficheTra.setHeader(header);
		headerService.addHeader(header);
		return "redirect:/acteTechnique/tra/vacheTra/" + nom;
	}

	@RequestMapping(value = "/vacheTra/{nom}", method = RequestMethod.GET)
	public String vacheTra(@PathVariable String nom, Model model)
	{
		FicheTra ficheTra = ficheTraService.findByNom(nom);

		if (ficheTra.getVache() == null)
		{
			model.addAttribute("vache", vacheService.newVache());
		}
		else
		{
			model.addAttribute("vache", ficheTra.getVache());
		}

		model.addAttribute("nom", nom);

		return "acteTechnique/tra/vacheTra";
	}

	@RequestMapping(value = "/vacheTra/{nom}", method = RequestMethod.POST)
	public String vacheTra(@PathVariable String nom, @Valid Vache vache, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("nom", nom);
			return "/acteTechnique/tra/vacheTra";
		}
		FicheTra ficheTra = ficheTraService.findByNom(nom);
		if (ficheTra.getVache() != null)
		{
			ficheTra.getVache().getFicheTraList().remove(ficheTra);
			ficheTra.setVache(null);
		}
		Vache vacheTrouve = vacheService.findByNum_identification(vache.getNum_identification());
		if (vacheTrouve == null)
		{
			vacheTrouve = vacheService.addVache(vache);
		}
		if (vache.getFicheTraList() == null)
		{
			vache.setFicheTraList(new ArrayList<FicheTra>());
		}
		vache.getFicheTraList().add(ficheTra);
		ficheTra.setVache(vacheTrouve);
		return "redirect:/acteTechnique/tra/traitementReceveuseTra/" + nom;
	}

	@RequestMapping(value = "/traitementReceveuseTra/{nom}", method = RequestMethod.GET)
	public String traitementDonneuse(@PathVariable String nom, Model model)
	{
		FicheTra ficheTra = ficheTraService.findByNom(nom);

		if (ficheTra.getTraitement_donneuse() == null)
		{
			Traitement_Donneuse traitementDonneuse = traitement_donneuseService.newTraitementDonneuse();
			traitementDonneuse.setTableau_pharmacie(new ArrayList<Tableau_Pharmacie>());
			traitementDonneuse.getTableau_pharmacie().add(new Tableau_Pharmacie());
			model.addAttribute("traitementDonneuse", traitementDonneuse);
		}
		else
		{

			if (ficheTra.getTraitement_donneuse().getTableau_pharmacie().size() <= 0)
			{
				ficheTra.getTraitement_donneuse().setTableau_pharmacie(new ArrayList<Tableau_Pharmacie>());
				ficheTra.getTraitement_donneuse().getTableau_pharmacie().add(new Tableau_Pharmacie());
			}
			model.addAttribute("traitementDonneuse", ficheTra.getTraitement_donneuse());
		}

		model.addAttribute("operateurList", operateurService.findAllOperateur());
		model.addAttribute("produitList", produitService.findAllProduit());
		model.addAttribute("nom", nom);

		return "acteTechnique/tra/traitementReceveuseTra";
	}

	@RequestMapping(value = "/traitementReceveuseTra/{nom}", method = RequestMethod.POST)
	public String traitementDonneuse(@PathVariable String nom, @Valid Traitement_Donneuse traitementDonneuse, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("operateurList", operateurService.findAllOperateur());
			model.addAttribute("produitList", produitService.findAllProduit());
			model.addAttribute("nom", nom);
			return "/acteTechnique/tra/traitementReceveuseTra";
		}
		FicheTra ficheTra = ficheTraService.findByNom(nom);
		if (ficheTra.getTraitement_donneuse() != null)
		{
			Traitement_Donneuse traitement_donneuseToDelete = ficheTra.getTraitement_donneuse();
			ficheTra.setTraitement_donneuse(null);
			traitement_donneuseService.delete(traitement_donneuseToDelete);
		}
		traitementDonneuse.setFicheTra(ficheTra);
		ficheTra.setTraitement_donneuse(traitementDonneuse);
		traitement_donneuseService.addTraitement_Donneuse(traitementDonneuse);

		for (int index = 0; index < traitementDonneuse.getTableau_pharmacie().size(); index++)
		{
			traitementDonneuse.getTableau_pharmacie().get(index).getProduit().setQteRestante(traitementDonneuse.getTableau_pharmacie().get(index).getProduit().getQteRestante() - traitementDonneuse.getTableau_pharmacie().get(index).getQuantite());
			produitService.updateProduit(traitementDonneuse.getTableau_pharmacie().get(index).getProduit());
			tableau_pharmacieService.addTableau_Pharmacie(traitementDonneuse.getTableau_pharmacie().get(index));
		}
		return "redirect:/acteTechnique/tra/corpsJauneTra/" + nom;
	}

	@RequestMapping(value = "/corpsJauneTra/{nom}", method = RequestMethod.GET)
	public String corpsJauneTra(@PathVariable String nom, Model model)
	{
		FicheTra ficheTra = ficheTraService.findByNom(nom);

		if (ficheTra.getCorpsJaune() != null)
		{
			model.addAttribute("corpsJaune", ficheTra.getCorpsJaune());
		}
		else
		{
			model.addAttribute("corpsJaune", corpsJauneService.newCorpsJaune());
		}

		model.addAttribute("qualiteList", qualiteService.findAllQualite());
		model.addAttribute("nom", nom);

		return "acteTechnique/tra/corpsJauneTra";
	}

	@RequestMapping(value = "/corpsJauneTra/{nom}", method = RequestMethod.POST)
	public String corpsJauneTra(@PathVariable String nom, @Valid CorpsJaune corpsJaune, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("qualiteList", qualiteService.findAllQualite());
			model.addAttribute("nom", nom);
			return "/acteTechnique/tra/corpsJauneTra";
		}
		FicheTra ficheTra = ficheTraService.findByNom(nom);
		if (ficheTra.getCorpsJaune() != null)
		{
			CorpsJaune corpsJauneToDelete = ficheTra.getCorpsJaune();
			ficheTra.setCorpsJaune(null);
			corpsJauneService.delete(corpsJauneToDelete);
		}
		corpsJaune.setFicheTra(ficheTra);
		ficheTra.setCorpsJaune(corpsJaune);
		corpsJauneService.addCorpsJaune(corpsJaune);
		return "redirect:/acteTechnique/tra/embryonsTransferesTra/" + nom;
	}

	@RequestMapping(value = "/embryonsTransferesTra/{nom}", method = RequestMethod.GET)
	public String embryonsTransferesTra(@PathVariable String nom, Model model)
	{
		FicheTra ficheTra = ficheTraService.findByNom(nom);

		if (ficheTra.getEmbryonsTransferes() != null)
		{
			model.addAttribute("embryonsTransferes", ficheTra.getEmbryonsTransferes());
		}
		else
		{
			model.addAttribute("embryonsTransferes", embryonsTransferesService.newEmbryonsTransferes());
		}

		model.addAttribute("vacheList",vacheService.findAllVache());
		model.addAttribute("qualiteList", qualiteService.findAllQualite());
		model.addAttribute("nom", nom);

		return "acteTechnique/tra/embryonsTransferesTra";
	}

	@RequestMapping(value = "/embryonsTransferesTra/{nom}", method = RequestMethod.POST)
	public String embryonsTransferesTra(@PathVariable String nom, @Valid EmbryonsTransferes embryonsTransferes, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("vacheList",vacheService.findAllVache());
			model.addAttribute("qualiteList", qualiteService.findAllQualite());
			model.addAttribute("nom", nom);
			return "/acteTechnique/tra/embryonsTransferesTra";
		}
		FicheTra ficheTra = ficheTraService.findByNom(nom);
		if (ficheTra.getEmbryonsTransferes() != null)
		{
			EmbryonsTransferes embryonsTransferesToDelete = ficheTra.getEmbryonsTransferes();
			ficheTra.setEmbryonsTransferes(null);
			embryonsTransferesService.delete(embryonsTransferesToDelete);
		}
		embryonsTransferes.setFicheTra(ficheTra);
		ficheTra.setEmbryonsTransferes(embryonsTransferes);
		Vache taureauTrouve = vacheService.findByNum_identification(embryonsTransferes.getTaureau().getNum_identification());
		if (taureauTrouve == null)
		{
			taureauTrouve = vacheService.addTaureau(embryonsTransferes.getTaureau());
		}
		embryonsTransferes.setTaureau(taureauTrouve);
		embryonsTransferesService.addEmbryonsTransferes(embryonsTransferes);
		return "redirect:/acteTechnique/tra/gestationTra/" + nom;
	}

	@RequestMapping(value = "/gestationTra/{nom}", method = RequestMethod.GET)
	public String gestationTra(@PathVariable String nom, Model model)
	{
		FicheTra ficheTra = ficheTraService.findByNom(nom);

		if (ficheTra.getGestation() == null)
		{
			Gestation gestation = gestationService.newGestation();
			gestation.setTableauGestationList(new ArrayList<Tableau_Gestation>());
			gestation.getTableauGestationList().add(new Tableau_Gestation());
			model.addAttribute("gestation", gestation);
		}
		else
		{
			if (ficheTra.getGestation().getTableauGestationList().size() <= 0)
			{
				ficheTra.getGestation().setTableauGestationList(new ArrayList<Tableau_Gestation>());
				ficheTra.getGestation().getTableauGestationList().add(new Tableau_Gestation());
			}
			model.addAttribute("gestation", ficheTra.getGestation());
		}

		model.addAttribute("nom", nom);

		return "acteTechnique/tra/gestationTra";
	}

	@RequestMapping(value = "/gestationTra/{nom}", method = RequestMethod.POST)
	public String gestation(@PathVariable String nom, @Valid Gestation gestation, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("nom", nom);
			return "/acteTechnique/tra/gestationTra";
		}
		FicheTra ficheTra = ficheTraService.findByNom(nom);
		if (ficheTra.getGestation() != null)
		{
			Gestation gestationToDelete = ficheTra.getGestation();
			ficheTra.setGestation(null);
			gestationService.delete(gestationToDelete);
		}
		gestation.setFicheTra(ficheTra);
		ficheTra.setGestation(gestation);
		gestationService.addGestation(gestation);

		for (int i = 0; i < gestation.getTableauGestationList().size(); i++)
		{
			gestation.getTableauGestationList().get(i).setGestation(gestation);
			tableau_gestationService.addTableauGestation(gestation.getTableauGestationList().get(i));
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/consultation", method = RequestMethod.GET)
	public String consultation(Model model)
	{
		model.addAttribute("ficheTra", ficheTraService.newFicheTra());
		model.addAttribute("ficheTraList", ficheTraService.findAllFicheTra());
		return "acteTechnique/tra/consultation/consultation";
	}

	@RequestMapping(value = "/consultation", method = RequestMethod.POST)
	public String consultation(@ModelAttribute FicheTra ficheTra, Model model)
	{
		ficheTra = ficheTraService.findByNom(ficheTra.getNom());

		if (ficheTra.getHeader() == null)
		{
			model.addAttribute("header", headerService.newHeader());
		}
		else
		{
			model.addAttribute("header", ficheTra.getHeader());
		}

		if (ficheTra.getVache() == null)
		{
			model.addAttribute("vache", vacheService.newVache());
		}
		else
		{
			model.addAttribute("vache", ficheTra.getVache());
		}

		if (ficheTra.getTraitement_donneuse() == null)
		{
			model.addAttribute("traitementDonneuse", traitement_donneuseService.newTraitementDonneuse());
		}
		else
		{
			model.addAttribute("traitementDonneuse", ficheTra.getTraitement_donneuse());
		}

		if (ficheTra.getCorpsJaune() != null)
		{
			model.addAttribute("corpsJaune", ficheTra.getCorpsJaune());
		}
		else
		{
			model.addAttribute("corpsJaune", corpsJauneService.newCorpsJaune());
		}

		if (ficheTra.getEmbryonsTransferes() != null)
		{
			model.addAttribute("embryonsTransferes", ficheTra.getEmbryonsTransferes());
		}
		else
		{
			model.addAttribute("embryonsTransferes", embryonsTransferesService.newEmbryonsTransferes());
		}

		if (ficheTra.getGestation() == null)
		{
			model.addAttribute("gestation", gestationService.newGestation());
		}
		else
		{
			model.addAttribute("gestation", ficheTra.getGestation());
		}

		return "acteTechnique/tra/consultation/consultationTra";
	}

	@RequestMapping(value = "/consultation/{nom}", method = RequestMethod.GET)
	public String consultation(@PathVariable String nom, Model model)
	{
		FicheTra ficheTra = ficheTraService.findByNom(nom);

		if (ficheTra.getHeader() == null)
		{
			model.addAttribute("header", headerService.newHeader());
		}
		else
		{
			model.addAttribute("header", ficheTra.getHeader());
		}

		if (ficheTra.getVache() == null)
		{
			model.addAttribute("vache", vacheService.newVache());
		}
		else
		{
			model.addAttribute("vache", ficheTra.getVache());
		}

		if (ficheTra.getTraitement_donneuse() == null)
		{
			model.addAttribute("traitementDonneuse", traitement_donneuseService.newTraitementDonneuse());
		}
		else
		{
			model.addAttribute("traitementDonneuse", ficheTra.getTraitement_donneuse());
		}

		if (ficheTra.getCorpsJaune() != null)
		{
			model.addAttribute("corpsJaune", ficheTra.getCorpsJaune());
		}
		else
		{
			model.addAttribute("corpsJaune", corpsJauneService.newCorpsJaune());
		}

		if (ficheTra.getEmbryonsTransferes() != null)
		{
			model.addAttribute("embryonsTransferes", ficheTra.getEmbryonsTransferes());
		}
		else
		{
			model.addAttribute("embryonsTransferes", embryonsTransferesService.newEmbryonsTransferes());
		}

		if (ficheTra.getGestation() == null)
		{
			model.addAttribute("gestation", gestationService.newGestation());
		}
		else
		{
			model.addAttribute("gestation", ficheTra.getGestation());
		}

		return "acteTechnique/tra/consultation/consultationTra";
	}

	@RequestMapping(value = "/modification", method = RequestMethod.GET)
	public String modification(Model model)
	{
		model.addAttribute("ficheTra", ficheTraService.newFicheTra());
		model.addAttribute("ficheTraList", ficheTraService.findAllFicheTra());
		return "acteTechnique/tra/modification";
	}

	@RequestMapping(value = "/modification", method = RequestMethod.POST)
	public String modification(@ModelAttribute FicheTra ficheTra)
	{
		return "redirect:/acteTechnique/tra/enteteTra/" + ficheTra.getNom();
	}
}
