package phenotypage.model.traitementDonneuse.tableauPharmacie;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fabien
 */
public interface Tableau_PharmacieRepository extends JpaRepository<Tableau_Pharmacie, Long>
{
	Tableau_Pharmacie findTableau_PharmacieById(long id);
}
