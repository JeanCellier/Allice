//package phenotypage.importation.ficher;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import phenotypage.importation.poi.Poi_Excel;
//import phenotypage.model.cryoconservation.Cryoconservation;
//import phenotypage.model.cryoconservation.CryoconservationService;
//import phenotypage.model.fiche.ficheAba.abattoir.Abattoir;
//import phenotypage.model.fiche.ficheAba.abattoir.AbattoirService;
//import phenotypage.model.informationsPIV.fiv.FIV;
//import phenotypage.model.informationsPIV.fiv.FIVService;
//import phenotypage.model.operateur.Operateur;
//import phenotypage.model.operateur.OperateurService;
//import phenotypage.model.programme.Programme;
//import phenotypage.model.programme.ProgrammeService;
//import phenotypage.model.informationsPIV.typeCulture.TypeCulture;
//import phenotypage.model.informationsPIV.typeCulture.TypeCultureService;
//import phenotypage.model.fiche.ficheAba.FicheAba;
//import phenotypage.model.fiche.ficheAba.FicheAbaService;
//import phenotypage.model.informationsPIV.Informations_PIV;
//import phenotypage.model.informationsPIV.Informations_PIVService;
//import phenotypage.model.invitro.culture.Culture;
//import phenotypage.model.invitro.culture.CultureService;
//import phenotypage.model.invitro.culture.tableauCulture.TableauCulture;
//import phenotypage.model.invitro.fecondation.Fecondation;
//import phenotypage.model.invitro.fecondation.FecondationService;
//import phenotypage.model.invitro.fecondation.tableauSemence.TableauSemence;
//import phenotypage.model.informationsPIV.milieuMaturation.MilieuMaturation;
//import phenotypage.model.informationsPIV.milieuMaturation.MilieuMaturationService;
//import phenotypage.model.vache.Vache;
//import phenotypage.model.vache.VacheService;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
///**
// * Created by Alex on 16/5/18.
// */
//@Component
//public class importABA
//{
//	@Autowired
//	OperateurService operateurService;
//
//	@Autowired
//	ProgrammeService programmeService;
//
//	@Autowired
//	AbattoirService abattoirService;
//
//	@Autowired
//	MilieuMaturationService milieuMaturationService;
//
//	@Autowired
//	FIVService fivService;
//
//	@Autowired
//	TypeCultureService typeCultureService;
//
//	@Autowired
//	CultureService cultureService;
//
//	@Autowired
//	Informations_PIVService informations_pivService;
//
//	@Autowired
//	FicheAbaService ficheAbaService;
//
//	@Autowired
//	CryoconservationService cryoconservationService;
//
//	@Autowired
//	FecondationService fecondationService;
//
//	@Autowired
//	private VacheService vacheService;
//
//	public void importABA(String _url)
//	{
//		FicheAba ficheAba = ficheAbaService.createFichieAba(Calendar.getInstance().get(Calendar.YEAR) + "ABA-" + ficheAbaService.countFicheAba());
//
//		//read fiche
//		Poi_Excel.readExcel(_url, 3, 7);
//		Poi_Excel.readExcel(_url, 4, 6);
//		Operateur oper = operateurService.findOperateurByNom(Poi_Excel.readExcel(_url, 4, 3));
//		String nomProgramme = Poi_Excel.readExcel(_url, 3, 1);
//		Programme pro = programmeService.findByNom(nomProgramme);
//		if (pro == null)
//		{
//			pro = programmeService.createProgramme(nomProgramme);
//		}
//		String nomAbattoir = Poi_Excel.readExcel(_url, 4, 1);
//		Abattoir abattoir = abattoirService.findByNom(nomAbattoir);
//		if (abattoir == null)
//		{
//			abattoir = abattoirService.createAbattoir(nomAbattoir);
//		}
//
//		/*Fiche fiche = new Fiche(oper, pro, Poi_Excel.readExcel(_url, 3, 4), abattoir);
//		headerService.addHeader(fiche);
//		ficheAba.setFiche(fiche);*/
//
//		//Millieu maturation
//		String nomMilieuMaturation = Poi_Excel.readExcel(_url, 9, 1);
//		String numeroLotMilieuMaturation = Poi_Excel.readExcel(_url, 9, 2);
//		MilieuMaturation milieuMaturation = milieuMaturationService.finByNom(nomMilieuMaturation);
//		if (milieuMaturation == null)
//		{
//			milieuMaturation = milieuMaturationService.createMilieuMaturation(nomMilieuMaturation, numeroLotMilieuMaturation);
//		}
//
//		String nomFIV = Poi_Excel.readExcel(_url, 10, 1);
//		String numeroFIV = Poi_Excel.readExcel(_url, 10, 2);
//		FIV fiv = fivService.findByNom(nomFIV);
//		if (fiv == null)
//		{
//			fiv = fivService.createFIV(nomFIV, numeroFIV);
//		}
//
//		String nomTypeCulture = Poi_Excel.readExcel(_url, 11, 1);
//		String numeroTypeCulture = Poi_Excel.readExcel(_url, 11, 2);
//		TypeCulture typeCulture = typeCultureService.findByNom(nomTypeCulture);
//		if (typeCulture == null)
//		{
//			typeCulture = typeCultureService.createTypeCulture(nomTypeCulture, numeroTypeCulture);
//		}
//
//		String operateurTotal = Poi_Excel.readExcel(_url, 7, 1);
//		String prenomoperateur = operateurTotal.split(" ")[0];
//		String nomOperateur = operateurTotal.split(" ")[1];
//		Operateur operateur = operateurService.findOperateurByNom(nomOperateur);
//		if (operateur == null)
//		{
//			operateur = operateurService.createOperateur(nomOperateur, prenomoperateur);
//		}
//		List<Operateur> list = new ArrayList<Operateur>();
//		list.add(operateur);
//
//		Informations_PIV informations_piv = new Informations_PIV();
//		informations_pivService.addInformation_PIV(informations_piv);
//		ficheAba.setInformations_piv(informations_piv);
//
//		//IMPORT CULTURE
//		Culture culture = cultureService.newCulture();
//		String culture_date = Poi_Excel.readExcel(_url, 48, 1);
//		String[] dateString = culture_date.split("/");
//		Date date = new Date(Long.parseLong(dateString[0] + dateString[1] + dateString[2]));
//		culture.setDate(date);
//		List<TableauCulture> tableauCultureList = new ArrayList<TableauCulture>();
//
//		//A faire Sanitaire
//		//A faire remarque
//
//		/*Tableau Culture*/
//		boolean stop = true;
//		int start = 52;
//		while (stop)
//		{
//			String groupe = Poi_Excel.readExcel(_url, start, 0);
//			if (groupe.equals(""))
//			{
//				stop = false;
//			}
//			else
//			{
//				String nbdovo = Poi_Excel.readExcel(_url, start, 1);
//				String cultureHeure = Poi_Excel.readExcel(_url, start, 2);
//				String nbseg = Poi_Excel.readExcel(_url, start, 3);
//				String seg = Poi_Excel.readExcel(_url, start, 4);
//				String j5 = Poi_Excel.readExcel(_url, start, 5);
//				String mo = Poi_Excel.readExcel(_url, start + 1, 1);
//				String BL = Poi_Excel.readExcel(_url, start + 1, 2);
//				String BE = Poi_Excel.readExcel(_url, start + 1, 3);
//				String Q1 = Poi_Excel.readExcel(_url, start + 1, 4);
//				String nbTotal = Poi_Excel.readExcel(_url, start + 1, 5);
//				String J7 = Poi_Excel.readExcel(_url, start + 2, 1);
//				String BEJ7 = Poi_Excel.readExcel(_url, start + 2, 2);
//				String Q1J7 = Poi_Excel.readExcel(_url, start + 2, 3);
//				String NB = Poi_Excel.readExcel(_url, start + 2, 4);
//				String J8 = Poi_Excel.readExcel(_url, start + 2, 5);
//				String destination = Poi_Excel.readExcel(_url, start + 2, 5);
//				boolean siCryo = false;
//				if (destination.equals("cryo"))
//				{
//					siCryo = true;
//				}
////				TableauCulture tableauCulture = new TableauCulture(groupe,
////						Integer.parseInt(nbdovo),
////						Integer.parseInt(cultureHeure),
////						Integer.parseInt(nbseg),
////						Float.parseFloat(seg),
////						Integer.parseInt(j5),
////						Integer.parseInt(mo),
////						Integer.parseInt(BL),
////						Integer.parseInt(BE),
////						Integer.parseInt(BE),
////						Integer.parseInt(Q1),
////						Integer.parseInt(nbTotal),
////						Float.parseFloat(J7),
////						Float.parseFloat(BEJ7),
////						Float.parseFloat(Q1J7),
////						Integer.parseInt(NB),
////						Integer.parseInt(J8),
////						siCryo);
//				//tableauCultureList.add(tableauCulture);
//			}
//			start++;
//		}
//		culture.setTableauCultureList(tableauCultureList);
//		cultureService.addCulture(culture);
//		ficheAba.setCulture(culture);
//
//		//ficheAba setFecondation
//		Fecondation fecondation = fecondationService.newFecondation();
//		String fecon_date = Poi_Excel.readExcel(_url, 32, 1);
//		dateString = fecon_date.split("/");
//		date = new Date(Long.parseLong(dateString[0] + dateString[1] + dateString[2]));
//		fecondation.setDate(date);
//		List<TableauSemence> tableauSemenceList = new ArrayList<TableauSemence>();
//
//		//A faire Sanitaire
//		//A faire remarque
//
//		/*Tableau EmbryonsInVitro*/
//		start = 35;
//		stop = true;
//		while (stop)
//		{
//			String nomTaureau = Poi_Excel.readExcel(_url, start, 1);
//			if (nomTaureau.equals(""))
//			{
//				stop = false;
//			}
//			else
//			{
//				TableauSemence tableauSemence = new TableauSemence();
//				String race = Poi_Excel.readExcel(_url, start, 2);
//				String numeroEja = Poi_Excel.readExcel(_url, start, 3);
//				String etat = Poi_Excel.readExcel(_url, start, 4);
//				String Volfiv = Poi_Excel.readExcel(_url, start, 5);
//				String nn = Poi_Excel.readExcel(_url, start, 6);
//
//				tableauSemence.setVolume(Float.parseFloat(Volfiv));
//				tableauSemence.setNumeroEjaculation(numeroEja);
//				//tableauSemence.setEtatFrais(etat);
//				Vache taureau = vacheService.findByNum_identification(nn);
//				if (taureau == null)
//				{
//					taureau = vacheService.createVache("", "", nn, 0, Integer.parseInt(race));
//				}
//				tableauSemence.setTaureau(taureau);
//				tableauSemenceList.add(tableauSemence);
//			}
//			start++;
//		}
//		fecondation.setTableau_semences(tableauSemenceList);
//		fecondationService.addFecondation(fecondation);
//		ficheAba.setFecondation(fecondation);
//
//		ficheAbaService.addFicheAba(ficheAba);
//	}
//
//	public int importInfoPIV(String _url)
//	{
//		String oper = Poi_Excel.readExcel(_url, 7, 1);
//		String prenom = oper.split(" ")[0];
//		String nom = oper.split(" ")[1];
//
//		MilieuMaturation milieuMaturation = milieuMaturationService.createMilieuMaturation(Poi_Excel.readExcel(_url, 9, 1), Poi_Excel.readExcel(_url, 9, 2));
//		milieuMaturationService.addMilieuMaturation(milieuMaturation);
//		FIV fiv = fivService.createFIV(Poi_Excel.readExcel(_url, 10, 1), Poi_Excel.readExcel(_url, 10, 2));
//		fivService.addFIV(fiv);
//		//TypeCulture typeCulture = new TypeCulture(Poi_Excel.readExcel(_url, 11, 1), Poi_Excel.readExcel(_url, 11, 2));
//		//typeCultureService.addTypeCulture(typeCulture);
//		Operateur operateur = new Operateur();
//		List<Operateur> list = new ArrayList<Operateur>();
//		list.add(operateur);
//		//Informations_PIV informations_piv = new Informations_PIV(list, milieuMaturation, fiv, typeCulture);
//		//informations_pivService.addInformation_PIV(informations_piv);
//		//ajouter à le bdd
//		return 0;
//	}
//
//	public int importCollect_Maturation(String _url)
//	{
//
//		String collect_date = Poi_Excel.readExcel(_url, 15, 1);
//		String collect_heure = Poi_Excel.readExcel(_url, 15, 3);
//
//
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy/hhh");
//		String dateInString = collect_date + "/" + collect_heure;
//		Date date = new Date();
//
//		try
//		{
//
//			date = formatter.parse(dateInString);
//
//		}
//		catch (ParseException e)
//		{
//			e.printStackTrace();
//		}
//
//		int start = 18;
//		while (true)
//		{
//			String pool = Poi_Excel.readExcel(_url, start, 1);
//			if (pool.equals(""))
//			{
//				break;
//			}
//			String raceOvaires = Poi_Excel.readExcel(_url, start, 0);
//			String nbOvaires = Poi_Excel.readExcel(_url, start, 2);
//			String nbOvo = Poi_Excel.readExcel(_url, start, 3);
//			String tauxColl = Poi_Excel.readExcel(_url, start, 4);
//			String heureMatu = Poi_Excel.readExcel(_url, start, 5);
//			String heyreFIV = Poi_Excel.readExcel(_url, start, 6);
//			String groupMIV = Poi_Excel.readExcel(_url, start + 7, 0);
//			String nbdOvo = Poi_Excel.readExcel(_url, start + 7, 1);
//
//			start++;
//		}
//		return 0;
//	}
//
//	public int importFecon(String _url)
//	{
//		Fecondation fecondation = fecondationService.newFecondation();
//		String fecon_date = Poi_Excel.readExcel(_url, 32, 1);
//		List<TableauSemence> SeList = new ArrayList<TableauSemence>();
//		//Sanitaire
//		//remarque
//		int start = 35;
//		while (true)
//		{
//			String taureau = Poi_Excel.readExcel(_url, start, 1);
//			if (taureau.equals(""))
//			{
//				break;
//			}
//			TableauSemence tableauSemence = new TableauSemence();
//			String race = Poi_Excel.readExcel(_url, start, 2);
//			String neja = Poi_Excel.readExcel(_url, start, 3);
//			String etat = Poi_Excel.readExcel(_url, start, 4);
//			String fiv = Poi_Excel.readExcel(_url, start, 5);
//			String nn = Poi_Excel.readExcel(_url, start, 6);
//			tableauSemence.setVolume(Float.parseFloat(fiv));
//			tableauSemence.setNumeroEjaculation(neja);
//			//tableauSemence.setEtatFrais();
//			//vache
//			//EmbryonsInVitro
//			SeList.add(tableauSemence);
//
//			start++;
//		}
//		fecondation.setTableau_semences(SeList);
//
//		return 0;
//	}
//
//	public int importCulture(String _url)
//	{
//		Culture cultureS = cultureService.newCulture();
//		String culture_date = Poi_Excel.readExcel(_url, 48, 1);
//		List<TableauCulture> lIst = new ArrayList<TableauCulture>();
//
//
//		//Sanitaire
//		//remarque
//		int start = 52;
//		while (true)
//		{
//			String groupe = Poi_Excel.readExcel(_url, start, 0);
//			if (groupe.equals(""))
//			{
//				break;
//			}
//			String nbdovo = Poi_Excel.readExcel(_url, start, 1);
//			String culture = Poi_Excel.readExcel(_url, start, 2);
//			String nbseg = Poi_Excel.readExcel(_url, start, 3);
//			String seg = Poi_Excel.readExcel(_url, start, 4);
//			String j5 = Poi_Excel.readExcel(_url, start, 5);
//			String mo = Poi_Excel.readExcel(_url, start + 1, 1);
//			String BL = Poi_Excel.readExcel(_url, start + 1, 2);
//			String BE = Poi_Excel.readExcel(_url, start + 1, 3);
//			String Q1 = Poi_Excel.readExcel(_url, start + 1, 4);
//			String nbTotal = Poi_Excel.readExcel(_url, start + 1, 5);
//			String J7 = Poi_Excel.readExcel(_url, start + 2, 1);
//			String BEJ7 = Poi_Excel.readExcel(_url, start + 2, 2);
//			String Q1J7 = Poi_Excel.readExcel(_url, start + 2, 3);
//			String NB = Poi_Excel.readExcel(_url, start + 2, 4);
//			String J8 = Poi_Excel.readExcel(_url, start + 2, 5);
//			String destination = Poi_Excel.readExcel(_url, start + 2, 5);
//			boolean siCryo = false;
//			if (destination.equals("cryo"))
//			{
//				siCryo = true;
//			}
////			TableauCulture tableauCulture = new TableauCulture(groupe,
////					Integer.parseInt(nbdovo),
////					Integer.parseInt(culture),
////					Integer.parseInt(nbseg),
////					Float.parseFloat(seg),
////					Integer.parseInt(j5),
////					Integer.parseInt(mo),
////					Integer.parseInt(BL),
////					Integer.parseInt(BE),
////					Integer.parseInt(BE),
////					Integer.parseInt(Q1),
////					Integer.parseInt(nbTotal),
////					Float.parseFloat(J7),
////					Float.parseFloat(BEJ7),
////					Float.parseFloat(Q1J7),
////					Integer.parseInt(NB),
////					Integer.parseInt(J8),
////					siCryo);
////			lIst.add(tableauCulture);
//			start++;
//		}
//		cultureS.setTableauCultureList(lIst);
//
//		return 0;
//	}
//
//	public int importInfocryo(String _url)
//	{
//		Cryoconservation cryoconservation = cryoconservationService.newCryoconservation();
//		String REfe_Conge = Poi_Excel.readExcel(_url, 82, 2);
//		String Heur_Conge = Poi_Excel.readExcel(_url, 82, 6);
//		String Me_Conge = Poi_Excel.readExcel(_url, 83, 2);
//		String Conge_uti = Poi_Excel.readExcel(_url, 84, 2);
//		String Op_con = Poi_Excel.readExcel(_url, 85, 2);
//		String Des_m = Poi_Excel.readExcel(_url, 86, 2);
//
//		cryoconservation.setDescMethode(Des_m);
//		//cryoconservation.setCongelateur();
//		//cryoconservation.setType();
//		cryoconservation.setHeure(Integer.parseInt(Heur_Conge));
//		//cryoconservation.setMethodeCongelation();
//		//cryoconservation.setOperateur();
//		//cryoconservation.setMinute();
//		cryoconservationService.addCryoconservation(cryoconservation);
//
//
//		return 0;
//
//	}
//
//	public int importEmbry(String _url)
//	{
//		int start = 95;
//		while (true)
//		{
//			String nem = Poi_Excel.readExcel(_url, start, 0);
//			String stade = Poi_Excel.readExcel(_url, start, 1);
//			if (stade.equals(""))
//			{
//				break;
//			}
//			Poi_Excel.readExcel(_url, start, 2);
//			Poi_Excel.readExcel(_url, start, 3);
//			Poi_Excel.readExcel(_url, start, 4);
//			Poi_Excel.readExcel(_url, start, 5);
//			Poi_Excel.readExcel(_url, start, 6);
//			Poi_Excel.readExcel(_url, start, 7);
//			Poi_Excel.readExcel(_url, start + 20, 2);
//			Poi_Excel.readExcel(_url, start + 20, 3);
//			Poi_Excel.readExcel(_url, start + 20, 4);
//			Poi_Excel.readExcel(_url, start + 20, 5);
//			Poi_Excel.readExcel(_url, start + 20, 6);
//			Poi_Excel.readExcel(_url, start + 20, 7);
//			start++;
//			if (Poi_Excel.readExcel(_url, start, 0).equals("20"))
//			{
//				start = 142;
//			}
//		}
//		return 0;
//	}
//
//
//}
