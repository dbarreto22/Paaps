
import java.awt.Image;
import java.util.Date;
import java.util.List;


public class Artista extends Usuario{
    private String biografia;
    private String link;
    private List<String> listDiscos;


    
    public Artista(String nickname, String nombre, String apellido, String mail, Date f_nac,
            String imagen, String biografia, String link, List<String> listDiscos) {
        super(nickname,nombre,apellido,mail,f_nac,imagen);
        this.biografia = biografia;
        this.link = link;
        this.listDiscos = listDiscos;
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

    public List<String> getListDiscos() {
        return listDiscos;
    }

    public void setListDiscos(List<String> listDiscos) {
        this.listDiscos = listDiscos;
    }
    
    
    
}
