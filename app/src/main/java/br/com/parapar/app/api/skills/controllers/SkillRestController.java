package br.com.parapar.app.api.skills.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.parapar.app.api.skills.dtos.SkillResponse;
import br.com.parapar.app.api.skills.mappers.SkillMapper;
import br.com.parapar.app.core.exceptions.SkillNotFoundException;
import br.com.parapar.app.core.repositories.SkillRepository;
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
        return skillRepository.findAll()
        .stream()
        .map(skillMapper::toSkillResponse)        
        .toList();        
    }
    @GetMapping("/{id}")
    public SkillResponse findById(@PathVariable Long id) {
        return skillRepository.findById(id)
        .map(skillMapper::toSkillResponse)
        .orElseThrow(SkillNotFoundException::new);
    }

}
