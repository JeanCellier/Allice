package phenotypage.model.cryoconservation.congelateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class CongelateurServiceImpl implements CongelateurService
{
	@Autowired
	private CongelateurRepository congelateurRepository;

	@Override
	public List<Congelateur> findAllCongelateur()
	{
		return congelateurRepository.findAll();
	}

	@Override
	public Congelateur createCongelateur(String nom)
	{
		return congelateurRepository.save(new Congelateur());
	}

	@Override
	public Congelateur addCongelateur(Congelateur congelateur)
	{
		return congelateurRepository.save(congelateur);
	}

	@Override
	public Congelateur newCongelateur()
	{
		return new Congelateur();
	}
}
