package phenotypage.model.cryoconservation.embryon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class TableauDetailServiceImpl implements TableauDetailService
{
	@Autowired
	private EmbryonRepository embryonRepository;

	@Override
	public List<TableauDetail> findAllTableauDetail()
	{
		return embryonRepository.findAll();
	}

	@Override
	public TableauDetail createTableauDetail(int numeroEnbryon, int groupe, int stade, String referecneTransfert, String remarque)
	{
		return embryonRepository.save(new TableauDetail());
	}

	@Override
	public TableauDetail addTableauDetail(TableauDetail tableauDetail)
	{
		return embryonRepository.save(tableauDetail);
	}

	@Override
	public TableauDetail newTableauDetail()
	{
		return new TableauDetail();
	}
}
