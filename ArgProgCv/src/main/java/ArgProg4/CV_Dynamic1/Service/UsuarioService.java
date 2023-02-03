/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArgProg4.CV_Dynamic1.Service;

import ArgProg4.CV_Dynamic1.Model.UsuarioModel;
import ArgProg4.CV_Dynamic1.Repository.UsuarioRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tonym
 */
@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }
    
    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public UsuarioModel encontrarUsuario(Integer id){
        UsuarioModel tipo = usuarioRepository.findById(id).orElse(null);
        return tipo;
    }

    public void borrarUsuario(Integer id){
        usuarioRepository.deleteById(id);
    }

    public void actualizarUsuario(UsuarioModel usuario){
        usuarioRepository.save(usuario);

    }

    public int encontrarEmail(String email){        
        ArrayList<UsuarioModel> users = (ArrayList<UsuarioModel>) usuarioRepository.findAll();                
        int id =-1;
        for (int i = 0 ; i < users.size();i++){
            if(users.get(i).getEmail().equals(email)) {
               //return(users.get(i).getIdusuario());
               id = i;
               return users.get(id).getIdusuario();
            }
        }
        return id;
    }
}
