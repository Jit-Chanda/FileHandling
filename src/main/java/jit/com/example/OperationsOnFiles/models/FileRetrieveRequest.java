package jit.com.example.OperationsOnFiles.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FileRetrieveRequest {

    @JsonProperty("request-id")  //may be sender is sending 'request-id' and not 'requestId'. That time we can use @JsonProperty
    private String requestId;
    @JsonProperty("file-names")
    private List<FileName> fileNames;

    public FileRetrieveRequest(String requestId, List<FileName> fileNames) {
        this.requestId = requestId;
        this.fileNames = fileNames;
    }

    public FileRetrieveRequest() {
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public List<FileName> getFileNames() {
        return fileNames;
    }

    public void setFileNames(List<FileName> fileNames) {
        this.fileNames = fileNames;
    }
}
