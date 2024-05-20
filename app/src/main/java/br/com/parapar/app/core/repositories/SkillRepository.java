package br.com.parapar.app.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.parapar.app.core.models.Skill;

public interface SkillRepository extends JpaRepository<Skill,Long> {
    
}
