package phenotypage.model.infoTraitementDonneuse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by nicolas on 29/05/17.
 */
@Component
public class InfoTraitementDonneuseServiceImpl implements InfoTraitementDonneuseService{

    @Autowired
    private InfoTraitementDonneuseRepository repository;

    @Override
    public InfoTraitementDonneuse update(InfoTraitementDonneuse infoTraitementDonneuse, int nb_follicules, int nb_droite,
                                         int nb_gauche, float pourc_dose, boolean image_echo) {
        infoTraitementDonneuse.setNb_follicules(nb_follicules);
        infoTraitementDonneuse.setPourc_dose(pourc_dose);
        infoTraitementDonneuse.setNb_gauche(nb_gauche);
        infoTraitementDonneuse.setNb_droite(nb_droite);
        infoTraitementDonneuse.setImage_echo(image_echo);
        return save(infoTraitementDonneuse);
    }

    @Override
    public InfoTraitementDonneuse create(InfoTraitementDonneuse infoTraitementDonneuse) {
        InfoTraitementDonneuse infoTraitementDonneuseNew = new InfoTraitementDonneuse();

        infoTraitementDonneuseNew.setImage_echo(infoTraitementDonneuse.isImage_echo());
        infoTraitementDonneuseNew.setNb_droite(infoTraitementDonneuse.getNb_droite());
        infoTraitementDonneuseNew.setNb_gauche(infoTraitementDonneuse.getNb_gauche());
        infoTraitementDonneuseNew.setNb_follicules(infoTraitementDonneuse.getNb_follicules());
        infoTraitementDonneuseNew.setPourc_dose(infoTraitementDonneuse.getPourc_dose());

        return save(infoTraitementDonneuseNew);
    }

    @Override
    public InfoTraitementDonneuse save(InfoTraitementDonneuse infoTraitementDonneuse) {
        return repository.save(infoTraitementDonneuse);
    }
}
