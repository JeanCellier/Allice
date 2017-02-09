package phenotypage.model.donneExistante.sanitaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class SanitaireServiceImpl implements SanitaireService
{
	@Autowired
	private SanitaireRepository sanitaireRepository;

	@Override
	public List<Sanitaire> findAllSanitaire()
	{
		return sanitaireRepository.findAll();
	}

	@Override
	public Sanitaire createSanitaire(String nom)
	{
		return sanitaireRepository.save(new Sanitaire(nom));
	}

	@Override
	public Sanitaire addSanitaire(Sanitaire sanitaire)
	{
		return sanitaireRepository.save(sanitaire);
	}

	@Override
	public Sanitaire newSanitaire()
	{
		return new Sanitaire();
	}
}
