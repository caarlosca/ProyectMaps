/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.xml.bind.DatatypeConverter;
import maps.java.MapsJava;
import maps.java.Route;
import maps.java.ShowMaps;
import maps.java.StaticMaps;
import maps.java.StreetView;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import constantes.Constantes;

/**
 *
 * @author Curso Mañana
 */
public class MapaDAO {

    private static WebApplicationContext context;
    private static ShowMaps ObjShowMap = new ShowMaps();
    private static String direccionMapa;
    //String direccionMapa=ObjShowMaps.getURLMap("Madrid, Puerta del Sol");
    private ShowMaps ObjShowMaps = new ShowMaps();

    public static void mostrarMapa(Double latitud, Double longitud) throws Exception {

//direccionMapa=ObjShowMaps.getURLMap(latitud,longitud);
        System.out.println(direccionMapa);

//Desktop.getDesktop().browse(new URI(direccionMapa));
    }

    public MapaDAO() {
    }

    private static void iniciar() {

        try {
            ServletContext sc = ServletActionContext.getServletContext();
            context = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
        } catch (Throwable e) {
            System.out.println("*****fallo de inicializacion****)");
            throw new ExceptionInInitializerError(e);
        }
    }

    public static WebApplicationContext getWebApplicationContext() {
        iniciar();
        return context;

    }

    /*public static Image creaURLmapa() throws Exception {
        Route ObjRout = new Route();
        StaticMaps ObjStatic = new StaticMaps();
        StaticMaps ObjStatMap = new StaticMaps();
//        Image resultadoMapa = ObjStatMap.getStaticMap(zonaSalida, 14, new Dimension(300, 300),
//                3, StaticMaps.Format.png, StaticMaps.Maptype.hybrid);

        String[][] resultadoRuta = ObjRout.getRoute("Puerta del Sol", "arguelles", null, Boolean.TRUE, Route.mode.walking, Route.avoids.nothing);

        Image imagenRuta = ObjStatic.getStaticMapRoute(new Dimension(300, 200),
                1, StaticMaps.Format.png, StaticMaps.Maptype.roadmap, ObjRout.getPolilines().get(0));
        return imagenRuta;
    }*/

    public static void guardarImagen(String zonaPartida, String zonaLlegada) {
        try {
            Route ObjRout = new Route();
            StaticMaps ObjStatic = new StaticMaps();
            StaticMaps ObjStatMap = new StaticMaps();
            File dir=new File(Constantes.getDIR());
            dir.delete();
            
            
            
            
            
            String[][] resultadoRuta = ObjRout.getRoute(zonaPartida, zonaLlegada, null, Boolean.TRUE, Route.mode.transit, Route.avoids.nothing);
            
            Image imagenRuta = ObjStatic.getStaticMapRoute(new Dimension(500, 500),
                    1, StaticMaps.Format.png, StaticMaps.Maptype.roadmap, ObjRout.getPolilines().get(0));
            
           dir.mkdir();
            File outputfile = new File(Constantes.getRUTA_IMG()+"foto\\saved1.png");
            if(outputfile.exists()){
                outputfile.delete();
                ImageIO.write((RenderedImage) imagenRuta, "png", outputfile);
            }else{
                ImageIO.write((RenderedImage) imagenRuta, "png", outputfile);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(MapaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MapaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MapaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    

    public static void main(String ar[]) throws Exception {
        
        //guardarImagen("Malaga", "cuatro Vientos, madrid");
        //System.out.println(Constantes.getRUTA_IMG()+"foto\\saved1.png");

    }
}
