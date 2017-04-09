package phenotypage.model.invitro.collecte.tableau_collecte;

import java.util.List;

public interface Tableau_CollecteService
{
	List<Tableau_Collecte> findAllTableauCollecte();

	Tableau_Collecte newTableauCollecte();

	Tableau_Collecte addTableauCollecte(Tableau_Collecte tableauCollecte);
}
