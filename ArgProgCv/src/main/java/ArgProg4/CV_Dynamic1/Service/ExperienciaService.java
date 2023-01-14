/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArgProg4.CV_Dynamic1.Service;

import ArgProg4.CV_Dynamic1.Model.ExperienciaModel;
import ArgProg4.CV_Dynamic1.Repository.ExperienciaRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tonym
 */
@Service
public class ExperienciaService {
    @Autowired
    ExperienciaRepository experienciaRepository;
    public ArrayList<ExperienciaModel> obtenerExperiencia(){
        return (ArrayList<ExperienciaModel>) experienciaRepository.findAll();
    }
    
    public ExperienciaModel guardarExperiencia(ExperienciaModel experiencia){
        return experienciaRepository.save(experiencia);
        
    }

    public ExperienciaModel encontrarExperiencia(Integer id){
        ExperienciaModel tipo = experienciaRepository.findById(id).orElse(null);
        return tipo;
    }

    public void borrarExperiencia(Integer id){
        experienciaRepository.deleteById(id);
    }
    
    
    
}
