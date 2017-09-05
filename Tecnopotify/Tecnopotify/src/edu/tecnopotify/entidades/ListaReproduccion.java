package edu.tecnopotify.entidades;

import edu.tecnopotify.datatypes.dataListaReproduccion;
import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class ListaReproduccion implements Serializable{
    /*
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/
    @Id
  
    private String nombre;
   
    private String imagen;
    @ManyToMany
    private Map<String, Temas> listaTemas = new HashMap<String,Temas>();

    
    
    public ListaReproduccion(dataListaReproduccion listaRep) {
        this.nombre = listaRep.getNombre();
        this.imagen = listaRep.getImagen();
        this.listaTemas = listaRep.getListaTemas();
    }

    public ListaReproduccion() {
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
