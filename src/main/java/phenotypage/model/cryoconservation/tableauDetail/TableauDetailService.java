package phenotypage.model.cryoconservation.tableauDetail;

import phenotypage.model.cryoconservation.stade.Stade;

import java.util.List;

/**
 * @author fabien
 */
public interface TableauDetailService
{
	List<TableauDetail> findAllTableauDetail();

	TableauDetail createTableauDetail(int numeroEnbryon, int groupe, Stade stade, String referecneTransfert, String remarque);

	TableauDetail addTableauDetail(TableauDetail tableauDetail);

	TableauDetail newTableauDetail();
}
