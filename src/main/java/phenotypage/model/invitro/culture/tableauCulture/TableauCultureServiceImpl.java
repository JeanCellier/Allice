package phenotypage.model.invitro.culture.tableauCulture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class TableauCultureServiceImpl implements TableauCultureService
{
	@Autowired
	private TableauCultureRepository tableauCultureRepository;

	@Override
	public List<TableauCulture> findAllTableauCulture()
	{
		return tableauCultureRepository.findAll();
	}

	@Override
	public TableauCulture createTableauCulture(String groupe, int nbInsemine, int heureCulture, int nbSegmente, float segment, int j5JM, int mo, int bl, int be, int bec, int q1, int nbTotal, float pourJ7, float pourBEJ7, float pourQ1J7, int j8parNb, int j8PourJ8, boolean siCryo)
	{
		return tableauCultureRepository.save(new TableauCulture());
	}

	@Override
	public TableauCulture newTableauCulture()
	{
		return new TableauCulture();
	}

	@Override
	public TableauCulture addTableauCulture(TableauCulture tableauCulture)
	{
		return tableauCultureRepository.save(tableauCulture);
	}

}
