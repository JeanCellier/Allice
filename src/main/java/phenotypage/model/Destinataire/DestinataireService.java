package phenotypage.model.Destinataire;

import java.util.List;

/**
 * Created by Jean on 11/05/2017.
 */
public interface DestinataireService {

    List<Destinataire> findAllDestinataire();

    Destinataire createDestinataire(String nom, String typeDestination, String adresse);

    Destinataire findByNom(String nom);

    Destinataire save(Destinataire destinataire);

    void delete(Destinataire destinataire);
}
