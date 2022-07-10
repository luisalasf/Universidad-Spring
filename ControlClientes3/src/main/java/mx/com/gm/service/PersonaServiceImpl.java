package mx.com.gm.service;

import mx.com.gm.dao.PersonaDao;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    private PersonaDao personaDao;

    @Override
    @Transactional //si va a modificar info de la base de datos
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional(readOnly = true) //solo de lectura en la base de datos
    public Persona encontrarPersona(Persona persona) {
        //Si no encuentra a la persona, regresa null
        //regresa un Optional<Persona>
        return personaDao.findById(persona.getId_persona()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll(); //regresa un Iterable, por lo que se castea a List
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }
}
