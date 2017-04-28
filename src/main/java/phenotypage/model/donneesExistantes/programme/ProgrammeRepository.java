package phenotypage.model.donneesExistantes.programme;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fabien
 */
public interface ProgrammeRepository extends JpaRepository<Programme, Long>
{
	Programme findByNom(String s);
}
