package phenotypage.model.cryoconservation.embryon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class EmbryonServiceImpl implements EmbryonService
{
	@Autowired
	private EmbryonRepository embryonRepository;

	@Override
	public List<Embryon> findAllTableauDetail()
	{
		return embryonRepository.findAll();
	}

	@Override
	public Embryon createTableauDetail(int numeroEnbryon, int groupe, int stade, String referecneTransfert, String remarque)
	{
		return embryonRepository.save(new Embryon());
	}

	@Override
	public Embryon addTableauDetail(Embryon tableauDetail)
	{
		return embryonRepository.save(tableauDetail);
	}

	@Override
	public Embryon newTableauDetail()
	{
		return new Embryon();
	}
}
