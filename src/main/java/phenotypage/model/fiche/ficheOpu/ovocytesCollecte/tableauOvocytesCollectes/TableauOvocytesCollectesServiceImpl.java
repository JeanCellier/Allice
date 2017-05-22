package phenotypage.model.fiche.ficheOpu.ovocytesCollecte.tableauOvocytesCollectes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class TableauOvocytesCollectesServiceImpl implements TableauOvocytesCollectesService
{
	@Autowired
	private TableauOvocytesCollectesRepository tableauOvocytes_collectesRepository;

	@Override
	public List<TableauOvocytesCollectes> findAllTableauOvocytes_Collectes()
	{
		return tableauOvocytes_collectesRepository.findAll();
	}

	@Override
	public TableauOvocytesCollectes createTableauOvocytes_Collectes()
	{
		return tableauOvocytes_collectesRepository.save(new TableauOvocytesCollectes());
	}

	@Override
	public TableauOvocytesCollectes newTableauOvocytes_Collectes()
	{
		return new TableauOvocytesCollectes();
	}

	@Override
	public TableauOvocytesCollectes addTableauOvocytes_Collectes(TableauOvocytesCollectes tableauOvocytes_collectes)
	{
		return tableauOvocytes_collectesRepository.save(tableauOvocytes_collectes);
	}
}
