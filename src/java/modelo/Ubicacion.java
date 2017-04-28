package modelo;

/**
 *
 * @author Luis Marcos
 */

//adsd
public class Ubicacion {
    
    private  double latitud;
    private  double longitud;
    private static String direccion;

    public Ubicacion() {
    }

    public Ubicacion(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

  

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setLatitud(double aLatitud) {
        latitud = aLatitud;
    }

    public void setLongitud(double aLongitud) {
        longitud = aLongitud;
    }

    public void setDireccion(String aDireccion) {
        direccion = aDireccion;
    }
    
}
