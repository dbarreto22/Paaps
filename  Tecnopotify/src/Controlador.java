
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;






public class Controlador implements Interfaz {
    
    public void altaUsuario(String nickname , String nombre, String apellido,
            String mail, Date f_nac, String imagen){
        
        Usuario U = new Usuario(nickname, nombre, apellido,mail,f_nac, imagen);
        if (listaUsuarios.containsKey(nickname)){
        System.out.println("No se puede introducir el Usuario. Nickname ya existe.");
    }
    else{
        listaUsuarios.put(U.getNickname(), U);               
    }
}

    
    public void otrosDatos(String a, String b) {
        
    }

    
    public int altaGenero(String a, String b) {
        return 0;
    }

    
    public int altaAlbum(String a) {
        return 0;
    }

    
    public void datosAlbum(String nombre, int anioCreado, String imagen) {

    }

    
    public void altaTema(String nombre, String duracion, int posicion) {

    }

    
    public void seleccionarLista(String a) {

    }

    
    public int consultarListaRep(boolean a, boolean b) {
        return 0;
    }

    
    public int consultarAlbum(boolean a, boolean b) {
        return 0;
    }

    
    public void seleccionarAlbum(String a) {

    }

    
    public int seleccionarArtista(String a) {
        return 0;
    }

    
    public int seleccionarCliente(String a) {
        return 0;
    }

    
    public void eliminarFavorito(boolean b, boolean c, boolean d, String a) {

    }

    
    public void agregarFavorito(boolean b, boolean c, boolean d, String a) {

    }

    
    public int dejarDeSeguirUsuario(boolean a, String b, String c) {
        return 0;
    }

    
    public int SeguirUsuario(boolean a, String b, String c) {
        return 0;
    }

    
    public int publicarLista(String b, String c) {
        return 0;
    }

    
    public int seleccionarLista(String b, String c) {
        return 0;
    }

    
    public void quitarTema(String a) {

    }

    
    public void agregarTema(String a) {

    }

    
    public int crearListaRep(boolean a, String b, String c) {
        return 0;
    }

    
    public void crearLista(String b, boolean a) {

    }
    
}