package phenotypage.model.cuve.canister.visoTube.old;

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
		VisoTube visoTube = new VisoTube();
		visoTube.setCouleur(couleur);
		visoTube.setNumero(numero);
		return save(visoTube);
	}

	@Override
	public VisoTube save(VisoTube visoTube){
		return  canisterRepository.save(visoTube);
	}
}
