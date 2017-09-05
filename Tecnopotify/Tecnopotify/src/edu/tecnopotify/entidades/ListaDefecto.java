package edu.tecnopotify.entidades;

import edu.tecnopotify.datatypes.dataListaReproduccion;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ListaDefecto extends ListaReproduccion implements Serializable{
    
    private Genero genero;

    public ListaDefecto() {
        super();
    }
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
}
