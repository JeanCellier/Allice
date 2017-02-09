package phenotypage.model.fiches.traitement.header;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HeaderServiceImpl implements HeaderService
{
	@Autowired
	private HeaderRepository headerRepository;

	@Override
	public List<Header> findAllHeader()
	{
		return headerRepository.findAllHeader();
	}

	@Override
	public Header addHeader(Header header)
	{
		return headerRepository.save(header);
	}

	@Override
	public Header newHeader()
	{
		return new Header();
	}

	@Override
	public void delete(Header header)
	{
		headerRepository.delete(header);
	}

}
