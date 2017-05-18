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
//import phenotypage.model.destionationCulture.DestinationCultureService;
//import phenotypage.model.informationsPIV.fiv.FIVService;
//import phenotypage.model.operateur.OperateurService;
//import phenotypage.model.programme.ProgrammeService;
//import phenotypage.model.qualite.QualiteService;
//import phenotypage.model.sanitaire.SanitaireService;
//import phenotypage.model.cryoconservation.stade.StadeService;
//import phenotypage.model.informationsPIV.typeCulture.TypeCultureService;
//import phenotypage.model.fiche.ficheOpu.FicheOpu;
//import phenotypage.model.fiche.ficheOpu.FicheOpuService;
//import phenotypage.model.fiche.Fiche;
//import phenotypage.model.fiche.fiche.HeaderService;
//import phenotypage.model.fiche.ficheOpu.imageEcho.Echo;
//import phenotypage.model.fiche.ficheOpu.imageEcho.EchoService;
//import phenotypage.model.informationsPIV.Informations_PIV;
//import phenotypage.model.informationsPIV.Informations_PIVService;
//import phenotypage.model.invitro.collecte.Collecte;
//import phenotypage.model.invitro.collecte.CollecteService;
//import phenotypage.model.invitro.collecte.tableau_collecte.Tableau_Collecte;
//import phenotypage.model.invitro.collecte.tableau_collecte.Tableau_CollecteService;
//import phenotypage.model.invitro.culture.Culture;
//import phenotypage.model.invitro.culture.CultureService;
//import phenotypage.model.invitro.culture.tableauCulture.TableauCulture;
//import phenotypage.model.invitro.culture.tableauCulture.TableauCultureService;
//import phenotypage.model.invitro.fecondation.Fecondation;
//import phenotypage.model.invitro.fecondation.FecondationService;
//import phenotypage.model.invitro.fecondation.tableauSemence.TableauSemence;
//import phenotypage.model.invitro.fecondation.tableauSemence.TableauSemenceService;
//import phenotypage.model.cryoconservation.methodeCongelation.MethodeCongelationService;
//import phenotypage.model.informationsPIV.milieuMaturation.MilieuMaturationService;
//import phenotypage.model.fiche.ficheOpu.ovocytesCollecte.OvocytesCollectes;
//import phenotypage.model.fiche.ficheOpu.ovocytesCollecte.OvocytesCollectesService;
//import phenotypage.model.fiche.ficheOpu.ovocytesCollecte.tableauOvocytesCollectes.TableauOvocytesCollectes;
//import phenotypage.model.fiche.ficheOpu.ovocytesCollecte.tableauOvocytesCollectes.TableauOvocytesCollectesService;
//import phenotypage.model.pharmacie.produit.ProduitService;
//import phenotypage.model.traitementDonneuse.Traitement_Donneuse;
//import phenotypage.model.traitementDonneuse.Tableau_DonneuseService;
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
//@RequestMapping("/acteTechnique/opu")
//public class OpuController
//{
//	@Autowired
//	private FicheOpuService ficheOpuService;
//
//	@Autowired
//	private HeaderService headerService;
//
//	@Autowired
//	private ProgrammeService programmeService;
//
//	@Autowired
//	private OperateurService operateurService;
//
//	@Autowired
//	private AbattoirService abattoirService;
//
//	@Autowired
//	private VacheService vacheService;
//
//	@Autowired
//	private Tableau_DonneuseService traitement_donneuseService;
//
//	@Autowired
//	private EchoService echoService;
//
//	@Autowired
//	private OvocytesCollectesService ovocytesCollectesService;
//
//	@Autowired
//	private Informations_PIVService informationsPIVService;
//
//	@Autowired
//	private CollecteService collecteService;
//
//	@Autowired
//	private CultureService cultureService;
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
//	private FecondationService fecondationService;
//
//	@Autowired
//	private CryoconservationService cryoconservationService;
//
//	@Autowired
//	private SanitaireService sanitaireService;
//
//	@Autowired
//	private ProduitService produitService;
//
//	@Autowired
//	private TableauDetailService tableauDetailService;
//
//	@Autowired
//	private TableauOvocytesCollectesService tableauOvocytesCollectesService;
//
//	@Autowired
//	private Tableau_CollecteService tableauCollecteService;
//
//	@Autowired
//	private TableauCultureService tableauCultureService;
//
//	@Autowired
//	private TableauSemenceService tableauSemenceService;
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
//	private DestinationCultureService destinationCultureService;
//
//	@Autowired
//	private MethodeCongelationService methodeCongelationService;
//
//	@Autowired
//	private CongelateurService congelateurService;
//
//	@RequestMapping(value = "/opuNew", method = RequestMethod.GET)
//	public String opuNew()
//	{
//		FicheOpu ficheOpu = ficheOpuService.createFichieOpu(Calendar.getInstance().get(Calendar.YEAR) + "OPU-" + ficheOpuService.countFicheOpu());
//		return "redirect:/acteTechnique/opu/enteteOpu/" + ficheOpu.getNom();
//	}
//
//	@RequestMapping(value = "/enteteOpu/{nom}", method = RequestMethod.GET)
//	public String enteteOpu(@PathVariable String nom, Model model)
//	{
//		FicheOpu ficheOpu = ficheOpuService.findByNom(nom);
//
//		if (ficheOpu.getFiche() == null)
//		{
//			model.addAttribute("fiche", headerService.newHeader());
//		}
//		else
//		{
//			model.addAttribute("fiche", ficheOpu.getFiche());
//		}
//
//		model.addAttribute("programmeList", programmeService.findAllProgramme());
//		model.addAttribute("abatoirList", abattoirService.findAllAbattoir());
//		model.addAttribute("operateurList", operateurService.findAllOperateur());
//		model.addAttribute("nom", nom);
//
//		return "acteTechnique/opu/enteteOpu";
//	}
//
//	@RequestMapping(value = "/enteteOpu/{nom}", method = RequestMethod.POST)
//	public String enteteOpu(@PathVariable String nom, @Valid Fiche fiche, Errors errors, Model model)
//	{
//		if (errors.hasErrors())
//		{
//			model.addAttribute("programmeList", programmeService.findAllProgramme());
//			model.addAttribute("abatoirList", abattoirService.findAllAbattoir());
//			model.addAttribute("operateurList", operateurService.findAllOperateur());
//			model.addAttribute("nom", nom);
//			return "/acteTechnique/opu/enteteOpu";
//		}
//		FicheOpu ficheOpu = ficheOpuService.findByNom(nom);
//		if (ficheOpu.getFiche() != null)
//		{
//			Fiche headerDeleted = ficheOpu.getFiche();
//			ficheOpu.setFiche(null);
//			headerService.delete(headerDeleted);
//		}
//		if (fiche.isSnig())
//		{
//			ficheOpu.setSnig(true);
//		}
//		fiche.setFicheOpu(ficheOpu);
//		ficheOpu.setFiche(fiche);
//		headerService.addHeader(fiche);
//		return "redirect:/acteTechnique/opu/vacheOpu/" + nom;
//	}
//
//	@RequestMapping(value = "/vacheOpu/{nom}", method = RequestMethod.GET)
//	public String vacheOpu(@PathVariable String nom, Model model)
//	{
//		FicheOpu ficheOpu = ficheOpuService.findByNom(nom);
//
//		if (ficheOpu.getVache() == null)
//		{
//			model.addAttribute("vache", vacheService.newVache());
//		}
//		else
//		{
//			model.addAttribute("vache", ficheOpu.getVache());
//		}
//
//		model.addAttribute("nom", nom);
//
//		return "acteTechnique/opu/vacheOpu";
//	}
//
//	@RequestMapping(value = "/vacheOpu/{nom}", method = RequestMethod.POST)
//	public String vacheOpu(@PathVariable String nom, @Valid Vache vache, Errors errors, Model model)
//	{
//		if (errors.hasErrors())
//		{
//			model.addAttribute("nom", nom);
//			return "/acteTechnique/opu/vacheOpu";
//		}
//		vache.setNom("");
//		FicheOpu ficheOpu = ficheOpuService.findByNom(nom);
//		if (ficheOpu.getVache() != null)
//		{
//			ficheOpu.getVache().getFicheOpuList().remove(ficheOpu);
//			ficheOpu.setVache(null);
//		}
//		Vache vacheTrouve = vacheService.findByNum_identification(vache.getNum_identification());
//		if (vacheTrouve == null)
//		{
//			vacheTrouve = vacheService.addVache(vache);
//		}
//		if (vache.getFicheOpuList() == null)
//		{
//			vache.setFicheOpuList(new ArrayList<FicheOpu>());
//		}
//		vache.getFicheOpuList().add(ficheOpu);
//		ficheOpu.setVache(vacheTrouve);
//		return "redirect:/acteTechnique/opu/traitementDonneuseOpu/" + nom;
//	}
//
//	@RequestMapping(value = "/traitementDonneuseOpu/{nom}", method = RequestMethod.GET)
//	public String traitementDonneuseOpu(@PathVariable String nom, Model model)
//	{
//		FicheOpu ficheOpu = ficheOpuService.findByNom(nom);
//
//		if (ficheOpu.getTraitement_donneuse() == null)
//		{
//			Traitement_Donneuse traitementDonneuse = traitement_donneuseService.newTraitementDonneuse();
//			traitementDonneuse.setTableau_pharmacie(new ArrayList<Tableau_Pharmacie>());
//			traitementDonneuse.getTableau_pharmacie().add(new Tableau_Pharmacie());
//			traitementDonneuse.setTableau_pharmacie_superovulation_medicament(new ArrayList<Tableau_Pharmacie>());
//			traitementDonneuse.getTableau_pharmacie_superovulation_medicament().add(new Tableau_Pharmacie());
//			model.addAttribute("traitementDonneuse", traitementDonneuse);
//		}
//		else
//		{
//			if (ficheOpu.getTraitement_donneuse().getTableau_pharmacie().size() <= 0)
//			{
//				ficheOpu.getTraitement_donneuse().setTableau_pharmacie(new ArrayList<Tableau_Pharmacie>());
//				ficheOpu.getTraitement_donneuse().getTableau_pharmacie().add(new Tableau_Pharmacie());
//			}
//			if (ficheOpu.getTraitement_donneuse().getTableau_pharmacie_superovulation_medicament() == null)
//			{
//				ficheOpu.getTraitement_donneuse().setTableau_pharmacie_superovulation_medicament(new ArrayList<Tableau_Pharmacie>());
//				ficheOpu.getTraitement_donneuse().getTableau_pharmacie_superovulation_medicament().add(new Tableau_Pharmacie());
//			}
//			model.addAttribute("traitementDonneuse", ficheOpu.getTraitement_donneuse());
//		}
//		model.addAttribute("operateurList", operateurService.findAllOperateur());
//		model.addAttribute("produitList", produitService.findAll());
//		model.addAttribute("nom", nom);
//
//		return "acteTechnique/opu/traitementDonneuseOpu";
//	}
//
//	@RequestMapping(value = "/traitementDonneuseOpu/{nom}", method = RequestMethod.POST)
//	public String traitementDonneuseOpu(@PathVariable String nom, @Valid Traitement_Donneuse traitement_donneuse, Errors errors, Model model)
//	{
//		if (errors.hasErrors())
//		{
//			model.addAttribute("operateurList", operateurService.findAllOperateur());
//			model.addAttribute("produitList", produitService.findAll());
//			model.addAttribute("nom", nom);
//			model.addAttribute("traitementDonneuse", traitement_donneuse);
//
//			return "/acteTechnique/opu/traitementDonneuseOpu";
//		}
//		FicheOpu ficheOpu = ficheOpuService.findByNom(nom);
//		if (ficheOpu.getTraitement_donneuse() != null)
//		{
//			Traitement_Donneuse traitement_donneuseToDelete = ficheOpu.getTraitement_donneuse();
//			ficheOpu.setTraitement_donneuse(null);
//			traitement_donneuseService.delete(traitement_donneuseToDelete);
//		}
//
//		traitement_donneuse.setFicheOpu(ficheOpu);
//		ficheOpu.setTraitement_donneuse(traitement_donneuse);
//		traitement_donneuseService.addTraitement_Donneuse(traitement_donneuse);
//
//		for (int index = 0; index < traitement_donneuse.getTableau_pharmacie().size(); index++)
//		{
//			traitement_donneuse.getTableau_pharmacie().get(index).getProduit().setQteRestante(traitement_donneuse.getTableau_pharmacie().get(index).getProduit().getQteRestante() - traitement_donneuse.getTableau_pharmacie().get(index).getQuantite());
//			produitService.updateProduit(traitement_donneuse.getTableau_pharmacie().get(index).getProduit());
//			tableau_pharmacieService.addTableau_Pharmacie(traitement_donneuse.getTableau_pharmacie().get(index));
//		}
//
//		for (int index = 0; index < traitement_donneuse.getTableau_pharmacie_superovulation_medicament().size(); index++)
//		{
//			traitement_donneuse.getTableau_pharmacie_superovulation_medicament().get(index).setTraitement_donneuseSuper(traitement_donneuse);
//			tableau_pharmacieService.addTableau_Pharmacie(traitement_donneuse.getTableau_pharmacie_superovulation_medicament().get(index));
//		}
//		return "redirect:/acteTechnique/opu/imageEchoOpu/" + nom;
//	}
//
//	@RequestMapping(value = "/imageEchoOpu/{nom}", method = RequestMethod.GET)
//	public String imageEchoOpu(@PathVariable String nom, Model model)
//	{
//		FicheOpu ficheOpu = ficheOpuService.findByNom(nom);
//
//		if (ficheOpu.getImageEcho() == null)
//		{
//			model.addAttribute("imageEcho", echoService.newEcho());
//		}
//		else
//		{
//			model.addAttribute("imageEcho", ficheOpu.getImageEcho());
//		}
//
//		model.addAttribute("nom", nom);
//
//		return "acteTechnique/opu/imageEchoOpu";
//	}
//
//	@RequestMapping(value = "/imageEchoOpu/{nom}", method = RequestMethod.POST)
//	public String imageEchoOpu(@PathVariable String nom, @Valid Echo imageEcho, Errors errors, Model model)
//	{
//		if (errors.hasErrors())
//		{
//			model.addAttribute("nom", nom);
//			return "/acteTechnique/opu/imageEchoOpu";
//		}
//		FicheOpu ficheOpu = ficheOpuService.findByNom(nom);
//		if (ficheOpu.getImageEcho() != null)
//		{
//			Echo imageEchoToDelete = ficheOpu.getImageEcho();
//			ficheOpu.setImageEcho(null);
//			echoService.delete(imageEchoToDelete);
//		}
//		imageEcho.setFicheOpu(ficheOpu);
//		ficheOpu.setImageEcho(imageEcho);
//		echoService.addEcho(imageEcho);
//		return "redirect:/acteTechnique/opu/ovocytesCollectesOpu/" + nom;
//	}
//
//	@RequestMapping(value = "/ovocytesCollectesOpu/{nom}", method = RequestMethod.GET)
//	public String ovocytesCollectesOpu(@PathVariable String nom, Model model)
//	{
//		FicheOpu ficheOpu = ficheOpuService.findByNom(nom);
//
//		if (ficheOpu.getOvocytesCollectes() == null)
//		{
//			OvocytesCollectes ovocytesCollectes = ovocytesCollectesService.newOvocytesCollectes();
//			ovocytesCollectes.setTableauOvocytes_collectesList(new ArrayList<TableauOvocytesCollectes>());
//			ovocytesCollectes.getTableauOvocytes_collectesList().add(new TableauOvocytesCollectes());
//			model.addAttribute("ovocytesCollectes", ovocytesCollectes);
//		}
//		else
//		{
//			if (ficheOpu.getCollecte().getTableauCollecteList().size() <= 0)
//			{
//				ficheOpu.getCollecte().setTableauCollecteList(new ArrayList<Tableau_Collecte>());
//				ficheOpu.getCollecte().getTableauCollecteList().add(new Tableau_Collecte());
//			}
//			model.addAttribute("ovocytesCollectes", ficheOpu.getOvocytesCollectes());
//		}
//
//		model.addAttribute("qualiteList", qualiteService.findAllQualite());
//		model.addAttribute("sanitaireList", sanitaireService.findAllSanitaire());
//		model.addAttribute("nom", nom);
//
//		return "acteTechnique/opu/ovocytesCollectesOpu";
//	}
//
//	@RequestMapping(value = "/ovocytesCollectesOpu/{nom}", method = RequestMethod.POST)
//	public String ovocytesCollectesOpu(@PathVariable String nom, @Valid OvocytesCollectes ovocytesCollectes, Errors errors, Model model)
//	{
//		if (errors.hasErrors())
//		{
//			model.addAttribute("qualiteList", qualiteService.findAllQualite());
//			model.addAttribute("sanitaireList", sanitaireService.findAllSanitaire());
//			model.addAttribute("nom", nom);
//			return "/acteTechnique/opu/ovocytesCollectesOpu";
//		}
//		FicheOpu ficheOpu = ficheOpuService.findByNom(nom);
//		if (ficheOpu.getOvocytesCollectes() != null)
//		{
//			OvocytesCollectes ovocytesCollectesToDelete = ficheOpu.getOvocytesCollectes();
//			ficheOpu.setOvocytesCollectes(null);
//			ovocytesCollectesService.delete(ovocytesCollectesToDelete);
//		}
//
//		ovocytesCollectes.setFicheOpu(ficheOpu);
//		ficheOpu.setOvocytesCollectes(ovocytesCollectes);
//		ovocytesCollectesService.addOvocytesCollectes(ovocytesCollectes);
//
//		for (int i = 0; i < ovocytesCollectes.getTableauOvocytes_collectesList().size(); i++)
//		{
//			ovocytesCollectes.getTableauOvocytes_collectesList().get(i).setOvocytes_collectes(ovocytesCollectes);
//			tableauOvocytesCollectesService.addTableauOvocytes_Collectes(ovocytesCollectes.getTableauOvocytes_collectesList().get(i));
//		}
//
//		return "redirect:/acteTechnique/opu/infoGeneralOpu/" + nom;
//	}
//
//	@RequestMapping(value = "/infoGeneralOpu/{nom}", method = RequestMethod.GET)
//	public String infoGeneralOpu(@PathVariable String nom, Model model)
//	{
//		FicheOpu ficheOpu = ficheOpuService.findByNom(nom);
//
//		if (ficheOpu.getInformations_piv() == null)
//		{
//			model.addAttribute("infoPIV", informationsPIVService.newInfoPIV());
//		}
//		else
//		{
//			model.addAttribute("infoPIV", ficheOpu.getInformations_piv());
//		}
//
//		model.addAttribute("operateurList", operateurService.findAllOperateur());
//		model.addAttribute("milieu_maturationList", milieuMaturationService.findAllMilieuMaturation());
//		model.addAttribute("milieu_fivList", fivService.findAllFIV());
//		model.addAttribute("milieu_cultureList", typeCultureService.findAllTypeCulture());
//		model.addAttribute("nom", nom);
//
//		return "acteTechnique/opu/infoGeneralOpu";
//	}
//
//	@RequestMapping(value = "/infoGeneralOpu/{nom}", method = RequestMethod.POST)
//	public String infoGeneralOpu(@PathVariable String nom, @Valid Informations_PIV informations_piv, Errors errors, Model model)
//	{
//		if (errors.hasErrors())
//		{
//			model.addAttribute("operateurList", operateurService.findAllOperateur());
//			model.addAttribute("milieu_maturationList", milieuMaturationService.findAllMilieuMaturation());
//			model.addAttribute("milieu_fivList", fivService.findAllFIV());
//			model.addAttribute("milieu_cultureList", typeCultureService.findAllTypeCulture());
//			model.addAttribute("nom", nom);
//			return "acteTechnique/opu/infoGeneralOpu";
//		}
//		FicheOpu ficheOpu = ficheOpuService.findByNom(nom);
//		if (ficheOpu.getInformations_piv() != null)
//		{
//			Informations_PIV informations_pivToDelete = ficheOpu.getInformations_piv();
//			ficheOpu.setInformations_piv(null);
//			for (int index = 0; index < informations_pivToDelete.getOperateurList().size(); index++)
//			{
//				informations_pivToDelete.getOperateurList().get(index).getInformations_pivList().remove(informations_pivToDelete);
//			}
//			informations_pivToDelete.setOperateurList(null);
//			informationsPIVService.delete(informations_pivToDelete);
//		}
//		informations_piv.setFicheOpu(ficheOpu);
//		ficheOpu.setInformations_piv(informations_piv);
//		for (int i = 0; i < informations_piv.getOperateurList().size(); i++)
//		{
//			informations_piv.getOperateurList().get(i).getInformations_pivList().add(informations_piv);
//		}
//		informationsPIVService.addInformation_PIV(informations_piv);
//		return "redirect:/acteTechnique/opu/collecteMaturationOpu/" + nom;
//	}
//
//	@RequestMapping(value = "/collecteMaturationOpu/{nom}", method = RequestMethod.GET)
//	public String collecteMaturationOpu(@PathVariable String nom, Model model)
//	{
//		FicheOpu ficheOpu = ficheOpuService.findByNom(nom);
//
//		if (ficheOpu.getCollecte() == null)
//		{
//			Collecte collecte = collecteService.newCollecte();
//			collecte.setTableauCollecteList(new ArrayList<Tableau_Collecte>());
//			collecte.getTableauCollecteList().add(new Tableau_Collecte());
//			model.addAttribute("collecte", collecte);
//		}
//		else
//		{
//			if (ficheOpu.getCollecte().getTableauCollecteList().size() <= 0)
//			{
//				ficheOpu.getCollecte().setTableauCollecteList(new ArrayList<Tableau_Collecte>());
//				ficheOpu.getCollecte().getTableauCollecteList().add(new Tableau_Collecte());
//			}
//			model.addAttribute("collecte", ficheOpu.getCollecte());
//		}
//
//		model.addAttribute("vacheList", vacheService.findAllVache());
//		model.addAttribute("nom", nom);
//
//		return "acteTechnique/opu/collecteMaturationOpu";
//	}
//
//	@RequestMapping(value = "/collecteMaturationOpu/{nom}", method = RequestMethod.POST)
//	public String collecteMaturatioOpu(@PathVariable String nom, @Valid Collecte collecte, Errors errors, Model model)
//	{
//		if (errors.hasErrors())
//		{
//			model.addAttribute("vacheList", vacheService.findAllVache());
//			model.addAttribute("nom", nom);
//			return "acteTechnique/opu/collecteMaturationOpu";
//		}
//		FicheOpu ficheOpu = ficheOpuService.findByNom(nom);
//		if (ficheOpu.getCollecte() != null)
//		{
//			Collecte collecteToDelete = ficheOpu.getCollecte();
//			ficheOpu.setCollecte(null);
//			collecteService.delete(collecteToDelete);
//		}
//		collecte.setFicheOpu(ficheOpu);
//		ficheOpu.setCollecte(collecte);
//		collecteService.addCollecte(collecte);
//		for (int i = 0; i < collecte.getTableauCollecteList().size(); i++)
//		{
//			collecte.getTableauCollecteList().get(i).setCollecte(collecte);
//			tableauCollecteService.addTableauCollecte(collecte.getTableauCollecteList().get(i));
//		}
//		return "redirect:/acteTechnique/opu/fecondationInVitroOpu/" + nom;
//	}
//
//	@RequestMapping(value = "/fecondationInVitroOpu/{nom}", method = RequestMethod.GET)
//	public String fecondationInVitroOpu(@PathVariable String nom, Model model)
//	{
//		FicheOpu ficheOpu = ficheOpuService.findByNom(nom);
//
//		if (ficheOpu.getFecondation() == null)
//		{
//			Fecondation fecondation = fecondationService.newFecondation();
//			fecondation.setTableau_semences(new ArrayList<TableauSemence>());
//			fecondation.getTableau_semences().add(new TableauSemence());
//			model.addAttribute("fecondationInvitro", fecondation);
//		}
//		else
//		{
//			if (ficheOpu.getFecondation().getTableau_semences().size() <= 0)
//			{
//				ficheOpu.getFecondation().setTableau_semences(new ArrayList<TableauSemence>());
//				ficheOpu.getFecondation().getTableau_semences().add(new TableauSemence());
//			}
//			model.addAttribute("fecondationInvitro", ficheOpu.getFecondation());
//		}
//
//		model.addAttribute("taureauList", vacheService.findAllTaureau());
//		model.addAttribute("sanitaireList", sanitaireService.findAllSanitaire());
//		model.addAttribute("nom", nom);
//
//		return "acteTechnique/opu/fecondationInVitroOpu";
//	}
//
//	@RequestMapping(value = "/fecondationInVitroOpu/{nom}", method = RequestMethod.POST)
//	public String fecondationInVitroOpu(@PathVariable String nom, @Valid Fecondation fecondationInvitro, Errors errors, Model model)
//	{
//		if (errors.hasErrors())
//		{
//			model.addAttribute("taureauList", vacheService.findAllTaureau());
//			model.addAttribute("sanitaireList", sanitaireService.findAllSanitaire());
//			model.addAttribute("fecondationInvitro", fecondationInvitro);
//			model.addAttribute("nom", nom);
//			return "acteTechnique/opu/fecondationInVitroOpu";
//		}
//		Vache vacheTrouve;
//		FicheOpu ficheOpu = ficheOpuService.findByNom(nom);
//		if (ficheOpu.getFecondation() != null)
//		{
//			Fecondation fecondationToDelete = ficheOpu.getFecondation();
//			ficheOpu.setFecondation(null);
//			for (int index = 0; index < fecondationToDelete.getSanitaireList().size(); index++)
//			{
//				fecondationToDelete.getSanitaireList().get(index).getFecondationList().remove(fecondationToDelete);
//			}
//			fecondationToDelete.setSanitaireList(null);
//			fecondationService.delete(fecondationToDelete);
//		}
//		fecondationInvitro.setFicheOpu(ficheOpu);
//		ficheOpu.setFecondation(fecondationInvitro);
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
//		return "redirect:/acteTechnique/opu/cultureInVitroOpu/" + nom;
//	}
//
//	@RequestMapping(value = "/cultureInVitroOpu/{nom}", method = RequestMethod.GET)
//	public String cultureInVitroOpu(@PathVariable String nom, Model model)
//	{
//		FicheOpu ficheOpu = ficheOpuService.findByNom(nom);
//
//		if (ficheOpu.getCulture() == null)
//		{
//			Culture culture = cultureService.newCulture();
//			culture.setTableauCultureList(new ArrayList<TableauCulture>());
//			culture.getTableauCultureList().add(new TableauCulture());
//			model.addAttribute("cultureInVitro", culture);
//		}
//		else
//		{
//			if (ficheOpu.getCulture().getTableauCultureList().size() <= 0)
//			{
//				ficheOpu.getCulture().setTableauCultureList(new ArrayList<TableauCulture>());
//				ficheOpu.getCulture().getTableauCultureList().add(new TableauCulture());
//			}
//			model.addAttribute("cultureInVitro", ficheOpu.getCulture());
//		}
//
//		model.addAttribute("destinationCulture", destinationCultureService.findAllDestinationCulture());
//		model.addAttribute("sanitaireList", sanitaireService.findAllSanitaire());
//		model.addAttribute("nom", nom);
//
//		return "acteTechnique/opu/cultureInVitroOpu";
//	}
//
//	@RequestMapping(value = "/cultureInVitroOpu/{nom}", method = RequestMethod.POST)
//	public String cultureInVitroOpu(@PathVariable String nom, @Valid Culture culture, Errors errors, Model model)
//	{
//		if (errors.hasErrors())
//		{
//			model.addAttribute("destinationCulture", destinationCultureService.findAllDestinationCulture());
//			model.addAttribute("sanitaireList", sanitaireService.findAllSanitaire());
//			model.addAttribute("cultureInVitro", culture);
//
//			model.addAttribute("nom", nom);
//			return "acteTechnique/opu/cultureInVitroOpu";
//		}
//		FicheOpu ficheOpu = ficheOpuService.findByNom(nom);
//		if (ficheOpu.getCulture() != null)
//		{
//			Culture cultureToDelete = ficheOpu.getCulture();
//			ficheOpu.setCulture(null);
//			for (int index = 0; index < cultureToDelete.getSanitaireList().size(); index++)
//			{
//				cultureToDelete.getSanitaireList().get(index).getCultureList().remove(cultureToDelete);
//			}
//			cultureToDelete.setSanitaireList(null);
//			cultureService.delete(cultureToDelete);
//		}
//		culture.setFicheOpu(ficheOpu);
//		ficheOpu.setCulture(culture);
//		cultureService.addCulture(culture);
//		for (int i = 0; i < culture.getTableauCultureList().size(); i++)
//		{
//			culture.getTableauCultureList().get(i).setCulture(culture);
//			tableauCultureService.addTableauCulture(culture.getTableauCultureList().get(i));
//		}
//		return "redirect:/acteTechnique/opu/infoSiCryoOpu/" + nom;
//	}
//
//	@RequestMapping(value = "/infoSiCryoOpu/{nom}", method = RequestMethod.GET)
//	public String infoSiCryoOpu(@PathVariable String nom, Model model)
//	{
//		FicheOpu ficheOpu = ficheOpuService.findByNom(nom);
//
//		int nbLigneCryo = 0;
//		List<TableauCulture> tableauCultureList = ficheOpu.getCulture().getTableauCultureList();
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
//			if (ficheOpu.getCryoconservation() == null)
//			{
//				model.addAttribute("cryoconservation", cryoconservationService.newCryoconservation());
//			}
//			else
//			{
//				model.addAttribute("cryoconservation", ficheOpu.getCryoconservation());
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
//			return "acteTechnique/opu/infoSiCryoOpu";
//		}
//		return "redirect:/";
//
//	}
//
//	@RequestMapping(value = "/infoSiCryoOpu/{nom}", method = RequestMethod.POST)
//	public String infoSiCryoOpu(@PathVariable String nom, @Valid Cryoconservation cryoconservation, Errors errors, Model model)
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
//			return "acteTechnique/opu/infoSiCryoOpu";
//		}
//		FicheOpu ficheOpu = ficheOpuService.findByNom(nom);
//		if (ficheOpu.getCryoconservation() != null)
//		{
//			Cryoconservation cryoconservationToDelete = ficheOpu.getCryoconservation();
//			ficheOpu.setCryoconservation(null);
//			cryoconservationService.delete(cryoconservationToDelete);
//		}
//		cryoconservation.setFicheOpu(ficheOpu);
//		ficheOpu.setCryoconservation(cryoconservation);
//		cryoconservationService.addCryoconservation(cryoconservation);
//		for (int i = 0; i < cryoconservation.getTableauDetailList().size(); i++)
//		{
//			cryoconservation.getTableauDetailList().get(i).setCryoconservation(cryoconservation);
//			tableauDetailService.addTableauDetail(cryoconservation.getTableauDetailList().get(i));
//		}
//		return "redirect:/";
//	}
//
//	@RequestMapping(value = "/consultation", method = RequestMethod.GET)
//	public String consultation(Model model)
//	{
//		model.addAttribute("ficheOpu", ficheOpuService.newFicheOpu());
//		model.addAttribute("ficheOpuList", ficheOpuService.findAllFicheOpu());
//		return "acteTechnique/opu/consultation/consultation";
//	}
//
//	@RequestMapping(value = "/consultation", method = RequestMethod.POST)
//	public String consultation(@ModelAttribute FicheOpu ficheOpu, Model model)
//	{
//		ficheOpu = ficheOpuService.findByNom(ficheOpu.getNom());
//
//		if (ficheOpu.getFiche() == null)
//		{
//			model.addAttribute("fiche", headerService.newHeader());
//		}
//		else
//		{
//			model.addAttribute("fiche", ficheOpu.getFiche());
//		}
//
//		if (ficheOpu.getVache() == null)
//		{
//			model.addAttribute("vache", vacheService.newVache());
//		}
//		else
//		{
//			model.addAttribute("vache", ficheOpu.getVache());
//		}
//
//		if (ficheOpu.getTraitement_donneuse() == null)
//		{
//			model.addAttribute("traitementDonneuse", traitement_donneuseService.newTraitementDonneuse());
//		}
//		else
//		{
//			model.addAttribute("traitementDonneuse", ficheOpu.getTraitement_donneuse());
//		}
//
//		if (ficheOpu.getImageEcho() == null)
//		{
//			model.addAttribute("imageEcho", echoService.newEcho());
//		}
//		else
//		{
//			model.addAttribute("imageEcho", ficheOpu.getImageEcho());
//		}
//
//		if (ficheOpu.getOvocytesCollectes() == null)
//		{
//			model.addAttribute("ovocytesCollectes", ovocytesCollectesService.newOvocytesCollectes());
//		}
//		else
//		{
//			model.addAttribute("ovocytesCollectes", ficheOpu.getOvocytesCollectes());
//		}
//
//		if (ficheOpu.getInformations_piv() == null)
//		{
//			model.addAttribute("infoPIV", informationsPIVService.newInfoPIV());
//		}
//		else
//		{
//			model.addAttribute("infoPIV", ficheOpu.getInformations_piv());
//		}
//
//		if (ficheOpu.getCollecte() == null)
//		{
//			model.addAttribute("collecte", collecteService.newCollecte());
//		}
//		else
//		{
//			model.addAttribute("collecte", ficheOpu.getCollecte());
//		}
//
//		if (ficheOpu.getFecondation() == null)
//		{
//			model.addAttribute("fecondationInvitro", fecondationService.newFecondation());
//		}
//		else
//		{
//			model.addAttribute("fecondationInvitro", ficheOpu.getFecondation());
//		}
//
//		if (ficheOpu.getCulture() == null)
//		{
//			model.addAttribute("cultureInVitro", cultureService.newCulture());
//		}
//		else
//		{
//			model.addAttribute("cultureInVitro", ficheOpu.getCulture());
//		}
//
//		if (ficheOpu.getCryoconservation() == null)
//		{
//			model.addAttribute("cryoconservation", cryoconservationService.newCryoconservation());
//		}
//		else
//		{
//			model.addAttribute("cryoconservation", ficheOpu.getCryoconservation());
//		}
//
//		return "acteTechnique/opu/consultation/consultationOpu";
//	}
//
//	@RequestMapping(value = "/consultation/{nom}", method = RequestMethod.GET)
//	public String consultation(@PathVariable String nom, Model model)
//	{
//		FicheOpu ficheOpu = ficheOpuService.findByNom(nom);
//
//		if (ficheOpu.getFiche() == null)
//		{
//			model.addAttribute("fiche", headerService.newHeader());
//		}
//		else
//		{
//			model.addAttribute("fiche", ficheOpu.getFiche());
//		}
//
//		if (ficheOpu.getVache() == null)
//		{
//			model.addAttribute("vache", vacheService.newVache());
//		}
//		else
//		{
//			model.addAttribute("vache", ficheOpu.getVache());
//		}
//
//		if (ficheOpu.getTraitement_donneuse() == null)
//		{
//			model.addAttribute("traitementDonneuse", traitement_donneuseService.newTraitementDonneuse());
//		}
//		else
//		{
//			model.addAttribute("traitementDonneuse", ficheOpu.getTraitement_donneuse());
//		}
//
//		if (ficheOpu.getImageEcho() == null)
//		{
//			model.addAttribute("imageEcho", echoService.newEcho());
//		}
//		else
//		{
//			model.addAttribute("imageEcho", ficheOpu.getImageEcho());
//		}
//
//		if (ficheOpu.getOvocytesCollectes() == null)
//		{
//			model.addAttribute("ovocytesCollectes", ovocytesCollectesService.newOvocytesCollectes());
//		}
//		else
//		{
//			model.addAttribute("ovocytesCollectes", ficheOpu.getOvocytesCollectes());
//		}
//
//		if (ficheOpu.getInformations_piv() == null)
//		{
//			model.addAttribute("infoPIV", informationsPIVService.newInfoPIV());
//		}
//		else
//		{
//			model.addAttribute("infoPIV", ficheOpu.getInformations_piv());
//		}
//
//		if (ficheOpu.getCollecte() == null)
//		{
//			model.addAttribute("collecte", collecteService.newCollecte());
//		}
//		else
//		{
//			model.addAttribute("collecte", ficheOpu.getCollecte());
//		}
//
//		if (ficheOpu.getFecondation() == null)
//		{
//			model.addAttribute("fecondationInvitro", fecondationService.newFecondation());
//		}
//		else
//		{
//			model.addAttribute("fecondationInvitro", ficheOpu.getFecondation());
//		}
//
//		if (ficheOpu.getCulture() == null)
//		{
//			model.addAttribute("cultureInVitro", cultureService.newCulture());
//		}
//		else
//		{
//			model.addAttribute("cultureInVitro", ficheOpu.getCulture());
//		}
//
//		if (ficheOpu.getCryoconservation() == null)
//		{
//			model.addAttribute("cryoconservation", cryoconservationService.newCryoconservation());
//		}
//		else
//		{
//			model.addAttribute("cryoconservation", ficheOpu.getCryoconservation());
//		}
//
//		return "acteTechnique/opu/consultation/consultationOpu";
//	}
//
//	@RequestMapping(value = "/modification", method = RequestMethod.GET)
//	public String modification(Model model)
//	{
//		model.addAttribute("ficheOpu", ficheOpuService.newFicheOpu());
//		model.addAttribute("ficheOpuList", ficheOpuService.findAllFicheOpu());
//		return "acteTechnique/opu/modification";
//	}
//
//	@RequestMapping(value = "/modification", method = RequestMethod.POST)
//	public String modification(@ModelAttribute FicheOpu ficheOpu)
//	{
//		return "redirect:/acteTechnique/opu/enteteOpu/" + ficheOpu.getNom();
//	}
//}
