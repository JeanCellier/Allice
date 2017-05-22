package phenotypage.model.informationsPIV.fiv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class FIVServiceImpl implements FIVService
{
	@Autowired
	private FIVRepository fivRepository;

	@Override
	public List<FIV> findAllFIV()
	{
		return fivRepository.findAll();
	}

	@Override
	public FIV createFIV(String nom, String numeroLot)
	{
		return fivRepository.save(new FIV());
	}

	@Override
	public FIV addFIV(FIV fiv)
	{
		return fivRepository.save(fiv);
	}

	@Override
	public FIV newFIV()
	{
		return new FIV();
	}

	@Override
	public FIV findByNom(String nomFIV)
	{
		return fivRepository.findByNom(nomFIV);
	}
}
