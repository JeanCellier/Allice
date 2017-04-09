package phenotypage.model.cuve.visoTube;

import java.util.List;

/**
 * @author fabien
 */

public interface VisoTubeService
{
	List<VisoTube> findAllVisoTube();

	VisoTube createVisoTube(int numero, String couleur);

	VisoTube addVisoTube(VisoTube visoTube);

	VisoTube newVisoTube();
}
