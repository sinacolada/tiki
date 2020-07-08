package com.sinacolada.tiki.util.custom.error;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class TikiError {

    private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    private String error;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> errors;

}