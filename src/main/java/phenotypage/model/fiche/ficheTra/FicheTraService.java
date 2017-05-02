package phenotypage.model.fiche.ficheTra;

import phenotypage.model.fiche.ficheTra.corpsJaune.CorpsJaune;
import phenotypage.model.operateur.Operateur;
import phenotypage.model.programme.Programme;
import phenotypage.model.fiche.ficheTra.embryonsTransferes.EmbryonsTransferes;
import phenotypage.model.gestation.Gestation;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;
import phenotypage.model.vache.Vache;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author fabien
 */
public interface FicheTraService
{
	List<FicheTra> findAll();

	FicheTra createFicheTra(String nom, Programme programme, Date date, String numAgrement, String lieu,
						Operateur operateur, Vache vache, Traitement_Donneuse traitementDonneuse,
						CorpsJaune corpsJaune, EmbryonsTransferes embryonsTransferes, Gestation gestation);

	FicheTra updateFicheTra(FicheTra ficheTraForUpdate, String nom, Programme programme, Date dateFiche,
							String numAgrement, String lieu, Operateur operateur, Vache vache,
							Traitement_Donneuse traitement_donneuse, CorpsJaune corpsJaune,
							EmbryonsTransferes embryonsTransferes, Gestation gestation);

	void delete(FicheTra ficheTra);

	Optional<FicheTra> findOne(long id);

	FicheTra save(FicheTra ficheTra);

	FicheTra findTopByOrderByNomDesc();

	int determineStatut(FicheTra ficheTra);
}
