package phenotypage.model.donneesExistantes.cuve.canister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fabien
 */

@Component
public class CanisterPopulator
{
	@Autowired
	private CanisterService canisterService;

	@PostConstruct
	void inti()
	{
		canisterService.createCanister(1);
		canisterService.createCanister(2);
		canisterService.createCanister(3);
		canisterService.createCanister(4);
		canisterService.createCanister(5);
		canisterService.createCanister(6);
		canisterService.createCanister(7);
		canisterService.createCanister(8);
		canisterService.createCanister(9);
	}
}
