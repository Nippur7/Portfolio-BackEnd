/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArgProg4.CV_Dynamic1.Repository;

import ArgProg4.CV_Dynamic1.Model.DetalleModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tonym
 */
@Repository
public interface DetalleRepository extends CrudRepository<DetalleModel,Integer>{
    
}
