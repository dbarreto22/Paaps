
import java.util.HashMap;
import java.util.Map;

public class Genero {
 
    String nombre;
    String padre;

    
    public Map<String, ListaDefecto> listasReprGenero = new HashMap<String, ListaDefecto>();
    
    public Genero(String nombre, String padre) {
        this.nombre = nombre;
        this.padre = padre;
    }

    public Genero() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }
    
    
}
