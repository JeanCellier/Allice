package phenotypage.model.milieuMaturation;

import java.util.List;

/**
 * @author fabien
 */

public interface MilieuMaturationService
{
	List<MilieuMaturation> findAllMilieuMaturation();

	MilieuMaturation createMilieuMaturation(String nom, String numeroLot);

	MilieuMaturation addMilieuMaturation(MilieuMaturation milieuMaturation);

	MilieuMaturation newMilieuMaturation();

	MilieuMaturation finByNom(String nomMilieuMaturation);
}
