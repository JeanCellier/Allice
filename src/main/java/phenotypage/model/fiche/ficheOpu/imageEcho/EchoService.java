package phenotypage.model.fiche.ficheOpu.imageEcho;

import java.util.List;

/**
 * @author fabien
 */
public interface EchoService
{
	List<Echo> findAllEcho();

	Echo createEcho();

	Echo addEcho(Echo echo);

	Echo newEcho();

	void delete(Echo imageEchoToDelete);
}
