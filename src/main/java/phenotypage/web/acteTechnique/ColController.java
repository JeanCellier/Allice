//package phenotypage.web.acteTechnique;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import phenotypage.model.cryoconservation.Cryoconservation;
//import phenotypage.model.cryoconservation.CryoconservationService;
//import phenotypage.model.cryoconservation.tableauDetail.TableauDetailService;
//import phenotypage.model.fiche.ficheAba.abattoir.AbattoirService;
//import phenotypage.model.cryoconservation.congelateur.CongelateurService;
//import phenotypage.model.cuve.CuveService;
//import phenotypage.model.cuve.canister.CanisterService;
//import phenotypage.model.cuve.visoTube.VisoTubeService;
//import phenotypage.model.operateur.OperateurService;
//import phenotypage.model.programme.ProgrammeService;
//import phenotypage.model.qualite.QualiteService;
//import phenotypage.model.sanitaire.SanitaireService;
//import phenotypage.model.cryoconservation.stade.StadeService;
//import phenotypage.model.fiche.Fiche;
//import phenotypage.model.fiche.ficheCol.FicheCol;
//import phenotypage.model.fiche.ficheCol.FicheColService;
//import phenotypage.model.invitro.collecte.resultat.Resultat;
//import phenotypage.model.invitro.collecte.resultat.ResultatService;
//import phenotypage.model.cryoconservation.methodeCongelation.MethodeCongelationService;
//import phenotypage.model.pharmacie.produit.ProduitService;
//import phenotypage.model.traitementDonneuse.traitement_donneuse.Tableau_DonneuseService;
//import phenotypage.model.vache.Vache;
//import phenotypage.model.vache.VacheService;
//
//import javax.validation.Valid;
//import java.util.ArrayList;
//import java.util.Calendar;
//
///**
// * @author fabien
// */
//
//@Controller
//@RequestMapping("/acteTechnique/col")
//public class ColController
//{
//	@Autowired
//	private Tableau_DonneuseService traitement_donneuseService;
//
//	@Autowired
//	private VacheService vacheService;
//
//	@Autowired
//	private ResultatService resultatService;
//
//	@Autowired
//	private CryoconservationService cryoconservationService;
//
//	@Autowired
//	private FicheColService ficheColService;
//
//	@Autowired
//	private OperateurService operateurService;
//
//	@Autowired
//	private ProgrammeService programmeService;
//
//
//	@Autowired
//	private AbattoirService abattoirService;
//
//	@Autowired
//	private ProduitService produitService;
//
//	@Autowired
//	private TableauDetailService tableauDetailService;
//
//	@Autowired
//	private SanitaireService sanitaireService;
//
//	@Autowired
//	private MethodeCongelationService methodeCongelationService;
//
//	@Autowired
//	private CongelateurService congelateurService;
//
//	@Autowired
//	private CuveService cuveService;
//
//	@Autowired
//	private CanisterService canisterService;
//
//	@Autowired
//	private VisoTubeService visoTubeService;
//
//	@Autowired
//	private QualiteService qualiteService;
//
//	@Autowired
//	private StadeService stadeService;
//
//	@RequestMapping(value = "/colNew", method = RequestMethod.GET)
//	public String colNew(Model model)
//	{
//		FicheCol ficheCol = ficheColService.createFicheCol(Calendar.getInstance().get(Calendar.YEAR) + "COL-" + ficheColService.countFicheCol());
//		return "redirect:/acteTechnique/col/enteteCol/" + ficheCol.getNom();
//	}
//
//	@RequestMapping(value = "/enteteCol/{nom}", method = RequestMethod.GET)
//	public String enteteCol(@PathVariable String nom, Model model)
//	{
//		FicheCol ficheCol = ficheColService.findByNom(nom);
//
////		if (ficheCol.getFiche() == null)
////		{
////			//model.addAttribute("fiche", headerService.newHeader());
////		}
////		else
////		{
////			model.addAttribute("fiche", ficheCol.getFiche());
////		}
//
//		model.addAttribute("programmeList", programmeService.findAllProgramme());
//		model.addAttribute("abattoirList", abattoirService.findAllAbattoir());
//		model.addAttribute("operateurList", operateurService.findAllOperateur());
//		model.addAttribute("nom", nom);
//
//		return "acteTechnique/col/enteteCol";
//	}
//
//	@RequestMapping(value = "/enteteCol/{nom}", method = RequestMethod.POST)
//	public String enteteCol(@PathVariable String nom, @Valid Fiche fiche, Errors errors, Model model)
//	{
//		if (errors.hasErrors())
//		{
//			model.addAttribute("programmeList", programmeService.findAllProgramme());
//			model.addAttribute("abattoirList", abattoirService.findAllAbattoir());
//			model.addAttribute("operateurList", operateurService.findAllOperateur());
//			model.addAttribute("nom", nom);
//			return "/acteTechnique/col/enteteCol";
//		}
////		FicheCol ficheCol = ficheColService.findByNom(nom);
////		if (ficheCol.getFiche() != null)
////		{
////			Fiche ficheDeleted = ficheCol.getFiche();
////			ficheCol.setFiche(null);
////			//headerService.delete(ficheDeleted);
////		}
////		if (fiche.isSnig())
////		{
////			ficheCol.setSnig(true);
////		}
////		ficheCol.setFiche(fiche);
//		//headerService.addHeader(fiche);
//		return "redirect:/acteTechnique/col/vacheCol/" + nom;
//	}
//
//	@RequestMapping(value = "/vacheCol/{nom}", method = RequestMethod.GET)
//	public String vacheCol(@PathVariable String nom, Model model)
//	{
//		FicheCol ficheCol = ficheColService.findByNom(nom);
//
//		if (ficheCol.getVache() == null)
//		{
//			model.addAttribute("vache", vacheService.newVache());
//		}
//		else
//		{
//			model.addAttribute("vache", ficheCol.getVache());
//		}
//
//		model.addAttribute("nom", nom);
//
//		return "acteTechnique/col/vacheCol";
//	}
//
//	@RequestMapping(value = "/vacheCol/{nom}", method = RequestMethod.POST)
//	public String vacheCol(@PathVariable String nom, @Valid Vache vache, Errors errors, Model model)
//	{
//		if (errors.hasErrors())
//		{
//			model.addAttribute("nom", nom);
//			return "/acteTechnique/col/vacheCol";
//		}
//		FicheCol ficheCol = ficheColService.findByNom(nom);
//		if (ficheCol.getVache() != null)
//		{
//			ficheCol.getVache().getFicheOpuList().remove(ficheCol);
//			ficheCol.setVache(null);
//		}
//		Vache vacheTrouve = vacheService.findByNum_identification(vache.getNum_identification());
//		if (vacheTrouve == null)
//		{
//			vacheTrouve = vacheService.addVache(vache);
//		}
//		if (vache.getFicheColList() == null)
//		{
//			vache.setFicheColList(new ArrayList<FicheCol>());
//		}
//		vache.getFicheColList().add(ficheCol);
//		ficheCol.setVache(vacheTrouve);
//		return "redirect:/acteTechnique/col/traitementDonneuse/" + nom;
//	}
//
////	@RequestMapping(value = "/traitementDonneuse/{nom}", method = RequestMethod.GET)
////	public String traitementDonneuse(@PathVariable String nom, Model model)
////	{
////		FicheCol ficheCol = ficheColService.findByNom(nom);
////
////		if (ficheCol.getTraitement_donneuse() == null)
////		{
////			Traitement_Donneuse traitementDonneuse = traitement_donneuseService.newTraitementDonneuse();
////			traitementDonneuse.setTableau_pharmacie(new ArrayList<Tableau_Pharmacie>());
////			traitementDonneuse.getTableau_pharmacie().add(new Tableau_Pharmacie());
////			traitementDonneuse.setTableau_pharmacie_superovulation_medicament(new ArrayList<Tableau_Pharmacie>());
////			traitementDonneuse.getTableau_pharmacie_superovulation_medicament().add(new Tableau_Pharmacie());
////			model.addAttribute("traitementDonneuse", traitementDonneuse);
////		}
////		else
////		{
////			if (ficheCol.getTraitement_donneuse().getTableau_pharmacie().size() <= 0)
////			{
////				ficheCol.getTraitement_donneuse().setTableau_pharmacie(new ArrayList<Tableau_Pharmacie>());
////				ficheCol.getTraitement_donneuse().getTableau_pharmacie().add(new Tableau_Pharmacie());
////			}
////			if (ficheCol.getTraitement_donneuse().getTableau_pharmacie_superovulation_medicament() == null)
////			{
////				ficheCol.getTraitement_donneuse().setTableau_pharmacie_superovulation_medicament(new ArrayList<Tableau_Pharmacie>());
////				ficheCol.getTraitement_donneuse().getTableau_pharmacie_superovulation_medicament().add(new Tableau_Pharmacie());
////			}
////			model.addAttribute("traitementDonneuse", ficheCol.getTraitement_donneuse());
////		}
////
////		model.addAttribute("operateurList", operateurService.findAllOperateur());
////		model.addAttribute("produitList", produitService.findAll());
////		model.addAttribute("nom", nom);
////
////		return "acteTechnique/col/traitementDonneuseCol";
////	}
//
////	@RequestMapping(value = "/traitementDonneuse/{nom}", method = RequestMethod.POST)
////	public String traitementDonneuse(@PathVariable String nom, @Valid Traitement_Donneuse traitementDonneuse, Errors errors, Model model)
////	{
////		if (errors.hasErrors())
////		{
////			model.addAttribute("operateurList", operateurService.findAllOperateur());
////			model.addAttribute("produitList", produitService.findAll());
////			model.addAttribute("nom", nom);
////			return "/acteTechnique/col/traitementDonneuse";
////		}
////		FicheCol ficheCol = ficheColService.findByNom(nom);
////		if (ficheCol.getTraitement_donneuse() != null)
////		{
////			Traitement_Donneuse traitement_donneuseToDelete = ficheCol.getTraitement_donneuse();
////			ficheCol.setTraitement_donneuse(null);
////			traitement_donneuseService.delete(traitement_donneuseToDelete);
////		}
////		traitementDonneuse.setFicheCol(ficheCol);
////		ficheCol.setTraitement_donneuse(traitementDonneuse);
////		traitement_donneuseService.addTraitement_Donneuse(traitementDonneuse);
////
////		for (int index = 0; index < traitementDonneuse.getTableau_pharmacie().size(); index++)
////		{
////			traitementDonneuse.getTableau_pharmacie().get(index).setTraitement_donneuse(traitementDonneuse);
////			traitementDonneuse.getTableau_pharmacie().get(index).getProduit().setQteRestante(traitementDonneuse.getTableau_pharmacie().get(index).getProduit().getQteRestante() - traitementDonneuse.getTableau_pharmacie().get(index).getQuantite());
////			produitService.updateProduit(traitementDonneuse.getTableau_pharmacie().get(index).getProduit());
////			tableau_pharmacieService.addTableau_Pharmacie(traitementDonneuse.getTableau_pharmacie().get(index));
////		}
////
////		for (int index = 0; index < traitementDonneuse.getTableau_pharmacie_superovulation_medicament().size(); index++)
////		{
////			traitementDonneuse.getTableau_pharmacie_superovulation_medicament().get(index).setTraitement_donneuseSuper(traitementDonneuse);
////			tableau_pharmacieService.addTableau_Pharmacie(traitementDonneuse.getTableau_pharmacie_superovulation_medicament().get(index));
////		}
////
////		return "redirect:/acteTechnique/col/resultat/" + nom;
////	}
//
//	@RequestMapping(value = "/resultat/{nom}", method = RequestMethod.GET)
//	public String resultat(@PathVariable String nom, Model model)
//	{
//		FicheCol ficheCol = ficheColService.findByNom(nom);
//
//		if (ficheCol.getResultat_collecte() == null)
//		{
//			model.addAttribute("resultat", resultatService.newResultat());
//		}
//		else
//		{
//			model.addAttribute("resultat", ficheCol.getResultat_collecte());
//		}
//
//		model.addAttribute("sanitaireList", sanitaireService.findAllSanitaire());
//		model.addAttribute("nom", nom);
//
//		return "acteTechnique/col/resultatCollecteCol";
//	}
//
//	@RequestMapping(value = "/resultat/{nom}", method = RequestMethod.POST)
//	public String resultat(@PathVariable String nom, @Valid Resultat resultat, Errors errors, Model model)
//	{
//		if (errors.hasErrors())
//		{
//			model.addAttribute("sanitaireList", sanitaireService.findAllSanitaire());
//			model.addAttribute("nom", nom);
//			return "/acteTechnique/col/resultat";
//		}
//		FicheCol ficheCol = ficheColService.findByNom(nom);
//		//resultat.setFicheCol(ficheCol);
//		ficheCol.setResultat_collecte(resultat);
//		resultatService.addResultat(resultat);
//		return "redirect:/acteTechnique/col/infoSiCryoCol/" + nom;
//	}
//
//	@RequestMapping(value = "/infoSiCryoCol/{nom}", method = RequestMethod.GET)
//	public String infoSiCryoCol(@PathVariable String nom, Model model)
//	{
//		FicheCol ficheCol = ficheColService.findByNom(nom);
//
//		int nbLigneCryo = ficheCol.getResultat_collecte().getNombre_Embryons_Viables();
//
//		if (nbLigneCryo > 0)
//		{
//			if (ficheCol.getCryoconservation() == null)
//			{
//				model.addAttribute("cryoconservation", cryoconservationService.newCryoconservation());
//			}
//			else
//			{
//				model.addAttribute("cryoconservation", ficheCol.getCryoconservation());
//			}
//
//			model.addAttribute("nbLigneCryo", nbLigneCryo - 1);
//			model.addAttribute("qualiteList", qualiteService.findAllQualite());
//			model.addAttribute("stadeList", stadeService.findAllStade());
//			model.addAttribute("cuveList", cuveService.findAllCuve());
//			model.addAttribute("canisterList", canisterService.findAllCanister());
//			model.addAttribute("visoTubeList", visoTubeService.findAllVisoTube());
//			model.addAttribute("congelateurList", congelateurService.findAllCongelateur());
//			model.addAttribute("methodeCongelationList", methodeCongelationService.findAllMethodeCongelation());
//			model.addAttribute("operateurList", operateurService.findAllOperateur());
//			model.addAttribute("nom", nom);
//
//			return "acteTechnique/col/infoSiCryoCol";
//		}
//		return "redirect:/";
//	}
//
//	@RequestMapping(value = "/infoSiCryoCol/{nom}", method = RequestMethod.POST)
//	public String infoSiCryoCol(@PathVariable String nom, @Valid Cryoconservation cryoconservation, Errors errors, Model model)
//	{
//		if (errors.hasErrors())
//		{
//			//model.addAttribute("nbLigneCryo", cryoconservation.getTableauDetailList().size() - 1);
//			model.addAttribute("qualiteList", qualiteService.findAllQualite());
//			model.addAttribute("stadeList", stadeService.findAllStade());
//			model.addAttribute("cuveList", cuveService.findAllCuve());
//			model.addAttribute("canisterList", canisterService.findAllCanister());
//			model.addAttribute("visoTubeList", visoTubeService.findAllVisoTube());
//			model.addAttribute("congelateurList", congelateurService.findAllCongelateur());
//			model.addAttribute("methodeCongelationList", methodeCongelationService.findAllMethodeCongelation());
//			model.addAttribute("operateurList", operateurService.findAllOperateur());
//			model.addAttribute("nom", nom);
//			return "acteTechnique/col/infoSiCryoCol";
//		}
//		FicheCol ficheCol = ficheColService.findByNom(nom);
//		//cryoconservation.setFicheCol(ficheCol);
//		ficheCol.setCryoconservation(cryoconservation);
//		cryoconservationService.addCryoconservation(cryoconservation);
////		for (int i = 0; i < cryoconservation.getTableauDetailList().size(); i++)
////		{
////			cryoconservation.getTableauDetailList().get(i).setCryoconservation(cryoconservation);
////			tableauDetailService.addTableauDetail(cryoconservation.getTableauDetailList().get(i));
////		}
//
//		return "redirect:/";
//	}
//
//	@RequestMapping(value = "/consultation", method = RequestMethod.GET)
//	public String consultation(Model model)
//	{
//		model.addAttribute("ficheCol", ficheColService.newFicheCol());
//		model.addAttribute("ficheColList", ficheColService.findAllFicheCol());
//		return "acteTechnique/col/consultation/consultation";
//	}
//
//	@RequestMapping(value = "/consultation", method = RequestMethod.POST)
//	public String consultation(@ModelAttribute FicheCol ficheCol, Model model)
//	{
//		ficheCol = ficheColService.findByNom(ficheCol.getNom());
//
////		if (ficheCol.getFiche() == null)
////		{
////			//model.addAttribute("fiche", headerService.newHeader());
////		}
////		else
////		{
////			model.addAttribute("fiche", ficheCol.getFiche());
////		}
//
//		if (ficheCol.getVache() == null)
//		{
//			model.addAttribute("vache", vacheService.newVache());
//		}
//		else
//		{
//			model.addAttribute("vache", ficheCol.getVache());
//		}
//
//		if (ficheCol.getTraitement_donneuse() == null)
//		{
//			model.addAttribute("traitementDonneuse", traitement_donneuseService.newTraitementDonneuse());
//		}
//		else
//		{
//			model.addAttribute("traitementDonneuse", ficheCol.getTraitement_donneuse());
//		}
//
//		if (ficheCol.getResultat_collecte() == null)
//		{
//			model.addAttribute("resultat", resultatService.newResultat());
//		}
//		else
//		{
//			model.addAttribute("resultat", ficheCol.getResultat_collecte());
//		}
//
//		if (ficheCol.getCryoconservation() == null)
//		{
//			model.addAttribute("cryoconservation", cryoconservationService.newCryoconservation());
//		}
//		else
//		{
//			model.addAttribute("cryoconservation", ficheCol.getCryoconservation());
//		}
//
//		return "acteTechnique/col/consultation/consultationCol";
//	}
//
//	@RequestMapping(value = "/consultation/{nom}", method = RequestMethod.GET)
//	public String consultation(@PathVariable String nom, Model model)
//	{
//		FicheCol ficheCol = ficheColService.findByNom(nom);
//
////		if (ficheCol.getFiche() == null)
////		{
////			//model.addAttribute("fiche", headerService.newHeader());
////		}
////		else
////		{
////			model.addAttribute("fiche", ficheCol.getFiche());
////		}
//
//		if (ficheCol.getVache() == null)
//		{
//			model.addAttribute("vache", vacheService.newVache());
//		}
//		else
//		{
//			model.addAttribute("vache", ficheCol.getVache());
//		}
//
//		if (ficheCol.getTraitement_donneuse() == null)
//		{
//			model.addAttribute("traitementDonneuse", traitement_donneuseService.newTraitementDonneuse());
//		}
//		else
//		{
//			model.addAttribute("traitementDonneuse", ficheCol.getTraitement_donneuse());
//		}
//
//		if (ficheCol.getResultat_collecte() == null)
//		{
//			model.addAttribute("resultat", resultatService.newResultat());
//		}
//		else
//		{
//			model.addAttribute("resultat", ficheCol.getResultat_collecte());
//		}
//
//		if (ficheCol.getCryoconservation() == null)
//		{
//			model.addAttribute("cryoconservation", cryoconservationService.newCryoconservation());
//		}
//		else
//		{
//			model.addAttribute("cryoconservation", ficheCol.getCryoconservation());
//		}
//
//		return "acteTechnique/col/consultation/consultationCol";
//	}
//
//	@RequestMapping(value = "/modification", method = RequestMethod.GET)
//	public String modification(Model model)
//	{
//		model.addAttribute("ficheCol", ficheColService.newFicheCol());
//		model.addAttribute("ficheColList", ficheColService.findAllFicheCol());
//		return "acteTechnique/col/modification";
//	}
//
//	@RequestMapping(value = "/modification", method = RequestMethod.POST)
//	public String modification(@ModelAttribute FicheCol ficheCol)
//	{
//		return "redirect:/acteTechnique/col/enteteCol/" + ficheCol.getNom();
//	}
//}
