package edu.tecnopotify.entidades;

import edu.tecnopotify.datatypes.dataListaReproduccion;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ListaDefecto extends ListaReproduccion implements Serializable{
    
    @Column
    private Genero genero;

    public ListaDefecto(dataListaReproduccion listaRep) {
        super(listaRep);
    }

    public ListaDefecto(Genero genero, dataListaReproduccion listaRep) {
        super(listaRep);
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
