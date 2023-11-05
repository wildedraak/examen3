package sv.edu.ufg.Examen3Api1.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sv.edu.ufg.Examen3Api1.model.Empleado;

import java.util.Optional;

public interface IEmpRepo extends IGenericRepo<Empleado,Integer>{
    @Query("SELECT e FROM Empleado e WHERE e.salarioEmplado.id = :salarioEmpladoId")
    Optional<Empleado> findBySalarioEmpladoId(@Param("salarioEmpladoId") Integer salarioEmpladoId);
}
