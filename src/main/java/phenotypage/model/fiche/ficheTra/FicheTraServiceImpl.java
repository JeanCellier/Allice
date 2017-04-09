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
	private FicheTraRepository ficheTraRepository;

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
		return ficheTraRepository.findAll();
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
