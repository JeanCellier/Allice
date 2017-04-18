package phenotypage.importation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created with magic
 * User: simoe
 * Date: 18/04/2017 17:15
 * Project: appPhenotypage
 */
@Service
public class ImportServiceImpl implements ImportService {

    private final Path directoryPath;

    @Autowired
    public ImportServiceImpl(ImportProperties properties) {
        directoryPath = Paths.get(properties.getDirectory());
    }

    @Override
    public void init() {
        try {
            Files.createDirectory(directoryPath);
        } catch (IOException e) {
            throw new ImportException("Could not initialize storage", e);
        }
    }

    @Override
    public void store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new ImportException("Failed to store empty file " + file.getOriginalFilename());
            }
            Files.copy(file.getInputStream(), this.directoryPath.resolve(file.getOriginalFilename()));
        } catch (IOException e) {
            throw new ImportException("Failed to store file " + file.getOriginalFilename(), e);
        }
    }

    @Override
    public void parse(File file, String type) {
        switch (type) {
            case "ABA":
                //TODO: parse the ABA.xlsx
                break;
            case "COL":
                //TODO: parse the COL.xlsx
                break;
            case "IA":
                //TODO: parse the IA.xlsx
                break;
            case "OPU":
                //TODO: parse the OPU.xlsx
                break;
            case "TRA":
                //TODO: parse the TRA.xlsx
                break;
        }
    }

    @Override
    public File load(String filename) {
        try {
            Path file = directoryPath.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource.getFile();
            } else {
                throw new ImportException("Could not read file: " + filename);
            }
        } catch (MalformedURLException e) {
            throw new ImportException("Could not read file: " + filename, e);
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
