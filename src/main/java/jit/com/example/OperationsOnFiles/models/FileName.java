package jit.com.example.OperationsOnFiles.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FileName {

    @JsonProperty("file-name")
    private String fileName;
}
