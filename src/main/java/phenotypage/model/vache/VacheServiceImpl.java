package phenotypage.model.vache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class VacheServiceImpl implements VacheService
{
	@Autowired
	private VacheRepository vacheRepository;

	@Override
	public List<Vache> findAllVache()
	{
		return vacheRepository.findAll();
	}

	@Override
	public Vache createVache(String proprietaire, String num_elevage, String num_identification, long num_travail, int race)
	{
		return vacheRepository.save(new Vache());
	}

	@Override
	public Vache addVache(Vache vache)
	{
		return vacheRepository.save(vache);
	}

	@Override
	public Vache newVache()
	{
		return new Vache();
	}

	@Override
	public Vache findByNum_identification(String num_identification)
	{
		return vacheRepository.findBynum_identification(num_identification);
	}
}
