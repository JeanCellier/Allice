package phenotypage.model.fiche.ficheAba.abattoir;

import java.util.List;
import java.util.Optional;

/**
 * @author fabien
 */
public interface AbattoirService
{
	List<Abattoir> findAllAbattoir();

	Abattoir createAbattoir(String nom);

	Abattoir addAbattoir(Abattoir abattoir);

	Abattoir newAbattoir();

	Optional<Abattoir> findByNom(String nomAbattoir);
}
