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
import modelo.Lugares;
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
    public static float mostrarLatitud() {
        float latitud;
        EntityManagerFactory emf = getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        EntityTransaction trx = em.getTransaction();
        trx.begin();

        String hsql = "SELECT c FROM Lugares c where c.id=1";
        Query query = em.createQuery(hsql);
        Lugares lugares = (Lugares) query.getSingleResult();
        latitud = lugares.getLatitud();

        em.close();
        emf.close();
        return latitud;
    }

    /*prueba con id sdasdadasdasdasdas*/
    public static float mostrarLongitud() {
        float longitud;
        EntityManagerFactory emf = getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        EntityTransaction trx = em.getTransaction();
        trx.begin();

        String hsql = "SELECT c FROM Lugares c where c.id=1";

        Query query = em.createQuery(hsql);
        //List<Lugares> list = query.getResultList();
        Lugares lugares = (Lugares) query.getSingleResult();
        longitud = lugares.getLongitud();

        em.close();
        emf.close();
        return longitud;
    }

//    private ArrayList<String> tiposLocal(){
//        ArrayList<String> locales=new ArrayList<>();
//        for(int i=0;i<JList_TiposLocal.getModel().getSize();i++){
//            locales.add(JList_TiposLocal.getModel().getElementAt(i).toString());
//        }
//        return locales;
//    }
//  private Places.Rankby buscarPor(){
//        if(JCombo_BuscarPOR.getSelectedIndex()==0){
//            return Places.Rankby.prominence;
//        }else{
//            return Places.Rankby.distance;
//        }
//    }
//    private ArrayList<String> tiposLocal(){
//        ArrayList<String> locales=new ArrayList<>();
//        for(int i=0;i<JList_TiposLocal.getModel().getSize();i++){
//            locales.add(JList_TiposLocal.getModel().getElementAt(i).toString());
//        }
//        return locales;
//    }
    private Places ObjPlaces = new Places();
    private Ubicacion ObjUbicacion = new Ubicacion();
    String[][] resultadoPlaces;
    private double fov = 0.0;

    public String[][] getResultadoPlaces() {
        return resultadoPlaces;
    }

    public void setResultadoPlaces(String[][] resultadoPlaces) {
        this.resultadoPlaces = resultadoPlaces;
    }

    private String[][] buscarLocales() throws UnsupportedEncodingException, MalformedURLException, IOException {
        MapsJava.setKey("AIzaSyDVMXmApLq3pv_tVPwqK5omqwTfNml2bT0");
        String key = "AIzaSyDVMXmApLq3pv_tVPwqK5omqwTfNml2bT0";
        MapsJava.APIkeyCheck(key);
        System.out.println(MapsJava.APIkeyCheck(key));

        Places ObjPlace = new Places();
        try {
            String[][] resultado = ObjPlace.getPlaces(40.4171111, -3.7031133,
                    3000, "", "", Places.Rankby.distance, null);

            for (int i = 0; i < resultado.length; i++) {
                System.out.println("Place " + i + ":");
                for (int j = 0; j < resultado[0].length; j++) {
                    System.out.print(resultado[i][j] + "\t");
                }
                System.out.println("");
            }
        } catch (Exception e) {
            error("Place");
        }
//        String[][] resultadoPlaces=ObjPlaces.getPlaces(40.4171111, -3.7031133, 3000, "", "", Places.Rankby.prominence, null);
//        this.rellenarTabla(resultadoPlaces);
        //String direcResultUNO=resultadoPlaces[0][2] + "," + resultadoPlaces[0][3];
//        this.dibujarMapa(direcResultUNO);
//        this.dibujarStreetView(direcResultUNO);
        return resultadoPlaces;
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
        // TableModel tableModel=new TablaIconos(placesReducido, columnas);

        return resultadoPlaces;
    }

    public static void error(String funcionError) {
        System.err.println("Algo ocurrió, no se pudo ejecutar la función: " + funcionError);
    }

    public static void main(String ar[]) throws Exception {
        LugaresDAO test = new LugaresDAO();
        test.buscarLocales();
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
//         Route ObjRout=new Route();
//String[][] resultadoRuta=ObjRout.getRoute("Puerta del sol", "Museo de cera", null, Boolean.TRUE, Route.mode.walking, Route.avoids.nothing);
//for(int i=0;i< resultadoRuta.length;i++){
//   System.out.println("Tramo " + i + ":"+"</br>");
//   for(int j=0;j< resultadoRuta [0].length;j++){
//      System.out.print(resultadoRuta[i][j] + "\t");
//   }
//}
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
