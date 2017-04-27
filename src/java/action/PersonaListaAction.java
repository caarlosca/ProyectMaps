
package action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.Persona;
import utilities.PersonaDao;


public class PersonaListaAction  extends ActionSupport {

    List<Persona> list;

    public List<Persona> getList() {
        return list;
    }

    public void setList(List<Persona> list) {
        this.list = list;
    }

    public String execute() {
        list = PersonaDao.listar();
        return SUCCESS;
    }

}
