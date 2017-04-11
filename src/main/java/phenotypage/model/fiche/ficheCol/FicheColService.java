package phenotypage.model.fiche.ficheCol;

import java.util.List;
import java.util.Optional;

/**
 * @author fabien
 */
public interface FicheColService
{
	List<FicheCol> findAll();

	void delete(FicheCol ficheCol);

	Optional<FicheCol> findOne(long id);

	FicheCol save(FicheCol ficheCol);
}
