package phenotypage.model.cryoconservation.embryon;

import java.util.List;

/**
 * @author fabien
 */
public interface TableauDetailService
{
	List<TableauDetail> findAllTableauDetail();

	TableauDetail createTableauDetail(int numeroEnbryon, int groupe, int stade, String referecneTransfert, String remarque);

	TableauDetail addTableauDetail(TableauDetail tableauDetail);

	TableauDetail newTableauDetail();
}
