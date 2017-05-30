package phenotypage.model.traitement_acte;

import phenotypage.model.traitement_acte.acteTraitement.ActeTraitement;
import phenotypage.model.traitement_acte.tableau_traitement.Tableau_Traitement_Acte;

import java.util.List;
import java.util.Optional;

/**
 * Created by nicolas on 29/04/17.
 */
public interface TraitementActeService {
    List<TraitementActe> findAll();

    TraitementActe createTraitement(String nom, List<Tableau_Traitement_Acte> tableau_traitementActe,
                                    List<ActeTraitement> acteTraitements);

    TraitementActe createTraitement(TraitementActe traitementActe);

    TraitementActe save(TraitementActe traitementActe);

    void delete(TraitementActe traitementActe);

    Optional<TraitementActe> findOne(long id);

    TraitementActe updateTraitement(TraitementActe traitementActe, String nom, List<Tableau_Traitement_Acte> tableau_traitement_acte,
                                    List<ActeTraitement> acteTraitements);
}
