package phenotypage.model.fiche.ficheTra.corpsJaune;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author fabien
 */

@Component
public class CorpsJauneServiceImpl implements CorpsJauneService
{
	@Autowired
	private CorpsJauneRepository repository;

	@Override
	public CorpsJaune createCorpsJaune(String mode_evaluation, boolean imageEcho, char coteCorpsJaune, int qualite) {
		CorpsJaune corpsJaune = new CorpsJaune();
		corpsJaune.setImageEcho(imageEcho);
		corpsJaune.setQualite(qualite);
		corpsJaune.setCoteCorpsJaune(coteCorpsJaune);
		corpsJaune.setMode_evaluation(mode_evaluation);

		return save(corpsJaune);
	}

	@Override
	public CorpsJaune createCorpsJaune(CorpsJaune corpsJaune) {
		return save(corpsJaune);
	}


	@Override
	public void delete(CorpsJaune corpsJauneToDelete)
	{
		repository.delete(corpsJauneToDelete);
	}

	@Override
	public CorpsJaune save(CorpsJaune corpsJaune) {
		return repository.save(corpsJaune);
	}

	@Override
	public CorpsJaune update(CorpsJaune corpsJaune, String mode_evaluation, int qualite, char coteCorpsJaune) {
		corpsJaune.setMode_evaluation(mode_evaluation);
		corpsJaune.setQualite(qualite);
		corpsJaune.setCoteCorpsJaune(coteCorpsJaune);

		return save(corpsJaune);
	}
}
