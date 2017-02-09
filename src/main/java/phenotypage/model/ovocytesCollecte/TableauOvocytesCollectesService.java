package phenotypage.model.ovocytesCollecte;

import java.util.List;

/**
 * @author fabien
 */
public interface TableauOvocytesCollectesService
{
	List<TableauOvocytesCollectes> findAllTableauOvocytes_Collectes();

	TableauOvocytesCollectes createTableauOvocytes_Collectes();

	TableauOvocytesCollectes newTableauOvocytes_Collectes();

	TableauOvocytesCollectes addTableauOvocytes_Collectes(TableauOvocytesCollectes tableauOvocytes_collectes);
}
