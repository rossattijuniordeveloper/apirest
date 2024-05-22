package br.com.parapar.app.api.jobs.dtos;

import java.math.BigDecimal;
import java.util.List;

import br.com.parapar.app.core.enums.JobLevel;
import br.com.parapar.app.core.enums.JobType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobRequest {

    @NotEmpty
    @Size(min = 5, max = 255)
    private String title;

    @NotEmpty
    @Size(min = 5, max = 255)
    private String description;

    @NotEmpty
    @Size(min = 5, max = 50)
    private String company;

    @NotEmpty
    @Size(min = 5, max = 100)
    private String location;

    @NotNull
    private JobType type;

    @NotNull
    private JobLevel level;

    @NotNull
    @Positive
    private BigDecimal salary;

    @NotEmpty
    private List<Long> skills;

}
