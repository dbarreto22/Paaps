
import java.awt.Image;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Cliente extends Usuario {
    
    public Map<String, ListaParticular> listasReprParticular = new HashMap<String, ListaParticular>();

    public Cliente(ListaParticular lista, String nickname, String nombre, String apellido, String mail, Date f_nac, String imagen) {
        super(nickname, nombre, apellido, mail, f_nac, imagen);
        //this.lista = lista;
    }

    public Cliente() {
        super();
    }
    

    public Map<String, ListaParticular> getLista() {
        return listasReprParticular;
    }
/*
    public void setLista(ListaParticular lista) {
        this.lista = lista;
    }
*/
}
