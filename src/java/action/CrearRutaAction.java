package action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.awt.Image;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import maps.java.Geocoding;
import modelo.*;
import utilities.Lugares2DAO;
import utilities.LugaresDAO;
import utilities.MapaDAO;

public class CrearRutaAction extends ActionSupport {

    String NombreLugar;
    String NombreSalida;
    ArrayList<Ruta> ruta;

    String latitud2;
    String longitud2;

    public CrearRutaAction() throws Exception {

    }

    public CrearRutaAction(String NombreLugar, String NombreSalida, ArrayList<Ruta> ruta, String latitud2, String longitud2) {
        this.NombreLugar = NombreLugar;
        this.NombreSalida = NombreSalida;
        this.ruta = ruta;
        this.latitud2 = latitud2;
        this.longitud2 = longitud2;
    }

    public CrearRutaAction(String NombreLugar, ArrayList<Ruta> ruta, String latitud2, String longitud2) {
        this.NombreLugar = NombreLugar;
        this.ruta = ruta;
        this.latitud2 = latitud2;
        this.longitud2 = longitud2;
    }



    public String getLatitud2() {
        return latitud2;
    }

    public void setLatitud2(String latitud2) {
        this.latitud2 = latitud2;
    }

    public String getLongitud2() {
        return longitud2;
    }

    public void setLongitud2(String longitud2) {
        this.longitud2 = longitud2;
    }



    





    public String getNombreLugar() {
        return NombreLugar;
    }

    public void setNombreLugar(String NombreLugar) {
        this.NombreLugar = NombreLugar;
    }

    public String getNombreSalida() {
        return NombreSalida;
    }

    public void setNombreSalida(String NombreSalida) {
        this.NombreSalida = NombreSalida;
    }

    public ArrayList<Ruta> getRuta() {
        return ruta;
    }

    public void setRuta(ArrayList<Ruta> ruta) {
        this.ruta = ruta;
    }
    
    public static void mostrar(String latitud ){
        System.out.println(latitud);
    }

    public String execute() {

        try {

        double latitudD=Double.parseDouble(longitud2);
        double longitudD=Double.parseDouble(latitud2);
        MapaDAO.guardarImagen(NombreSalida, latitudD, longitudD);
        ruta= LugaresDAO.calcularRuta(NombreSalida, latitudD, longitudD);
           
          
            //MapaDAO.guardarImagen(NombreSalida, NombreLugar);
            //ruta = LugaresDAO.calcularRuta(NombreSalida, NombreLugar);

        } catch (Exception ex) {
            Logger.getLogger(CrearRutaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    


}
