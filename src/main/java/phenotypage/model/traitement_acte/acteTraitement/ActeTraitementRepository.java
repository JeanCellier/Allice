package phenotypage.model.traitement_acte.acteTraitement;

import org.springframework.data.jpa.repository.JpaRepository;
import phenotypage.model.traitement_acte.TraitementActe;

/**
 * Created by nicolas on 29/04/17.
 */
public interface ActeTraitementRepository extends JpaRepository<ActeTraitement, Long> {
}
