package phenotypage.web.acteTechnique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import phenotypage.model.cryoconservation.CryoconservationService;
import phenotypage.model.cryoconservation.embryon.EmbryonService;
import phenotypage.model.fiche.ficheAba.FicheAba;
import phenotypage.model.fiche.ficheAba.FicheAbaService;
import phenotypage.model.fiche.ficheAba.abattoir.Abattoir;
import phenotypage.model.fiche.ficheAba.abattoir.AbattoirService;
import phenotypage.model.informationsPIV.Informations_PIVService;
import phenotypage.model.invitro.collecte.CollecteService;
import phenotypage.model.invitro.culture.CultureService;
import phenotypage.model.invitro.fecondation.FecondationService;
import phenotypage.model.jsonResponse.JsonResponse;
import phenotypage.model.operateur.Operateur;
import phenotypage.model.operateur.OperateurService;
import phenotypage.model.programme.Programme;
import phenotypage.model.programme.ProgrammeService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Valliere
 */

@Controller
@RequestMapping("/acteTechnique/aba")
public class AbaController
{
	@Autowired
	private ProgrammeService programmeService;

	@Autowired
	private OperateurService operateurService;

	@Autowired
	private AbattoirService abattoirService;

	@Autowired
	private Informations_PIVService informations_pivService;

	@Autowired
	private CollecteService collecteService;

	@Autowired
	private FecondationService fecondationService;

	@Autowired
	private CultureService cultureService;

	@Autowired
	private CryoconservationService cryoconservationService;

	@Autowired
	private EmbryonService embryonService;

	@Autowired
	private FicheAbaService ficheAbaService;



	/** ACCUEIL ABA **/
	@RequestMapping(value = "/aba", method = RequestMethod.GET)
	public String Aba(Model model)
	{
		model.addAttribute("programmesList", programmeService.findAll());
		model.addAttribute("operateursList", operateurService.findAll());
		model.addAttribute("abattoirsList", abattoirService.findAllAbattoir());
		model.addAttribute("informationspivList", informations_pivService.findAllInformations_PIV());
		model.addAttribute("ficheABAList", ficheAbaService.findAllFicheAba());
		return "/acteTechnique/aba/aba_consult";
	}

	/******************** ADD OR UPDATE FICHE ********************/
	@ResponseBody
	@RequestMapping(value = "/addOrUpdatePart1", method = RequestMethod.POST)
	public JsonResponse addPart1(@RequestParam("nom") String nom, @RequestParam(value="programme", required = false) Programme programme,
								 @RequestParam("numAgrement") String numAgrement, @RequestParam("temperatureArrivee") float temperatureArrivee, @RequestParam(value="date", required = false) String date,
								 @RequestParam(value="operateur", required = false) Operateur operateur,@RequestParam("abattoir") String nomabattoir){

		JsonResponse jsonResponse = new JsonResponse();

		SimpleDateFormat formatterDateTime = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		Optional<Abattoir> abattoir = abattoirService.findByNom(nomabattoir);

		if(abattoir.isPresent()){
			try {
				Date dateFiche = formatterDateTime.parse(date);

				FicheAba ficheAba = ficheAbaService.createFicheAba(nom, programme, dateFiche, numAgrement,abattoir.get(), operateur,  temperatureArrivee,  null, null, null, null,null,null);
				jsonResponse.setObjet(ficheAba);
				jsonResponse.setMessage("1ère étape enregistrée");
			} catch (ParseException e) {
				FicheAba ficheAba = ficheAbaService.createFicheAba(nom, programme, null, numAgrement,abattoir.get(), operateur,  temperatureArrivee,  null, null, null, null,null,null);
				jsonResponse.setObjet(ficheAba);
				jsonResponse.setMessage("1ère étape enregistrée - erreur dans la date");
			}
			jsonResponse.setSucces(true);

		}else{
			jsonResponse.setSucces(false);
			jsonResponse.setMessage("Le numéro d'identification de ne correspond à aucune vache");
		}
		return jsonResponse;
	}
}
