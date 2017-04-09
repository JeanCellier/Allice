package phenotypage.model.invitro.fecondation.tableauSemence;

import phenotypage.model.vache.Vache;

import java.util.List;

/**
 * @author fabien
 */
public interface TableauSemenceService
{
	List<TableauSemence> findAllTableauSemence();

	TableauSemence createTableauSemence(Vache nomTaureau, String semence);

	TableauSemence addTableauSemence(TableauSemence tableauSemence);
}
