/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import java.awt.Image;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import modelo.Lugares;
import utilities.Lugares2DAO;

/**
 *
 * @author Curso Mañana
 */
public class OrganizarRutaAction extends ActionSupport {

    ArrayList<Lugares> lugares2;
    String zonaDePartida;
    Image urlMapa;

    public OrganizarRutaAction(ArrayList<Lugares> lugares2) {
        this.lugares2 = lugares2;
    }

    private int km;

    public OrganizarRutaAction() {
    }

    public OrganizarRutaAction(String zonaDePartida, int km) {

        this.zonaDePartida = zonaDePartida;
        this.km = km;
    }

    public String getZonaDePartida() {
        return zonaDePartida;
    }

    public void setZonaDePartida(String zonaDePartida) {
        this.zonaDePartida = zonaDePartida;
    }

    public ArrayList<Lugares> getLugares2() {
        return lugares2;
    }

    public void setLugares2(ArrayList<Lugares> lugares2) {
        this.lugares2 = lugares2;
    }

 

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    
    
    public String execute() throws UnsupportedEncodingException, MalformedURLException {

        System.out.println(Lugares2DAO.buscarLocales(zonaDePartida));

        lugares2 = Lugares2DAO.buscarLocales(zonaDePartida);

        return SUCCESS;
    }

}
