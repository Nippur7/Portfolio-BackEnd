/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArgProg4.CV_Dynamic1.Controller;

import ArgProg4.CV_Dynamic1.Model.SkillModel;
import ArgProg4.CV_Dynamic1.Service.SkillService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tonym
 */
@RestController
@RequestMapping(path = "/skill")
public class SkillController {
    @Autowired
    SkillService skillService;
    
    @GetMapping()
    public ArrayList<SkillModel> obtenerSkill(){
        return skillService.obtenerSkill();
    }
    
    @PostMapping(path = "/agregar")
    public SkillModel guardarSkill(@RequestBody SkillModel skill){
        return skillService.guardarSkill(skill);
    }

    @GetMapping("/buscar/{id}")
    public SkillModel buscarTipo(@PathVariable Integer id){
        return skillService.encontrarSkill(id);
    } 

    @DeleteMapping("/borrar/{id}")
    public String borrarTipo(@PathVariable Integer id){
        skillService.borrarSkill(id);
        return "Eliminación exitosa";
    }

}
