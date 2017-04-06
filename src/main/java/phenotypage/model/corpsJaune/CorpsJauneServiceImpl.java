package phenotypage.model.corpsJaune;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.donneesExistantes.qualite.Qualite;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class CorpsJauneServiceImpl implements CorpsJauneService
{
	@Autowired
	private CorpsJauneRepository corpsJauneRepository;

	@Override
	public List<CorpsJaune> findAllCorpsJaune()
	{
		return corpsJauneRepository.findAll();
	}

	@Override
	public CorpsJaune createCorpsJaune(boolean palpation, String mode_evaluation, boolean imageEcho, boolean coteCorpsJaune, Qualite qualite)
	{
		return corpsJauneRepository.save(new CorpsJaune());
	}

	@Override
	public CorpsJaune addCorpsJaune(CorpsJaune corpsJaune)
	{
		return corpsJauneRepository.save(corpsJaune);
	}

	@Override
	public CorpsJaune newCorpsJaune()
	{
		return new CorpsJaune();
	}

	@Override
	public void delete(CorpsJaune corpsJauneToDelete)
	{
		corpsJauneRepository.delete(corpsJauneToDelete);
	}
}
