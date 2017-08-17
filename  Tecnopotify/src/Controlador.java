
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;






public class Controlador implements Interfaz {
    
    Handler manejador = Handler.getInstance();
    
    public int altaUsuario(String nickname , String nombre, String apellido,
            String mail, Date f_nac, String imagen){
        
        Usuario U = new Usuario(nickname, nombre, apellido,mail,f_nac, imagen);
        if (manejador.listaUsuarios.containsKey(nickname)){
        return 0;
    }
    else{
        manejador.listaUsuarios.put(U.getNickname(), U);  
        return 1;
    }
}

    
    public void otrosDatos(String a, String b) {
        
    }

    
    public int altaGenero(String nombre, String padre) {
        Genero g = new Genero(nombre, padre);
       
        return 0;
    
    }

    //cambiar nombre.
    public int altaAlbum(String nombreArtista) {
        return 0;
    }

    
    public void datosAlbum(String nombre, int anioCreado, String imagen) {

    }

    
    public void altaTema(String nombre, String duracion, int posicion) {
      /*  Temas T = new Temas(nombre, duracion,posicion);
        if (manejador.listaTemas.contains(T)){
            System.out.println("El Tema ya existe");
        }
        else{
        manejador.listaTemas.add(T);  
        }*/
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

    
    public int seleccionarLista(String nickname, String nombreLista) {
        
        return 0;
    }

    
    public void quitarTemaLista(String nombreTema) {

    }

    
    public void agregarTemaLista(String a) {

    }

    
    public int crearListaRep(boolean a, String b, String c) {
        return 0;
    }

    
    public void crearLista(String b, boolean a) {

    }
    
}