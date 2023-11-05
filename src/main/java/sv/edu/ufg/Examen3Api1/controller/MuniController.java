package sv.edu.ufg.Examen3Api1.controller;


import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sv.edu.ufg.Examen3Api1.dto.DepartamentoDTO;
import sv.edu.ufg.Examen3Api1.dto.MunicipioDTO;
import sv.edu.ufg.Examen3Api1.model.Municipio;
import sv.edu.ufg.Examen3Api1.repo.IDepaRepo;
import sv.edu.ufg.Examen3Api1.repo.IMuniRepo;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/municipio")
public class MuniController {

    @Autowired
    private IMuniRepo iMuniRepo;
    @Autowired
    private IDepaRepo iDepaRepo;
    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/departamento/{nombreDepartamento}")
    public ResponseEntity<List<Municipio>> getMunicipiosByDepartamento(@PathVariable String nombreDepartamento) {
        List<Municipio> municipios = iMuniRepo.findMunicipiosByDepartamentoNombre(nombreDepartamento);

        if (municipios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(municipios, HttpStatus.OK);
    }

}
