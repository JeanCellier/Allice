package phenotypage.model.fiches.traitement.header;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface HeaderRepository extends JpaRepository<Header, Long>{

	@Query("select header from Header header")
	List<Header> findAllHeader();
}
