package br.com.parapar.app.api.jobs.dtos;

import java.math.BigDecimal;


import br.com.parapar.app.core.enums.JobLevel;
import br.com.parapar.app.core.enums.JobType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobResponse {
    
    private Long id;
    
    private String title;

    private String description;

    private String company;

    private String location;

    private JobType type;

    private JobLevel level;

    private BigDecimal salary;


}
