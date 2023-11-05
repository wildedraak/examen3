package sv.edu.ufg.Examen3Api1.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.ufg.Examen3Api1.dto.EmpleadoDTO;
import sv.edu.ufg.Examen3Api1.dto.MunicipioDTO;
import sv.edu.ufg.Examen3Api1.dto.SalarioEmpleadoDTO;
import sv.edu.ufg.Examen3Api1.model.Empleado;
import sv.edu.ufg.Examen3Api1.model.Municipio;
import sv.edu.ufg.Examen3Api1.model.SalarioEmplado;
import sv.edu.ufg.Examen3Api1.repo.IEmpRepo;
import sv.edu.ufg.Examen3Api1.repo.IMuniRepo;
import sv.edu.ufg.Examen3Api1.repo.ISalarioEmpleadoRepo;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {

    @Autowired
    private IMuniRepo iMuniRepo;

    @Autowired
    private IEmpRepo iEmpRepo;

    @Autowired
    private ISalarioEmpleadoRepo iSalarioEmpleadoRepo;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> findAll() {
        List<EmpleadoDTO> list = iEmpRepo.findAll().stream().map(p -> modelMapper.map(p, EmpleadoDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //insertar nuevos empleados
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody EmpleadoDTO empleadoDTO) {
        // Convierte EmpleadoDTO a Empleado usando modelMapper
        Empleado empleado = modelMapper.map(empleadoDTO, Empleado.class);

        // Verifica si el MunicipioDTO no es nulo y tiene un id antes de buscar en el repositorio
        if (empleadoDTO.getMunicipio() != null && empleadoDTO.getMunicipio().getId() != null) {
            // Obtiene el Municipio correspondiente del repositorio
            Municipio municipio = iMuniRepo.findById(empleadoDTO.getMunicipio().getId()).orElse(null);
            empleado.setMunicipio(municipio);
        }

        // Verifica si el SalarioEmpleadoDTO no es nulo y tiene un id antes de buscar en el repositorio
        if (empleadoDTO.getSalarioEmplado() != null && empleadoDTO.getSalarioEmplado().getId() != null) {
            // Obtiene el SalarioEmpleado correspondiente del repositorio
            SalarioEmplado salarioEmpleado = iSalarioEmpleadoRepo.findById(empleadoDTO.getSalarioEmplado().getId()).orElse(null);
            empleado.setSalarioEmplado(salarioEmpleado);

            empleado.setActivo(true);
            empleado.setMotivoInactivacion("Activo");
            // Guarda el empleado en la base de datos
            iEmpRepo.save(empleado);
        }
            // Devuelve una respuesta 201 Created
            return ResponseEntity.created(null).build();

    }
}