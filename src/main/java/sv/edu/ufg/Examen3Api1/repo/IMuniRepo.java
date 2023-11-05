package sv.edu.ufg.Examen3Api1.repo;

import sv.edu.ufg.Examen3Api1.model.Municipio;

import java.util.List;

public interface IMuniRepo extends IGenericRepo<Municipio,Integer>{
    List<Municipio> findMunicipiosByDepartamentoNombre(String nombreDepartamento);
}
