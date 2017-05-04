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
    ArrayList<Ruta> ruta;

    public CrearRutaAction() throws Exception {

    }

    public CrearRutaAction(String NombreLugar, String NombreSalida, ArrayList<Ruta> ruta) {
        this.NombreLugar = NombreLugar;
        this.NombreSalida = NombreSalida;
        this.ruta = ruta;
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

    public String execute() {
        try {
            MapaDAO.guardarImagen(NombreSalida, NombreLugar);
            ruta = LugaresDAO.calcularRuta(NombreSalida, NombreLugar);

        } catch (Exception ex) {
            Logger.getLogger(CrearRutaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }

}
