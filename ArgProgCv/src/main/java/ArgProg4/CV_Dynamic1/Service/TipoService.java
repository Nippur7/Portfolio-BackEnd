/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArgProg4.CV_Dynamic1.Service;

import ArgProg4.CV_Dynamic1.Model.TipoModel;
import ArgProg4.CV_Dynamic1.Repository.TipoRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tonym
 */
@Service
public class TipoService {
    @Autowired
    TipoRepository tipoRepository;
    
    public ArrayList<TipoModel> obtenerTipo(){
        return (ArrayList<TipoModel>) tipoRepository.findAll();
    }
    
    public TipoModel guardarTipo(TipoModel tipo){
         return tipoRepository.save(tipo);
    }
    
    public TipoModel encontrarTipo(Integer id){
        TipoModel tipo = tipoRepository.findById(id).orElse(null);
        return tipo;
    }

    public void borrarTipo(Integer id){
        tipoRepository.deleteById(id);
    }

}
