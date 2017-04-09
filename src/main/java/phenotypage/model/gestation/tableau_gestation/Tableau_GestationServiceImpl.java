package phenotypage.model.gestation.tableau_gestation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class Tableau_GestationServiceImpl implements Tableau_GestationService
{
	@Autowired
	private Tableau_GestationRepository repository;

	@Override
	public Tableau_Gestation createTableauGestation(Date date, String methode, String resultat) {
		Tableau_Gestation tableau_gestation = new Tableau_Gestation();
		tableau_gestation.setDate(date);
		tableau_gestation.setResultat(resultat);
		tableau_gestation.setMethode(methode);

		return save(tableau_gestation);
	}

	@Override
	public Tableau_Gestation createTableauGestation(Tableau_Gestation tableau_gestation) {
		return save(tableau_gestation);
	}

	@Override
	public Tableau_Gestation save(Tableau_Gestation tableau_Gestation) {
		return repository.save(tableau_Gestation);
	}
}
