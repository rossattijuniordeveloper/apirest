package br.com.parapar.app.api.skills.assemblers;

import org.springframework.hateoas.server.reactive.SimpleReactiveRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import br.com.parapar.app.api.skills.dtos.SkillResponse;


@Component
public class SkillAssembler implements SimpleReactiveRepresentationModelAssembler<SkillResponse> {

}
