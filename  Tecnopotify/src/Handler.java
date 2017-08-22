
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Handler {
   
    public Map<String, Usuario> listaUsuarios = new HashMap<String, Usuario>();
    //public Map<String, Album> listaAlbum = new HashMap<String, Album>();
    //public ArrayList<Album> listaAlbum = new ArrayList<Album> (); Los albums se guardan en los artistas
    public ArrayList<Genero> generos = new ArrayList<Genero> ();
    public ArrayList<Temas> listaTemas = new ArrayList<Temas> ();
    
    private Handler() {
    }
    
    public static Handler getInstance() {
        return HandlerHolder.INSTANCE;
    }
    
    private static class HandlerHolder {

        private static final Handler INSTANCE = new Handler();
    }
    
    public Map<String, Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(Map<String, Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

/*    public ArrayList<Album> getListaAlbum() {
        return listaAlbum;
    }

    public void setListaAlbum(ArrayList<Album> listaAlbum) {
        this.listaAlbum = listaAlbum;
    }
*/    
    public Usuario getUsuario(String usr)
    //Guarda un usuario en la coleccion de usuarios
    {
        return listaUsuarios.get(usr);
    }
    

    
  
}
