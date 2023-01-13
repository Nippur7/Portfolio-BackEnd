/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArgProg4.CV_Dynamic1.Service;

import ArgProg4.CV_Dynamic1.Model.SkillModel;
import ArgProg4.CV_Dynamic1.Repository.SkillRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author tonym
 */
@Service
public class SkillService {
    
    @Autowired
    SkillRepository skillRepository;
    
    public ArrayList<SkillModel> obtenerSkill(){
        return (ArrayList<SkillModel>) skillRepository.findAll();
    }
    
    public SkillModel guardarSkill(SkillModel skill){
        return skillRepository.save(skill);
    }
}
