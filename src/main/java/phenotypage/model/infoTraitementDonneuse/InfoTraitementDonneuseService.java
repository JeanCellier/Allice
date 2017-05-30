package phenotypage.model.infoTraitementDonneuse;

/**
 * Created by nicolas on 29/05/17.
 */
public interface InfoTraitementDonneuseService {
    InfoTraitementDonneuse update(InfoTraitementDonneuse infoTraitementDonneuse, int nb_follicules, int nb_droite, 
                                  int nb_gauche, float pourc_dose, boolean image_echo);

    InfoTraitementDonneuse create(InfoTraitementDonneuse infoTraitementDonneuse);

    InfoTraitementDonneuse save(InfoTraitementDonneuse infoTraitementDonneuse);
}
