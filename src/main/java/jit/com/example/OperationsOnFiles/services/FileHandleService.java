package jit.com.example.OperationsOnFiles.services;

import jit.com.example.OperationsOnFiles.controllers.FileHandleController;
import jit.com.example.OperationsOnFiles.exceptions.FileIsNotFoundException;
import jit.com.example.OperationsOnFiles.models.FileRetrieveRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import static jit.com.example.OperationsOnFiles.constants.FileHandleConstants.NO_FILE_IS_FOUND;

@Service
public class FileHandleService {
    private static final Logger log = LoggerFactory.getLogger(FileHandleController.class);
    private FileRetrieveService fileRetrieveService;

    @Autowired
    public FileHandleService(FileRetrieveService fileRetrieveService) {
        this.fileRetrieveService = fileRetrieveService;
    }

    public void retrieveFilesFromStorageSystem(FileRetrieveRequest request, String senderName) {
        log.info("Trying to retrieve files for: {}",senderName);
        MultipartFile[] files = fileRetrieveService.retrieveFilesFromLocalStorage(request.getFileNames());
        if (files.length<1){
            log.error(NO_FILE_IS_FOUND);
            throw new FileIsNotFoundException(NO_FILE_IS_FOUND);
        }
    }
}
