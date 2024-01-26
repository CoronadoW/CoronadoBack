package com.coronadoportfolio.coronado.Controller;

import com.coronadoportfolio.coronado.Dto.ExperienciaDto;
import com.coronadoportfolio.coronado.Security.Controller.Mensaje;
import com.coronadoportfolio.coronado.model.Experiencia;
import com.coronadoportfolio.coronado.service.ExperienciaService;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("experiencia")
@CrossOrigin(origins = "http://localhost:4200")

public class ExperienciaController {

    @Autowired
    ExperienciaService experienciaService;
   
    @GetMapping("/lista")
    public ResponseEntity <List<Experiencia>> lista(){
        List<Experiencia> lista =  experienciaService.list();
        return new ResponseEntity ( lista , HttpStatus.OK);
    }
    @GetMapping("/traeme/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") long id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity (new Mensaje("No se encontró esa id"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = experienciaService.traeUno(id).get();
        return new ResponseEntity (experiencia, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExperienciaDto expDto) {
        if (StringUtils.isBlank(expDto.getLugarExp())) 
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (experienciaService.existsByLugarExp(expDto.getLugarExp()))
            return new ResponseEntity(new Mensaje( "Ese lugar de exper. ya existe"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia(expDto.getLugarExp(), expDto.getDescripcionExp(), expDto.getAnioExp(), expDto.getImgExp());
        experienciaService.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia Agregada"), HttpStatus.OK);        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody ExperienciaDto expDto){
        //Validacion si existe el ID
        if (!experienciaService.existsById(id))
            return new ResponseEntity (new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        //Verifica que no exista ya ese lugarExp. Para verificar que no estemos intentanto ingresar la misma experiencia con otro id
        if (experienciaService.existsByLugarExp(expDto.getLugarExp()) && experienciaService.getByLugarExp(expDto.getLugarExp()).get().getId() !=id) 
            return new ResponseEntity (new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);        
         //Verifica que el campo no este vacio
        if (StringUtils.isBlank(expDto.getLugarExp()))
            return new ResponseEntity(new Mensaje("Este campo es obligatorio"), HttpStatus.BAD_REQUEST);
       
        Experiencia experiencia = experienciaService.traeUno(id).get();
        experiencia.setLugarExp(expDto.getLugarExp());
        experiencia.setDescripcionExp(expDto.getDescripcionExp());
        experiencia.setAnioExp(expDto.getAnioExp());
        experiencia.setImgExp(expDto.getImgExp());
        
        experienciaService.save(experiencia);
        return new ResponseEntity (new Mensaje("Experiencia con Id "+(id)+" Actualizada"),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity (new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        experienciaService.delete(id);
            return new ResponseEntity (new Mensaje("Experiencia con Id "+(id)+" borrada"),HttpStatus.OK);       
            
    }
    
}




/*
@Autowired para inyectar una instancia de la clase ExperienciaService
ExperienciaService experienciaService; declaramos la variable "experienciaService de tipo "ExperienciaService"
El @Autowired se encargara de asignar una instancia de la clase "ExperienciaService" a esta variable
public ResponseEntity<List<Experiencia>> list(): Este es el inicio de un método llamado "list" que devuelve un objeto "ResponseEntity" que contiene una lista de objetos "Experiencia". Un "ResponseEntity" es utilizado en aplicaciones de Spring para representar una respuesta HTTP y proporciona métodos para controlar el código de estado HTTP, encabezados y cuerpo de la respuesta.

List<Experiencia> list = experienciaService.list();: En esta línea, se llama al método "list" en el objeto "experienciaService" para obtener una lista de objetos "Experiencia". La variable "list" se utiliza para almacenar el resultado de esta llamada.

return new ResponseEntity(list, HttpStatus.ok);: Aquí se crea un nuevo objeto "ResponseEntity" pasando la lista obtenida como cuerpo de la respuesta y el estado "HttpStatus.ok" (que representa el código de estado HTTP 200, indicando una respuesta exitosa). Este objeto se devuelve como resultado del método "list".

En resumen, el método "list" en la clase "ExperienciaController" utiliza la instancia de "ExperienciaService" (que se inyecta automáticamente mediante la anotación @Autowired) para obtener una lista de objetos "Experiencia". Luego, se crea un objeto "ResponseEntity" que contiene esta lista y se devuelve como respuesta HTTP con un código de estado 200 (OK).
 */
