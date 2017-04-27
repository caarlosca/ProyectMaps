package utilities;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletContext;
import maps.java.Geocoding;
import modelo.Persona;

import org.apache.struts2.ServletActionContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import static utilities.LugaresDAO.mostrarLatitud;
import static utilities.LugaresDAO.mostrarLongitud;

public class PersonaDao {

    List<Persona> list;
    private static WebApplicationContext context;

    public List<Persona> getList() {
        return list;
    }

    public void setList(List<Persona> list) {
        this.list = list;
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

    public static void insertar(Persona p1) {
        EntityManagerFactory emf = getEntityManagerFactory();
        if (emf != null) {
            EntityManager em = emf.createEntityManager();
            EntityTransaction trx = em.getTransaction();
            trx.begin();

            em.persist(p1);

            trx.commit();
        }
    }

    public static List<Persona> listar() {
        EntityManagerFactory emf = getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction trx = em.getTransaction();
        trx.begin();
        String consultaHSQL = "SELECT c FROM Persona c";
        Query consulaCreada = em.createQuery(consultaHSQL);
        List<Persona> list = consulaCreada.getResultList();
        trx.commit();
        return list;
    }

    public static boolean login(String email, String contrasena) {
        String email1;
        boolean comprobar;
        EntityManagerFactory emf = getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction trx = em.getTransaction();
        trx.begin();
        String consultaHSQL = "SELECT c FROM Persona c  WHERE c.email='" + email + "'";
        Query consultaCreada = em.createQuery(consultaHSQL);
        

      // String test= (String) consulaCreada.getSingleResult();
      List<Persona> listaLogin= consultaCreada.getResultList();
      
      comprobar = !listaLogin.isEmpty();

        return comprobar;

    }
 
}

