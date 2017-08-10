
import java.util.List;


public class Artista extends Usuario{
    private String biografia;
    private String link;
    private List<String> listDiscos;

    public Artista() {
        super();
    }
    

    public Artista(String biografia, String link, List<String> listDiscos) {
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
