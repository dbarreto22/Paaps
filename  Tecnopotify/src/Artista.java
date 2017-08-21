
import java.awt.Image;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class Artista extends Usuario{
    private String biografia;
    private String link;
    private HashMap<String, Album> listaAlbum = new HashMap<String, Album>();


    
    public Artista(String nickname, String nombre, String apellido, String mail, Date f_nac,
            String imagen, String biografia, String link, HashMap<String, Album> listDiscos) {
        super(nickname,nombre,apellido,mail,f_nac,imagen);
        this.biografia = biografia;
        this.link = link;
        this.listaAlbum = listDiscos;
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

    public HashMap<String, Album> getListDiscos() {
        return listaAlbum;
    }

    public void setListDiscos(HashMap<String, Album> listDiscos) {
        this.listaAlbum = listDiscos;
    }
    
    public void setAlbum(Album val)
            //Guarda un album en la lista de albums del artista
    {
        listaAlbum.put(val.getNombre(), val);
    }
    
    public Album getAlbum(String nombre)
            //Devuelve el album con el nombre o null si no existe
    {
        return listaAlbum.get(nombre);
    }
    
    
}
