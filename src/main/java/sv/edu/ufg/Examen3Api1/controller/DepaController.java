package sv.edu.ufg.Examen3Api1.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.ufg.Examen3Api1.dto.DepartamentoDTO;
import sv.edu.ufg.Examen3Api1.dto.MunicipioDTO;
import sv.edu.ufg.Examen3Api1.model.Municipio;
import sv.edu.ufg.Examen3Api1.repo.IDepaRepo;
import sv.edu.ufg.Examen3Api1.repo.IMuniRepo;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/departamentosSV")
public class DepaController {

    @Autowired
    private IDepaRepo iDepaRepo;

    @Autowired
    private IMuniRepo iMuniRepo;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<DepartamentoDTO>> findAll() {
        List<DepartamentoDTO> list = iDepaRepo.findAll().stream().map(p -> modelMapper.map(p, DepartamentoDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


}
