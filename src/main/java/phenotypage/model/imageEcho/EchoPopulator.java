package phenotypage.model.imageEcho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fabien
 */

@Component
public class EchoPopulator
{
	@Autowired
	private EchoService echoService;

	@PostConstruct
	void init()
	{
		echoService.createEcho();
	}
}
