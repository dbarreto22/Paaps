
import java.util.Map;
import java.util.HashMap;





public class ListaReproduccion {
    String nombre;
    String imagen;
    public Map<String, Temas> listaTemas = new HashMap<String,Temas>();

    
    public ListaReproduccion(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStringn() {
        return imagen;
    }

    public void setStringn(String imagen) {
        this.imagen = imagen;
    }
    
    
}
