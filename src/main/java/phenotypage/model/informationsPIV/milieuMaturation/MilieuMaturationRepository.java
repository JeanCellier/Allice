package phenotypage.model.informationsPIV.milieuMaturation;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fabien
 */
public interface MilieuMaturationRepository extends JpaRepository<MilieuMaturation, Long>
{
	MilieuMaturation findByNom(String nomMilieuMaturation);
}
