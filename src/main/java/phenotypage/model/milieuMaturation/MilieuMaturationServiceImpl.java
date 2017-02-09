package phenotypage.model.milieuMaturation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class MilieuMaturationServiceImpl implements MilieuMaturationService
{
	@Autowired
	private MilieuMaturationRepository milieuMaturationRepository;

	@Override
	public List<MilieuMaturation> findAllMilieuMaturation()
	{
		return milieuMaturationRepository.findAll();
	}

	@Override
	public MilieuMaturation createMilieuMaturation(String nom, String numeroLot)
	{
		return milieuMaturationRepository.save(new MilieuMaturation(nom, numeroLot));
	}

	@Override
	public MilieuMaturation addMilieuMaturation(MilieuMaturation milieuMaturation)
	{
		return milieuMaturationRepository.save(milieuMaturation);
	}

	@Override
	public MilieuMaturation newMilieuMaturation()
	{
		return new MilieuMaturation();
	}

	@Override
	public MilieuMaturation finByNom(String nomMilieuMaturation)
	{
		return milieuMaturationRepository.findByNom(nomMilieuMaturation);
	}
}
