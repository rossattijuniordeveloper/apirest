package br.com.parapar.app.api.skills.mappers;

import br.com.parapar.app.api.skills.dtos.SkillRequest;
import br.com.parapar.app.api.skills.dtos.SkillResponse;
import br.com.parapar.app.core.models.Skill;

public interface SkillMapper {
    
    Skill toSkill(SkillRequest skillRequest);

    SkillResponse toSkillResponse(Skill skill);
}
