package phenotypage.importation;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created with magic
 * User: simoe
 * Date: 18/04/2017 17:17
 * Project: appPhenotypage
 */
@ConfigurationProperties(prefix = "import")
public class ImportProperties {

    private String directory = "fiches-dir";

    /**
     * Gets directory of fiches
     *
     * @return directory
     */
    public String getDirectory() {
        return directory;
    }

    /**
     * Sets directory of fiches
     *
     * @param directory directory
     */
    public void setDirectory(String directory) {
        this.directory = directory;
    }
}
