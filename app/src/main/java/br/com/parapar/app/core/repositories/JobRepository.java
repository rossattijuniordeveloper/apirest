package br.com.parapar.app.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.parapar.app.core.models.Job;

public interface JobRepository extends JpaRepository<Job,Long> {
    
}
