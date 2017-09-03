package edu.tecnopotify.interfaces;

import edu.tecnopotify.controladores.AlbumJpaController;
import edu.tecnopotify.controladores.ArtistaJpaController;
import edu.tecnopotify.controladores.ClienteJpaController;
import edu.tecnopotify.controladores.FavoritosJpaController;
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
import edu.tecnopotify.entidades.Favoritos;
import edu.tecnopotify.entidades.ListaDefecto;
import edu.tecnopotify.entidades.ListaParticular;
import edu.tecnopotify.entidades.Temas;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import static javax.swing.text.html.HTML.Tag.SELECT;

public class Controlador implements IControlador {

    EntityManagerFactory fact = Persistence.createEntityManagerFactory("TecnopotifyPU");
    EntityManager manager = fact.createEntityManager();

    public void crearCliente(dataUsuario usuario) {
        Usuario U = new Cliente(usuario);
        ClienteJpaController ctrCl = new ClienteJpaController(fact);
        try {
            ctrCl.create((Cliente) U);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearArtista(String biografia, String link, List<Album> listAlbum,
            dataUsuario usuario) {
        Usuario U = new Artista(biografia, link, listAlbum, usuario);
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

    public void crearListaDefecto(dataListaReproduccion listaD) {
        ListaReproduccion lista = new ListaDefecto(listaD);
        ListaDefectoJpaController crlListaD = new ListaDefectoJpaController(fact);
        try {
            crlListaD.create((ListaDefecto) lista);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void crearListaParticular(boolean privado, Cliente cliente, dataListaReproduccion listaP) {
        ListaReproduccion lista = new ListaParticular(privado, cliente, listaP);
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

    public ListaParticular seleccionarLista(String id) {
        ListaParticularJpaController ctrListaParticular = new ListaParticularJpaController(fact);
        ListaParticular aux = ctrListaParticular.findListaParticular(id);
        return aux;
    }

    public void agregarTemaLista(String idTema, dataListaReproduccion listaR) {

        TemasJpaController ctrTema = new TemasJpaController(fact);
        ListaReproduccionJpaController ctrListaReproduccion = new ListaReproduccionJpaController(fact);
        Temas aux = ctrTema.findTemas(idTema);
        ListaReproduccion Laux = ctrListaReproduccion.findListaReproduccion(listaR.getNombre());
        Laux.getListaTemas().put(aux.getNombre(), aux);
    }

    public void quitarTemaLista(String idTema, dataListaReproduccion listaR) {
        TemasJpaController ctrTema = new TemasJpaController(fact);
        ListaReproduccionJpaController ctrListaReproduccion = new ListaReproduccionJpaController(fact);
        Temas aux = ctrTema.findTemas(idTema);
        ListaReproduccion Laux = ctrListaReproduccion.findListaReproduccion(listaR.getNombre());
        Laux.getListaTemas().remove(aux.getNombre(), Laux);
    }

    public void crearAlbum(String nickNameArtista, dataAlbum dtAlbum) {
        //Crea un album y lo agrega a su artista
        ArtistaJpaController ctrArtista = new ArtistaJpaController(fact);
        //Busca al artista
        Artista oArtista = ctrArtista.findArtista(nickNameArtista);
        AlbumJpaController ctrAlbum = new AlbumJpaController(fact);
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
    public List<Genero> mostrarListaGenero() {
        GeneroJpaController ctrGenero = new GeneroJpaController(fact);
        List<Genero> resultados = ctrGenero.findGeneroEntities();
        return resultados;
    }

    //sirven para consultar Album, se le pregunta al usuario por que quiere consultar
    public List<Album> consultarAlbumPorArtista(dataArtista artista) {
        ArtistaJpaController ctrArtista = new ArtistaJpaController(fact);
        Artista oArtista = ctrArtista.findArtista(artista.getNickname());
        List<Album> listAlbumArtista = oArtista.getListDiscos();
        return listAlbumArtista;
    }

    public List<Album> consultarAlbumPorGenero(dataGenero genero) {
        //Funcion que obtiene los albums que pertenecen a un genero
        GeneroJpaController ctrGenero = new GeneroJpaController(fact);
        //Obtiene el genero deseado
        Genero oGeneros = ctrGenero.findGenero(genero.getNombre());
        //Devuelve la lista de albums que pertenecen a dicho genero
        return oGeneros.getListAlbum();
    }

    /*
    public void seleccionarLista(String a) {

    }*/

    public List<ListaReproduccion> consultarListaRep(boolean cliente, String id) {
        //el bool cliente se toma de la entrada, cuando el admin dice si la lista a consultar es de genero o artista
        //retorna en la variable lista la colección de listas de reproduccion a mostrar en pantalla

        List<ListaReproduccion> lista = null;
        if (cliente) { //string id de cliente (nickname)
            //retornar listas de reproduccion del cliente seleccionado
            ClienteJpaController cli = new ClienteJpaController(fact);
            Cliente c = cli.findCliente(id);
            lista.addAll((Collection<? extends ListaReproduccion>) c.getListasReprParticular());
        } else { //string nombreGenero
            //retornar listas de reproduccion del genero seleccionado
            GeneroJpaController gen = new GeneroJpaController(fact);
            Genero g = gen.findGenero(id);
            lista.addAll(0, (Collection<? extends ListaReproduccion>) g.getListasReprGenero());
        }
        return lista;
    }

    public void eliminarFavorito(boolean tema, boolean lista, boolean album, long idCliente, String idElemento) {
        //eliminar tema/lista/album de los favoritos de un cliente
        //selecciono un favorito y saco el elemento de la lista que corresponda
        FavoritosJpaController fav = new FavoritosJpaController(fact);
        Favoritos f = fav.findFavoritos(idCliente);
        
        if (tema) {
            TemasJpaController temactrl = new TemasJpaController(fact);
            Temas t = temactrl.findTemas(idElemento);
            f.getListTemas().remove(t);            
        }
        
        if (lista) {
            ListaReproduccionJpaController listactrl = new ListaReproduccionJpaController(fact);
            ListaReproduccion l = listactrl.findListaReproduccion(idElemento);
            f.getListRep().remove(l);            
        }
        
        if (album) {
            AlbumJpaController albctrl = new AlbumJpaController(fact);
            Album a = albctrl.findAlbum(idElemento);
            f.getListAlbum().remove(a);            
        }
    }

    public void agregarFavorito(boolean tema, boolean lista, boolean album, long idCliente, String idElemento) {
        FavoritosJpaController fav = new FavoritosJpaController(fact);
        Favoritos f = fav.findFavoritos(idCliente);
        
        if (tema) {
            TemasJpaController temactrl = new TemasJpaController(fact);
            Temas t = temactrl.findTemas(idElemento);
            f.getListTemas().add(t);            
        }
        
        if (lista) {
            ListaReproduccionJpaController listactrl = new ListaReproduccionJpaController(fact);
            ListaReproduccion l = listactrl.findListaReproduccion(idElemento);
            f.getListRep().add(l);            
        }
        
        if (album) {
            AlbumJpaController albctrl = new AlbumJpaController(fact);
            Album a = albctrl.findAlbum(idElemento);
            f.getListAlbum().add(a);            
        }

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
    
    public void publicarLista(String idUsr, String nombreLista) {
        ClienteJpaController cliCtrl = new ClienteJpaController(fact);
        Cliente c = cliCtrl.findCliente(idUsr);
        ListaParticular li = c.listasReprParticular.get(nombreLista);
        li.setEsPrivada(true);
    }

}
