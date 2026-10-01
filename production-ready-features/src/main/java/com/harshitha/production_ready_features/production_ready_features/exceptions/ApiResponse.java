package com.harshitha.production_ready_features.production_ready_features.exceptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {
    private T data;
    private ApiError apiError;
    private Object timestamp;

    public ApiResponse(){
        this.timestamp = LocalDateTime.now();
    }

    public ApiResponse(T data){
        this();
        this.data = data;
    }

    public ApiResponse(ApiError apiError){
        this();
        this.apiError = apiError;
    }
}
