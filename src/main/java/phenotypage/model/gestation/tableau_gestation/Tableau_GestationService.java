package phenotypage.model.gestation.tableau_gestation;

import java.util.Date;

public interface Tableau_GestationService
{
	Tableau_Gestation createTableauGestation(Date date, String methode, String resultat);

	Tableau_Gestation createTableauGestation(Tableau_Gestation tableau_gestation);

	Tableau_Gestation save(Tableau_Gestation tableau_Gestation);
}
