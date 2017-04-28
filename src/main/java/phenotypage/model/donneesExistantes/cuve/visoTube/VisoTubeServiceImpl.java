package phenotypage.model.donneesExistantes.cuve.visoTube;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class VisoTubeServiceImpl implements VisoTubeService
{
	@Autowired
	private VisoTubeRepository canisterRepository;

	@Override
	public List<VisoTube> findAllVisoTube()
	{
		return canisterRepository.findAll();
	}

	@Override
	public VisoTube createVisoTube(int numero, String couleur)
	{
		return canisterRepository.save(new VisoTube(numero, couleur));
	}

	@Override
	public VisoTube addVisoTube(VisoTube visoTube)
	{
		return canisterRepository.save(visoTube);
	}

	@Override
	public VisoTube newVisoTube()
	{
		return new VisoTube();
	}
}
