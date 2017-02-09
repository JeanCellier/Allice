package phenotypage.model.invitro.culture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CultureServiceImpl implements CultureService
{
	@Autowired
	private CultureRepository cultureRepository;

	@Override
	public List<Culture> findAll()
	{
		return cultureRepository.findAll();
	}

	@Override
	public Culture newCulture()
	{
		return new Culture();
	}

	@Override
	public Culture addCulture(Culture culture)
	{
		return cultureRepository.save(culture);
	}

	@Override
	public void delete(Culture culture)
	{
		cultureRepository.delete(culture);
	}

}
