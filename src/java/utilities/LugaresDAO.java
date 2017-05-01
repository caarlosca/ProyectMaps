/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.awt.Image;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletContext;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
import maps.java.Geocoding;
import maps.java.MapsJava;
import maps.java.Places;
import maps.java.Route;
import modelo.Lugares;
import modelo.Ruta;
import modelo.Ubicacion;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
//import se.walkercrou.places.GooglePlaces;

/**
 *
 * @author Curso Mañana
 */
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

    /*prueba con id 1*/
//    public static float mostrarLatitud() {
//        float latitud;
//        EntityManagerFactory emf = getEntityManagerFactory();
//        EntityManager em = emf.createEntityManager();
//
//        EntityTransaction trx = em.getTransaction();
//        trx.begin();
//
//        String hsql = "SELECT c FROM Lugares c where c.id=1";
//        Query query = em.createQuery(hsql);
//        Lugares lugares = (Lugares) query.getSingleResult();
//        latitud = lugares.getLatitud();
//
//        em.close();
//        emf.close();
//        return latitud;
//    }
//
//    /*prueba con id sdasdadasdasdasdas*/
//    public static float mostrarLongitud() {
//        float longitud;
//        EntityManagerFactory emf = getEntityManagerFactory();
//        EntityManager em = emf.createEntityManager();
//
//        EntityTransaction trx = em.getTransaction();
//        trx.begin();
//
//        String hsql = "SELECT c FROM Lugares c where c.id=1";
//
//        Query query = em.createQuery(hsql);
//        //List<Lugares> list = query.getResultList();
//        Lugares lugares = (Lugares) query.getSingleResult();
//        longitud = lugares.getLongitud();
//
//        em.close();
//        emf.close();
//        return longitud;
//    }

    public String[][] getResultadoPlaces() {
        return resultadoPlaces;
    }

    public void setResultadoPlaces(String[][] resultadoPlaces) {
        this.resultadoPlaces = resultadoPlaces;
    }

    private static ArrayList<Lugares> buscarLocales(String zonaSalida) throws UnsupportedEncodingException, MalformedURLException, IOException {
        MapsJava.setKey("AIzaSyDVMXmApLq3pv_tVPwqK5omqwTfNml2bT0");
        String key = "AIzaSyDVMXmApLq3pv_tVPwqK5omqwTfNml2bT0";
        MapsJava.APIkeyCheck(key);
        System.out.println(MapsJava.APIkeyCheck(key));
          Geocoding ObjGeocod = new Geocoding();
 Point2D.Double resultadoCD = ObjGeocod.getCoordinates("zonaSalida");
 ArrayList<Lugares> lugares= new ArrayList<Lugares>();
        Ubicacion ObjUbicacion2 = new Ubicacion(resultadoCD.x, resultadoCD.y);
        Places ObjPlace = new Places();
        try {
            String[][] resultado = ObjPlace.getPlaces(ObjUbicacion2.getLatitud(), ObjUbicacion2.getLongitud(),
                    3000, "", "", Places.Rankby.distance, null);

            for (int i = 0; i < resultado.length; i++) {
                System.out.println("Place " + i + ":");
                for (int j = 0; j < resultado[0].length; j++) {
                    System.out.print(resultado[i][0] + "\t");
                     System.out.print(resultado[i][1] + "\t");
                      System.out.print(resultado[i][2] + "\t");
                       System.out.print(resultado[i][3] + "\t");
                       System.out.print(resultado[i][4] + "\t");
                          String tramo = "Lugar " + i + ":" + "</br>";
            String nombre = resultado[i][0];
            String calle = resultado[i][1];
            double longitud =Double.parseDouble(resultado[i][2]) ;
             double latitud =Double.parseDouble(resultado[i][3]) ;
            
            Lugares l1= new Lugares(nombre, calle, longitud, latitud);
            lugares.add(l1);
            
 
                }
                System.out.println("");
            }
        } catch (Exception e) {
            error("Place");
        }

        return lugares;
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

    public static ArrayList<Ruta> calcularRuta(String direccionSalida, String direccionLlegada) throws Exception {
        Route ObjRout = new Route();
        String[][] resultadoRuta = ObjRout.getRoute(direccionSalida, direccionLlegada, null, Boolean.TRUE, Route.mode.driving, Route.avoids.nothing);
        ArrayList<Ruta> ruta= new ArrayList<Ruta>();
        for (int i = 0; i < resultadoRuta.length; i++) {
            //System.out.println("Tramo " + i + ":" + "</br>");
            String tramo = "Tramo " + i + ":" + "</br>";
            String tiempo = resultadoRuta[i][0];
            String distancia = resultadoRuta[i][1];
            String indicaciones = resultadoRuta[i][2];
            Ruta r1= new Ruta(tramo, resultadoRuta[i][0], resultadoRuta[i][1], resultadoRuta[i][2]);
            ruta.add(r1);

        }
        for (Ruta ruta1 : ruta) {
            System.out.println(ruta1);
        }

        return ruta;
    }

    public static void main(String ar[]) throws Exception {
        LugaresDAO test = new LugaresDAO();
        Geocoding ObjGeocod = new Geocoding();
        Point2D.Double resultadoCD = ObjGeocod.getCoordinates("Malaga");

        Ubicacion ObjUbicacion2 = new Ubicacion(resultadoCD.x, resultadoCD.y);
        test.buscarLocales("Malaga");
//        Ubicacion ObjUbicacion3 = new Ubicacion();
//        test.calcularRuta("Madrid", "Toledo");
//MapsJava.setKey("AIzaSyDVMXmApLq3pv_tVPwqK5omqwTfNml2bT0");
//                   String key= "AIzaSyDVMXmApLq3pv_tVPwqK5omqwTfNml2bT0";
//               MapsJava.APIkeyCheck(key);
//            System.out.println( MapsJava.APIkeyCheck(key));
//            
//            Places ObjPlace=new Places();
//            try {
//                String[][] resultado=ObjPlace.getPlaces(40.4171111, -3.7031133, 
//                        3000, "", "", Places.Rankby.distance, null);
//
//                for(int i=0;i<resultado.length;i++){
//                    System.out.println("Place " + i + ":");
//                    for(int j=0;j<resultado[0].length;j++){
//                        System.out.print(resultado[i][j] + "\t");
//                    }
//                    System.out.println("");
//                }
//            } catch (Exception e) {
//                error("Place");
//            }
        //  test.rellenarTabla();
//        float longitud;
//        float latitud;
//        
//        longitud=mostrarLongitud();
//         latitud=mostrarLatitud();
//        System.out.println(longitud);
//        System.out.println(latitud);
//       String nombre="Museo de cera";
//       String hsql = "SELECT c FROM Lugares c where c.nombre="+nombre+"";
//       System.out.println(hsql);
//           Geocoding ObjGeocod=new Geocoding();
//         
//         Point2D.Double resultadoCD=ObjGeocod.getCoordinates("parque Atracciones");
//         System.out.println("Las coordenadas de:"+nombre +
//                    resultadoCD.x + "," + resultadoCD.y);
//         
//Places ObjPlace=new Places();
//String[][] resultadoPlaces=ObjPlace.getPlaces(40.4171111, -3.7031133, 3000, "", "", Places.Rankby.prominence, null);
//for(int i=0;i< resultadoPlaces.length;i++){
//   System.out.println("Place " + i + ":");
//   for(int j=0;j< resultadoPlaces[0].length;j++){
//      System.out.print(resultadoPlaces[i][j] + "\t");
//   }
//}
// GooglePlaces google = new GooglePlaces("AIzaSyDVMXmApLq3pv_tVPwqK5omqwTfNml2bT0");
//               MapsJava.setKey("AIzaSyDVMXmApLq3pv_tVPwqK5omqwTfNml2bT0");
//               String key= "AIzaSyDVMXmApLq3pv_tVPwqK5omqwTfNml2bT0";
//               MapsJava.APIkeyCheck(key);
//            System.out.println( MapsJava.APIkeyCheck(key));
//            
//            Places ObjPlace=new Places();
//            try {
//                String[][] resultado=ObjPlace.getPlaces(40.4171111, -3.7031133, 
//                        3000, "", "", Places.Rankby.distance, null);
//
//                for(int i=0;i<resultado.length;i++){
//                    System.out.println("Place " + i + ":");
//                    for(int j=0;j<resultado[0].length;j++){
//                        System.out.print(resultado[i][j] + "\t");
//                    }
//                    System.out.println("");
//                }
//            } catch (Exception e) {
//                error("Place");
//            }
    }

}
