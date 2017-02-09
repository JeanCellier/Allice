package phenotypage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author fabien
 */

@Configuration
public class HandlerConfig extends WebMvcConfigurerAdapter
{
/*
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/static/pdf/**").addResourceLocations("/static/pdf/").setCachePeriod(0);
        registry.addResourceHandler("/static/images/**").addResourceLocations("/static/images/").setCachePeriod(0);
        registry.addResourceHandler("/static/js/**").addResourceLocations("/static/js/").setCachePeriod(0);
        registry.addResourceHandler("/static/php/**").addResourceLocations("/static/php/").setCachePeriod(0);
        registry.addResourceHandler("/static/css/**").addResourceLocations("/static/css/").setCachePeriod(0);
        //registry.addResourceHandler("/WEB-INF/views/css/**").addResourceLocations("/WEB-INF/views/css/").setCachePeriod(0);
    }

*/
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/static/**").addResourceLocations("/static/").setCachePeriod(0);

		/*registry.addResourceHandler("/static/pdf/**").addResourceLocations("/static/pdf/").setCachePeriod(0);
		registry.addResourceHandler("/static/images/**").addResourceLocations("/static/images/").setCachePeriod(0);
		registry.addResourceHandler("/static/js/**").addResourceLocations("/static/js/").setCachePeriod(0);
		registry.addResourceHandler("/static/php/**").addResourceLocations("/static/php/").setCachePeriod(0);
		registry.addResourceHandler("/static/css/**").addResourceLocations("/static/css/").setCachePeriod(0);*/
	}

}
