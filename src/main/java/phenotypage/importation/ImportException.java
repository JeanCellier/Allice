package phenotypage.importation;

/**
 * Created with magic
 * User: simoe
 * Date: 18/04/2017 17:23
 * Project: appPhenotypage
 */
public class ImportException extends RuntimeException {

    public ImportException(String s) {
        super(s);
    }

    public ImportException(String message, Throwable cause) {
        super(message, cause);
    }
}
