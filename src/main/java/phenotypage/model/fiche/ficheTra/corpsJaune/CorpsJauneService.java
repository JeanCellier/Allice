package phenotypage.model.fiche.ficheTra.corpsJaune;


/**
 * @author fabien
 */
public interface CorpsJauneService
{
	CorpsJaune createCorpsJaune(String mode_evaluation, boolean imageEcho, char coteCorpsJaune, int qualite);

	CorpsJaune createCorpsJaune(CorpsJaune corpsJaune);

	void delete(CorpsJaune corpsJauneToDelete);

	CorpsJaune save(CorpsJaune corpsJaune);

	CorpsJaune update(CorpsJaune corpsJaune, String mode_evaluation, int qualite, char coteCorpsJaune);
}
