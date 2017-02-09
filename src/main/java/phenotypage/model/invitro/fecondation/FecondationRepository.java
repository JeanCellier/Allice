package phenotypage.model.invitro.fecondation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FecondationRepository extends JpaRepository<Fecondation, Long>
{

	@Query("select fecondation from Fecondation fecondation")
	List<Fecondation> findAllFecondation();
}
