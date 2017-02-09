package phenotypage.model.fiches.traitement.header;

import java.util.List;

public interface HeaderService
{

	List<Header> findAllHeader();

	Header addHeader(Header header);

	Header newHeader();

	void delete(Header header);
}
