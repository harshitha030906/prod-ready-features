package com.harshitha.production_ready_features.production_ready_features.exceptions;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@Builder
@Data
public class ApiError {
    private LocalDateTime timestamp;
    private String error;
    private HttpStatusCode status;

    public ApiError(){

    }

    public ApiError(LocalDateTime timestamp, String error,  HttpStatusCode status){
        this();
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
    }
}

