
import java.awt.Image;
import java.util.Date;


public class Cliente extends Usuario {
    
    ListaParticular lista;

    public Cliente(ListaParticular lista, String nickname, String nombre, 
            String apellido, String mail, Date f_nac, String imagen) {
        super(nickname, nombre, apellido, mail, f_nac, imagen);
        this.lista = lista;
    }

    public Cliente() {
        super();
    }
    

    public ListaParticular getLista() {
        return lista;
    }

    public void setLista(ListaParticular lista) {
        this.lista = lista;
    }

}
