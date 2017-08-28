package edu.tecnopotify.datatypes;


import edu.tecnopotify.entidades.*;
import java.util.HashMap;
import java.util.Map;


public class dataGenero{

    private String nombre;
    private String padre;
    public Map<String, ListaDefecto> listasReprGenero = new HashMap<String, ListaDefecto>();
    
    public dataGenero(String nombre, String padre) {
        this.nombre = nombre;
        this.padre = padre;
    }

    public dataGenero() {
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
