package phenotypage.model.cuve.canister.visoTube.old;

import java.util.List;

/**
 * @author fabien
 */

public interface VisoTubeService
{
	List<VisoTube> findAllVisoTube();

	VisoTube createVisoTube(int numero, String couleur);

	VisoTube save(VisoTube visoTube);
}
