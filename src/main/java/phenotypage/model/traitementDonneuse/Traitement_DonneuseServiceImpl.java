package phenotypage.model.traitementDonneuse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class Traitement_DonneuseServiceImpl implements Traitement_DonneuseService
{
	@Autowired
	private Traitement_DonneuseRepository traitement_donneuseRepository;

	@Override
	public Traitement_Donneuse createTraitement_Donneuse()
	{
		return traitement_donneuseRepository.save(new Traitement_Donneuse());
	}

	@Override
	public Traitement_Donneuse addTraitement_Donneuse(Traitement_Donneuse traitement_donneuse)
	{
		return traitement_donneuseRepository.save(traitement_donneuse);
	}

	public List<Traitement_Donneuse> findAllTraitement_Donneuse()
	{
		return traitement_donneuseRepository.findAll();
	}

	@Override
	public Traitement_Donneuse findTraitement_DonneuseById(long id)
	{
		return traitement_donneuseRepository.findTraitement_DonneuseById(id);
	}

	@Override
	public Traitement_Donneuse newTraitementDonneuse()
	{
		return new Traitement_Donneuse();
	}

	@Override
	public void delete(Traitement_Donneuse traitement_donneuse)
	{
		traitement_donneuseRepository.delete(traitement_donneuse);
	}
}
