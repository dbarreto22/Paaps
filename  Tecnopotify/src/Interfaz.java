
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Interfaz {
    
   // public ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario> ();
    public Map<String, Usuario> listaUsuarios = new HashMap<String, Usuario>();
    //public Map<String, Album> listaAlbum = new HashMap<String, Album>();
    public ArrayList<Album> listaAlbum = new ArrayList<Album> ();
    public void altaUsuario(String nickname, String nombre, String apellido,
            String mail, Date f_nac, String imagen);
    public void otrosDatos(String a, String b);
    public int altaGenero(String a, String b);
    public int altaAlbum (String a);
    public void datosAlbum(String nombre, int anioCreado, String imagen);
    public void altaTema(String nombre, String duracion, int posicion);
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
    public int seleccionarLista(String b, String c);
    public void quitarTema(String a);
    public void agregarTema(String a);
    public int crearListaRep(boolean a, String b, String c);
    public void crearLista(String b, boolean a);
}
