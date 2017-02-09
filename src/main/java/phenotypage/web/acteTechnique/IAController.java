package phenotypage.web.acteTechnique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import phenotypage.model.donneExistante.abattoir.AbattoirService;
import phenotypage.model.donneExistante.operateur.OperateurService;
import phenotypage.model.donneExistante.programme.ProgrammeService;
import phenotypage.model.fiche.ficheCol.FicheColService;
import phenotypage.model.fiche.ficheIa.FicheIa;
import phenotypage.model.fiche.ficheIa.FicheIaService;
import phenotypage.model.fiche.ficheOpu.FicheOpu;
import phenotypage.model.fiches.traitement.header.Header;
import phenotypage.model.fiches.traitement.header.HeaderService;
import phenotypage.model.gestation.Gestation;
import phenotypage.model.gestation.GestationService;
import phenotypage.model.gestation.Tableau_Gestation;
import phenotypage.model.gestation.Tableau_GestationService;
import phenotypage.model.insemination.Insemination;
import phenotypage.model.insemination.InseminationService;
import phenotypage.model.pharmacie.produit.ProduitService;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;
import phenotypage.model.traitementDonneuse.Traitement_DonneuseService;
import phenotypage.model.traitementDonneuse.tableauPharmacie.Tableau_Pharmacie;
import phenotypage.model.traitementDonneuse.tableauPharmacie.Tableau_PharmacieService;
import phenotypage.model.vache.Vache;
import phenotypage.model.vache.VacheService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author fabien
 */

@Controller
@RequestMapping("/acteTechnique/ia")
public class IAController
{
	@Autowired
	private FicheIaService ficheIaService;

	@Autowired
	private HeaderService headerService;

	@Autowired
	private ProgrammeService programmeService;

	@Autowired
	private OperateurService operateurService;

	@Autowired
	private AbattoirService abattoirService;

	@Autowired
	private VacheService vacheService;

	@Autowired
	private InseminationService inseminationService;

	@Autowired
	private Traitement_DonneuseService traitement_donneuseService;

	@Autowired
	private GestationService gestationService;

	@Autowired
	private ProduitService produitService;

	@Autowired
	private Tableau_PharmacieService tableau_pharmacieService;

	@Autowired
	private Tableau_GestationService tableau_gestationService;

	@Autowired
	private FicheColService ficheColService;


	@RequestMapping(value = "/iaNew", method = RequestMethod.GET)
	public String iaNew()
	{
		FicheIa ficheIa = ficheIaService.createFichieIa(Calendar.getInstance().get(Calendar.YEAR) + "IA-" + ficheIaService.countFicheIa());
		return "redirect:/acteTechnique/ia/enteteIa/" + ficheIa.getNom();
	}

	@RequestMapping(value = "/enteteIa/{nom}", method = RequestMethod.GET)
	public String enteteIa(@PathVariable String nom, Model model)
	{
		FicheIa ficheIa = ficheIaService.findByNom(nom);

		if (ficheIa.getHeader() == null)
		{
			model.addAttribute("header", headerService.newHeader());
		}
		else
		{
			model.addAttribute("header", ficheIa.getHeader());
		}

		model.addAttribute("programmeList", programmeService.findAllProgramme());
		model.addAttribute("abatoirList", abattoirService.findAllAbattoir());
		model.addAttribute("operateurList", operateurService.findAllOperateur());
		model.addAttribute("nom", nom);

		return "acteTechnique/ia/enteteIa";
	}

