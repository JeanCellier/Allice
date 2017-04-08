package phenotypage.model.fiche.ficheTra;

import phenotypage.model.corpsJaune.CorpsJaune;
import phenotypage.model.donneesExistantes.operateur.Operateur;
import phenotypage.model.donneesExistantes.programme.Programme;
import phenotypage.model.embryonsTransferes.EmbryonsTransferes;
import phenotypage.model.gestation.Gestation;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;
import phenotypage.model.vache.Vache;

import java.util.Date;
import java.util.List;

/**
 * @author fabien
 */
public interface FicheTraService
{
	List<FicheTra> findAllFicheTra();

	void createFicheTra(String nom, Programme programme, Date date, String numAgrement, String lieu,
						Operateur operateur, Vache vache, Traitement_Donneuse traitementDonneuse,
						CorpsJaune corpsJaune, EmbryonsTransferes embryonsTransferes, Gestation gestation);

	FicheTra addFicheTra(FicheTra fichieTra);

	FicheTra newFicheTra();

	FicheTra findByNom(String nom);

	long countFicheTra();

	void save(FicheTra ficheTra);
}
