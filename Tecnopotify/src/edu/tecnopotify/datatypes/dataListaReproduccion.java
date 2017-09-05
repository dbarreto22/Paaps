package edu.tecnopotify.datatypes;


import edu.tecnopotify.entidades.*;
import java.util.Map;
import java.util.HashMap;



public class dataListaReproduccion{
    
    private String nombre;
    private String imagen;
    private Map<String, Temas> listaTemas = new HashMap<String,Temas>();

    
    public dataListaReproduccion(String nombre, String imagen, Map<String, Temas> listaTemas) {
        this.nombre = nombre;
        this.imagen = imagen;
    //    this.listaTemas = listaTemas;
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

    public Map<String, Temas> getListaTemas() {
        return listaTemas;
    }

    public void setListaTemas(Map<String, Temas> listaTemas) {
        this.listaTemas = listaTemas;
    }



    
    
}
