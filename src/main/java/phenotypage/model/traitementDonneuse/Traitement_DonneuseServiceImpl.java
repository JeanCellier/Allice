package phenotypage.model.traitementDonneuse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.traitementDonneuse.tableau_donneuse.Tableau_Donneuse;
import phenotypage.model.traitementDonneuse.tableau_donneuse.Tableau_DonneuseService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author fabien
 */

@Component
public class Traitement_DonneuseServiceImpl implements Traitement_DonneuseService
{
	@Autowired
	private Traitement_DonneuseRepository repository;

	@Autowired
	private Tableau_DonneuseService tableau_DonneuseService;

	@Override
	public Traitement_Donneuse createTraitement_Donneuse(Date dateRef, String typeChaleur, List<Tableau_Donneuse> tableau_donneuses){
		Traitement_Donneuse traitement_donneuse = new Traitement_Donneuse();
		traitement_donneuse.setDate_ref_chaleur(dateRef);
		traitement_donneuse.setTypeChaleur(typeChaleur);

		List<Tableau_Donneuse> tableau_donneusesSave = new ArrayList<>();

		for (Tableau_Donneuse tableau_donneuse:tableau_donneuses) {
			tableau_donneusesSave.add(tableau_DonneuseService.createTableauDonneuse(tableau_donneuse.getDate(), tableau_donneuse.getProduit(), tableau_donneuse.getQuantite(), tableau_donneuse.getMode_traitement()));
		}

		traitement_donneuse.setTableauDonneuse(tableau_donneusesSave);

		return save(traitement_donneuse);
	}

	@Override
	public Traitement_Donneuse createTraitement_Donneuse(Traitement_Donneuse traitement_donneuse) {
		List<Tableau_Donneuse> tableau_donneusesSave = new ArrayList<>();

		for (Tableau_Donneuse tableau_donneuse:traitement_donneuse.getTableauDonneuse()) {
			tableau_donneusesSave.add(tableau_DonneuseService.createTableauDonneuse(tableau_donneuse.getDate(), tableau_donneuse.getProduit(), tableau_donneuse.getQuantite(), tableau_donneuse.getMode_traitement()));
		}

		traitement_donneuse.setTableauDonneuse(tableau_donneusesSave);

		return save(traitement_donneuse);
	}

	@Override
	public Traitement_Donneuse save(Traitement_Donneuse traitement_donneuse) {
		return repository.save(traitement_donneuse);
	}

	@Override
	public void delete(Traitement_Donneuse traitementDonneuseToDelete) {
		repository.delete(traitementDonneuseToDelete);
	}
}
