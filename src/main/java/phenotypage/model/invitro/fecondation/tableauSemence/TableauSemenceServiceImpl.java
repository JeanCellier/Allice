package phenotypage.model.invitro.fecondation.tableauSemence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.vache.Vache;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class TableauSemenceServiceImpl implements TableauSemenceService
{
	@Autowired
	private TableauSemenceRepository tableauSemenceRepository;

	@Override
	public List<TableauSemence> findAllTableauSemence()
	{
		return tableauSemenceRepository.findAll();
	}

	@Override
	public TableauSemence createTableauSemence(Vache nomTaureau, String semence)
	{
		return tableauSemenceRepository.save(new TableauSemence());
	}

	@Override
	public TableauSemence addTableauSemence(TableauSemence tableauSemence)
	{
		return tableauSemenceRepository.save(tableauSemence);
	}
}
