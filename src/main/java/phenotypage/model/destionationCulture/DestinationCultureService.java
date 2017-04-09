package phenotypage.model.destionationCulture;

import java.util.List;

/**
 * @author fabien
 */
public interface DestinationCultureService
{
	List<DestinationCulture> findAllDestinationCulture();

	DestinationCulture createDestinationCulture(String nom);

	DestinationCulture addDestinationCulture(DestinationCulture destinationCulture);

	DestinationCulture newDestinationCulture();

	DestinationCulture findByNom(String destination);
}
