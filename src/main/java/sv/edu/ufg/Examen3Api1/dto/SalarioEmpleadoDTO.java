package sv.edu.ufg.Examen3Api1.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import sv.edu.ufg.Examen3Api1.model.Empleado;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SalarioEmpleadoDTO {
    @EqualsAndHashCode.Include
    private Integer id;
    @NotNull
    private Double salario_base;


}
