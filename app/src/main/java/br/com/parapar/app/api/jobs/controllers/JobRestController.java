package br.com.parapar.app.api.jobs.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.parapar.app.api.jobs.dtos.JobResponse;
import br.com.parapar.app.api.jobs.mappers.JobMapper;
import br.com.parapar.app.core.exceptions.JobNotFoundException;
import br.com.parapar.app.core.repositories.JobRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jobs")
public class JobRestController {
    private final JobMapper jobMapper;
    private final JobRepository jobRepository;

    @GetMapping
    public List<JobResponse> findAll() {
        return jobRepository.findAll()
        .stream()
        .map(jobMapper:: toJobResponse)
        .toList();
    }
    @GetMapping("/{id}")
    public JobResponse finById(@PathVariable Long id){
        var job = jobRepository.findById(id)
        .orElseThrow(JobNotFoundException::new);       
        return jobMapper.toJobResponse(job);
    }

    
}
