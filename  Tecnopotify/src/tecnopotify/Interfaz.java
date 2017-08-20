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
    public int altaAlbum (String nombreArtista);
    public void datosAlbum(String nombre, int anioCreado, String imagen);
    public void altaTema(String nombre, String duracion, int posicion);
    public void seleccionarLista(String a);
    public int consultarListaRep(boolean a, boolean b);
    public int consultarAlbum(boolean a, boolean b);
    public void seleccionarAlbum(String a);
    public int seleccionarArtista(String a);
    public Cliente seleccionarCliente(String nickname);
    public void eliminarFavorito(boolean b, boolean c, boolean d,String a);
    public void agregarFavorito(boolean b, boolean c, boolean d,String a);
    public int dejarDeSeguirUsuario(boolean a, String b, String c);
    public int SeguirUsuario(boolean a, String b, String c);
    public int publicarLista(String nickname, String nombreLista);
    public ListaParticular seleccionarLista(String nickname, String nombreLista);
    public void quitarTemaLista(String nombreTema, ListaReproduccion lista);
    public void agregarTemaLista(String nombreTema, ListaReproduccion lista);
    public int crearListaRep(boolean defecto, String nombreLista, String imagen);
    public void crearLista(String b, boolean a);
    public void mostrarListaGenero();
    public Cliente devolverCliente(String nickname);
    public void crearListaDefecto(Genero genero,String nombreLista,String imagen);
}
