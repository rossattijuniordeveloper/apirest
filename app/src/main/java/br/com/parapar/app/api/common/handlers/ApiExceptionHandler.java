package br.com.parapar.app.api.common.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.parapar.app.api.common.dtos.ErrorResponse;
import br.com.parapar.app.core.exceptions.ModelNotFoundException;

@RestControllerAdvice
public class ApiExceptionHandler{    
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ModelNotFoundException.class)
    public ErrorResponse handleModelNotFoundException( ModelNotFoundException exception){
        return ErrorResponse.builder()
        .message( exception.getLocalizedMessage() )
        .build();
    }
}
