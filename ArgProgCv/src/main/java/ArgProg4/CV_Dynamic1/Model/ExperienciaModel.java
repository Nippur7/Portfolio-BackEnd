/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArgProg4.CV_Dynamic1.Model;

import jakarta.persistence.*;
import java.sql.Date;

/**
 *
 * @author tonym
 */
@Entity
@Table(name = "experiencia")
public class ExperienciaModel {
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int idexperiencia;
    private String lugar;
    private Date inicio;
    private Date fin;
    private int iddetalles;
    private int tipo;
    private String obs;     
    //@Id
    //@Column(unique = false, nullable = false)
    private int iduser;

    public int getIdexperiencia() {
        return idexperiencia;
    }

    public void setIdexperiencia(int idexperiencia) {
        this.idexperiencia = idexperiencia;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public int getIddetalles() {
        return iddetalles;
    }

    public void setIddetalles(int iddetalles) {
        this.iddetalles = iddetalles;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    
}
