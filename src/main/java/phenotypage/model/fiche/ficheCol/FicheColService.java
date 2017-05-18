package phenotypage.model.fiche.ficheCol;

import phenotypage.model.vache.Vache;

import java.util.List;
import java.util.Optional;

/**
 * @author fabien
 */
public interface FicheColService
{
	List<FicheCol> findAll();

	List<FicheCol> findByVache(Vache vache);

	void delete(FicheCol ficheCol);

	Optional<FicheCol> findOne(long id);

	FicheCol save(FicheCol ficheCol);
}
