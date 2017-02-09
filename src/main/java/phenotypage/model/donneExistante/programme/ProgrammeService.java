package phenotypage.model.donneExistante.programme;

import java.util.List;

/**
 * @author fabien
 */
public interface ProgrammeService
{
	List<Programme> findAllProgramme();

	Programme createProgramme(String nom);

	Programme addProgramme(Programme programme);

	Programme newProgramme();

	Programme findByNom(String s);
}
