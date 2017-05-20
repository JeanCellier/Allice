package phenotypage.model.cuve.canister.visoTube.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

/**
 * @author fabien
 */

@Component
public class VisoTubePopulator
{
	@Autowired
	private VisoTubeService visoTubeService;

	@PostConstruct
	void init()
	{
		visoTubeService.createVisoTube(1, "blanc");
		visoTubeService.createVisoTube(2, "noir");
		visoTubeService.createVisoTube(3, "rouge");
		visoTubeService.createVisoTube(4, "gris");
		visoTubeService.createVisoTube(5, "rose");
		visoTubeService.createVisoTube(6, "orange");
		visoTubeService.createVisoTube(7, "jaune");
		visoTubeService.createVisoTube(8, "violet");
		visoTubeService.createVisoTube(9, "turquoise");
		visoTubeService.createVisoTube(10, "bleu");
		visoTubeService.createVisoTube(11, "marron");
		visoTubeService.createVisoTube(12, "vert");
	}
}
