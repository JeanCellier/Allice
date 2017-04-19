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
//import phenotypage.model.cryoconservation.TableauDetailService;
//import phenotypage.model.donneesExistantes.abattoir.AbattoirService;
//import phenotypage.model.donneesExistantes.congelateur.CongelateurService;
//import phenotypage.model.donneesExistantes.cuve.CuveService;
//import phenotypage.model.donneesExistantes.cuve.canister.CanisterService;
//import phenotypage.model.donneesExistantes.cuve.visoTube.VisoTubeService;
//import phenotypage.model.donneesExistantes.destionationCulture.DestinationCultureService;
//import phenotypage.model.donneesExistantes.fiv.FIVService;
//import phenotypage.model.donneesExistantes.operateur.OperateurService;
//import phenotypage.model.donneesExistantes.programme.ProgrammeService;
//import phenotypage.model.donneesExistantes.qualite.QualiteService;
//import phenotypage.model.donneesExistantes.sanitaire.SanitaireService;
//import phenotypage.model.donneesExistantes.stade.StadeService;
//import phenotypage.model.donneesExistantes.typeCulture.TypeCultureService;
//import phenotypage.model.fiche.ficheAba.FicheAba;
//import phenotypage.model.fiche.ficheAba.FicheAbaService;
//import phenotypage.model.fiche.Fiche;
//import phenotypage.model.informationsPIV.Informations_PIV;
//import phenotypage.model.informationsPIV.Informations_PIVService;
//import phenotypage.model.invitro.collecte.Collecte;
//import phenotypage.model.invitro.collecte.CollecteService;
//import phenotypage.model.invitro.collecte.Tableau_Collecte;
//import phenotypage.model.invitro.collecte.Tableau_CollecteService;
//import phenotypage.model.invitro.culture.Culture;
//import phenotypage.model.invitro.culture.CultureService;
//import phenotypage.model.invitro.culture.TableauCulture;
//import phenotypage.model.invitro.culture.TableauCultureService;
//import phenotypage.model.invitro.fecondation.Fecondation;
//import phenotypage.model.invitro.fecondation.FecondationService;
//import phenotypage.model.invitro.fecondation.TableauSemence;
//import phenotypage.model.invitro.fecondation.TableauSemenceService;
//import phenotypage.model.methodeCongelation.MethodeCongelationService;
//import phenotypage.model.milieuMaturation.MilieuMaturationService;
//import phenotypage.model.vache.Vache;
//import phenotypage.model.vache.VacheService;
//
//import javax.validation.Valid;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.List;
//
///**
// * @author fabien
// */
//
//@Controller
//@RequestMapping("/acteTechnique/aba")
//public class AbaController
//{
//	@Autowired
//	private Informations_PIVService informationsPIVService;
//
//	@Autowired
//	private CollecteService collecteService;
//
//	@Autowired
//	private FecondationService fecondationService;
//
//	@Autowired
//	private CultureService cultureService;
//
//	@Autowired
//	private CryoconservationService cryoconservationService;
//
//	@Autowired
//	private FicheAbaService ficheAbaService;
//
//	@Autowired
//	private OperateurService operateurService;
//
//	@Autowired
//	private MilieuMaturationService milieuMaturationService;
//
//	@Autowired
//	private TypeCultureService typeCultureService;
//
//	@Autowired
//	private FIVService fivService;
//
//	@Autowired
//	private ProgrammeService programmeService;
//
//	@Autowired
//	private SanitaireService sanitaireService;
//
//	@Autowired
//	private AbattoirService abattoirService;
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
//	@Autowired
//	private Tableau_CollecteService tableauCollecteService;
//
//	@Autowired
//	private VacheService vacheService;
//
//	@Autowired
//	private DestinationCultureService destinationCultureService;
//
//	@Autowired
//	private TableauCultureService tableauCultureService;
//
//	@Autowired
//	private TableauDetailService tableauDetailService;
//
//	@Autowired
//	private TableauSemenceService tableauSemenceService;
//
//	@RequestMapping(value = "/abaNew", method = RequestMethod.GET)
//	public String abaNew()
//	{
//		FicheAba ficheAba = ficheAbaService.createFicheAba(Calendar.getInstance().get(Calendar.YEAR) + "ABA-" + ficheAbaService.countFicheAba());
//		return "redirect:/acteTechnique/aba/enteteAba/" + ficheAba.getNom();
//	}
//
//	@RequestMapping(value = "/enteteAba/{nom}", method = RequestMethod.GET)
//	public String enteteAba(@PathVariable String nom, Model model)
//	{
//		FicheAba ficheAba = ficheAbaService.findByNom(nom);
//
//		if (ficheAba.getFiche() != null)
//		{
//			model.addAttribute("fiche", ficheAba.getFiche());
//		}
//		else
//		{
//			//Fiche fiche = headerService.newHeader();
//			//model.addAttribute("fiche", fiche);
//		}
//
//		model.addAttribute("programmeList", programmeService.findAllProgramme());
//		model.addAttribute("abattoirList", abattoirService.findAllAbattoir());
//		model.addAttribute("operateurList", operateurService.findAllOperateur());
//		model.addAttribute("nom", nom);
//
//		return "acteTechnique/aba/enteteAba";
//	}
//
//	@RequestMapping(value = "/enteteAba/{nom}", method = RequestMethod.POST)
//	public String enteteAba(@PathVariable String nom, @Valid Fiche fiche, Errors errors, Model model)
//	{
//		if (errors.hasErrors())
//		{
//			model.addAttribute("programmeList", programmeService.findAllProgramme());
//			model.addAttribute("abattoirList", abattoirService.findAllAbattoir());
//			model.addAttribute("operateurList", operateurService.findAllOperateur());
//			model.addAttribute("nom", nom);
//			return "/acteTechnique/aba/enteteAba";
//		}
//		FicheAba ficheAba = ficheAbaService.findByNom(nom);
//		if (ficheAba.getFiche() != null)
//		{
//			Fiche ficheDeleted = ficheAba.getFiche();
//			ficheAba.setFiche(null);
//			//headerService.delete(ficheDeleted);
//		}
////		if (fiche.isSnig())
////		{
////			ficheAba.setSnig(true);
////		}
//		ficheAba.setFiche(fiche);
//		//headerService.addHeader(fiche);
//		return "redirect:/acteTechnique/aba/infoGeneralAba/" + nom;
//	}
//
//	@RequestMapping(value = "/infoGeneralAba/{nom}", method = RequestMethod.GET)
//	public String infoGeneralAba(@PathVariable String nom, Model model)
//	{
//		FicheAba ficheAba = ficheAbaService.findByNom(nom);
//
//		if (ficheAba.getInformations_piv() == null)
//		{
//			model.addAttribute("infoPIV", informationsPIVService.newInfoPIV());
//		}
//		else
//		{
//			model.addAttribute("infoPIV", ficheAba.getInformations_piv());
//		}
//
//		model.addAttribute("operateurListe", operateurService.findAllOperateur());
//		model.addAttribute("milieu_maturationList", milieuMaturationService.findAllMilieuMaturation());
//		model.addAttribute("milieu_fivList", fivService.findAllFIV());
//		model.addAttribute("milieu_cultureList", typeCultureService.findAllTypeCulture());
//		model.addAttribute("nom", nom);
//
//		return "acteTechnique/aba/infoGeneralAba";
//	}
//
//	@RequestMapping(value = "/infoGeneralAba/{nom}", method = RequestMethod.POST)
//	public String infoGeneralAba(@PathVariable String nom, @Valid Informations_PIV informations_piv, Errors errors, Model model)
//	{
//		if (errors.hasErrors())
//		{
//			model.addAttribute("infoPIV", informations_piv);
//			model.addAttribute("operateurListe", operateurService.findAllOperateur());
//			model.addAttribute("milieu_maturationList", milieuMaturationService.findAllMilieuMaturation());
//			model.addAttribute("milieu_fivList", fivService.findAllFIV());
//			model.addAttribute("milieu_cultureList", typeCultureService.findAllTypeCulture());
//			model.addAttribute("nom", nom);
//			return "acteTechnique/aba/infoGeneralAba";
//		}
//		FicheAba ficheAba = ficheAbaService.findByNom(nom);
//		if (ficheAba.getInformations_piv() != null)
//		{
//			Informations_PIV informations_pivToDelete = ficheAba.getInformations_piv();
//			ficheAba.setInformations_piv(null);
//			for (int index = 0; index < informations_pivToDelete.getOperateurList().size(); index++)
//			{
//				informations_pivToDelete.getOperateurList().get(index).getInformations_pivList().remove(informations_pivToDelete);
//			}
//			informations_pivToDelete.setOperateurList(null);
//			informationsPIVService.delete(informations_pivToDelete);
//		}
//
//		informations_piv.setFicheAba(ficheAba);
//		ficheAba.setInformations_piv(informations_piv);
//		for (int i = 0; i < informations_piv.getOperateurList().size(); i++)
//		{
//			informations_piv.getOperateurList().get(i).getInformations_pivList().add(informations_piv);
//		}
//
//		informationsPIVService.addInformation_PIV(informations_piv);
//
//		return "redirect:/acteTechnique/aba/collecteMaturationAba/" + nom;
//	}
//
//	@RequestMapping(value = "/collecteMaturationAba/{nom}", method = RequestMethod.GET)
//	public String collecteMaturationAba(@PathVariable String nom, Model model)
//	{
//		FicheAba ficheAba = ficheAbaService.findByNom(nom);
//
//		if (ficheAba.getCollecte() == null)
//		{
//			Collecte collecte = collecteService.newCollecte();
//			collecte.setTableauCollecteList(new ArrayList<Tableau_Collecte>());
//			collecte.getTableauCollecteList().add(new Tableau_Collecte());
//			model.addAttribute("collecte", collecte);
//		}
//		else
//		{
//			if (ficheAba.getCollecte().getTableauCollecteList().size() <= 0)
//			{
//				ficheAba.getCollecte().setTableauCollecteList(new ArrayList<Tableau_Collecte>());
//				ficheAba.getCollecte().getTableauCollecteList().add(new Tableau_Collecte());
//			}
//			model.addAttribute("collecte", ficheAba.getCollecte());
//		}
//
//		model.addAttribute("vacheList", vacheService.findAllVache());
//		model.addAttribute("nom", nom);
//
//		return "acteTechnique/aba/collecteMaturationAba";
//	}
//
//	@RequestMapping(value = "/collecteMaturationAba/{nom}", method = RequestMethod.POST)
//	public String collecteMaturationAba(@PathVariable String nom, @Valid Collecte collecte, Errors errors, Model model)
//	{
//		if (errors.hasErrors())
//		{
//			model.addAttribute("vacheList", vacheService.findAllVache());
//			model.addAttribute("nom", nom);
//			return "acteTechnique/aba/collecteMaturationAba";
//		}
//		FicheAba ficheAba = ficheAbaService.findByNom(nom);
//		if (ficheAba.getCollecte() != null)
//		{
//			Collecte collecteToDelete = ficheAba.getCollecte();
//			ficheAba.setCollecte(null);
//			collecteService.delete(collecteToDelete);
//		}
//		collecte.setFicheAba(ficheAba);
//		ficheAba.setCollecte(collecte);
//		collecteService.addCollecte(collecte);
//		for (int i = 0; i < collecte.getTableauCollecteList().size(); i++)
//		{
//			collecte.getTableauCollecteList().get(i).setCollecte(collecte);
//			tableauCollecteService.addTableauCollecte(collecte.getTableauCollecteList().get(i));
//		}
//		return "redirect:/acteTechnique/aba/fecondationInVitroAba/" + nom;
//	}
//
//	@RequestMapping(value = "/fecondationInVitroAba/{nom}", method = RequestMethod.GET)
//	public String fecondationInVitroAba(@PathVariable String nom, Model model)
//	{
//		FicheAba ficheAba = ficheAbaService.findByNom(nom);
//
//		if (ficheAba.getFecondation() == null)
//		{
//			Fecondation fecondation = fecondationService.newFecondation();
//			fecondation.setTableau_semences(new ArrayList<TableauSemence>());
//			fecondation.getTableau_semences().add(new TableauSemence());
//			model.addAttribute("fecondationInvitro", fecondation);
//		}
//		else
//		{
//			if (ficheAba.getFecondation().getTableau_semences().size() <= 0)
//			{
//				ficheAba.getFecondation().setTableau_semences(new ArrayList<TableauSemence>());
//				ficheAba.getFecondation().getTableau_semences().add(new TableauSemence());
//			}
//			model.addAttribute("fecondationInvitro", ficheAba.getFecondation());
//		}
//
//		model.addAttribute("taureauList", vacheService.findAllTaureau());
//		model.addAttribute("sanitaireList", sanitaireService.findAllSanitaire());
//		model.addAttribute("nom", nom);
//
//		return "acteTechnique/aba/fecondationInVitroAba";
//	}
//
//	@RequestMapping(value = "/fecondationInVitroAba/{nom}", method = RequestMethod.POST)
//	public String fecondationInVitroAba(@PathVariable String nom, @Valid Fecondation fecondationInvitro, Errors errors, Model model)
//	{
//		Vache vacheTrouve;
//		if (errors.hasErrors())
//		{
//			model.addAttribute("fecondationInvitro", fecondationInvitro);
//			model.addAttribute("taureauList", vacheService.findAllTaureau());
//			model.addAttribute("sanitaireList", sanitaireService.findAllSanitaire());
//			model.addAttribute("nom", nom);
//			return "acteTechnique/aba/fecondationInVitroAba";
//		}
//		FicheAba ficheAba = ficheAbaService.findByNom(nom);
//		if (ficheAba.getFecondation() != null)
//		{
//			Fecondation fecondationToDelete = ficheAba.getFecondation();
//			ficheAba.setFecondation(null);
//			for (int index = 0; index < fecondationToDelete.getSanitaireList().size(); index++)
//			{
//				fecondationToDelete.getSanitaireList().get(index).getFecondationList().remove(fecondationToDelete);
//			}
//			fecondationToDelete.setSanitaireList(null);
//			fecondationService.delete(fecondationToDelete);
//		}
//		fecondationInvitro.setFicheAba(ficheAba);
//		ficheAba.setFecondation(fecondationInvitro);
//		for (int i = 0; i < fecondationInvitro.getSanitaireList().size(); i++)
//		{
//			if (fecondationInvitro.getSanitaireList().get(i) != null)
//			{
//				fecondationInvitro.getSanitaireList().get(i).getFecondationList().add(fecondationInvitro);
//			}
//		}
//		fecondationService.addFecondation(fecondationInvitro);
//		for (int i = 0; i < fecondationInvitro.getTableau_semences().size(); i++)
//		{
//			vacheTrouve = vacheService.findByNum_identification(fecondationInvitro.getTableau_semences().get(i).getTaureau().getNum_identification());
//			if (vacheTrouve == null || !vacheTrouve.isMale())
//			{
//				vacheTrouve = vacheService.addTaureau(fecondationInvitro.getTableau_semences().get(i).getTaureau());
//			}
//			fecondationInvitro.getTableau_semences().get(i).setTaureau(vacheTrouve);
//			fecondationInvitro.getTableau_semences().get(i).setFecondation(fecondationInvitro);
//			tableauSemenceService.addTableauSemence(fecondationInvitro.getTableau_semences().get(i));
//		}
//		return "redirect:/acteTechnique/aba/cultureInVitroAba/" + nom;
//	}
//
//	@RequestMapping(value = "/cultureInVitroAba/{nom}", method = RequestMethod.GET)
//	public String cultureInVitroAba(@PathVariable String nom, Model model)
//	{
//		FicheAba ficheAba = ficheAbaService.findByNom(nom);
//
//		if (ficheAba.getCulture() == null)
//		{
//			Culture culture = cultureService.newCulture();
//			culture.setTableauCultureList(new ArrayList<TableauCulture>());
//			culture.getTableauCultureList().add(new TableauCulture());
//			culture.getTableauCultureList().get(0).setGroupe("1");
//			model.addAttribute("cultureInVitro", culture);
//		}
//		else
//		{
//			if (ficheAba.getCulture().getTableauCultureList().size() <= 0)
//			{
//				ficheAba.getCulture().setTableauCultureList(new ArrayList<TableauCulture>());
//				ficheAba.getCulture().getTableauCultureList().add(new TableauCulture());
//				ficheAba.getCulture().getTableauCultureList().get(0).setGroupe("1");
//			}
//			model.addAttribute("cultureInVitro", ficheAba.getCulture());
//		}
//
//		model.addAttribute("destinationCulture", destinationCultureService.findAllDestinationCulture());
//		model.addAttribute("sanitaireList", sanitaireService.findAllSanitaire());
//		model.addAttribute("nom", nom);
//
//		return "acteTechnique/aba/cultureInVitroAba";
//	}
//
//	@RequestMapping(value = "/cultureInVitroAba/{nom}", method = RequestMethod.POST)
//	public String cultureInVitroAba(@PathVariable String nom, @Valid Culture culture, Errors errors, Model model)
//	{
//		if (errors.hasErrors())
//		{
//			model.addAttribute("cultureInVitro", culture);
//			model.addAttribute("destinationCulture", destinationCultureService.findAllDestinationCulture());
//			model.addAttribute("sanitaireList", sanitaireService.findAllSanitaire());
//			model.addAttribute("nom", nom);
//			return "acteTechnique/aba/cultureInVitroAba";
//		}
//		FicheAba ficheAba = ficheAbaService.findByNom(nom);
//		if (ficheAba.getCulture() != null)
//		{
//			Culture cultureToDelete = ficheAba.getCulture();
//			ficheAba.setCulture(null);
//			for (int index = 0; index < cultureToDelete.getSanitaireList().size(); index++)
//			{
//				cultureToDelete.getSanitaireList().get(index).getCultureList().remove(cultureToDelete);
//			}
//			cultureToDelete.setSanitaireList(null);
//			cultureService.delete(cultureToDelete);
//		}
//		culture.setFicheAba(ficheAba);
//		ficheAba.setCulture(culture);
//		cultureService.addCulture(culture);
//		for (int i = 0; i < culture.getSanitaireList().size(); i++)
//		{
//			if (culture.getSanitaireList().get(i) != null)
//			{
//				culture.getSanitaireList().get(i).getCultureList().add(culture);
//			}
//		}
//		for (int i = 0; i < culture.getTableauCultureList().size(); i++)
//		{
//			culture.getTableauCultureList().get(i).setCulture(culture);
//			tableauCultureService.addTableauCulture(culture.getTableauCultureList().get(i));
//		}
//		return "redirect:/acteTechnique/aba/infoSiCryoAba/" + nom;
//	}
//
//	@RequestMapping(value = "/infoSiCryoAba/{nom}", method = RequestMethod.GET)
//	public String infoSiCryoAba(@PathVariable String nom, Model model)
//	{
//		FicheAba ficheAba = ficheAbaService.findByNom(nom);
//
//		int nbLigneCryo = 0;
//		List<TableauCulture> tableauCultureList = ficheAba.getCulture().getTableauCultureList();
//		for (TableauCulture aTableauCulture : tableauCultureList)
//		{
//			if (aTableauCulture.isSiCryo())
//			{
//				nbLigneCryo += aTableauCulture.getNbTotal();
//			}
//		}
//		if (nbLigneCryo > 0)
//		{
//
//			if (ficheAba.getCryoconservation() == null)
//			{
//				model.addAttribute("cryoconservation", cryoconservationService.newCryoconservation());
//			}
//			else
//			{
//				model.addAttribute("cryoconservation", ficheAba.getCryoconservation());
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
//			return "acteTechnique/aba/infoSiCryoAba";
//		}
//		return "redirect:/";
//	}
//
//	@RequestMapping(value = "/infoSiCryoAba/{nom}", method = RequestMethod.POST)
//	public String infoSiCryoAba(@PathVariable String nom, @Valid Cryoconservation cryoconservation, Errors errors, Model model)
//	{
//		if (errors.hasErrors())
//		{
//			model.addAttribute("nbLigneCryo", cryoconservation.getTableauDetailList().size());
//			model.addAttribute("qualiteList", qualiteService.findAllQualite());
//			model.addAttribute("stadeList", stadeService.findAllStade());
//			model.addAttribute("cuveList", cuveService.findAllCuve());
//			model.addAttribute("canisterList", canisterService.findAllCanister());
//			model.addAttribute("visoTubeList", visoTubeService.findAllVisoTube());
//			model.addAttribute("congelateurList", congelateurService.findAllCongelateur());
//			model.addAttribute("methodeCongelationList", methodeCongelationService.findAllMethodeCongelation());
//			model.addAttribute("operateurList", operateurService.findAllOperateur());
//			model.addAttribute("nom", nom);
//			return "acteTechnique/aba/infoSiCryoAba";
//		}
//		FicheAba ficheAba = ficheAbaService.findByNom(nom);
//		if (ficheAba.getCryoconservation() != null)
//		{
//			Cryoconservation cryoconservationToDelete = ficheAba.getCryoconservation();
//			ficheAba.setCryoconservation(null);
//			cryoconservationService.delete(cryoconservationToDelete);
//		}
//		cryoconservation.setFicheAba(ficheAba);
//		ficheAba.setCryoconservation(cryoconservation);
//		cryoconservationService.addCryoconservation(cryoconservation);
//		cryoconservationService.addCryoconservation(cryoconservation);
//		for (int i = 0; i < cryoconservation.getTableauDetailList().size(); i++)
//		{
//			cryoconservation.getTableauDetailList().get(i).setCryoconservation(cryoconservation);
//			tableauDetailService.addTableauDetail(cryoconservation.getTableauDetailList().get(i));
//		}
//
//		return "redirect:/";
//	}
//
//	@RequestMapping(value = "/modification", method = RequestMethod.GET)
//	public String modification(Model model)
//	{
//		model.addAttribute("ficheAba", ficheAbaService.newFicheAba());
//		model.addAttribute("ficheAbaList", ficheAbaService.findAllFicheAba());
//		return "acteTechnique/aba/modification";
//	}
//
//	@RequestMapping(value = "/modification", method = RequestMethod.POST)
//	public String modification(@ModelAttribute FicheAba ficheAba)
//	{
//		return "redirect:/acteTechnique/aba/enteteAba/" + ficheAba.getNom();
//	}
//
//	@RequestMapping(value = "/consultation", method = RequestMethod.GET)
//	public String consultation(Model model)
//	{
//		model.addAttribute("ficheAba", ficheAbaService.newFicheAba());
//		model.addAttribute("ficheAbaList", ficheAbaService.findAllFicheAba());
//		return "acteTechnique/aba/consultation/consultation";
//	}
//
//	@RequestMapping(value = "/consultation", method = RequestMethod.POST)
//	public String consultation(@ModelAttribute FicheAba ficheAba, Model model)
//	{
//		ficheAba = ficheAbaService.findByNom(ficheAba.getNom());
//
//		if (ficheAba.getFiche() != null)
//		{
//			model.addAttribute("fiche", ficheAba.getFiche());
//		}
//		else
//		{
//			//model.addAttribute("fiche", headerService.newHeader());
//		}
//
//		if (ficheAba.getInformations_piv() == null)
//		{
//			model.addAttribute("infoPIV", informationsPIVService.newInfoPIV());
//		}
//		else
//		{
//			model.addAttribute("infoPIV", ficheAba.getInformations_piv());
//		}
//
//		if (ficheAba.getCollecte() == null)
//		{
//			model.addAttribute("collecte", collecteService.newCollecte());
//		}
//		else
//		{
//			model.addAttribute("collecte", ficheAba.getCollecte());
//		}
//
//		if (ficheAba.getFecondation() == null)
//		{
//			model.addAttribute("fecondationInvitro", fecondationService.newFecondation());
//		}
//		else
//		{
//			model.addAttribute("fecondationInvitro", ficheAba.getFecondation());
//		}
//
//		if (ficheAba.getCulture() == null)
//		{
//			model.addAttribute("cultureInVitro", cultureService.newCulture());
//		}
//		else
//		{
//			model.addAttribute("cultureInVitro", ficheAba.getCulture());
//		}
//
//		if (ficheAba.getCryoconservation() == null)
//		{
//			model.addAttribute("cryoconservation", cryoconservationService.newCryoconservation());
//		}
//		else
//		{
//			model.addAttribute("cryoconservation", ficheAba.getCryoconservation());
//		}
//
//		model.addAttribute("nom", ficheAba.getNom());
//		return "acteTechnique/aba/consultation/consultationAba";
//	}
//
//	@RequestMapping(value = "/consultation/{nom}", method = RequestMethod.GET)
//	public String consultation(@PathVariable String nom, Model model)
//	{
//		FicheAba ficheAba = ficheAbaService.findByNom(nom);
//
//		if (ficheAba.getFiche() != null)
//		{
//			model.addAttribute("fiche", ficheAba.getFiche());
//		}
//		else
//		{
//			//Fiche fiche = headerService.newHeader();
//			//model.addAttribute("fiche", fiche);
//		}
//
//		if (ficheAba.getInformations_piv() == null)
//		{
//			model.addAttribute("infoPIV", informationsPIVService.newInfoPIV());
//		}
//		else
//		{
//			model.addAttribute("infoPIV", ficheAba.getInformations_piv());
//		}
//
//		if (ficheAba.getCollecte() == null)
//		{
//			model.addAttribute("collecte", collecteService.newCollecte());
//		}
//		else
//		{
//			model.addAttribute("collecte", ficheAba.getCollecte());
//		}
//
//		if (ficheAba.getFecondation() == null)
//		{
//			model.addAttribute("fecondationInvitro", fecondationService.newFecondation());
//		}
//		else
//		{
//			model.addAttribute("fecondationInvitro", ficheAba.getFecondation());
//		}
//
//		if (ficheAba.getCulture() == null)
//		{
//			model.addAttribute("cultureInVitro", cultureService.newCulture());
//		}
//		else
//		{
//			model.addAttribute("cultureInVitro", ficheAba.getCulture());
//		}
//
//		if (ficheAba.getCryoconservation() == null)
//		{
//			model.addAttribute("cryoconservation", cryoconservationService.newCryoconservation());
//		}
//		else
//		{
//			model.addAttribute("cryoconservation", ficheAba.getCryoconservation());
//		}
//
//		return "acteTechnique/aba/consultation/consultationAba";
//	}
//}
