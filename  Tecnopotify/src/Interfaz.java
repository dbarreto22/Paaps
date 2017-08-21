
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Interfaz {
    
  
    public int altaUsuario(String nickname, String nombre, String apellido,
            String mail, Date f_nac, String imagen);
    public void otrosDatos(String a, String b);
    public int altaGenero(String a, String b);
    public Usuario buscarUSuario(String nombreUsuario);
    public void altaAlbum(String artista, String nombre, int anioCreado, String imagen);
    public void altaTema(String nomArtista, String nomAlbum, String nombre, String duracion, int posicion);
    public void seleccionarLista(String a);
    public int consultarListaRep(boolean a, boolean b);
    public int consultarAlbum(boolean a, boolean b);
    public void seleccionarAlbum(String a);
    public int seleccionarArtista(String a);
    public int seleccionarCliente(String a);
    public void eliminarFavorito(boolean b, boolean c, boolean d,String a);
    public void agregarFavorito(boolean b, boolean c, boolean d,String a);
    public int dejarDeSeguirUsuario(boolean a, String b, String c);
    public int SeguirUsuario(boolean a, String b, String c);
    public int publicarLista(String b, String c);
    public int seleccionarLista(String nickname, String nombreLista);
    public void quitarTemaLista(String nombreTema);
    public void agregarTemaLista(String a);
    public int crearListaRep(boolean a, String b, String c);
    public void crearLista(String b, boolean a);
}
