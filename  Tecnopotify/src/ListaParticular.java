
import java.awt.Image;


public class ListaParticular extends ListaReproduccion{
    
    private boolean esPrivada;

    public ListaParticular(boolean esPrivada, String nombre, Image imagen) {
        super(nombre, imagen);
        this.esPrivada = esPrivada;
    }
    
    
}
