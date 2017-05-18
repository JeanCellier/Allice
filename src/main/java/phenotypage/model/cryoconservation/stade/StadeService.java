package phenotypage.model.cryoconservation.stade;

import java.util.List;

/**
 * @author fabien
 */
public interface StadeService
{
	List<Stade> findAllStade();

	Stade createStade(String nom, int numero);

	Stade addStade(Stade stade);

	Stade newStade();
}
