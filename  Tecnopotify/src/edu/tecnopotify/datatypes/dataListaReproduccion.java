package edu.tecnopotify.datatypes;


import edu.tecnopotify.entidades.*;
import java.util.Map;
import java.util.HashMap;



public class dataListaReproduccion{
    
    String nombre;
    String imagen;
    public Map<String, Temas> listaTemas = new HashMap<String,Temas>();

    
    public dataListaReproduccion(String nombre, String imagen) {
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
