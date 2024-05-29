package br.com.parapar.app.api.common.handlers;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.parapar.app.api.common.dtos.ErrorResponse;
import br.com.parapar.app.api.common.dtos.ValidationErrorResponse;
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

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationErrorResponse handleMethodArgumentNotValidException(
        MethodArgumentNotValidException exception
        ){
            var errors = exception.getBindingResult().getFieldErrors()
            .stream()
            .collect(Collectors.groupingBy(
                fieldError -> fieldError.getField(),
                Collectors.mapping(
                    fieldError -> fieldError.getDefaultMessage(),
                    Collectors.toList() 
                )
            ));

            return ValidationErrorResponse.builder()
            .message("Validation error")
            .errors(errors)
            .build();
        }
}
