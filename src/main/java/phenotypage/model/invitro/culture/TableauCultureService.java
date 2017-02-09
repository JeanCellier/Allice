package phenotypage.model.invitro.culture;

import phenotypage.model.gestation.Tableau_Gestation;

import java.util.List;

/**
 * @author fabien
 */
public interface TableauCultureService
{
	List<TableauCulture> findAllTableauCulture();

	TableauCulture createTableauCulture(String groupe, int nbInsemine, int heureCulture, int nbSegmente, float segment, int j5JM, int mo, int bl, int be, int bec, int q1, int nbTotal, float pourJ7, float pourBEJ7, float pourQ1J7, int j8parNb, int j8PourJ8, boolean siCryo);

	TableauCulture newTableauCulture();

	TableauCulture addTableauCulture(TableauCulture tableauCulture);

	List<TableauCulture> findByCulture(Culture culture);
}
