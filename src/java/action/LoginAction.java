
package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import utilities.PersonaDao;


public class LoginAction extends ActionSupport{
   
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
