package edu.tecnopotify.entidades;



import edu.tecnopotify.datatypes.dataUsuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Artista extends Usuario implements Serializable{
    
    @Column
    private String biografia;
    @Column
    private String link;
    @OneToMany
    private List<Album> listAlbum;

    public Artista(String biografia, String link, List<Album> listAlbum,
            dataUsuario usuario) {
        super(usuario);
        this.biografia = biografia;
        this.link = link;
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

    public List<Album> getListDiscos() {
        return listAlbum;
    }

    public void setListDiscos(List<Album> listAlbum) {
        this.listAlbum = listAlbum;
    }
    
    
    
}
