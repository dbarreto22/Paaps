package edu.tecnopotify.datatypes;


import edu.tecnopotify.entidades.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class dataGenero{

    private String nombre;
    private String padre;
    public List listasReprGenero;
    private List<Genero> generosHijos;
    
    public dataGenero(String nombre, String Padre) {
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

    public List<ListaDefecto> getListasReprGenero() {
        return listasReprGenero;
    }

    public void setListasReprGenero(List<ListaDefecto> listasReprGenero) {
        this.listasReprGenero = listasReprGenero;
    }

    public List<Genero> getGenerosHijos() {
        return generosHijos;
    }

    public void setGenerosHijos(List<Genero> generosHijos) {
        this.generosHijos = generosHijos;
    }  
}
