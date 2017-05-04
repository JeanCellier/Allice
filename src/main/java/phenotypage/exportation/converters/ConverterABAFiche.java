package phenotypage.exportation.converters;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.fiche.ficheAba.FicheAba;
import phenotypage.model.fiche.ficheAba.FicheAbaService;

/**
 * Created with magic
 * User: simoe
 * Date: 03/05/2017 22:46
 * Project: appPhenotypage
 */
@Component("Aba")
public class ConverterABAFiche implements ConverterFiche {

    private final FicheAbaService ficheAbaService;

    @Autowired
    public ConverterABAFiche(FicheAbaService ficheAbaService) {
        this.ficheAbaService = ficheAbaService;
    }

    @Override
    public XSSFWorkbook toWorkbook(String ficheNom) {
        FicheAba ficheAba = ficheAbaService.findByNom(ficheNom);
        XSSFWorkbook workBook = new XSSFWorkbook();
        XSSFSheet sheet = workBook.createSheet(ficheAba != null ? ficheAba.getNom() : "Fiche");
        if (ficheAba != null) {
            insertPIV(sheet, ficheAba);
        }
        return workBook;
    }

    private void insertPIV(XSSFSheet sheet, FicheAba ficheAba) {
        //Programme label
        XSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("Programme:");
        row1.createCell(1, CellType.STRING).setCellValue(ficheAba.getProgramme().getNom());


    }
}
