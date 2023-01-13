/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArgProg4.CV_Dynamic1.Controller;

import ArgProg4.CV_Dynamic1.Model.ContactoModel;
import ArgProg4.CV_Dynamic1.Service.ContactoService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tonym
 */
@RestController
@RequestMapping(path = "contacto")
public class ContactoController {
    
    @Autowired
    ContactoService contactoService;
    
    @GetMapping()
    public ArrayList<ContactoModel> obtenerContacto(){
        return contactoService.obtenerContacto();
    }
    
    @PostMapping(path = "/agregar")
    public ContactoModel guardarContacto(@RequestBody ContactoModel contacto){
        return this.contactoService.guardarContacto(contacto);
    
 
    }
}
