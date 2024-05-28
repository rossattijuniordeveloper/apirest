package br.com.parapar.app.api.jobs.mappers;

import br.com.parapar.app.api.jobs.dtos.JobRequest;
import br.com.parapar.app.api.jobs.dtos.JobResponse;
import br.com.parapar.app.core.models.Job;

public interface JobMapper {
    
    JobResponse toJobResponse(Job job);
    
    Job toJob(JobRequest jobRequest);
}
