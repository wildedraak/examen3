package sv.edu.ufg.Examen3Api1.dto;

import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import sv.edu.ufg.Examen3Api1.model.Departamento;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DepartamentoDTO {
    @EqualsAndHashCode.Include
    private Integer id;

    private String nombre;

}
