package phenotypage.model.invitro.culture;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author fabien
 */
public interface TableauCultureRepository extends JpaRepository<TableauCulture, Long>
{
	List<TableauCulture> findByCulture(Culture culture);
}
