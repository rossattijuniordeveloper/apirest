package br.com.parapar.app.api.skills.dtos;

import br.com.parapar.app.core.validations.SkillNameIsUnique;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillRequest {
    
    @NotEmpty
    @SkillNameIsUnique
    private String name;
}
