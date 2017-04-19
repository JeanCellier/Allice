package phenotypage.model.donneesExistantes.abattoir;

import java.util.List;

/**
 * @author fabien
 */
public interface AbattoirService
{
	List<Abattoir> findAllAbattoir();

	Abattoir createAbattoir(String nom);

	Abattoir addAbattoir(Abattoir abattoir);

	Abattoir newAbattoir();

	Abattoir findByNom(String nomAbattoir);
}