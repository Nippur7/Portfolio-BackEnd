/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArgProg4.CV_Dynamic1.Controller;

import ArgProg4.CV_Dynamic1.Model.DetalleModel;
import ArgProg4.CV_Dynamic1.Service.DetalleService;
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
@RequestMapping("/detalle")
public class DetalleController {
    @Autowired
    DetalleService detalleService;
    
    @GetMapping()
    public ArrayList<DetalleModel> obtenerDetalle(){
        return detalleService.obtenerDetalle();
    }
    
    @PostMapping("/agregar")
    public DetalleModel guardarDetalle(@RequestBody DetalleModel detalle){
        return this.detalleService.guardarDetalle(detalle);
    }
    
    @GetMapping("/buscar/{id}")
    public DetalleModel buscarServicio(@PathVariable Integer id){
        return detalleService.encontrarDetalle(id);
    } 

    @DeleteMapping("/borrar/{id}")
    public String borrarTipo(@PathVariable Integer id){
        detalleService.borrarDetalle(id);
        return "Eliminación exitosa";
    }
    
}
