/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletContext;
import maps.java.Geocoding;
import maps.java.MapsJava;
import maps.java.Places;
import modelo.Lugares;
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

    

//    
//    public static void main(String ar[]) throws Exception {
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
//         Point2D.Double resultadoCD=ObjGeocod.getCoordinates("sol");
//         System.out.println("Las coordenadas de:"+nombre +
//                    resultadoCD.x + "," + resultadoCD.y);
//    }
//    
//    
       public static void error(String funcionError){
        System.err.println("Algo ocurrió, no se pudo ejecutar la función: " + funcionError);
    }
        public static void main(String ar[]) throws Exception {
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
               MapsJava.setKey("AIzaSyDVMXmApLq3pv_tVPwqK5omqwTfNml2bT0");
               String key= "AIzaSyDVMXmApLq3pv_tVPwqK5omqwTfNml2bT0";
               MapsJava.APIkeyCheck(key);
            System.out.println( MapsJava.APIkeyCheck(key));
            
            Places ObjPlace=new Places();
            try {
                String[][] resultado=ObjPlace.getPlaces(40.4171111, -3.7031133, 
                        3000, "", "", Places.Rankby.distance, null);

                for(int i=0;i<resultado.length;i++){
                    System.out.println("Place " + i + ":");
                    for(int j=0;j<resultado[0].length;j++){
                        System.out.print(resultado[i][j] + "\t");
                    }
                    System.out.println("");
                }
            } catch (Exception e) {
                error("Place");
            }

    }
    
}
