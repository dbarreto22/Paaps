package edu.tecnopotify.interfaces;

import edu.tecnopotify.controladores.AlbumJpaController;
import edu.tecnopotify.controladores.ArtistaJpaController;
import edu.tecnopotify.controladores.ClienteJpaController;
import edu.tecnopotify.controladores.GeneroJpaController;
import edu.tecnopotify.controladores.ListaDefectoJpaController;
import edu.tecnopotify.controladores.ListaParticularJpaController;
import edu.tecnopotify.controladores.ListaReproduccionJpaController;
import edu.tecnopotify.controladores.TemasJpaController;
import edu.tecnopotify.entidades.Genero;
import edu.tecnopotify.entidades.ListaReproduccion;
import edu.tecnopotify.datatypes.dataUsuario;
import edu.tecnopotify.entidades.Usuario;
import java.util.Date;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import edu.tecnopotify.controladores.UsuarioJpaController;
import edu.tecnopotify.datatypes.dataAlbum;
import edu.tecnopotify.datatypes.dataArtista;
import edu.tecnopotify.datatypes.dataGenero;
import edu.tecnopotify.datatypes.dataListaDefecto;
import edu.tecnopotify.datatypes.dataListaParticular;
import edu.tecnopotify.datatypes.dataListaReproduccion;
import edu.tecnopotify.datatypes.dataTemas;
import edu.tecnopotify.entidades.Album;
import edu.tecnopotify.entidades.Artista;
import edu.tecnopotify.entidades.Cliente;
import edu.tecnopotify.entidades.ListaDefecto;
import edu.tecnopotify.entidades.ListaParticular;
import edu.tecnopotify.entidades.Temas;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import static javax.swing.text.html.HTML.Tag.SELECT;

public class Controlador implements Interfaz {
    
    EntityManagerFactory fact = Persistence.createEntityManagerFactory("TecnopotifyPU");
    EntityManager manager = fact.createEntityManager();
    
