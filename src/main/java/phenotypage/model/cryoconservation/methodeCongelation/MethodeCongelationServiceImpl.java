package phenotypage.model.cryoconservation.methodeCongelation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class MethodeCongelationServiceImpl implements MethodeCongelationService
{
	@Autowired
	private MethodeCongelationRepository methodeCongelationRepository;

	@Override
	public List<MethodeCongelation> findAllMethodeCongelation()
	{
		return methodeCongelationRepository.findAll();
	}

	@Override
	public MethodeCongelation createMethodeCongelation(String nom)
	{
		return methodeCongelationRepository.save(new MethodeCongelation());
	}

	@Override
	public MethodeCongelation addMethodeCongelation(MethodeCongelation methodeCongelation)
	{
		return methodeCongelationRepository.save(methodeCongelation);
	}

	@Override
	public MethodeCongelation newMethodeCongelation()
	{
		return new MethodeCongelation();
	}
}
