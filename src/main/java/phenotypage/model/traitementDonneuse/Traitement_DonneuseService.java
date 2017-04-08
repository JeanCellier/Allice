package phenotypage.model.traitementDonneuse;

import java.sql.Date;
import java.util.List;

/**
 * @author fabien
 */
public interface Traitement_DonneuseService
{
	Traitement_Donneuse createTraitement_Donneuse(Date dateRef, List<Tableau_Donneuse> tableau_donneuses, boolean naturel,
												  boolean ponctionFollicule, int nbFollicules, int nbDroite, int nbGauche,
												  boolean imageEcho, boolean superovulation, String typeFsh, float pourcDose);

	Traitement_Donneuse addTraitement_Donneuse(Traitement_Donneuse traitement_donneuse);

	List<Traitement_Donneuse> findAllTraitement_Donneuse();

	Traitement_Donneuse findTraitement_DonneuseById(long id);

	Traitement_Donneuse newTraitementDonneuse();

	void delete(Traitement_Donneuse traitement_donneuse);

	Traitement_Donneuse save(Traitement_Donneuse traitement_donneuse);
}
