package br.com.parapar.app.core.exceptions;

public class SkillNotFoundException extends ModelNotFoundException {

    public SkillNotFoundException() {
        super("Skill Not Found!");
    }
    
    public SkillNotFoundException(String message){
        super(message);
    }
}
