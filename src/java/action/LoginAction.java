package action;

import com.opensymphony.xwork2.ActionSupport;
import utilities.PersonaDao;

//alaoba
public class LoginAction extends ActionSupport {

    private String email;
    private String contrasena;

    public String execute() {
        //  System.out.println(PersonaDao.login(email, contrasena));
        System.out.println("**********HOla***********************");

        if (PersonaDao.login(email, contrasena)) {
            return SUCCESS;
        }

        return ERROR;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
