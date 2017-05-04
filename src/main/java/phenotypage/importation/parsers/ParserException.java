package phenotypage.importation.parser;

/**
 * Created with magic
 * User: simoe
 * Date: 19/04/2017 14:09
 * Project: appPhenotypage
 */
public class ParserException extends RuntimeException {

    public ParserException(String s) {
        super(s);
    }

    public ParserException(String message, Throwable cause) {
        super(message, cause);
    }
}
