package phenotypage.model.gestation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GestationServiceImpl implements GestationService
{
	@Autowired
	private GestationRepository gestationRepository;

	public List<Gestation> findAllGestation()
	{
		return gestationRepository.findAll();
	}

	@Override
	public Gestation newGestation()
	{
		return new Gestation();
	}

	@Override
	public Gestation addGestation(Gestation gestation)
	{
		return gestationRepository.save(gestation);
	}

	@Override
	public void delete(Gestation gestationToDelete)
	{
		gestationRepository.delete(gestationToDelete);
	}

}
