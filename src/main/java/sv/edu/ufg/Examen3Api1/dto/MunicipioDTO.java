package sv.edu.ufg.Examen3Api1.dto;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import sv.edu.ufg.Examen3Api1.model.Departamento;
import sv.edu.ufg.Examen3Api1.model.Municipio;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MunicipioDTO {

    @EqualsAndHashCode.Include
    private Integer id;
    @NotNull
    private String nombre;
    @NotNull
    private DepartamentoDTO departamento;
}
