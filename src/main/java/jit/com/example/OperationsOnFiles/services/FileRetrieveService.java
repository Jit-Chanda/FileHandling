package jit.com.example.OperationsOnFiles.services;

import jit.com.example.OperationsOnFiles.controllers.FileHandleController;
import jit.com.example.OperationsOnFiles.models.CustomMultipartFile;
import jit.com.example.OperationsOnFiles.models.FileName;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileRetrieveService {
    private static final Logger log = LoggerFactory.getLogger(FileHandleController.class);
    @Value("${file.storage.path}")
    private String storageDirectory;
    public MultipartFile[] retrieveFilesFromLocalStorage(List<FileName> fileNames) {

        List<MultipartFile> files = new ArrayList<>();
        try{
            Instant start = Instant.now();
            for (FileName fileName: fileNames){
                boolean fileExists = Files.exists(Paths.get(storageDirectory+fileName.getFileName()));
                if(fileExists){
                    File file = new File(storageDirectory+fileName.getFileName());
                    MultipartFile multipartFile = new CustomMultipartFile(file.getName(), FileUtils.readFileToByteArray(file));
                    files.add(multipartFile);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return files.toArray(MultipartFile[]::new);
    }
}
