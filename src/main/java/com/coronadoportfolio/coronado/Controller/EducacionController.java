
package com.coronadoportfolio.coronado.Controller;

import com.coronadoportfolio.coronado.Dto.EducacionDto;
import com.coronadoportfolio.coronado.Security.Controller.Mensaje;
import com.coronadoportfolio.coronado.model.Educacion;
import com.coronadoportfolio.coronado.service.EducacionService;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("educacion")
@CrossOrigin(origins = "http://localhost:4200")

public class EducacionController {  
    @Autowired
    EducacionService educacionService;
    
    @GetMapping("/listaEducacion")
    public ResponseEntity<List<Educacion>> listaEducacion(){
        List<Educacion> listaEducacion = educacionService.listaEdu();
        return new ResponseEntity(listaEducacion, HttpStatus.OK);
    }
    
    @GetMapping("/traeId/{id}")
    public ResponseEntity <Educacion> traeId(@PathVariable("id") Long id){
        if(!educacionService.existeId(id))
            return new ResponseEntity(new Mensaje("No existe esa Id"), HttpStatus.BAD_REQUEST);
        Optional<Educacion> educacion = educacionService.encuentraId(id);
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/borrarId/{id}")
    public ResponseEntity<?> borrarId(@PathVariable("id") Long id){
        if(!educacionService.existeId(id))
            return new ResponseEntity(new Mensaje("No existe la Id "+(id)), HttpStatus.NOT_FOUND);
        educacionService.borraId(id);
        return new ResponseEntity(new Mensaje("Se borro id "+(id)), HttpStatus.OK);
    }
    
    @PostMapping("/crearEducacion")
    public ResponseEntity<?> crearEducacion(@RequestBody EducacionDto eduDto){
        if(StringUtils.isBlank(eduDto.getLugarEdu()))
            return new ResponseEntity(new Mensaje("Este campo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(educacionService.existeLugarEdu(eduDto.getLugarEdu()))
            return new ResponseEntity(new Mensaje("Ya existe esta Educacion"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = new Educacion(eduDto.getLugarEdu(), eduDto.getDescripcionEdu(), eduDto.getAnioEdu(), eduDto.getImgEdu());
        educacionService.salvarEdu(educacion);
        return new ResponseEntity(new Mensaje("Nueva Educacion creada"), HttpStatus.OK);
    }
    
    
    @PutMapping("/editarId/{id}")
    public ResponseEntity<?> editarId(@PathVariable("id") Long id, @RequestBody EducacionDto eduDto){
        if(StringUtils.isBlank(eduDto.getLugarEdu()))
            return new ResponseEntity(new Mensaje("Este campo es obligatorio"), HttpStatus.BAD_REQUEST);        
        if(!educacionService.existeId(id))
            return new ResponseEntity(new Mensaje("No existe la id "+(id)), HttpStatus.BAD_REQUEST);
        //Aqui hay una diferencia con experienciaController, el uso del !Objects.equals
        //if(educacionService.existeLugarEdu(eduDto.getLugarEdu())&& !Objects.equals(educacionService.encuentraLugarEdu(eduDto.getLugarEdu()).get().getId(), id))
            //return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        if(educacionService.existeLugarEdu(eduDto.getLugarEdu())&& educacionService.encuentraLugarEdu(eduDto.getLugarEdu()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Esta Educacion ya existe con otro id"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = educacionService.encuentraId(id).get();
        educacion.setLugarEdu(eduDto.getLugarEdu());
        educacion.setDescripcionEdu(eduDto.getDescripcionEdu());
        educacion.setAnioEdu(eduDto.getAnioEdu());
        educacion.setImgEdu(eduDto.getImgEdu());
        
        educacionService.salvarEdu(educacion);
        return new ResponseEntity(new Mensaje("Educacion editada"), HttpStatus.OK);
    }          
} 
