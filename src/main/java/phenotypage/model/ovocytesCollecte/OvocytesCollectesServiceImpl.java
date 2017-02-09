package phenotypage.model.ovocytesCollecte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OvocytesCollectesServiceImpl implements OvocytesCollectesService
{
	@Autowired
	private OvocytesCollectesRepository ovocytes_collectesRepository;

	public OvocytesCollectes createOvocytesCollectes()
	{
		return ovocytes_collectesRepository.save(new OvocytesCollectes());
	}

	@Override
	public OvocytesCollectes newOvocytesCollectes()
	{
		return new OvocytesCollectes();
	}

	@Override
	public OvocytesCollectes addOvocytesCollectes(OvocytesCollectes culture)
	{
		return ovocytes_collectesRepository.save(culture);
	}

	@Override
	public void delete(OvocytesCollectes ovocytesCollectesToDelete)
	{
		ovocytes_collectesRepository.delete(ovocytesCollectesToDelete);
	}
}
