/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArgProg4.CV_Dynamic1.Model;

import jakarta.persistence.*;

/**
 *
 * @author tonym
 */
@Entity
@Table(name ="detalle")
public class DetalleModel {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique = true, nullable =false)
    private int iddetalles;
    
    private String puesto;
    private String descripcion;
    private String obs;
    private int iduser;

    public int getIddetalles() {
        return iddetalles;
    }

    public void setIddetalles(int iddetalles) {
        this.iddetalles = iddetalles;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
