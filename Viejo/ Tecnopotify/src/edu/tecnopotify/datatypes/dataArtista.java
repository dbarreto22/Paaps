package edu.tecnopotify.datatypes;



import edu.tecnopotify.entidades.*;
import java.util.List;
;


public class dataArtista extends dataUsuario{
    
  
    private String biografia;
    private String link;
    private List<Album> listAlbum;


    
<<<<<<< HEAD
    public dataArtista(String biografia, String link, List<Album> listAlbum, String nickname, String nombre, String apellido, String mail, dataFecha f_nac, String imagen) {
=======
    public dataArtista(String biografia, String link, List<Album> listAlbum, 
            String nickname, String nombre, String apellido, String mail,
            dataFecha f_nac, String imagen, List<Usuario> lstSeguidos, 
            List<Usuario> lstSeguidores) {
>>>>>>> 818ef66eb723a65565484cf99d6fbc3ead4b9494
        super(nickname, nombre, apellido, mail, f_nac, imagen);
        this.biografia = biografia;
        this.link = link;
        this.listAlbum = listAlbum;
    }

    public dataArtista(String biografia, String link, List<Album> listAlbum) {
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
