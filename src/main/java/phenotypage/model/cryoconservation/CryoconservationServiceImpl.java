package phenotypage.model.cryoconservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CryoconservationServiceImpl implements CryoconservationService
{

	@Autowired
	private CryoconservationRepository cryoconservationRepository;

	public Cryoconservation createCryoconservation()
	{
		return cryoconservationRepository.save(new Cryoconservation());
	}

	public List<Cryoconservation> findAllCryoconservation()
	{
		return cryoconservationRepository.findAllCryoconservation();
	}

	@Override
	public Cryoconservation addCryoconservation(Cryoconservation cryoconservation)
	{
		return cryoconservationRepository.save(cryoconservation);
	}

	@Override
	public Cryoconservation newCryoconservation()
	{
		return new Cryoconservation();
	}

	@Override
	public void delete(Cryoconservation cryoconservation)
	{
		cryoconservationRepository.delete(cryoconservation);
	}

}
