package phenotypage.model.donneExistante.fiv;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fabien
 */
public interface FIVRepository extends JpaRepository<FIV, Long>
{
	FIV findByNom(String nomFIV);
}
