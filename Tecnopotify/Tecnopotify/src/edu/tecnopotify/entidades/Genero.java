package edu.tecnopotify.entidades;

import edu.tecnopotify.datatypes.dataGenero;
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
import javax.persistence.OneToMany;

@Entity
public class Genero implements Serializable{
    
    //private static final long serialVersionUID = 1L;
    @Id
    private String nombre;

    private String padre;

    @OneToMany
    private Map<String, ListaDefecto> listasReprGenero = new HashMap<String, ListaDefecto>();
    
  
    @ManyToMany(mappedBy="listGenero")
    private List<Album> listAlbum;
    
    public Genero(dataGenero genero) {
        this.nombre = genero.getNombre();
       // this.padre = genero.getPadre();
    }

    public Genero() {
        
    }
    
//    
//     public Long getSerialVersioUID() {
//        return serialVersionUID;
//    }

    public Map<String, ListaDefecto> getListasReprGenero() {
        return listasReprGenero;
    }

    public void setListasReprGenero(Map<String, ListaDefecto> listasReprGenero) {
        this.listasReprGenero = listasReprGenero;
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
    
    public List<Album> getListAlbum() {
        return listAlbum;
    }

    public void setListAlbum(List<Album> aux) {
        this.listAlbum = aux;
    }
    
    
}
