package phenotypage.model.fiche.ficheCol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.vache.Vache;

import java.util.List;
import java.util.Optional;

/**
 * @author fabien
 */

@Component
public class
FicheColServiceImpl implements FicheColService
{
	@Autowired
	private FicheColRepository repository;

	@Override
	public List<FicheCol> findAll() {
		return repository.findAll();
	}

	@Override
	public List<FicheCol> findByVache(Vache vache) {
		return repository.findByVache(vache);
	}

	@Override
	public void delete(FicheCol ficheCol) {
		repository.delete(ficheCol);
	}

	@Override
	public Optional<FicheCol> findOne(long id) {
		return Optional.ofNullable(repository.findOne(id));
	}

	@Override
	public FicheCol save(FicheCol ficheCol) {
		return repository.save(ficheCol);
	}
}
