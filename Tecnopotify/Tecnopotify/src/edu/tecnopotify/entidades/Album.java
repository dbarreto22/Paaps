package edu.tecnopotify.entidades;

import edu.tecnopotify.datatypes.dataAlbum;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Album implements Serializable {

//    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    
 
    private String nombre;
    
 
    private int anioCreado;
    private String imagenAlbum;
    @OneToMany
    private List<Temas> listTemas;
    @ManyToMany
    private List<Genero> listGenero;
/*
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }*/

   
    
    public Album(dataAlbum album) {
        this.nombre = album.getNombre();
        this.anioCreado = album.getAnioCreado();
        this.imagenAlbum = album.getImagenAlbum();
    }

    public Album() {
    }

    public List<Temas> getListTemas() {
        return listTemas;
    }

    public void setListTemas(List<Temas> listTemas) {
        this.listTemas = listTemas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnioCreado() {
        return anioCreado;
    }

    public void setAnioCreado(int anioCreado) {
        this.anioCreado = anioCreado;
    }

    public String getImagenAlbum() {
        return imagenAlbum;
    }

    public void setImagenAlbum(String imagenAlbum) {
        this.imagenAlbum = imagenAlbum;
    }

    public void setListGenero(List<Genero> listGenero) {
        this.listGenero = listGenero;
    }
    
     public List<Genero> getListGenero() {
        return listGenero;
    }
    
    
   
}
