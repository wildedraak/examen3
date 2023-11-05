package sv.edu.ufg.Examen3Api1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String apellido;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "municipio_id", referencedColumnName = "id")
    private Municipio municipio;

    private String genero;
    private String telefono;


    //Posterior llamnano
    @ManyToOne
    @JoinColumn(name = "salarioEmplado_id", referencedColumnName = "id")
    private SalarioEmplado salarioEmplado;
    private String motivoInactivacion;
    private Boolean activo;
    




}
