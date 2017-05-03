/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import modelo.Ruta;
import utilities.LugaresDAO;

/**
 *
 * @author Gema
 */
public class MostrarRutaAction extends ActionSupport{
   ArrayList<Ruta> ruta;

    public MostrarRutaAction() {
    }

    public MostrarRutaAction(ArrayList<Ruta> ruta) {
        this.ruta = ruta;
    }
    
    

    public ArrayList<Ruta> getRuta() {
        return ruta;
    }

    public void setRuta(ArrayList<Ruta> ruta) {
        this.ruta = ruta;
    }
    
    
    
    
    


    
    public String execute() throws Exception {
        
        
    ruta=LugaresDAO.calcularRuta("parque de atracciones", "puerta del sol");
            
        return SUCCESS; 
    }
    
    
}
