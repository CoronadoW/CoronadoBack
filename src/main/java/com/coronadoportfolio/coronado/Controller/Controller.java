package com.coronadoportfolio.coronado.Controller;

import com.coronadoportfolio.coronado.model.Persona;
import com.coronadoportfolio.coronado.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://coronadologin.web.app")
public class Controller {   
   
   @Autowired
   private IPersonaService persoServ;
    
    @PostMapping("/Persona/new")
    public void newPersona(@RequestBody Persona pers){
        persoServ.newPersona(pers);
    }
    
    @GetMapping("/Persona/ver")
    @ResponseBody
    public List<Persona> verPersonas(){
        return persoServ.verPersonas();
    }
    
    @DeleteMapping("/Persona/delete/{id}")
    public void deletePersona(@PathVariable Long id){
        persoServ.deletePersona(id);
    }
    
    @GetMapping("/Persona/find/{id}")
    public Persona findPersona(@PathVariable Long id){
        return persoServ.findPersona(id);
    }
    
    @PutMapping("/Persona/update/{id}")
    public void updatePersona(@PathVariable Long id,
                              @RequestParam("nombre") String newNombre,
                              @RequestParam("titulo") String newTitulo,
                              @RequestParam("img") String newImg){
        
        Persona pers = persoServ.findPersona(id);
        
        pers.setNombre(newNombre); 
        pers.setTitulo(newTitulo);
        pers.setImg(newImg);
        
        persoServ.updatePersona(pers);
    }
    
    @GetMapping("/Persona/ver/perfil")
    public Persona findPersona(){
        
        return persoServ.findPersona((long)1);
    }
}

/*Como parte de la implementacion del back en el front, para evitar el error de cors ingreso la anotation @croosOrigin(origins = "http://localhost:4200")
Estoy haciendo llamados desde esta url, aceptalas 
un comentario mas para ver el git*/
