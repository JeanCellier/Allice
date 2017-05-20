package phenotypage.model.fiche.ficheIa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.fiche.ficheIa.insemination.Insemination;
import phenotypage.model.fiche.ficheIa.insemination.InseminationService;
import phenotypage.model.fiche.ficheTra.FicheTra;
import phenotypage.model.gestation.Gestation;
import phenotypage.model.gestation.GestationService;
import phenotypage.model.programme.Programme;
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
FicheIaServiceImpl implements FicheIaService
{
	@Autowired
	private FicheIaRepository repository;

	@Autowired
	private InseminationService inseminationService;

	@Autowired
	private Traitement_DonneuseService traitement_donneuseService;

	@Autowired
	private GestationService gestationService;

	@Override
	public List<FicheIa> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<FicheIa> findOne(long id)  {
		return Optional.ofNullable(repository.findOne(id));
	}

	@Override
	public FicheIa save(FicheIa ficheIa) {
		return repository.save(ficheIa);
	}

	@Override
	public void delete(FicheIa ficheIa) {
		repository.delete(ficheIa);
	}

	@Override
	public FicheIa createFicheIa(String nom, Date dateFiche, String lieu, Programme programme, String numIpe, String numSemence, Vache vache, Insemination insemination, Traitement_Donneuse traitement_donneuse, Gestation gestation) {
		Traitement_Donneuse traitement = traitement_donneuseService.createTraitement_Donneuse(traitement_donneuse);
		Insemination inseminationSave = inseminationService.createInsemination(insemination);
		Gestation gestationSave = gestationService.createGestation(gestation);

		FicheIa ficheIa = new FicheIa();
		ficheIa.setNom(nom);
		ficheIa.setDateHeureMinute(dateFiche);
		ficheIa.setLieu(lieu);
		ficheIa.setProgramme(programme);
		ficheIa.setNumIpe(numIpe);
		ficheIa.setNumDepotSemence(numSemence);
		ficheIa.setVache(vache);
		ficheIa.setInsemination(inseminationSave);
		ficheIa.setTraitement_donneuse(traitement);
		ficheIa.setGestation(gestationSave);

		return save(ficheIa);
	}

	@Override
	public FicheIa updateFicheIa(FicheIa ficheIaForUpdate, String nom, Date dateFiche, String lieu, Programme programme, String numIpe, String numSemence, Vache vache, Insemination insemination, Traitement_Donneuse traitement_donneuse, Gestation gestation) {
		Traitement_Donneuse traitementDonneuseToDelete = ficheIaForUpdate.getTraitement_donneuse();
		Gestation gestationToDelete = ficheIaForUpdate.getGestation();

		ficheIaForUpdate.setNom(nom);
		ficheIaForUpdate.setNom(nom);
		ficheIaForUpdate.setDateHeureMinute(dateFiche);
		ficheIaForUpdate.setLieu(lieu);
		ficheIaForUpdate.setProgramme(programme);
		ficheIaForUpdate.setNumIpe(numIpe);
		ficheIaForUpdate.setNumDepotSemence(numSemence);
		ficheIaForUpdate.setVache(vache);
		ficheIaForUpdate.setInsemination(inseminationService.updateInsemination(insemination));
		ficheIaForUpdate.setTraitement_donneuse(traitement_donneuseService.createTraitement_Donneuse(traitement_donneuse));
		ficheIaForUpdate.setGestation(gestationService.createGestation(gestation));

		gestationService.delete(gestationToDelete);
		traitement_donneuseService.delete(traitementDonneuseToDelete);

		return save(ficheIaForUpdate);
	}

	@Override
	public FicheIa findTopByOrderByNomDesc() {
		return repository.findTopByOrderByNomDesc();
	}
}
