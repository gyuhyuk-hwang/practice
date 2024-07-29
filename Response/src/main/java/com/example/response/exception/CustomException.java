package com.example.response.exception;

import com.example.response.entity.ErrorCode;
import lombok.Getter;

import java.util.AbstractMap;
import java.util.Map;

public class CustomException extends RuntimeException {

    @Getter
    private final ErrorCode errorCode;
    private String message;

    //  "data":{
    //          "inputRestriction": {
    //              "maxGrade":"6"
    //          }
    //  }

    @Getter
    private Map.Entry<String, Object> data;

    public CustomException(ErrorCode errorCode, String message, Object data) {
        this.errorCode = errorCode;
        this.message = message;
        if(data != null) {
            this.data = new AbstractMap.SimpleEntry(data.getClass().getSimpleName(), data);
        }
        else{
            this.data = null;
        }
    }
}
