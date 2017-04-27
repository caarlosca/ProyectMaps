/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Curso Mañana
 */
@Entity
public class Lugares implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private float latitud;
    private float longitud;
    private String nombre;

    public Lugares() {
    }

    //ejemplo gitaffasfafafaf
    public Lugares(int id, float latitud, float longitud, String nombre) {
        this.id = id;
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombre = nombre;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Lugares{" + "id=" + id + ", latitud=" + latitud + ", longitud=" + longitud + ", nombre=" + nombre + '}';
    }


    
    
}
