
public class Temas {
    private String nombre;
    private String duracion;
    private int posicion;

    public Temas(String nombre, String duracion, int posicion) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
}
