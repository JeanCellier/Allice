package phenotypage.model.programme;

import java.util.List;

/**
 * @author fabien
 */
public interface ProgrammeService
{
	List<Programme> findAll();

	Programme createProgramme(String nom);

	Programme addProgramme(Programme programme);

	Programme newProgramme();

	Programme findByNom(String s);
}
