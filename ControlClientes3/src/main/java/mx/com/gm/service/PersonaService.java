package mx.com.gm.service;

import mx.com.gm.domain.Persona;

import java.util.List;

public interface PersonaService {
    //CRUD
    //Create
    public void guardar(Persona persona);
    //Read
    public Persona encontrarPersona(Persona persona);
    public List<Persona> listarPersonas();
    //Delete
    public void eliminar(Persona persona);

}
