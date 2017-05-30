package phenotypage.model.fiche.ficheAba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cryoconservation.Cryoconservation;
import phenotypage.model.cryoconservation.CryoconservationService;
import phenotypage.model.cryoconservation.embryon.Embryon;
import phenotypage.model.cryoconservation.embryon.EmbryonService;
import phenotypage.model.fiche.ficheAba.abattoir.Abattoir;
import phenotypage.model.informationsPIV.Informations_PIV;
import phenotypage.model.informationsPIV.Informations_PIVService;
import phenotypage.model.invitro.collecte.Collecte;
import phenotypage.model.invitro.collecte.CollecteService;
import phenotypage.model.invitro.culture.Culture;
import phenotypage.model.invitro.culture.CultureService;
import phenotypage.model.invitro.fecondation.Fecondation;
import phenotypage.model.invitro.fecondation.FecondationService;
import phenotypage.model.operateur.Operateur;
import phenotypage.model.programme.Programme;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fabien
 */

@Component
public class
FicheAbaServiceImpl implements FicheAbaService
{
	@Autowired
	private FicheAbaRepository ficheAbaRepository;
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


	@Override
	public List<FicheAba> findAllFicheAba()
	{
		return ficheAbaRepository.findAll();
	}

	@Override
	public FicheAba createFicheAba(String nom, Programme programme, Date date, String numAgrement, Abattoir abattoir, Operateur operateur,
								   float temperatureArrivee, Informations_PIV informations_piv, Collecte collecte, Fecondation fecondation,
								   Culture culture, Cryoconservation cryoconservation, List<Embryon> embryons)
	{
		FicheAba ficheAba = new FicheAba();

		if(informations_piv != null) {
			Informations_PIV infos = informations_pivService.addInformation_PIV(informations_piv);
			ficheAba.setInformations_piv(infos);
		}
		if(collecte != null) {
			Collecte collectes = collecteService.addCollecte(collecte);
			ficheAba.setCollecte(collectes);
		}
		if(fecondation != null) {
			Fecondation fecondations = fecondationService.addFecondation(fecondation);
			ficheAba.setFecondation(fecondations);
		}
		if(culture != null) {
			Culture cultures = cultureService.addCulture(culture);
			ficheAba.setCulture(cultures);
		}
		if(cryoconservation != null) {
		//	Cryoconservation cryoconservations = cryoconservationService.addCryoconservation(cryoconservation);
			//ficheAba.setCryoconservation(cryoconservations);
		}
		if(embryons != null) {
			List<Embryon> tableauDetailsList = new LinkedList();
			for(int i = 0; i < embryons.size(); i++)
			{
			//	tableauDetailsList.add(embryonService.addTableauDetail(embryons.get(i)));
			}
			ficheAba.setEmbryons(tableauDetailsList);
		}
		ficheAba.setNom(nom);
		ficheAba.setProgramme(programme);
		ficheAba.setDateHeureMinute(date);
		ficheAba.setNumeroAgrement(numAgrement);
		ficheAba.setAbattoir(abattoir);
		ficheAba.setOperateur(operateur);
		ficheAba.setTemperatureArrivee(temperatureArrivee);

		return ficheAbaRepository.save(ficheAba);
	}

	@Override
	public FicheAba addFicheAba(FicheAba ficheAba)
	{
		return ficheAbaRepository.save(ficheAba);
	}

	@Override
	public FicheAba newFicheAba()
	{
		return new FicheAba();
	}

	@Override
	public FicheAba findByNom(String nom)
	{
		return ficheAbaRepository.findByNom(nom);
	}

	@Override
	public long countFicheAba()
	{
		return ficheAbaRepository.count();
	}
}
