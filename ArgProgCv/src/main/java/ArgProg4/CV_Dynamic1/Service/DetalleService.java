/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArgProg4.CV_Dynamic1.Service;

import ArgProg4.CV_Dynamic1.Model.DetalleModel;
import ArgProg4.CV_Dynamic1.Repository.DetalleRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tonym
 */
@Service
public class DetalleService {
    @Autowired
    DetalleRepository detalleRepository;
    public ArrayList<DetalleModel> obtenerDetalle(){
        return (ArrayList<DetalleModel>) detalleRepository.findAll();
    }
    
    public DetalleModel guardarDetalle(DetalleModel detalle){
        return detalleRepository.save(detalle);
    }
    
    
}
