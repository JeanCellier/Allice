package phenotypage.model.corpsJaune;

import phenotypage.model.donneExistante.qualite.Qualite;

import java.util.List;

/**
 * @author fabien
 */
public interface CorpsJauneService
{
	List<CorpsJaune> findAllCorpsJaune();

	CorpsJaune createCorpsJaune(boolean palpation, String mode_evaluation, boolean imageEcho, boolean coteCorpsJaune, Qualite qualite);

	CorpsJaune addCorpsJaune(CorpsJaune corpsJaune);

	CorpsJaune newCorpsJaune();

	void delete(CorpsJaune corpsJauneToDelete);
}
