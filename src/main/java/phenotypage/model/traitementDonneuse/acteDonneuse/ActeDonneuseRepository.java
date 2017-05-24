package phenotypage.model.traitementDonneuse.acteDonneuse;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nicolas on 29/04/17.
 */
public interface ActeTraitementRepository extends JpaRepository<ActeDonneuse, Long> {
}
