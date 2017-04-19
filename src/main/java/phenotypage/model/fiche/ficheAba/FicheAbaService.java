package phenotypage.model.fiche.ficheAba;

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
public interface FicheAbaService {
    List<FicheAba> findAllFicheAba();

    FicheAba createFicheAba(String nom, Date dateHeureMinute, Programme programme, String numeroAgrement, Abattoir abattoir,
                            Operateur operateur, float temperatureArrivee, Informations_PIV informationsPiv, Collecte collecte,
                            Fecondation fecondation, Culture culture, Cryoconservation cryoconservation, List<TableauDetail> tableauDetails);

    FicheAba addFicheAba(FicheAba ficheAba);

    FicheAba findByNom(String nom);

    long countFicheAba();
}
