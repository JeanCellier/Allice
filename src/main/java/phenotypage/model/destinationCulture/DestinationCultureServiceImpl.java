package phenotypage.model.destinationCulture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class DestinationCultureServiceImpl implements DestinationCultureService
{
	@Autowired
	private DestinationCultureRepository destinationCultureRepository;

	@Override
	public List<DestinationCulture> findAllDestinationCulture()
	{
		return destinationCultureRepository.findAll();
	}

	@Override
	public DestinationCulture createDestinationCulture(String nom)
	{
		return destinationCultureRepository.save(new DestinationCulture());
	}

	@Override
	public DestinationCulture addDestinationCulture(DestinationCulture destinationCulture)
	{
		return destinationCultureRepository.save(destinationCulture);
	}

	@Override
	public DestinationCulture newDestinationCulture()
	{
		return new DestinationCulture();
	}

	@Override
	public DestinationCulture findByNom(String destination)
	{
		return destinationCultureRepository.findByNom(destination);
	}
}
