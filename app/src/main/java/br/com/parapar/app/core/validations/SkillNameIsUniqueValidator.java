package br.com.parapar.app.core.validations;

import org.springframework.stereotype.Component;

import br.com.parapar.app.core.repositories.SkillRepository;
import br.com.parapar.app.core.services.http.HttpService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
//import lombok.var;

@Component
@RequiredArgsConstructor
public class SkillNameIsUniqueValidator implements ConstraintValidator<SkillNameIsUnique, String> {

    private final HttpService httpService;
    private final SkillRepository skillRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if( value == null){
            return true;
        }
        var id = httpService.getPathVariable("id", Long.class);
        if(id.isEmpty()){
            return !skillRepository.existsByName(value);
        }
        return !skillRepository.existsByNameAndIdNot(value,id.get());

    }
    

}
