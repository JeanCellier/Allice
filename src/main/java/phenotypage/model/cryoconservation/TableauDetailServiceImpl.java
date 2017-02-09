package phenotypage.model.cryoconservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.donneExistante.stade.Stade;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class TableauDetailServiceImpl implements TableauDetailService
{
	@Autowired
	private TableauDetailRepository tableauDetailRepository;

	@Override
	public List<TableauDetail> findAllTableauDetail()
	{
		return tableauDetailRepository.findAll();
	}

	@Override
	public TableauDetail createTableauDetail(int numeroEnbryon, int groupe, Stade stade, String referecneTransfert, String remarque)
	{
		return tableauDetailRepository.save(new TableauDetail(numeroEnbryon, groupe, stade, referecneTransfert, remarque));
	}

	@Override
	public TableauDetail addTableauDetail(TableauDetail tableauDetail)
	{
		return tableauDetailRepository.save(tableauDetail);
	}

	@Override
	public TableauDetail newTableauDetail()
	{
		return new TableauDetail();
	}
}
