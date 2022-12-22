/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miaplicacion.primerproyecto.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author tonym
 */
@RestController

/**
 *
 * @author tonym
 */
public class HolaController1 {
    @GetMapping("/hola/{nombre}")
    public String decirHola(@PathVariable String nombre){
        return "Holitas pues, ahora si funciona " + nombre;
    }
    
}
