/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArgProg4.CV_Dynamic1.Controller;

import java.util.ArrayList;

//import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ArgProg4.CV_Dynamic1.Model.UsuarioModel;
import ArgProg4.CV_Dynamic1.Service.UsuarioService;
//import io.micrometer.common.util.StringUtils;

/**
 *
 * @author tonym
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }
    
    @PostMapping(path = "/agregar")
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
        
    }

    @GetMapping("/buscar/{id}")
    public UsuarioModel buscarUsuario(@PathVariable Integer id){
        return usuarioService.encontrarUsuario(id);
    } 

    @DeleteMapping("/borrar/{id}")
    public String borrarUsuario(@PathVariable Integer id){
        usuarioService.borrarUsuario(id);
        return "Eliminación exitosa";
    }

    //@PostMapping("/users/save")
    //public RedirectView saveUser(UsuarioModel user,
    //        @RequestParam("image") MultipartFile multipartFile) throws IOException {
         
        //String fileName = StringUtils.(multipartFile.getOriginalFilename());
        //user.setPicture(fileName);

         
      //  UsuarioModel savedUser = usuarioService.guardarUsuario(user);
 
        //String uploadDir = "user-photos/" + savedUser.getIdusuario();
 
        //FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
         
        //return new RedirectView("/users", true);
    //}

}
