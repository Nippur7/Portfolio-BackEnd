/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArgProg4.CV_Dynamic1.Service;

import ArgProg4.CV_Dynamic1.Model.ContactoModel;
import ArgProg4.CV_Dynamic1.Repository.ContactoRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tonym
 */

@Service
public class ContactoService {
    
    @Autowired
    ContactoRepository contactoRepository;
    
    public ArrayList<ContactoModel> obtenerContacto(){
        return (ArrayList<ContactoModel>) contactoRepository.findAll();
    }
    
    public ContactoModel guardarContacto(ContactoModel contacto){
        return contactoRepository.save(contacto);
    }
}
