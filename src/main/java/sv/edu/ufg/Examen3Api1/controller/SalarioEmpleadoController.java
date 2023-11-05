package sv.edu.ufg.Examen3Api1.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.ufg.Examen3Api1.dto.EmpleadoDTO;
import sv.edu.ufg.Examen3Api1.dto.EmpleadoDTO2;
import sv.edu.ufg.Examen3Api1.dto.SalarioEmpleadoDTO;
import sv.edu.ufg.Examen3Api1.model.Empleado;
import sv.edu.ufg.Examen3Api1.model.SalarioEmplado;
import sv.edu.ufg.Examen3Api1.repo.IEmpRepo;
import sv.edu.ufg.Examen3Api1.repo.IMuniRepo;
import sv.edu.ufg.Examen3Api1.repo.ISalarioEmpleadoRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/salarioBase")
public class SalarioEmpleadoController {

    @Autowired
    private ISalarioEmpleadoRepo iSalarioEmpleadoRepo;

    @Autowired
    private IEmpRepo iEmpRepo;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<SalarioEmpleadoDTO>> findAll() {
        List<SalarioEmpleadoDTO> list = iSalarioEmpleadoRepo.findAll().stream().map(p -> modelMapper.map(p, SalarioEmpleadoDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody SalarioEmpleadoDTO salarioEmpleadoDTO) {
        // Convierte PeliculaDTO a Pelicula usando modelMapper
        SalarioEmplado salarioEmplado = modelMapper.map(salarioEmpleadoDTO, SalarioEmplado.class);

        // Guarda la película en la base de datos
        iSalarioEmpleadoRepo.save(salarioEmplado);

        // Devuelve una respuesta 201 Created
        return ResponseEntity.created(null).build();
    }
/* No funciona
    @PutMapping("/{id}")
    public ResponseEntity<SalarioEmpleadoDTO> actualizarEntidad(@PathVariable Integer id, @Valid @RequestBody EmpleadoDTO empleadoDTO) {
        Optional<Empleado> empleadoOptional = iEmpRepo.findById(id);
        if (empleadoOptional.isPresent()) {
            Empleado empleadoExistente = empleadoOptional.get();
            empleadoExistente.setMotivoInactivacion(empleadoDTO.getMotivoInactivacion());
            empleadoExistente.setActivo(false);

            // Guardar la entidad actualizada en la base de datos usando el método save
            Empleado actualizarEmpleadoActivo = iEmpRepo.save(empleadoExistente);

            // Mapear el Empleado actualizado a un EmpleadoDTO
            EmpleadoDTO2 empleadoActualizadoDTO = modelMapper.map(actualizarEmpleadoActivo, EmpleadoDTO.class);

            // Devolver el EmpleadoDTO actualizado en la respuesta
            return ResponseEntity.ok(empleadoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/



}
