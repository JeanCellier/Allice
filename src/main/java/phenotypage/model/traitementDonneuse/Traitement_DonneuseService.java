package phenotypage.model.traitementDonneuse;

import phenotypage.model.traitementDonneuse.tableau_donneuse.Tableau_Donneuse;
import java.util.Date;
import java.util.List;

/**
 * @author fabien
 */
public interface Traitement_DonneuseService
{
	Traitement_Donneuse createTraitement_Donneuse(Date dateRef, String typeChaleur, List<Tableau_Donneuse> tableau_donneuses);

	Traitement_Donneuse createTraitement_Donneuse(Traitement_Donneuse traitement_donneuse);

	Traitement_Donneuse save(Traitement_Donneuse traitement_donneuse);
}
