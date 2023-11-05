package sv.edu.ufg.Examen3Api1.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EmpleadoDTO2 {


    @NotNull
    private String motivoInactivacion;




}
