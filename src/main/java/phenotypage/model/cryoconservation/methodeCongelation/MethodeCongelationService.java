package phenotypage.model.cryoconservation.methodeCongelation;

import java.util.List;

/**
 * @author fabien
 */
public interface MethodeCongelationService
{
	List<MethodeCongelation> findAllMethodeCongelation();

	MethodeCongelation createMethodeCongelation(String nom);

	MethodeCongelation addMethodeCongelation(MethodeCongelation methodeCongelation);

	MethodeCongelation newMethodeCongelation();
}
