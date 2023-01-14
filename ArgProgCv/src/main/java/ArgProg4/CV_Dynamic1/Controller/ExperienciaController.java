 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArgProg4.CV_Dynamic1.Controller;

import ArgProg4.CV_Dynamic1.Model.ExperienciaModel;
import ArgProg4.CV_Dynamic1.Service.ExperienciaService;
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
@RequestMapping("/experiencia")
public class ExperienciaController {
    @Autowired
    ExperienciaService experienciaService;
    
    @GetMapping()
    public ArrayList<ExperienciaModel> obtenerExperiencia(){
        return experienciaService.obtenerExperiencia();
    }
    
    @PostMapping(path = "/agregar")
    public ExperienciaModel guardarExperiencia(@RequestBody ExperienciaModel experiencia){
        return this.experienciaService.guardarExperiencia(experiencia);
        
    }
    
    @GetMapping("/buscar/{id}")
    public ExperienciaModel buscarTipo(@PathVariable Integer id){
        return experienciaService.encontrarExperiencia(id);
    } 

    @DeleteMapping("/borrar/{id}")
    public String borrarTipo(@PathVariable Integer id){
        experienciaService.borrarExperiencia(id);
        return "Eliminación exitosa";
    }

    @GetMapping("/usuario/{id}")
    public ArrayList<ExperienciaModel> obtenerExpUser(@PathVariable Integer id){
        ArrayList<ExperienciaModel> byUser = new ArrayList<ExperienciaModel>();
        ArrayList<ExperienciaModel> aux = experienciaService.obtenerExperiencia();
        //Integer ii = 0;
        for (int i=0;i<aux.size();i++) {      
            //System.out.println(lista.get(i));
            if(aux.get(i).getIduser() == id){
                byUser.add(aux.get(i));

            }
          }
        return byUser;
    }
    
}
