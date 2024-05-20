package br.com.parapar.app.api.skills.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.parapar.app.api.skills.dtos.SkillRequest;
import br.com.parapar.app.api.skills.dtos.SkillResponse;
import br.com.parapar.app.core.models.Skill;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ModelMapperSkillMapper implements SkillMapper {

    private final ModelMapper modelMapper;

    @Override
    public Skill toSkill(SkillRequest skillRequest) {
        return modelMapper.map(skillRequest,Skill.class);
    }

    @Override
    public SkillResponse toSkillResponse(Skill skill) {
        return modelMapper.map(skill, SkillResponse.class);
    }

    
}