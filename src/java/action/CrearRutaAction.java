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
import modelo.*;
import utilities.Lugares2DAO;
import utilities.LugaresDAO;
import utilities.MapaDAO;

/**
 *
 * @author admin
 */
public class CrearRutaAction extends ActionSupport{

    String nombre;

    public CrearRutaAction() {
    }

    public CrearRutaAction(String nombre) {
        this.nombre = nombre;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
     public String execute() {
     
         
     return SUCCESS;
     }
    
}
