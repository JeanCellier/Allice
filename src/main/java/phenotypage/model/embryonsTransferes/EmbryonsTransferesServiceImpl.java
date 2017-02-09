package phenotypage.model.embryonsTransferes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class EmbryonsTransferesServiceImpl implements EmbryonsTransferesService
{
	@Autowired
	private EmbryonsTransferesRepository embryonsTransferesRepository;

	@Override
	public List<EmbryonsTransferes> findAllEmbryonsTransferes()
	{
		return embryonsTransferesRepository.findAll();
	}

	@Override
	public EmbryonsTransferes createEmbryonsTransferes()
	{
		return embryonsTransferesRepository.save(new EmbryonsTransferes());
	}

	@Override
	public EmbryonsTransferes addEmbryonsTransferes(EmbryonsTransferes embryonsTransferes)
	{
		return embryonsTransferesRepository.save(embryonsTransferes);
	}

	@Override
	public EmbryonsTransferes newEmbryonsTransferes()
	{
		return new EmbryonsTransferes();
	}

	@Override
	public void delete(EmbryonsTransferes embryonsTransferesToDelete)
	{
		embryonsTransferesRepository.delete(embryonsTransferesToDelete);
	}
}
