package br.com.parapar.app.api.jobs.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.parapar.app.api.jobs.dtos.JobRequest;
import br.com.parapar.app.api.jobs.dtos.JobResponse;
import br.com.parapar.app.api.jobs.mappers.JobMapper;
import br.com.parapar.app.core.exceptions.JobNotFoundException;
import br.com.parapar.app.core.repositories.JobRepository;
import jakarta.validation.Valid;
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
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public JobResponse create(@RequestBody @Valid JobRequest jobRequest){
        var job = jobMapper.toJob(jobRequest);
        job = jobRepository.save(job);
        return jobMapper.toJobResponse(job);
    }
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public JobResponse update(
        @RequestBody @Valid JobRequest jobRequest,
        @PathVariable Long id
        ){
            var job = jobRepository.findById(id)
            .orElseThrow(JobNotFoundException::new);
            var jobData = jobMapper.toJob(jobRequest);
            BeanUtils.copyProperties(jobData,job,"id");
            job = jobRepository.save(job);
            return jobMapper.toJobResponse(job);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        var job = jobRepository.findById(id)
        .orElseThrow(JobNotFoundException::new);
        jobRepository.delete(job);
    }    
}
