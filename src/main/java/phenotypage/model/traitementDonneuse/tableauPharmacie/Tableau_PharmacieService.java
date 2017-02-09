package phenotypage.model.traitementDonneuse.tableauPharmacie;

import java.util.List;

/**
 * @author fabien
 */
public interface Tableau_PharmacieService
{
	Tableau_Pharmacie createTableau_Pharmacie();

	Tableau_Pharmacie addTableau_Pharmacie(Tableau_Pharmacie tableau_pharmacieR);

	List<Tableau_Pharmacie> findAllTableau_Pharmacie();

	Tableau_Pharmacie findTableau_PharmacieById(long id);
}
