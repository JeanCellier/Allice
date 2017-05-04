package phenotypage.exportation;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phenotypage.exportation.converters.ConverterFiche;

import java.util.Map;

/**
 * Created with magic
 * User: simoe
 * Date: 03/05/2017 13:15
 * Project: appPhenotypage
 */
@Service
public class ExportServiceImpl implements ExportService {

    private final Map<String, ConverterFiche> converters;

    @Autowired
    public ExportServiceImpl(Map<String, ConverterFiche> converters) {
        this.converters = converters;
    }

    @Override
    public Workbook export(String ficheNom, String type) {
        return converters.get(type).toWorkbook(ficheNom);
    }
}
