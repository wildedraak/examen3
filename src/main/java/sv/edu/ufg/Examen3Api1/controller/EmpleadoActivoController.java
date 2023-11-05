package sv.edu.ufg.Examen3Api1.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.ufg.Examen3Api1.dto.EmpleadoDTO2;
import sv.edu.ufg.Examen3Api1.model.Empleado;
import sv.edu.ufg.Examen3Api1.model.Municipio;
import sv.edu.ufg.Examen3Api1.model.SalarioEmplado;
import sv.edu.ufg.Examen3Api1.repo.IEmpRepo;
import sv.edu.ufg.Examen3Api1.repo.IMuniRepo;
import sv.edu.ufg.Examen3Api1.repo.ISalarioEmpleadoRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/empleadoActivo")
public class EmpleadoActivoController {

    @Autowired
    private IMuniRepo iMuniRepo;

    @Autowired
    private IEmpRepo iEmpRepo;

    @Autowired
    private ISalarioEmpleadoRepo iSalarioEmpleadoRepo;
    @Autowired
    private ModelMapper modelMapper;

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO2> actualizarEntidad(@PathVariable Integer id, @Valid @RequestBody EmpleadoDTO2 empleadoDTO) {
        Optional<Empleado> empleadoOptional = iEmpRepo.findById(id);
        if (empleadoOptional.isPresent()) {
            Empleado empleadoExistente = empleadoOptional.get();
            empleadoExistente.setMotivoInactivacion(empleadoDTO.getMotivoInactivacion());
            empleadoExistente.setActivo(false);

            // Guardar la entidad actualizada en la base de datos usando el método save
            Empleado actualizarEmpleadoActivo = iEmpRepo.save(empleadoExistente);

            // Mapear el Empleado actualizado a un EmpleadoDTO
            EmpleadoDTO2 empleadoActualizadoDTO = modelMapper.map(actualizarEmpleadoActivo, EmpleadoDTO2.class);

            // Devolver el EmpleadoDTO actualizado en la respuesta
            return ResponseEntity.ok(empleadoActualizadoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}