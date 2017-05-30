package phenotypage.model.Destinataire;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jean on 11/05/2017.
 */
public interface DestinataireRepository extends JpaRepository<Destinataire, Long> {

    Destinataire findByNom(String nom);
}
