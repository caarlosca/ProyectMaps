
package modelo;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



public class Lugares implements Serializable {
    
    private String nombre;
    private String calle;
    private double longitud;
    private double latitud;

    public Lugares() {
    }

    public Lugares(String nombre, String calle, double longitud, double latitud) {
        this.nombre = nombre;
        this.calle = calle;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public Lugares(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    


    
    
}
