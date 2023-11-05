package sv.edu.ufg.Examen3Api1.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import sv.edu.ufg.Examen3Api1.model.Empleado;
import sv.edu.ufg.Examen3Api1.model.Municipio;
import sv.edu.ufg.Examen3Api1.model.SalarioEmplado;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EmpleadoDTO {

    @EqualsAndHashCode.Include
    private Integer id;
    @NotNull
    private String apellido;
    @NotNull
    private String nombre;
    @NotNull
    private String genero;
    @NotNull
    private String telefono;
    @NotNull
    private MunicipioDTO municipio;
    @NotNull
    private SalarioEmpleadoDTO salarioEmplado;
    @NotNull
    private String motivoInactivacion;

    @NotNull
    private Boolean activo;



    public MunicipioDTO getMunicipio() {
        return municipio;
    }

    public void setMunicipio(MunicipioDTO municipio) {
        this.municipio = municipio;
    }


}
