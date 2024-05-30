package br.com.parapar.app.api.skills.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.parapar.app.api.skills.dtos.SkillRequest;
import br.com.parapar.app.api.skills.dtos.SkillResponse;
import br.com.parapar.app.api.skills.mappers.SkillMapper;
import br.com.parapar.app.core.exceptions.SkillNotFoundException;
import br.com.parapar.app.core.repositories.SkillRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


//@Controller
//@ResponseBody
// substitui-se as anotações acima por @RestController
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/skills")
public class SkillRestController {
    
    private final SkillMapper skillMapper;
    private final SkillRepository skillRepository;


    /* uma forma de retorno 
    @GetMapping    
    public ResponseEntity<List<SkillResponse>> findAll(){
        var skills = skillRepository.findAll()
        .stream()
        .map(skillMapper::toSkillResponse)        
        .toList();
        return ResponseEntity.ok().body(skills);
    }
    */
    // outra forma de retorno sem ResponseEntity na declaração do metodo e...
    // sem criação da variavel skills e inclusão da anotação @ResponseBody no Nivel da Classe 
    @GetMapping    
//    @ResponseBody
    public List<SkillResponse> findAll(){
        var skills = skillRepository.findAll()
        .stream()
        .map(skillMapper::toSkillResponse)        
        .toList();         
        skills.forEach( skill -> {
            var id = skill.getId();

            var selflink  = linkTo(
                methodOn(SkillRestController.class).findById(id))
                .withSelfRel()
                .withType("GET");

            var updatelink = linkTo(methodOn(SkillRestController.class).update(id,null))
            .withRel("update")    
            .withType("PUT");

            var deleteLink = linkTo(methodOn(SkillRestController.class).delete(id))
            .withRel("delete")
            .withType("DELETE");

            skill.add(selflink,updatelink,deleteLink);

            
        });
        return skills;
    }

    @GetMapping("/{id}")
    public SkillResponse findById(@PathVariable Long id) {
        var skill = skillRepository.findById(id)
        .map(skillMapper::toSkillResponse)
        .orElseThrow(SkillNotFoundException::new);

        var selflink  = linkTo(
            methodOn(SkillRestController.class).findById(id))
            .withSelfRel()
            .withType("GET");

        var updatelink = linkTo(methodOn(SkillRestController.class).update(id,null))
        .withRel("update")    
        .withType("PUT");

        var deleteLink = linkTo(methodOn(SkillRestController.class).delete(id))
        .withRel("delete")
        .withType("DELETE");

        skill.add(selflink,updatelink,deleteLink);

        return skill;
    }

    @PostMapping   
    @ResponseStatus(code = HttpStatus.CREATED)
    public SkillResponse create(@Valid @RequestBody SkillRequest skillRequest){
        var skill = skillMapper.toSkill(skillRequest);
        skill = skillRepository.save(skill);
        return  skillMapper.toSkillResponse(skill);            
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public SkillResponse update(
        @PathVariable Long id,
        @Valid @RequestBody SkillRequest skillRequest 
    ){
        var skill = skillRepository.findById(id)
        .orElseThrow(SkillNotFoundException::new);
        BeanUtils.copyProperties(skillRequest,skill,"id");
        skill = skillRepository.save(skill);
        return skillMapper.toSkillResponse(skill);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Long id
    ){
        var skill = skillRepository.findById(id)
        .orElseThrow(SkillNotFoundException::new);
        skillRepository.delete(skill);        
        return ResponseEntity.noContent().build();
    }

}
