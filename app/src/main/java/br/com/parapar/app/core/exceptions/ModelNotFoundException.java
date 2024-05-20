package br.com.parapar.app.core.exceptions;

public class ModelNotFoundException extends RuntimeException {

    public ModelNotFoundException(String message){
        super(message);
    }
    
}
