package phenotypage.model.fiche.ficheAba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cryoconservation.Cryoconservation;
import phenotypage.model.cryoconservation.TableauDetail;
import phenotypage.model.donneesExistantes.abattoir.Abattoir;
import phenotypage.model.donneesExistantes.operateur.Operateur;
import phenotypage.model.donneesExistantes.programme.Programme;
import phenotypage.model.informationsPIV.Informations_PIV;
import phenotypage.model.invitro.collecte.Collecte;
import phenotypage.model.invitro.culture.Culture;
import phenotypage.model.invitro.fecondation.Fecondation;

import java.util.Date;
import java.util.List;

/**
 * @author fabien
 */

@Component
public class
FicheAbaServiceImpl implements FicheAbaService {
    @Autowired
    private FicheAbaRepository ficheAbaRepository;

    @Override
    public List<FicheAba> findAllFicheAba() {
        return ficheAbaRepository.findAll();
    }

    @Override
    public FicheAba createFicheAba(String nom, Date dateHeureMinute, Programme programme, String numeroAgrement, Abattoir abattoir, Operateur operateur, float temperatureArrivee, Informations_PIV informationsPiv, Collecte collecte, Fecondation fecondation, Culture culture, Cryoconservation cryoconservation, List<TableauDetail> tableauDetails) {
        FicheAba ficheAba = new FicheAba();
        ficheAba.setNom(nom);
        ficheAba.setDateHeureMinute(dateHeureMinute);
        ficheAba.setProgramme(programme);
        ficheAba.setNumeroAgrement(numeroAgrement);
        ficheAba.setAbattoir(abattoir);
        ficheAba.setOperateur(operateur);
        ficheAba.setTemperatureArrivee(temperatureArrivee);
        ficheAba.setInformations_piv(informationsPiv);
        ficheAba.setCollecte(collecte);
        ficheAba.setFecondation(fecondation);
        ficheAba.setCulture(culture);
        ficheAba.setCryoconservation(cryoconservation);
        ficheAba.setTableauDetails(tableauDetails);
        return ficheAbaRepository.save(ficheAba);
    }


    @Override
    public FicheAba addFicheAba(FicheAba ficheAba) {
        return ficheAbaRepository.save(ficheAba);
    }

    @Override
    public FicheAba findByNom(String nom) {
        return ficheAbaRepository.findByNom(nom);
    }

    @Override
    public long countFicheAba() {
        return ficheAbaRepository.count();
    }
}
