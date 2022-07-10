package mx.com.gm;

import lombok.extern.slf4j.Slf4j;
import lombok.var;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class ControladorInicio {
    @Value("${index.saludo}")
    private String saludo;

    @GetMapping("/")
    public String inicio(Model model){
        var mensaje = "Adios con Thymeleaf";
        Persona persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setEmail("jperez@mail.com");
        persona.setTelefono("030478654");

        Persona persona2 = new Persona();
        persona2.setNombre("Paco");
        persona2.setApellido("Salas");
        persona2.setEmail("psalas@mail.com");
        persona2.setTelefono("55619302215");

        List <Persona> personas = new ArrayList<>();
        personas.add(persona);
        personas.add(persona2);

        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);
        return "index";
    }
}
