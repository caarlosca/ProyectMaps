/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Gema
 */
public class Ruta implements Serializable {
    private String tramo;
    private String tiempo;
    private String distancia;
    private String indicaciones;

    public Ruta() {
    }

    public Ruta(String tramo, String tiempo, String distancia, String indicaciones) {
        this.tramo = tramo;
        this.tiempo = tiempo;
        this.distancia = distancia;
        this.indicaciones = indicaciones;
    }
    
    

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }
 

    public String getTramo() {
        return tramo;
    }

    public void setTramo(String tramo) {
        this.tramo = tramo;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    @Override
    public String toString() {
        return "Ruta{" + "tramo=" + tramo + ", tiempo=" + tiempo + ", distancia=" + distancia + ", indicaciones=" + indicaciones + '}';
    }


    
    
    
}