	@RequestMapping(value = "/enteteIa/{nom}", method = RequestMethod.POST)
	public String enteteIa(@PathVariable String nom, @Valid Header header, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("programmeList", programmeService.findAllProgramme());
			model.addAttribute("abatoirList", abattoirService.findAllAbattoir());
			model.addAttribute("operateurList", operateurService.findAllOperateur());
			model.addAttribute("nom", nom);
			return "/acteTechnique/ia/enteteIa";
		}
		FicheIa ficheIa = ficheIaService.findByNom(nom);
		if (ficheIa.getHeader() != null)
		{
			Header headerDeleted = ficheIa.getHeader();
			ficheIa.setHeader(null);
			headerService.delete(headerDeleted);
		}
		if (header.isSnig())
		{
			ficheIa.setSnig(true);
		}
		header.setFicheIa(ficheIa);
		ficheIa.setHeader(header);
		headerService.addHeader(header);
		return "redirect:/acteTechnique/ia/vacheIa/" + nom;
	}

	@RequestMapping(value = "/vacheIa/{nom}", method = RequestMethod.GET)
	public String vacheIa(@PathVariable String nom, Model model)
	{
		FicheIa ficheIa = ficheIaService.findByNom(nom);

		if (ficheIa.getVache() == null)
		{
			model.addAttribute("vache", vacheService.newVache());
		}
		else
		{
			model.addAttribute("vache", ficheIa.getVache());
		}

		model.addAttribute("nom", nom);

		return "acteTechnique/ia/vacheIa";
	}

	@RequestMapping(value = "/vacheIa/{nom}", method = RequestMethod.POST)
	public String vacheIa(@PathVariable String nom, @Valid Vache vache, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("nom", nom);
			return "/acteTechnique/ia/vacheIa";
		}
		FicheIa ficheIa = ficheIaService.findByNom(nom);
		if (ficheIa.getVache() != null)
		{
			ficheIa.getVache().getFicheOpuList().remove(ficheIa);
			ficheIa.setVache(null);
		}
		Vache vacheTrouve = vacheService.findByNum_identification(vache.getNum_identification());
		if (vacheTrouve == null)
		{
			vacheTrouve = vacheService.addVache(vache);
		}
		if (vache.getFicheIaList() == null)
		{
			vache.setFicheIaList(new ArrayList<FicheIa>());
		}
		vache.getFicheIaList().add(ficheIa);
		ficheIa.setVache(vacheTrouve);
		return "redirect:/acteTechnique/ia/inseminationIa/" + nom;
	}

	@RequestMapping(value = "/inseminationIa/{nom}", method = RequestMethod.GET)
	public String insemination(@PathVariable String nom, Model model)
	{
		FicheIa ficheIa = ficheIaService.findByNom(nom);

		if (ficheIa.getInsemination() == null)
		{
			model.addAttribute("insemination", inseminationService.newInsemination());
		}
		else
		{
			model.addAttribute("insemination", ficheIa.getInsemination());
		}

		model.addAttribute("operateurList", operateurService.findAllOperateur());
		model.addAttribute("ficheColList", ficheColService.findAllFicheCol());
		model.addAttribute("taureauList", vacheService.findAllTaureau());
		model.addAttribute("nom", nom);

		return "acteTechnique/ia/inseminationIa";
	}

	@RequestMapping(value = "/inseminationIa/{nom}", method = RequestMethod.POST)
	public String insemination(@PathVariable String nom, @Valid Insemination insemination, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("operateurList", operateurService.findAllOperateur());
			model.addAttribute("ficheColList", ficheColService.findAllFicheCol());
			model.addAttribute("taureauList", vacheService.findAllTaureau());
			model.addAttribute("nom", nom);
			return "/acteTechnique/ia/insemination";
		}
		FicheIa ficheIa = ficheIaService.findByNom(nom);
		if (ficheIa.getInsemination() != null)
		{
			Insemination inseminationToDelete = ficheIa.getInsemination();
			ficheIa.setInsemination(null);
			inseminationService.delete(inseminationToDelete);
		}
		insemination.setFicheIa(ficheIa);
		ficheIa.setInsemination(insemination);
		Vache taureauTrouve = vacheService.findByNum_identification(insemination.getTaureau().getNum_identification());
		if (taureauTrouve == null)
		{
			taureauTrouve = vacheService.addTaureau(insemination.getTaureau());
		}
		insemination.setTaureau(taureauTrouve);
		inseminationService.addInsemination(insemination);
		if (!insemination.isCollecte())
		{
			return "redirect:/acteTechnique/ia/traitementDonneuseIa/" + nom;
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/traitementDonneuseIa/{nom}", method = RequestMethod.GET)
	public String traitementDonneuseIa(@PathVariable String nom, Model model)
	{
		FicheIa ficheIa = ficheIaService.findByNom(nom);

		if (ficheIa.getTraitement_donneuse() == null)
		{
			Traitement_Donneuse traitementDonneuse = traitement_donneuseService.newTraitementDonneuse();
			traitementDonneuse.setTableau_pharmacie(new ArrayList<Tableau_Pharmacie>());
			traitementDonneuse.getTableau_pharmacie().add(new Tableau_Pharmacie());
			model.addAttribute("traitementDonneuse", traitementDonneuse);
		}
		else
		{
			if (ficheIa.getTraitement_donneuse().getTableau_pharmacie().size() <= 0)
			{
				ficheIa.getTraitement_donneuse().setTableau_pharmacie(new ArrayList<Tableau_Pharmacie>());
				ficheIa.getTraitement_donneuse().getTableau_pharmacie().add(new Tableau_Pharmacie());
			}
			model.addAttribute("traitementDonneuse", ficheIa.getTraitement_donneuse());
		}

		model.addAttribute("operateurList", operateurService.findAllOperateur());
		model.addAttribute("produitList", produitService.findAllProduit());
		model.addAttribute("nom", nom);

		return "acteTechnique/ia/traitementDonneuseIa";
	}

	@RequestMapping(value = "/traitementDonneuseIa/{nom}", method = RequestMethod.POST)
	public String traitementDonneuseIa(@PathVariable String nom, @Valid Traitement_Donneuse traitementDonneuse, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("operateurList", operateurService.findAllOperateur());
			model.addAttribute("produitList", produitService.findAllProduit());
			model.addAttribute("nom", nom);
			model.addAttribute("traitementDonneuse", traitementDonneuse);

			return "/acteTechnique/ia/traitementDonneuseIa";
		}
		FicheIa ficheIa = ficheIaService.findByNom(nom);
		if (ficheIa.getTraitement_donneuse() != null)
		{
			Traitement_Donneuse traitement_donneuseToDelete = ficheIa.getTraitement_donneuse();
			ficheIa.setTraitement_donneuse(null);
			traitement_donneuseService.delete(traitement_donneuseToDelete);
		}

		traitementDonneuse.setFicheIa(ficheIa);
		ficheIa.setTraitement_donneuse(traitementDonneuse);
		traitement_donneuseService.addTraitement_Donneuse(traitementDonneuse);

		for (int index = 0; index < traitementDonneuse.getTableau_pharmacie().size(); index++)
		{
			traitementDonneuse.getTableau_pharmacie().get(index).getProduit().setQte_restante(traitementDonneuse.getTableau_pharmacie().get(index).getProduit().getQte_restante() - traitementDonneuse.getTableau_pharmacie().get(index).getQuantite());
			produitService.updateProduit(traitementDonneuse.getTableau_pharmacie().get(index).getProduit());
			tableau_pharmacieService.addTableau_Pharmacie(traitementDonneuse.getTableau_pharmacie().get(index));
		}
		return "redirect:/acteTechnique/ia/gestationIa/" + nom;
	}

	@RequestMapping(value = "/gestationIa/{nom}", method = RequestMethod.GET)
	public String gestationIa(@PathVariable String nom, Model model)
	{
		FicheIa ficheIa = ficheIaService.findByNom(nom);

		if (ficheIa.getGestation() == null)
		{
			Gestation gestation = gestationService.newGestation();
			gestation.setTableauGestationList(new ArrayList<Tableau_Gestation>());
			gestation.getTableauGestationList().add(new Tableau_Gestation());
			model.addAttribute("gestation", gestation);
		}
		else
		{
			if (ficheIa.getGestation().getTableauGestationList().size() <= 0)
			{
				ficheIa.getGestation().setTableauGestationList(new ArrayList<Tableau_Gestation>());
				ficheIa.getGestation().getTableauGestationList().add(new Tableau_Gestation());
			}
			model.addAttribute("gestation", ficheIa.getGestation());
		}

		model.addAttribute("nom", nom);

		return "acteTechnique/ia/gestationIa";
	}

	@RequestMapping(value = "/gestationIa/{nom}", method = RequestMethod.POST)
	public String gestationIa(@PathVariable String nom, @Valid Gestation gestation, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("nom", nom);
			return "/acteTechnique/ia/gestationIa";
		}
		FicheIa ficheIa = ficheIaService.findByNom(nom);
		if (ficheIa.getGestation() != null)
		{
			Gestation gestationToDelete = ficheIa.getGestation();
			ficheIa.setGestation(null);
			gestationService.delete(gestationToDelete);
		}
		gestation.setFicheIa(ficheIa);
		ficheIa.setGestation(gestation);
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
		model.addAttribute("ficheIa", ficheIaService.newFicheIa());
		model.addAttribute("ficheIaList", ficheIaService.findAllFicheIa());
		return "acteTechnique/ia/consultation/consultation";
	}

	@RequestMapping(value = "/consultation", method = RequestMethod.POST)
	public String consultation(@ModelAttribute FicheIa ficheIa, Model model)
	{
		ficheIa = ficheIaService.findByNom(ficheIa.getNom());

		if (ficheIa.getHeader() == null)
		{
			model.addAttribute("header", headerService.newHeader());
		}
		else
		{
			model.addAttribute("header", ficheIa.getHeader());
		}

		if (ficheIa.getVache() == null)
		{
			model.addAttribute("vache", vacheService.newVache());
		}
		else
		{
			model.addAttribute("vache", ficheIa.getVache());
		}

		if (ficheIa.getInsemination() == null)
		{
			model.addAttribute("insemination", inseminationService.newInsemination());
		}
		else
		{
			model.addAttribute("insemination", ficheIa.getInsemination());
		}

		if (ficheIa.getTraitement_donneuse() == null)
		{
			model.addAttribute("traitementDonneuse", traitement_donneuseService.newTraitementDonneuse());
		}
		else
		{
			model.addAttribute("traitementDonneuse", ficheIa.getTraitement_donneuse());
		}

		if (ficheIa.getGestation() == null)
		{
			model.addAttribute("gestation", gestationService.newGestation());
		}
		else
		{
			model.addAttribute("gestation", ficheIa.getGestation());
		}

		if (ficheIa.getRemarque() == null)
		{
			model.addAttribute("remarques", new String());
		}
		else
		{
			model.addAttribute("remarques", ficheIa.getRemarque());
		}

		model.addAttribute("ficheColList", ficheColService.findAllFicheCol());

		return "acteTechnique/ia/consultation/consultationIa";
	}

	@RequestMapping(value = "/consultation/{nom}", method = RequestMethod.GET)
	public String consultation(@PathVariable String nom, Model model)
	{
		FicheIa ficheIa = ficheIaService.findByNom(nom);
		if (ficheIa.getHeader() == null)
		{
			model.addAttribute("header", headerService.newHeader());
		}
		else
		{
			model.addAttribute("header", ficheIa.getHeader());
		}

		if (ficheIa.getVache() == null)
		{
			model.addAttribute("vache", vacheService.newVache());
		}
		else
		{
			model.addAttribute("vache", ficheIa.getVache());
		}

		if (ficheIa.getInsemination() == null)
		{
			model.addAttribute("insemination", inseminationService.newInsemination());
		}
		else
		{
			model.addAttribute("insemination", ficheIa.getInsemination());
		}

		if (ficheIa.getTraitement_donneuse() == null)
		{
			model.addAttribute("traitementDonneuse", traitement_donneuseService.newTraitementDonneuse());
		}
		else
		{
			model.addAttribute("traitementDonneuse", ficheIa.getTraitement_donneuse());
		}

		if (ficheIa.getGestation() == null)
		{
			model.addAttribute("gestation", gestationService.newGestation());
		}
		else
		{
			model.addAttribute("gestation", ficheIa.getGestation());
		}

		if (ficheIa.getRemarque() == null)
		{
			model.addAttribute("remarques");
		}
		else
		{
			model.addAttribute("remarques", ficheIa.getRemarque());
		}

		model.addAttribute("ficheColList", ficheColService.findAllFicheCol());

		return "acteTechnique/ia/consultation/consultationIa";
	}

	@RequestMapping(value = "/modification", method = RequestMethod.GET)
	public String modification(Model model)
	{
		model.addAttribute("ficheIa", ficheIaService.newFicheIa());
		model.addAttribute("ficheIaList", ficheIaService.findAllFicheIa());
		return "acteTechnique/ia/modification";
	}

	@RequestMapping(value = "/modification", method = RequestMethod.POST)
	public String modification(@ModelAttribute FicheIa ficheIa)
	{
		return "redirect:/acteTechnique/ia/enteteIa/" + ficheIa.getNom();
	}
}
