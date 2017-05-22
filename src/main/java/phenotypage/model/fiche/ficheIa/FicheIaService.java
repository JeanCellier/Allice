package phenotypage.model.fiche.ficheIa;

import phenotypage.model.fiche.ficheIa.insemination.Insemination;
import phenotypage.model.gestation.Gestation;
import phenotypage.model.programme.Programme;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;
import phenotypage.model.vache.Vache;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author fabien
 */
public interface FicheIaService
{
	List<FicheIa> findAll();

	Optional<FicheIa> findOne(long id);

	FicheIa save(FicheIa ficheIa);

	void delete(FicheIa ficheIa);

    FicheIa createFicheIa(String nom, Date dateFiche, String lieu, Programme programme, String numIpe, String numSemence, Vache vache, Insemination insemination, Traitement_Donneuse traitement_donneuse, Gestation gestation);

	FicheIa updateFicheIa(FicheIa ficheIaForUpdate, String nom, Date dateFiche, String lieu, Programme programme, String numIpe, String numSemence, Vache vache, Insemination insemination, Traitement_Donneuse traitement_donneuse, Gestation gestation);

	FicheIa findTopByOrderByNomDesc();

	FicheIa findByNom(String nom);

	int determineStatut(FicheIa ficheIa);

    List<FicheIa> findAllFicheIa();
}
