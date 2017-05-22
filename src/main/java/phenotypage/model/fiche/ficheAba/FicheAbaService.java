package phenotypage.model.fiche.ficheAba;

import phenotypage.model.cryoconservation.Cryoconservation;
import phenotypage.model.cryoconservation.embryon.Embryon;
import phenotypage.model.fiche.ficheAba.abattoir.Abattoir;
import phenotypage.model.informationsPIV.Informations_PIV;
import phenotypage.model.invitro.collecte.Collecte;
import phenotypage.model.invitro.culture.Culture;
import phenotypage.model.invitro.fecondation.Fecondation;
import phenotypage.model.operateur.Operateur;
import phenotypage.model.programme.Programme;

import java.util.Date;
import java.util.List;

/**
 * @author fabien
 */
public interface FicheAbaService
{
	List<FicheAba> findAllFicheAba();

	FicheAba createFicheAba(String nom, Programme programme, Date date, String numAgrement, Abattoir abattoir, Operateur operateur,
                            float temperatureArrivee, Informations_PIV informations_piv, Collecte collecte, Fecondation fecondation,
                            Culture culture, Cryoconservation cryoconservation, List<Embryon> embryons);

	FicheAba addFicheAba(FicheAba ficheAba);

	FicheAba newFicheAba();

	FicheAba findByNom(String nom);

	long countFicheAba();
}
