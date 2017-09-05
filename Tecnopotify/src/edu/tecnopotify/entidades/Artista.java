package edu.tecnopotify.entidades;

import edu.tecnopotify.datatypes.dataUsuario;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Artista extends Usuario implements Serializable {

    private String biografia;
    private String link;
    @OneToMany
    private Collection<Album> listAlbum;

    public Artista(String biografia, String link,
            dataUsuario usuario) {
        super(usuario);
        this.biografia = biografia;
        this.link = link;

    }

    public Artista() {
        super();
    }

    public void setListAlbum(List<Album> listAlbum) {
        this.listAlbum = listAlbum;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Collection<Album> getListAlbum() {
        return listAlbum;
    }

    public void setListAlbum(Collection<Album> listAlbum) {
        this.listAlbum = listAlbum;
    }

}
