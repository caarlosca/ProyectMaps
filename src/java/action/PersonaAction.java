
package action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import modelo.Persona;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import utilities.PersonaDao;

@Action(value="insertar",
        results={
            @Result(name="success",location="/response.jsp"),
            @Result(name="input",location="/formularioRegistro.jsp")})

public class PersonaAction extends ActionSupport{
    private int id;
    private String nombre;
    private String email;
    private String contrasena;
    private Persona p1;
public String execute() {
        
   p1= new Persona( nombre, email, contrasena);
        PersonaDao.insertar(p1);
        return SUCCESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    @RequiredStringValidator(message= "El nombre es un campo obligatorio")
    
    @StringLengthFieldValidator(minLength = "3",
            maxLength = "10",
            message = "La longitud del nombre debe estar comprendida entre ${minLength} y ${maxLength} caracteres")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }
    @RequiredStringValidator (message = "EMAIL ES OBLIGATORIO")
    @EmailValidator(message = "Introduzca un email valido!")
    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }
    @RequiredStringValidator(message= "La contraseña es un campo obligatorio")
    
    @StringLengthFieldValidator(minLength = "5",
            maxLength = "10",
            message = "La longitud de la contraseña debe estar comprendida entre ${minLength} y ${maxLength} caracteres")
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

   

}