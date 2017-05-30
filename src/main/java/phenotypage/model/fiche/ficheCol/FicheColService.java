package phenotypage.model.fiche.ficheCol;

import phenotypage.model.cryoconservation.Cryoconservation;
import phenotypage.model.cryoconservation.embryon.Embryon;
import phenotypage.model.infoTraitementDonneuse.InfoTraitementDonneuse;
import phenotypage.model.invitro.collecte.resultat.Resultat;
import phenotypage.model.operateur.Operateur;
import phenotypage.model.programme.Programme;
import phenotypage.model.tableauTraitement.TableauTraitement;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;
import phenotypage.model.traitementDonneuse.tableau_donneuse.Tableau_Donneuse;
import phenotypage.model.vache.Vache;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author fabien
 */
public interface FicheColService
{
	List<FicheCol> findAll();

	FicheCol createFicheCol(String nom, Programme programme, Date date, String numAgrement, String lieu, Operateur operateur, Vache vache,
							Traitement_Donneuse traitementDonneuse, Resultat resultatCollecte,
							Cryoconservation cryoconservation, Traitement_Donneuse tableauSuperOv,
							InfoTraitementDonneuse infoTraitementDonneuse, List<Embryon> detailsEmbryonsViables,
							boolean LC, boolean LL, boolean ED) ;

	FicheCol updateFicheCol(FicheCol ficheColToUpdate, String nom, Programme programme, Date date, String numAgrement,
							String lieu, Operateur operateur, Vache vache, Traitement_Donneuse traitementDonneuse,
							Resultat resultatCollecte, Cryoconservation cryoconservation, Traitement_Donneuse tableauSuperOv,
							InfoTraitementDonneuse infoTraitementDonneuse, List<Embryon> detailsEmbryonsViables,
							boolean LC, boolean LL, boolean ED);

	List<FicheCol> findByVache(Vache vache);

	FicheCol findByNom(String nom);

	void delete(FicheCol ficheCol);

	Optional<FicheCol> findOne(long id);

	FicheCol save(FicheCol ficheCol);

    List<FicheCol> findAllFicheCol();

	FicheCol findTopByOrderByNomDesc();
}
