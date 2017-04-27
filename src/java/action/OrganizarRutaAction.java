/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;

/**
 *
 * @author Curso Mañana
 */
public class OrganizarRutaAction extends ActionSupport{
    
    private Date fecha;
    private String zonaDePartida;
    private int km;

    public OrganizarRutaAction() {
    }

    public OrganizarRutaAction(Date fecha, String zonaDePartida, int km) {
        this.fecha = fecha;
        this.zonaDePartida = zonaDePartida;
        this.km = km;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getZonaDePartida() {
        return zonaDePartida;
    }

    public void setZonaDePartida(String zonaDePartida) {
        this.zonaDePartida = zonaDePartida;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    @Override
    public String toString() {
        return "OrganizarRutaAction{" + "fecha=" + fecha + ", zonaDePartida=" + zonaDePartida + ", km=" + km + '}';
    }
    
    public String execute() {
        
        
        
        return SUCCESS;
    }
    
}
