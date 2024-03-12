
package com.coronadoportfolio.coronado.Controller;

import com.coronadoportfolio.coronado.Dto.SkillDto;
import com.coronadoportfolio.coronado.Security.Controller.Mensaje;
import com.coronadoportfolio.coronado.model.Skill;
import com.coronadoportfolio.coronado.service.SkillService;
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
@RequestMapping("/skill")
@CrossOrigin(origins = {"https://coronadologin.web.app"})
public class SkillController {
    @Autowired
    SkillService skillService;
    
    @GetMapping("/listaSkill")
    public ResponseEntity<List<Skill>> listaSkill(){
        List<Skill> listaSkill = skillService.listaSkill();
        return new ResponseEntity(listaSkill, HttpStatus.OK);
    }
    
    @GetMapping("/encuentraSkillId/{id}")
    public ResponseEntity<Skill> encuentraSkillId(@PathVariable("id") Long id){
        if(!skillService.existeSkillId(id))
            return new ResponseEntity(new Mensaje("Esta id no existe"), HttpStatus.BAD_REQUEST);
        Optional<Skill> skill = skillService.encuentraSkillId(id);
        return new ResponseEntity(skill, HttpStatus.OK);
    } 
    
    @DeleteMapping("/borrarSkill/{id}")
    public ResponseEntity<?> borrarSkill(@PathVariable("id") Long id){
        if(!skillService.existeSkillId(id))
            return new ResponseEntity(new Mensaje("No se puede borrar la id "+(id)+" por que no existe"), HttpStatus.BAD_REQUEST);
        skillService.borrarSkillId(id);
        return new ResponseEntity(new Mensaje("Id "+(id)+" borrada"), HttpStatus.OK);
    }
    
    @PostMapping("/crearSkill")
    public ResponseEntity<?> crearSkill(@RequestBody SkillDto skillDto){
        if(StringUtils.isBlank(skillDto.getTitulo()))
            return new ResponseEntity(new Mensaje("Este campo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(skillService.existeTitulo(skillDto.getTitulo()))
            return new ResponseEntity(new Mensaje("Ya existe ese titulo"), HttpStatus.BAD_REQUEST);
         
        Skill skill = new Skill(skillDto.getTitulo(), skillDto.getPorcentaje(), skillDto.getInnerColor(), skillDto.getOuterColor());
        skillService.salvarSkill(skill);        
        return new ResponseEntity(new Mensaje("Nuevo Skill guardado"), HttpStatus.OK);
    }
    
    @PutMapping("/editarSkill/{id}")
    public ResponseEntity<?> editarSkill(@PathVariable("id") Long id, @RequestBody SkillDto skillDto){
        if(StringUtils.isBlank(skillDto.getTitulo()))
            return new ResponseEntity(new Mensaje("Este campo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(!skillService.existeSkillId(id))
            return new ResponseEntity(new Mensaje("La "+(id)+" no existe"), HttpStatus.BAD_REQUEST);
        if(skillService.existeTitulo(skillDto.getTitulo()) && skillService.encuentraTitulo(skillDto.getTitulo()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Este skill ya existe con otro id"), HttpStatus.BAD_REQUEST);
           
        Skill skill = skillService.encuentraSkillId(id).get();
        skill.setTitulo(skillDto.getTitulo());
        skill.setPorcentaje(skillDto.getPorcentaje());
        skill.setInnerColor(skillDto.getInnerColor());
        skill.setOuterColor(skillDto.getOuterColor());
        
        skillService.salvarSkill(skill);        
        return new ResponseEntity(new Mensaje("Skill con id "+(id)+" editado"), HttpStatus.OK);
        
    }       
    
}
