package phenotypage.model.gestation;

import phenotypage.model.gestation.tableau_gestation.Tableau_Gestation;

import java.util.List;

public interface GestationService
{
	Gestation createGestation(List<Tableau_Gestation> tableauGestations, String remarques);

	Gestation createGestation(Gestation gestation);

	void delete(Gestation gestationToDelete);

	Gestation save(Gestation gestation);

    int determineStatut(Gestation gestation);
}
