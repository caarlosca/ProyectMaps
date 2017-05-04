/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.awt.Image;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.*;
import utilities.Lugares2DAO;
import utilities.LugaresDAO;
import utilities.MapaDAO;

/**
 *
 * @author admin
 */
public class CrearRutaAction extends ActionSupport {

    String NombreLugar;
    String NombreSalida;
 ArrayList<Ruta> lugares2;

    public ArrayList<Ruta> getLugares2() {
        return lugares2;
    }

    public void setLugares2(ArrayList<Ruta> lugares2) {
        this.lugares2 = lugares2;
    }

    public CrearRutaAction(String NombreLugar, String NombreSalida, ArrayList<Ruta> lugares2) {
        this.NombreLugar = NombreLugar;
        this.NombreSalida = NombreSalida;
        this.lugares2 = lugares2;
    }

    public CrearRutaAction(ArrayList<Ruta> lugares2) {
        this.lugares2 = lugares2;
    }
 
 
 
 
    public CrearRutaAction(String NombreLugar, String NombreSalida) {
        this.NombreLugar = NombreLugar;
        this.NombreSalida = NombreSalida;
    }

    public String getNombreSalida() {
        return NombreSalida;
    }

    public void setNombreSalida(String NombreSalida) {
        this.NombreSalida = NombreSalida;
    }

    public CrearRutaAction() {
    }

    public String getNombreLugar() {
        return NombreLugar;
    }

    public void setNombreLugar(String NombreLugar) {
        this.NombreLugar = NombreLugar;
    }

    public CrearRutaAction(String NombreLugar) {
        this.NombreLugar = NombreLugar;
    }

    public String execute() {
        try {
            
           lugares2 =LugaresDAO.calcularRuta(NombreSalida, NombreLugar);
            MapaDAO.guardarImagen(NombreSalida, NombreLugar);
            
        } catch (Exception ex) {
            Logger.getLogger(CrearRutaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }

}
