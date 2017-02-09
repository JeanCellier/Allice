package phenotypage.model.imageEcho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class EchoServiceImpl implements EchoService
{
	@Autowired
	private EchoRepository echoRepository;

	@Override
	public List<Echo> findAllEcho()
	{
		return echoRepository.findAll();
	}

	@Override
	public Echo createEcho()
	{
		return echoRepository.save(new Echo());
	}

	@Override
	public Echo addEcho(Echo echo)
	{
		return echoRepository.save(echo);
	}

	@Override
	public Echo newEcho()
	{
		return new Echo();
	}

	@Override
	public void delete(Echo imageEchoToDelete)
	{
		echoRepository.delete(imageEchoToDelete);
	}
}
