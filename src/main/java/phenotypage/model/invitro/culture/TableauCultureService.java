package phenotypage.model.invitro.culture;

import java.util.List;

/**
 * @author fabien
 */
public interface TableauCultureService {
    List<TableauCulture> findAllTableauCulture();

    TableauCulture createTableauCulture(String groupe, int nbInsemine, int heureCulture, int minuteCulture,
                                        int nbSegmente, float segment, int j5JM, int mo, int bl, int be,
                                        int q1, int nbTotal, float pourJ7, float pourBEJ7, float pourQ1J7,
                                        int j8parNb, float j8PourJ8, String destination);

    TableauCulture newTableauCulture();

    TableauCulture addTableauCulture(TableauCulture tableauCulture);
}
