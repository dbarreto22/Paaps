package edu.tecnopotify.datatypes;

import edu.tecnopotify.entidades.ListaReproduccion;
import java.util.HashMap;
import java.util.Map;




public class dataTemas{
    
    private String nombre;
    private String duracion;
    private int posicion;
    private Map<String, ListaReproduccion> listaR = new HashMap<String,ListaReproduccion>();

    public dataTemas() {
    }

    public dataTemas(String nombre, String duracion, int posicion) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.posicion = posicion;
    }

    public Map<String, ListaReproduccion> getListaR() {
        return listaR;
    }

    public void setListaR(Map<String, ListaReproduccion> listaR) {
        this.listaR = listaR;
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
