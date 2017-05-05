
package utilities;

import java.awt.Image;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.swing.ImageIcon;
import maps.java.Geocoding;
import maps.java.Places;
import maps.java.Route;
import modelo.Ruta;
import modelo.Ubicacion;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class LugaresDAO {

    private static WebApplicationContext context;
    private Places ObjPlaces = new Places();
    private Ubicacion ObjUbicacion = new Ubicacion();
    String[][] resultadoPlaces;
    private double fov = 0.0;
    Route ObjRuta = new Route();
    String[][] resultadoRuta;

    public LugaresDAO() {
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

    public static EntityManagerFactory getEntityManagerFactory() {
        Map properties = new HashMap();
        properties.put("javax.persistence.jdbc.user", "root");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaProyectoMapsPU", properties);

        return emf;
    }



    public String[][] getResultadoPlaces() {
        return resultadoPlaces;
    }

    public void setResultadoPlaces(String[][] resultadoPlaces) {
        this.resultadoPlaces = resultadoPlaces;
    }



    private String[][] rellenarTabla(String[][] datosPlaces) throws IOException {
        String[] columnas = new String[3];
        columnas[0] = "Local";
        columnas[1] = "Dirección";
        columnas[2] = "Tipo establecimiento";
        Object[][] placesReducido = new Object[datosPlaces.length][3];
        for (int i = 0; i < placesReducido.length; i++) {
            placesReducido[i][0] = datosPlaces[i][0].toString();
            placesReducido[i][1] = datosPlaces[i][1].toString();
            Image imageCargada;
            imageCargada = ImageIO.read(new URL(datosPlaces[i][4]));
            imageCargada = imageCargada.getScaledInstance(20, 20, Image.SCALE_FAST);
            placesReducido[i][2] = new ImageIcon(imageCargada);
        }

        return resultadoPlaces;
    }

    public static void error(String funcionError) {
        System.err.println("Algo ocurrió, no se pudo ejecutar la función: " + funcionError);
    }

    public static ArrayList<Ruta> calcularRuta(String direccionSalida, Double latitud, Double longitud) throws Exception {
        Route ObjRout = new Route();
         Geocoding ObjGeocod1 = new Geocoding();

        ArrayList<String> nombreSitio = ObjGeocod1.getAddress(latitud, longitud);
        if(nombreSitio.isEmpty()){
            System.out.println("*************esta vacia");
        }
        
        String direccionLlegada=nombreSitio.get(0);
                
        String[][] resultadoRuta = ObjRout.getRoute(direccionSalida, direccionLlegada, null, Boolean.TRUE, Route.mode.walking, Route.avoids.nothing);
        ArrayList<Ruta> ruta= new ArrayList<Ruta>();
        
  
        for (int i = 0; i < resultadoRuta.length; i++) {
            String tramo = "Tramo " + i + ":" ;
            String tiempo = resultadoRuta[i][0];
            String distancia = resultadoRuta[i][1];
            String indicaciones = resultadoRuta[i][2];
            indicaciones=indicaciones.replace("<b>", " ");
            indicaciones=indicaciones.replace("</b>", " ");
            indicaciones=indicaciones.replace("</b>", " ");
            indicaciones=indicaciones.replace("<div style=\"font-size:0.9em\">", " ");
            indicaciones=indicaciones.replace("</div>", " ");
            Ruta r1= new Ruta(tramo, resultadoRuta[i][0], resultadoRuta[i][1], indicaciones);
            ruta.add(r1);

        }
        for (Ruta ruta1 : ruta) {
            System.out.println(ruta1);
        }

        return ruta;
    }

    public static void main(String ar[]) throws Exception {
       /* LugaresDAO test = new LugaresDAO();
        Geocoding ObjGeocod = new Geocoding();
        Point2D.Double resultadoCD = ObjGeocod.getCoordinates("Malaga");

        Ubicacion ObjUbicacion2 = new Ubicacion(resultadoCD.x, resultadoCD.y);
       LugaresDAO.calcularRuta("Parque de Atracciones, Madrid", 40.4132295, -3.7512561);*/
       
                Geocoding ObjGeocod1 = new Geocoding();

        ArrayList<String> nombreSitio = ObjGeocod1.getAddress(40.4078890, -3.7512152);
        String direccionLlegada=nombreSitio.get(0);
        System.out.println(direccionLlegada);
    }

}
