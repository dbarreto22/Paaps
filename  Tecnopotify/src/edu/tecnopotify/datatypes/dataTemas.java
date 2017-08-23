package edu.tecnopotify.datatypes;




public class dataTemas{
    
    private String nombre;
    private String duracion;
    private int posicion;

    public dataTemas() {
    }

    public dataTemas(String nombre, String duracion, int posicion) {
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
