/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import modelo.*;
import utilities.Lugares2DAO;
import utilities.LugaresDAO;

/**
 *
 * @author admin
 */
public class LugaresAction extends ActionSupport{
     ArrayList<Lugares> lugares;

    public ArrayList<Lugares> getLugares() {
        return lugares;
    }

    public void setLugares(ArrayList<Lugares> lugares) {
        this.lugares = lugares;
    }

    public LugaresAction() {
    }

    public LugaresAction(ArrayList<Lugares> lugares) {
        this.lugares = lugares;
    }
     
     @Override
         public String execute() throws Exception {
        
        
    lugares=Lugares2DAO.buscarLocalesLugareses("Malaga");
            
        return SUCCESS; 
    }
}
