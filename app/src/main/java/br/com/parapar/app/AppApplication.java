package br.com.parapar.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/* 
// utilizado para Incluir na Inicialização um JOB 

import java.math.BigDecimal;
import java.util.List;
import org.springframework.boot.CommandLineRunner;



import br.com.parapar.app.core.enums.JobLevel;
import br.com.parapar.app.core.enums.JobType;
import br.com.parapar.app.core.models.Job;
import br.com.parapar.app.core.repositories.JobRepository;
import br.com.parapar.app.core.repositories.SkillRepository;
import lombok.RequiredArgsConstructor;

*/
@SpringBootApplication
public class AppApplication{

	public static void main(String[] args) {		
		SpringApplication.run(AppApplication.class, args);
	}
}

/* 
// utilizado para Incluir na Inicialização um JOB 
@SpringBootApplication
@RequiredArgsConstructor
public class AppApplication implements CommandLineRunner {

		private final JobRepository jobRepository;
		private final SkillRepository skillRepository;

	public static void main(String[] args) {		
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		var javaSkill = skillRepository.findById(2L).get();
		var springSkill = skillRepository.findById(3L).get();

		var job = Job.builder()
			.title("Desenvoledor Back-End Java")
			.description("Vaga para dev que saiba Java e Spring")
			.company("ParaPar Tecnologia")
			.location("Cuiaba - MT")
			.salary(new BigDecimal(16500.00))
			.level(JobLevel.SENIOR)
			.type(JobType.FULL_TIME)
			.skills(List.of(javaSkill,springSkill))
			.build();
		jobRepository.save(job)	;
		
	}
}
*/




