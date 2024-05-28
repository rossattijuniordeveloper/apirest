package br.com.parapar.app.core.exceptions;

public class JobNotFoundException  extends ModelNotFoundException {
    public JobNotFoundException (){
       super("Job Not Found!");
    }
    public JobNotFoundException(String message) {
        super(message);
    }

}
