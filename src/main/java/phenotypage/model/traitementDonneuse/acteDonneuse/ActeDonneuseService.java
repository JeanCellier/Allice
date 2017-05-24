package phenotypage.model.traitementDonneuse.acteDonneuse;

/**
 * Created by nicolas on 29/04/17.
 */
public interface ActeTraitementService {
    ActeDonneuse createTraitement(int decalageJour, float decalageHeure, String acte);

    ActeDonneuse save(ActeDonneuse acteDonneuse);

    void delete(ActeDonneuse acteDonneuse);

    ActeDonneuse updateTraitement(ActeDonneuse acteDonneuse, int decalageJour, float decalageHeure, String acte);
}
