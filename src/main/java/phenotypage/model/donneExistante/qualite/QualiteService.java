package phenotypage.model.donneExistante.qualite;

import java.util.List;

/**
 * @author fabien
 */
public interface QualiteService
{
	List<Qualite> findAllQualite();

	Qualite createQualite(String nom, int numero);

	Qualite addQualite(Qualite qualite);

	Qualite newQualite();
}
