package phenotypage.importation;

import org.springframework.web.multipart.MultipartFile;
import phenotypage.model.fiche.Fiche;

import java.io.File;
import java.util.List;

/**
 * Created with magic
 * User: simoe
 * Date: 18/04/2017 16:58
 * Project: appPhenotypage
 */
public interface ImportService {

    /**
     * Initializes the service mainly to create the directory of "fiches"
     */
    void init();

    /**
     * Stores the files / fiches
     *
     * @param file file
     */
    void store(MultipartFile file);

    /**
     * Parses the file to create a fiches
     *
     * @param file file
     * @param type type of fiche
     * @return fiche
     */
    List<Fiche> parse(File file, String type);

    /**
     * Loads the file
     *
     * @param filename filename
     * @return file
     */
    File load(String filename);

    /**
     * Empties the directory
     */
    void deleteAll();
}