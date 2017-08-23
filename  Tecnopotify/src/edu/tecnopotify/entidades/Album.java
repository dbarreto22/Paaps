package edu.tecnopotify.entidades;

import edu.tecnopotify.datatypes.dataAlbum;
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
    
    public Album(dataAlbum album) {
        this.nombre = album.getNombre();
        this.anioCreado = album.getAnioCreado();
        this.imagenAlbum = album.getImagenAlbum();
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
    
}
