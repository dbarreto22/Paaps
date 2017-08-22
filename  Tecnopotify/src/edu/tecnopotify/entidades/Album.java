package edu.tecnopotify.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column
    private String nombre;
    
    @Column
    private int anioCreado;
    
    @Column
    private String imagenAlbum;
    
    @Column
    @OneToMany
    private List<Temas> listTemas;

    public List<Temas> getListTemas() {
        return listTemas;
    }

    public void setListTemas(List<Temas> listTemas) {
        this.listTemas = listTemas;
    }

    public Album(String nombre, int anioCreado, String imagenAlbum) {
        this.nombre = nombre;
        this.anioCreado = anioCreado;
        this.imagenAlbum = imagenAlbum;
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
    
}
