package jit.com.example.OperationsOnFiles.models;

import org.springframework.http.HttpStatus;

public class FileRetrieveResponse {

    private String message;

    public FileRetrieveResponse(String message) {
        this.message = message;
    }

    public FileRetrieveResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
