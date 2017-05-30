package phenotypage.model.traitement_acte.acteTraitement;

import phenotypage.model.traitement_acte.TraitementActe;
import phenotypage.model.traitement_acte.tableau_traitement.Tableau_Traitement_Acte;

import java.util.List;
import java.util.Optional;

/**
 * Created by nicolas on 29/04/17.
 */
public interface ActeTraitementService {
    ActeTraitement createTraitement(int decalageJour, float decalageHeure, String acte);

    ActeTraitement save(ActeTraitement acteTraitement);

    void delete(ActeTraitement acteTraitement);

    ActeTraitement updateTraitement(ActeTraitement acteTraitement, int decalageJour, float decalageHeure, String acte);
}
