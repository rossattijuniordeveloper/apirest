package br.com.parapar.app.api.jobs.controllers;

/*
Usando este controller não deu certo 
pois a injeção de depencia abaixo não funcionou
o metodo findSkillsByJobId foi levado para o arquivo JobRestController


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.parapar.app.api.skills.dtos.SkillResponse;
import br.com.parapar.app.api.skills.mappers.SkillMapper;
import br.com.parapar.app.core.exceptions.JobNotFoundException;
import br.com.parapar.app.core.repositories.JobRepository;

@RestController
@RequestMapping("/api/jobs/{id}/skills")
public class JobSkillController {
     Usando este controller não deu certo 
      pois a injeção de depencia abaixo não funcionou
      o metodo findSkillsByJobId foi levado para o arquivo JobRestController

    private final SkillMapper skillMapper;
    private final JobRepository jobRepository;

    @GetMapping()   
    public List<SkillResponse> findSkillsByJobId(@PathVariable Long id){
        var job = jobRepository.findById(id)
        .orElseThrow(JobNotFoundException::new);
        return job.getSkills()
        .stream()
        .map(skillMapper::toSkillResponse)
        .toList();       
    } 
    
}
*/
