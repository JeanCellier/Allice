package phenotypage.model.ovocytesCollecte;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class OvocytesCollectesPopulator
{
	@Autowired
	private OvocytesCollectesServiceImpl ovocytes_collectesServiceImpl;

	@PostConstruct
	void init()
	{
		ovocytes_collectesServiceImpl.createOvocytesCollectes();
	}
}
