package phenotypage.model.fiche.ficheCarriere;

import java.util.List;

public interface Tableau_CarriereService
{
	List<Tableau_Carriere> findAllTableauCarriere();

	Tableau_Carriere newTableauCarriere();

	Tableau_Carriere addTableauCarriere(Tableau_Carriere TableauCarriere);
}
