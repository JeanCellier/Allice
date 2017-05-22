package phenotypage.model.cryoconservation.embryon;

import java.util.List;

/**
 * @author fabien
 */
public interface EmbryonService
{
	List<Embryon> findAllTableauDetail();

	Embryon createTableauDetail(int numeroEnbryon, int groupe, int stade, String referecneTransfert, String remarque);

	Embryon addTableauDetail(Embryon tableauDetail);

	Embryon newTableauDetail();
}
