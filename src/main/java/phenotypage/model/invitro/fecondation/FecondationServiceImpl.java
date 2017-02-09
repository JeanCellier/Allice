package phenotypage.model.invitro.fecondation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FecondationServiceImpl implements FecondationService
{
	@Autowired
	private FecondationRepository fecondationRepository;

	@Override
	public Fecondation newFecondation()
	{
		return new Fecondation();
	}

	@Override
	public Fecondation addFecondation(Fecondation fecondation)
	{
		return fecondationRepository.save(fecondation);
	}

	@Override
	public void delete(Fecondation fecondation)
	{
		fecondationRepository.delete(fecondation);
	}

	public List<Fecondation> findAllFecondation()
	{
		return fecondationRepository.findAllFecondation();
	}
}
