package phenotypage.importation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with magic
 * User: simoe
 * Date: 18/04/2017 17:51
 * Project: appPhenotypage
 */
@Configuration
@EnableConfigurationProperties(ImportProperties.class)
public class ImportConfiguration {

    @Bean
    CommandLineRunner init(ImportService importService) {
        return (args) -> {
            importService.deleteAll();
            importService.init();
        };
    }
}
