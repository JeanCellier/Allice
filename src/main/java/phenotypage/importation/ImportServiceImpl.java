package phenotypage.importation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import phenotypage.importation.parsers.ParserFicheService;
import phenotypage.model.fiche.Fiche;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created with magic
 * User: simoe
 * Date: 18/04/2017 17:15
 * Project: appPhenotypage
 */
@Service
public class ImportServiceImpl implements ImportService {

    private final Path directoryPath;

    private final ParserFicheService parserFicheService;

    @Autowired
    public ImportServiceImpl(ImportProperties properties, ParserFicheService parserFicheService) {
        directoryPath = Paths.get(properties.getDirectory());
        this.parserFicheService = parserFicheService;
    }

    @Override
    public void init() {
        try {
            Files.createDirectory(directoryPath);
        } catch (IOException e) {
            throw new ImportException("Impossible d'initialiser le répertoire des fiches.", e);
        }
    }

    @Override
    public void store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new ImportException("Impossible de stocker le fichier vide " + file.getOriginalFilename());
            }
            Files.copy(file.getInputStream(), this.directoryPath.resolve(file.getOriginalFilename()));
        } catch (IOException e) {
            throw new ImportException("Impossible de stocker le fichier " + file.getOriginalFilename(), e);
        }
    }

    @Override
    public List<Fiche> parse(File file, String type) {
        return parserFicheService.parse(file, type);
    }

    @Override
    public File load(String filename) {
        try {
            Path file = directoryPath.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource.getFile();
            } else {
                throw new ImportException("Impossible de lire le fichier: " + filename);
            }
        } catch (MalformedURLException e) {
            throw new ImportException("Impossible de lire le fichier: " + filename, e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(directoryPath.toFile());
    }
}
