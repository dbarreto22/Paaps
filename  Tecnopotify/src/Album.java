
import java.awt.Image;
import java.util.Date;


public class Album {
    private String nombre;
    private Date anioCreado;
    private Image imagenAlbum;

    public Album(String nombre, Date anioCreado, Image imagenAlbum) {
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

    public Date getAnioCreado() {
        return anioCreado;
    }

    public void setAnioCreado(Date anioCreado) {
        this.anioCreado = anioCreado;
    }

    public Image getImagenAlbum() {
        return imagenAlbum;
    }

    public void setImagenAlbum(Image imagenAlbum) {
        this.imagenAlbum = imagenAlbum;
    }
    
}
