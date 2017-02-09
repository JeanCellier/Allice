package phenotypage.model.gestation;

import java.util.List;

public interface Tableau_GestationService
{
	List<Tableau_Gestation> findAllTableauGestation();

	Tableau_Gestation newTableauGestation();

	Tableau_Gestation addTableauGestation(Tableau_Gestation tableau_gestation);
}
