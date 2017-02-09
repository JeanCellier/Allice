package phenotypage.config;

import java.io.File;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author fabien
 */

@Configuration
// Enable Spring Web MVC
@EnableWebMvc
//@EnableAutoConfiguration
class WebConfig implements EmbeddedServletContainerCustomizer
{
    /*
     * (non-Javadoc)
     *
     * @see org.springframework.boot.context.embedded.
     * EmbeddedServletContainerCustomizer#customize(org.springframework.boot.
     * context.embedded.ConfigurableEmbeddedServletContainer)
     */
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container)
    {
        // define the document root
        container.setDocumentRoot(new File("src/main/resources/"));
    }

    /**
     * View resolver.
     *
     * @return the view resolver
     */
    @Bean
    public ViewResolver viewResolver()
    {
        // define the view resolver to handle JSP pages
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }
}
