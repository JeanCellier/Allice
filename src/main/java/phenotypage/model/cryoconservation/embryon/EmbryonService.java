package phenotypage.model.cryoconservation.embryon;

import java.util.List;

/**
 * @author fabien
 */
public interface EmbryonService
{
	List<Embryon> findAll();

	Embryon save (Embryon tableauDetail);

    void delete(Embryon embryon);

	Embryon create(Embryon embryon);
}