    public void crearCliente(dataUsuario usuario){
        Usuario U = new Cliente(usuario);
        ClienteJpaController ctrCl = new ClienteJpaController(fact);
        try {
            ctrCl.create((Cliente) U);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearArtista(String biografia, String link, List<Album> listAlbum,
            dataUsuario usuario){
        Usuario U = new Artista(biografia,link,listAlbum,usuario);
        ArtistaJpaController ctrA = new ArtistaJpaController(fact);
        try {
            ctrA.create((Artista) U);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void altaTema(dataTemas tema) {
        Temas T = new Temas(tema);
        TemasJpaController crlTema = new TemasJpaController(fact);
        try {
            crlTema.create(T);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
     public void crearListaDefecto(dataListaReproduccion listaD){
        ListaReproduccion lista = new ListaDefecto(listaD);  
        ListaDefectoJpaController crlListaD = new ListaDefectoJpaController(fact);
        try {
            crlListaD.create((ListaDefecto) lista);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
     public void crearListaParticular(boolean privado, Cliente cliente, dataListaReproduccion listaP){
        ListaReproduccion lista = new ListaParticular(privado, cliente,listaP);  
        ListaParticularJpaController crlListaP = new ListaParticularJpaController(fact);
        try {
            crlListaP.create((ListaParticular) lista);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
    public void altaGenero(dataGenero genero) {
        Genero G = new Genero(genero);
        GeneroJpaController crlG = new GeneroJpaController(fact);
        try {
            crlG.create(G);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Artista seleccionarArtista(String nickname) {
        ArtistaJpaController ctrArtista = new ArtistaJpaController(fact);
        Artista aux = ctrArtista.findArtista(nickname);
        return aux;
    }
    
    public Cliente seleccionarCliente(String nickname) {
        ClienteJpaController ctrCliente = new ClienteJpaController(fact);
        Cliente aux = ctrCliente.findCliente(nickname);
        return aux;      
    }
    
    public Album seleccionarAlbum(String id) {
        AlbumJpaController ctrAlbum = new AlbumJpaController(fact);
        Album aux = ctrAlbum.findAlbum(id);
        return aux; 
    }
    
    public ListaParticular seleccionarLista(String id){
        ListaParticularJpaController ctrListaParticular = new ListaParticularJpaController(fact);
        ListaParticular aux = ctrListaParticular.findListaParticular(id);
        return aux;    
    }
    
    public void agregarTemaLista(long idTema, dataListaReproduccion listaR) {
        
        TemasJpaController ctrTema = new TemasJpaController(fact);
        ListaReproduccionJpaController ctrListaReproduccion = new ListaReproduccionJpaController(fact);
        Temas aux = ctrTema.findTemas(idTema);
        ListaReproduccion Laux = ctrListaReproduccion.findListaReproduccion(listaR.getNombre());
        Laux.getListaTemas().put(aux.getNombre(), aux);
    }
    
    public void quitarTemaLista(long idTema, dataListaReproduccion listaR) {
       TemasJpaController ctrTema = new TemasJpaController(fact);
        ListaReproduccionJpaController ctrListaReproduccion = new ListaReproduccionJpaController(fact);
        Temas aux = ctrTema.findTemas(idTema);
        ListaReproduccion Laux = ctrListaReproduccion.findListaReproduccion(listaR.getNombre());
        Laux.getListaTemas().remove(aux.getNombre(), Laux);
    }

    public void crearAlbum(String nickNameArtista, dataAlbum dtAlbum) {
        //Crea un album y lo agrega a su artista
        ArtistaJpaController ctrArtista= new ArtistaJpaController(fact);
        //Busca al artista
        Artista oArtista= ctrArtista.findArtista(nickNameArtista);
        AlbumJpaController ctrAlbum=new AlbumJpaController(fact);
        //Crea el album
        Album oAlbum = new Album(dtAlbum);
        //Agrega el album a la lista del artista
        oArtista.getListDiscos().add(oAlbum);
        try {
            //Persiste el album y modifica el artista 
            ctrArtista.edit(oArtista);            
            ctrAlbum.create(oAlbum);            
        } catch (Exception e) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    //debe devolver Dts?
    public List <Genero> mostrarListaGenero() {
          TypedQuery<Genero> query =manager.createQuery( "SELECT c FROM Genero c" 
                  , Genero.class ) ;
          List <Genero> resultados = query.getResultList();
          return resultados;
    }
    
        //sirven para consultar Album, se le pregunta al usuario por que quiere consultar
    public List<Album> consultarAlbumPorArtista(dataArtista artista) {
        ArtistaJpaController ctrArtista= new ArtistaJpaController(fact);
        Artista oArtista = ctrArtista.findArtista(artista.getNickname());
        List<Album> listAlbumArtista = oArtista.getListDiscos();
        return listAlbumArtista;
    }
    
    public List<Album> consultarAlbumPorGenero(dataGenero genero){
        //Funcion que obtiene los albums que pertenecen a un genero
        GeneroJpaController ctrGenero= new GeneroJpaController(fact);
        //Obtiene el genero deseado
        Genero oGeneros= ctrGenero.findGenero(genero.getSerialVersioUID());
        //Devuelve la lista de albums que pertenecen a dicho genero
        return oGeneros.getListAlbum();
    }
/*
    public void seleccionarLista(String a) {

    }*/
    
    public List<ListaReproduccion> consultarListaRep(boolean artista, String id) {
        //el bool artista se toma de la entrada, cuando el admin dice si la lista a consultar es de genero o artista
        //retorna en la variable lista el listado de listas de reproduccion a mostrar en pantalla
//        ListaDefectoJpaController retDefecto = new ListaDefectoJpaController(fact);
//        ListaParticularJpaController retParticular = new ListaParticularJpaController(fact);
//
//        List<ListaReproduccion> lista = null;
//        if (artista) { //string id de artista (nickname)
//            //retornar listas de reproduccion del artista seleccionado
//            ArtistaJpaController art = new ArtistaJpaController(fact);
//            Artista a = art.findArtista(id);
//            
//            lista.addAll(0, retParticular.findListaParticularEntities());
//        } else { //string nombreGenero
//            //retornar listas de reproduccion del genero seleccionado
//            lista.addAll(0, retDefecto.findListaDefectoEntities());
//        }
//        
//        return lista;
        return null;
    }

    
    public void eliminarFavorito(boolean b, boolean c, boolean d, String a) {
        //eliminar tema/lista/album de los favoritos de un cliente
        //selecciono un favorito y saco el elemento de la lista que corresponda

    }

    
    public void agregarFavorito(boolean b, boolean c, boolean d, String a) {

    }
    
    public void dejarDeSeguirUsuario(String nickCliente, String nickUsr) {
        UsuarioJpaController usrCtrl = new UsuarioJpaController(fact);
        Usuario u = usrCtrl.findUsuario(nickCliente);
        Usuario v = usrCtrl.findUsuario(nickUsr);
        u.removeFromSeguidos(v);
        v.removeFromSeguidores(u);
    }

    public void seguirUsuario(String nickCliente, String nickUsr) {
        UsuarioJpaController usrCtrl = new UsuarioJpaController(fact);
        Usuario u = usrCtrl.findUsuario(nickCliente);
        Usuario v = usrCtrl.findUsuario(nickUsr);
        u.addToSeguidos(v); 
        v.addToSeguidores(u);
    }
    
    public void publicarLista(String nickname, String nombreLista) {
        
    }


    
    
    
    

    


    
}