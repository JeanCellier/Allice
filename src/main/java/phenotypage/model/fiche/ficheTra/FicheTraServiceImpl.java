package phenotypage.model.fiche.ficheTra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.fiche.ficheTra.corpsJaune.CorpsJaune;
import phenotypage.model.fiche.ficheTra.corpsJaune.CorpsJauneService;
import phenotypage.model.operateur.Operateur;
import phenotypage.model.programme.Programme;
import phenotypage.model.fiche.ficheTra.embryonsTransferes.EmbryonsTransferes;
import phenotypage.model.fiche.ficheTra.embryonsTransferes.EmbryonsTransferesService;
import phenotypage.model.gestation.Gestation;
import phenotypage.model.gestation.GestationService;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;
import phenotypage.model.traitementDonneuse.Traitement_DonneuseService;
import phenotypage.model.vache.Vache;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author fabien
 */

@Component
public class
FicheTraServiceImpl implements FicheTraService
{
	/** The repository. */
	@Autowired
	private FicheTraRepository repository;

	@Autowired
	private Traitement_DonneuseService traitement_donneuseService;

	@Autowired
	private CorpsJauneService corpsJauneService;

	@Autowired
	private EmbryonsTransferesService embryonsTransferesService;

	@Autowired
	private GestationService gestationService;

	@Override
	public List<FicheTra> findAll()
	{
		return repository.findAll();
	}

	@Override
	public FicheTra createFicheTra(String nom, Programme programme, Date date, String numAgrement, String lieu,
							   Operateur operateur, Vache vache, Traitement_Donneuse traitementDonneuse,
							   CorpsJaune corpsJaune, EmbryonsTransferes embryonsTransferes, Gestation gestation) {

		Traitement_Donneuse traitement = traitement_donneuseService.createTraitement_Donneuse(traitementDonneuse);
		CorpsJaune corpsJauneSave = corpsJauneService.createCorpsJaune(corpsJaune);
		EmbryonsTransferes embryonSave = embryonsTransferesService.createEmbryonsTransferes(embryonsTransferes);
		Gestation gestationSave = gestationService.createGestation(gestation);

		FicheTra ficheTra = new FicheTra();
		ficheTra.setNom(nom);
		ficheTra.setProgramme(programme);
		ficheTra.setDateHeureMinute(date);
		ficheTra.setNumeroAgrement(numAgrement);
		ficheTra.setLieu(lieu);
		ficheTra.setOperateur(operateur);
		ficheTra.setVache(vache);
		ficheTra.setTraitement_donneuse(traitement);
		ficheTra.setCorpsJaune(corpsJauneSave);
		ficheTra.setEmbryonsTransferes(embryonSave);
		ficheTra.setGestation(gestationSave);

		return save(ficheTra);
	}

	@Override
	public FicheTra updateFicheTra(FicheTra ficheTraForUpdate, String nom, Programme programme, Date dateFiche, String numAgrement, String lieu, Operateur operateur, Vache vache, Traitement_Donneuse traitement_donneuse, CorpsJaune corpsJaune, EmbryonsTransferes embryonsTransferes, Gestation gestation) {
		Traitement_Donneuse traitementDonneuseToDelete = ficheTraForUpdate.getTraitement_donneuse();
		Gestation gestationToDelete = ficheTraForUpdate.getGestation();
		ficheTraForUpdate.setNom(nom);
		ficheTraForUpdate.setProgramme(programme);
		ficheTraForUpdate.setDateHeureMinute(dateFiche);
		ficheTraForUpdate.setNumeroAgrement(numAgrement);
		ficheTraForUpdate.setLieu(lieu);
		ficheTraForUpdate.setOperateur(operateur);
		ficheTraForUpdate.setVache(vache);
		ficheTraForUpdate.setTraitement_donneuse(traitement_donneuseService.createTraitement_Donneuse(traitement_donneuse));
		ficheTraForUpdate.setGestation(gestationService.createGestation(gestation));

		ficheTraForUpdate.setEmbryonsTransferes(embryonsTransferesService.update(ficheTraForUpdate.getEmbryonsTransferes(), embryonsTransferes.isSemenceSexee(), embryonsTransferes.getRefExperience(), embryonsTransferes.getRefEmbryons(), embryonsTransferes.getTaureau(), embryonsTransferes.getCote(), embryonsTransferes.getEmplacementColUterine(), embryonsTransferes.getFaciliteprogression()));
		ficheTraForUpdate.setCorpsJaune(corpsJauneService.update(ficheTraForUpdate.getCorpsJaune(), corpsJaune.getMode_evaluation(), corpsJaune.getQualite(), corpsJaune.getCoteCorpsJaune()));

		gestationService.delete(gestationToDelete);
		traitement_donneuseService.delete(traitementDonneuseToDelete);

		return save(ficheTraForUpdate);
	}

	@Override
	public void delete(FicheTra ficheTra) {
		repository.delete(ficheTra);
	}

	@Override
	public Optional<FicheTra> findOne(long id) {
		return Optional.ofNullable(repository.findOne(id));
	}

	@Override
	public FicheTra save(FicheTra ficheTra) {
		return repository.save(ficheTra);
	}


}
