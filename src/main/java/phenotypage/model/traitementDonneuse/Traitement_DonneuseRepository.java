package phenotypage.model.traitementDonneuse;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fabien
 */
public interface Traitement_DonneuseRepository extends JpaRepository<Traitement_Donneuse, Long>
{
	Traitement_Donneuse findTraitement_DonneuseById(long id);
}
