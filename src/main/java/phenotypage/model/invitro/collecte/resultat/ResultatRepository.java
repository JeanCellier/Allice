package phenotypage.model.invitro.collecte.resultat;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultatRepository extends JpaRepository<Resultat, Long>
{
	List<Resultat> findAll();
}
