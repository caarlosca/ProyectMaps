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
     ArrayList<Lugares> lugares2;

    public LugaresAction(ArrayList<Lugares> lugares2) {
        this.lugares2 = lugares2;
    }

    public LugaresAction() {
    }

    public ArrayList<Lugares> getLugares2() {
        return lugares2;
    }

    public void setLugares2(ArrayList<Lugares> lugares2) {
        this.lugares2 = lugares2;
    }

    
     
     @Override
         public String execute() throws Exception {
        
        
    lugares2=Lugares2DAO.buscarLocales("Puerta del sol");
            
        return SUCCESS; 
    }
}
