
import java.awt.Image;


public class ListaReproduccion {
    String nombre;
    Image imagen;

    public ListaReproduccion(String nombre, Image imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    
    
}
