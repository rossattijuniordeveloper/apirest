package br.com.parapar.app.core.validations;

import java.lang.annotation.ElementType;
//import java.lang.annotation.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {SkillNameIsUniqueValidator.class })
@Target(ElementType.FIELD)
public @interface SkillNameIsUnique {

    String message() default " this ${validateValue} skill name already in use";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

    
}
