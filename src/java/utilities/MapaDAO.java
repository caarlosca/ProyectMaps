
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
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;


public class MapaDAO {

    private static WebApplicationContext context;

    private static String direccionMapa;

    public static void mostrarMapa(Double latitud, Double longitud) throws Exception {

        System.out.println(direccionMapa);

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


    public static void guardarImagen(String zonaPartida, String zonaLlegada) {
        
        try {
            Route ObjRout = new Route();
            StaticMaps ObjStatic = new StaticMaps();

            File dir = new File(Constantes.getDIR());
            dir.delete();

            String[][] resultadoRuta = ObjRout.getRoute(zonaPartida, zonaLlegada, null, Boolean.TRUE, Route.mode.walking, Route.avoids.nothing);

            Image imagenRuta = ObjStatic.getStaticMapRoute(new Dimension(500, 500),
                    1, StaticMaps.Format.png, StaticMaps.Maptype.roadmap, ObjRout.getPolilines().get(0));
            System.out.println("La URL asociada a la imagen es: " + MapsJava.getLastRequestURL());
            dir.mkdir();
            File outputfile = new File(Constantes.getRUTA_IMG() + "\\saved1.png");
            if (outputfile.exists()) {
                outputfile.delete();
                ImageIO.write((RenderedImage) imagenRuta, "png", outputfile);
            } else {
                ImageIO.write((RenderedImage) imagenRuta, "png", outputfile);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(MapaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MapaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MapaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            //dir.delete();
            //outputfile.delete();
        }

    }

    public static String[][] MuestraRutas(String zonaPartida, String zonaLlegada) throws IOException {
        Route ObjRout = new Route();
        String[][] resultadoRuta = ObjRout.getRoute(zonaPartida, zonaLlegada, null, Boolean.TRUE, Route.mode.walking, Route.avoids.nothing);
        for (int i = 0; i < resultadoRuta.length; i++) {

            for (int j = 0; j < resultadoRuta.length; j++) {
                System.out.println(resultadoRuta[i][2]);
            }


        }
        return resultadoRuta;
    }
    
    

    public static void main(String ar[]) throws Exception {
        File miDir = new File(".");
        System.out.println(miDir.getAbsolutePath());

        StaticMaps ObjStatic = new StaticMaps();
        StaticMaps ObjStatMap = new StaticMaps();
        File dir = new File(Constantes.getDIR());
        dir.delete();

        MapaDAO.guardarImagen("AMA ARQUITECTOS S.L.P.U.", "Salvador Crossa Ramírez");

    }
}
