
package com.coronadoportfolio.coronado.Controller;

import com.coronadoportfolio.coronado.Dto.SoftSkillDto;
import com.coronadoportfolio.coronado.Security.Controller.Mensaje;
import com.coronadoportfolio.coronado.model.SoftSkill;
import com.coronadoportfolio.coronado.service.SoftSkillService;
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
@RequestMapping("/softSkill")
@CrossOrigin(origins = {"https://coronadologin.web.app"})
public class SoftSkillController {
    
    @Autowired
    SoftSkillService softSkillService;
    
    @GetMapping("/listaSoft")
    public ResponseEntity<List<SoftSkill>> listaSoft(){
        List<SoftSkill> listaSoft = softSkillService.listaSoft();
        return new ResponseEntity(listaSoft, HttpStatus.OK);
    }
    
    @GetMapping("/encuentraSoftSkillId/{id}")
    public ResponseEntity <SoftSkill> encuentraSoftSkillId(@PathVariable("id") Long id){
        if(!softSkillService.existeSoftSkillId(id))
            return new ResponseEntity(new Mensaje("La id "+(id)+" no existe como softSkill"), HttpStatus.BAD_REQUEST);
        Optional<SoftSkill> softSkill = softSkillService.encuentraSoftSkillId(id);
        return new ResponseEntity(softSkill, HttpStatus.OK);
    }
    
    @DeleteMapping("/borrarSoftSkill/{id}")
    public ResponseEntity<?> borrarSoftSkill(@PathVariable("id") Long id){
        if(!softSkillService.existeSoftSkillId(id))
            return new ResponseEntity(new Mensaje("No existe Soft Skill con id "+(id)), HttpStatus.BAD_REQUEST);
        softSkillService.borrarSoftSkill(id);
        return new ResponseEntity(new Mensaje("SoftSkill con id "+(id)+" borrado"), HttpStatus.OK);
    } 
    
    @PostMapping("/salvarSoftSkill")
    public ResponseEntity<?> salvarSoftSkill(@RequestBody SoftSkillDto softSkillDto){
        if(softSkillService.existeSoftSkill(softSkillDto.getSoftSkill()))
            return new ResponseEntity(new Mensaje("Ya existe ese Soft Skill"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(softSkillDto.getSoftSkill()))
            return new ResponseEntity(new Mensaje("Este campo es obligatorio"), HttpStatus.BAD_REQUEST);
        SoftSkill softSkill = new SoftSkill(softSkillDto.getSoftSkill(), softSkillDto.getSoftPorcentaje(), softSkillDto.getSoftInnerColor(), softSkillDto.getSoftOuterColor());
        softSkillService.salvarSoftSkill(softSkill);
        return new ResponseEntity(new Mensaje("Nueva Soft Skill creada"), HttpStatus.OK);
    }
    
    @PutMapping("/editarSoftSkill/{id}")
    public ResponseEntity<?> editarSoftSkill(@PathVariable("id") Long id, @RequestBody SoftSkillDto softSkillDto){
        if(StringUtils.isBlank(softSkillDto.getSoftSkill()))
            return new ResponseEntity(new Mensaje("Este campo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(!softSkillService.existeSoftSkillId(id))
            return new ResponseEntity(new Mensaje("No existe una Soft Skill con id "+(id)), HttpStatus.BAD_REQUEST);
        if(softSkillService.existeSoftSkill(softSkillDto.getSoftSkill()) && softSkillService.encuentraSoftSkillId(id).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Ya existe esa SoftSkill con otra id"), HttpStatus.BAD_REQUEST);
        
        SoftSkill softSkill = softSkillService.encuentraSoftSkillId(id).get();
        softSkill.setSoftSkill(softSkillDto.getSoftSkill());
        softSkill.setSoftPorcentaje(softSkillDto.getSoftPorcentaje());
        softSkill.setSoftInnerColor(softSkillDto.getSoftInnerColor());
        softSkill.setSoftOuterColor(softSkillDto.getSoftOuterColor());
        
        softSkillService.salvarSoftSkill(softSkill);
        return new ResponseEntity(new Mensaje("Se edito la Soft Skill con id "+(id)), HttpStatus.OK);
    }
}
