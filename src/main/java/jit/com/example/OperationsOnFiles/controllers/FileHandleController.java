package jit.com.example.OperationsOnFiles.controllers;

import jit.com.example.OperationsOnFiles.models.FileRetrieveRequest;
import jit.com.example.OperationsOnFiles.models.FileRetrieveResponse;
import jit.com.example.OperationsOnFiles.services.FileHandleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static jit.com.example.OperationsOnFiles.constants.FileHandleConstants.SENDER_NAME;

@RestController
@RequestMapping("/file")
public class FileHandleController {

    private static final Logger log = LoggerFactory.getLogger(FileHandleController.class);
    private FileHandleService fileHandleService;
    @Autowired
    public FileHandleController(FileHandleService fileHandleService) {
        this.fileHandleService = fileHandleService;
    }

    @PostMapping("/retrieve")
    public ResponseEntity<FileRetrieveResponse> retrieveFilesFromStorageSystem(
            @RequestHeader Map<String,String> headerDetails,
            @RequestBody FileRetrieveRequest request){
        String senderName = headerDetails.get(SENDER_NAME);
        log.info("Currently we're handling the request of: {}",senderName);
        fileHandleService.retrieveFilesFromStorageSystem(request,senderName);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new FileRetrieveResponse("File successfully retrieved !!"));
    }
}
