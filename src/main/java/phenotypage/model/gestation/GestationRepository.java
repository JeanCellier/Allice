package phenotypage.model.gestation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface GestationRepository extends JpaRepository<Gestation, Long>
{
}
