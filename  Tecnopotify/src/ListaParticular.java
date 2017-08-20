



public class ListaParticular extends ListaReproduccion{
    
    private boolean esPrivada;
    private Cliente cliente;

    public ListaParticular(boolean esPrivada, Cliente cliente, String nombre, String imagen) {
        super(nombre, imagen);
        this.esPrivada = esPrivada;
        this.cliente = cliente;
    }

    public ListaParticular(String nombre, String imagen) {
        super(nombre, imagen);
        esPrivada = false;
    }

    public boolean isEsPrivada() {
        return esPrivada;
    }

    public void setEsPrivada(boolean esPrivada) {
        this.esPrivada = esPrivada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    
    
}