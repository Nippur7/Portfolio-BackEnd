/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArgProg4.CV_Dynamic1.Controller;

import ArgProg4.CV_Dynamic1.Model.TipoModel;
import ArgProg4.CV_Dynamic1.Service.TipoService;
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
@RequestMapping("/tipo")
public class TipoController {
    @Autowired
    TipoService tipoService;
    
    @GetMapping()
    public ArrayList<TipoModel> obtenerTipo(){
        return tipoService.obtenerTipo();        
    }
    
    @PostMapping(path = "/agregar")
    public TipoModel guardarTipo(@RequestBody TipoModel tipo){
        return this.tipoService.guardarTipo(tipo);
    }

    @GetMapping("/buscar/{id}")
    public TipoModel buscarTipo(@PathVariable Integer id){
        return tipoService.encontrarTipo(id);
    } 

    @DeleteMapping("/borrar/{id}")
    public String borrarTipo(@PathVariable Integer id){
        tipoService.borrarTipo(id);
        return "Eliminación exitosa";
    }



}
