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
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.xml.bind.DatatypeConverter;
import maps.java.MapsJava;
import maps.java.Route;
import maps.java.ShowMaps;
import maps.java.StaticMaps;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author Curso Mañana
 */
public class MapaDAO {

    private static WebApplicationContext context;

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

    public static String creaURLmapa(String zonaSalida) throws Exception {
        Route ObjRout = new Route();

        StaticMaps ObjStatMap = new StaticMaps();
        Image resultadoMapa = ObjStatMap.getStaticMap(zonaSalida, 14, new Dimension(300, 300),
                3, StaticMaps.Format.png, StaticMaps.Maptype.hybrid);
        String mapaURL = MapsJava.getLastRequestURL();
        return mapaURL;
    }

    public Image qie(BufferedImage bi) {
        return Toolkit.getDefaultToolkit().createImage(bi.getSource());
    }

    public static void main(String ar[]) throws Exception {
//        MapaDAO test2 = new MapaDAO();

        String key = "AIzaSyDVMXmApLq3pv_tVPwqK5omqwTfNml2bT0";
        MapsJava.APIkeyCheck(key);
        ShowMaps ObjShowMap = new ShowMaps();
        ObjShowMap.getURLMap("Madrid, Puerta del Sol");
//String direccionMapa=ObjShowMaps.getURLMap(“Madrid, Puerta del Sol”);
        StaticMaps ObjStatic = new StaticMaps();
        Route ObjRout = new Route();
        String[][] resultadoRuta = ObjRout.getRoute("Puerta del Sol", "arguelles", null, Boolean.TRUE, Route.mode.walking, Route.avoids.nothing);

        Image imagenRuta = ObjStatic.getStaticMapRoute(new Dimension(300, 200),
                1, StaticMaps.Format.png, StaticMaps.Maptype.roadmap, ObjRout.getPolilines().get(0));

        //  Toolkit.getDefaultToolkit().createImage(imagenRuta.getSource()); 
//        
//ByteArrayOutputStream out = new ByteArrayOutputStream();
//ImageIO.write((RenderedImage) imagenRuta, "PNG", out);
//byte[] bytes = out.toByteArray();
//
//String base64bytes = Base64.encode(bytes);
//String src = "data:image/png;base64," + base64bytes;
//        ByteArrayOutputStream output = new ByteArrayOutputStream();
//        ImageIO.write((RenderedImage) imagenRuta, "png", output);
//        DatatypeConverter.printBase64Binary(output.toByteArray());

        System.out.println(ObjStatic.getStaticMapRoute(new Dimension(300, 200),
                1, StaticMaps.Format.png, StaticMaps.Maptype.roadmap, ObjRout.getPolilines().get(0)));

//WritableImage image = SwingFXUtils.toFXImage((BufferedImage) imagenRuta, null);
//myImageView.setImage(image);
    }
}
