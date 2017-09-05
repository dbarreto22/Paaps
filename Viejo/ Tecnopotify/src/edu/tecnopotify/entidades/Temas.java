package edu.tecnopotify.entidades;

import edu.tecnopotify.datatypes.dataTemas;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Temas implements Serializable {
    
//    private static final long serialVersionUID = 1L;
    
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column
    private String nombre;
    @Column
    private String duracion;
    @Column
    private int posicion;
    
    @ManyToMany
    public Map<String, ListaReproduccion> listaR = new HashMap<String,ListaReproduccion>();

    public Map<String, ListaReproduccion> getListaR() {
        return listaR;
    }

    public void setListaR(Map<String, ListaReproduccion> listaR) {
        this.listaR = listaR;
    }
    
    public Temas() {
    }

    public Temas(dataTemas tema) {
        this.nombre = tema.getNombre();
        this.duracion = tema.getDuracion();
        this.posicion = tema.getPosicion();
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
/*
    public Long getSerialVersioUID() {
        return serialVersionUID;
    }
    */
}
