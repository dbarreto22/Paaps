



public class ListaDefecto extends ListaReproduccion {
    
    private Genero genero;
    
    public ListaDefecto(String nombre, String imagen, Genero genero) {
        super(nombre, imagen);
    }

    public ListaDefecto(Genero genero, String nombre, String imagen) {
        super(nombre, imagen);
        this.genero = genero;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
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
