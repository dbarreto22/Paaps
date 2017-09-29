package edu.tecnopotify.interfaces;

import edu.tecnopotify.controladores.AlbumJpaController;
import edu.tecnopotify.controladores.ArtistaJpaController;
import edu.tecnopotify.controladores.ClienteJpaController;
import edu.tecnopotify.controladores.ExtJpaAlbum;
import edu.tecnopotify.controladores.ExtJpaFavoritos;
import edu.tecnopotify.controladores.ExtJpaGenero;
import edu.tecnopotify.controladores.ExtJpaSrtista;
import edu.tecnopotify.controladores.ExtUsuario;
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
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import edu.tecnopotify.controladores.UsuarioJpaController;
import edu.tecnopotify.controladores.exceptions.PreexistingEntityException;
import edu.tecnopotify.datatypes.dataAlbum;
import edu.tecnopotify.datatypes.dataArtista;
import edu.tecnopotify.datatypes.dataFecha;
import edu.tecnopotify.datatypes.dataGenero;
import edu.tecnopotify.datatypes.dataListaReproduccion;
import edu.tecnopotify.datatypes.dataTemas;
import edu.tecnopotify.entidades.Album;
import edu.tecnopotify.entidades.Artista;
import edu.tecnopotify.entidades.Cliente;
import edu.tecnopotify.entidades.Favoritos;
import edu.tecnopotify.entidades.ListaDefecto;
import static edu.tecnopotify.entidades.ListaDefecto_.genero;
import edu.tecnopotify.entidades.ListaParticular;
import edu.tecnopotify.entidades.Temas;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador implements IControlador {

    EntityManagerFactory fact = Persistence.createEntityManagerFactory("EjemploJPAPU");

    public Controlador() {
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return this.fact;
    }

    public void crearCliente(dataUsuario usuario) {
        Usuario U = new Cliente(usuario);
        ClienteJpaController ctrCl = new ClienteJpaController(fact);
        try {
            ctrCl.create((Cliente) U);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearArtista(String biografia, String link,
            dataUsuario usuario) {
        Usuario U = new Artista(biografia, link, usuario);
        ArtistaJpaController ctrA = new ArtistaJpaController(fact);
        try {
            ctrA.create((Artista) U);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void altaTema(dataTemas tema, String album) {
        ExtJpaAlbum crlAlbum = new ExtJpaAlbum(fact);
        Temas oTema = new Temas(tema);
        Album oAlbum = crlAlbum.findAlbum(album);
        oAlbum.getListTemas().add(oTema);
        try {
            crlAlbum.agregarTema(oAlbum, oTema);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearListaDefecto(dataListaReproduccion listaD, String nombreGenero) {
        ListaDefectoJpaController crlListaD = new ListaDefectoJpaController(fact);
        GeneroJpaController genctrl = new GeneroJpaController(fact);
        try {
            Genero g = genctrl.findGenero(nombreGenero);
            ListaReproduccion lista = new ListaDefecto(g, listaD);
            crlListaD.create((ListaDefecto) lista);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearListaParticular(boolean privado, String nickCliente, dataListaReproduccion listaP) {

        Cliente cli = seleccionarCliente(nickCliente);
        ListaReproduccion lista = new ListaParticular(privado, cli, listaP);
        ListaParticularJpaController crlListaP = new ListaParticularJpaController(fact);
        try {
            crlListaP.create((ListaParticular) lista);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void altaGenero(dataGenero oDtGenero) {
        Genero oGeneroPadre;
        Genero G = new Genero(oDtGenero);
        ExtJpaGenero crlG = new ExtJpaGenero(fact);
        System.out.println("padre: " + oDtGenero.getPadre() + " nombre: " + oDtGenero.getNombre());
        try {
            if (!"".equals(oDtGenero.getPadre())) {//Si no es el genero raiz
                //Busco el genero padre y agrego el hijo
                oGeneroPadre = crlG.findGenero(oDtGenero.getPadre());
                crlG.agregarHijo(oGeneroPadre, G);
            } else {//Si es el genero raiz lo crea en la raiz
                crlG.create(G);
            }

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
        Laux.getListaTemas().add(aux);
    }

    public void quitarTemaLista(String idTema, dataListaReproduccion listaR) {
        TemasJpaController ctrTema = new TemasJpaController(fact);
        ListaReproduccionJpaController ctrListaReproduccion = new ListaReproduccionJpaController(fact);
        Temas aux = ctrTema.findTemas(idTema);
        ListaReproduccion Laux = ctrListaReproduccion.findListaReproduccion(listaR.getNombre());
        Laux.getListaTemas().remove(aux.getNombre());
    }

    public void crearAlbum(String nickNameArtista, dataAlbum dtAlbum) {
        //Crea un album y lo agrega a su artista
        ExtJpaSrtista  ctrArtista = new ExtJpaSrtista(fact);
        //Busca al artista
        Artista oArtista = ctrArtista.findArtista(nickNameArtista);
        if (oArtista!=null)
        {
            System.out.println("Hay artista");
        }
        AlbumJpaController ctrAlbum = new AlbumJpaController(fact);
        //Crea el album
        Album oAlbum = new Album(dtAlbum);
        //Agrega el album a la lista del artista
//        oArtista.getListAlbum().add(oAlbum);
        try {
            //Persiste el album y modifica el artista 
            ctrAlbum.create(oAlbum);
            ctrArtista.agregarAlbum(oArtista,oAlbum);
            
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
    public Collection<Album> consultarAlbumPorArtista(dataArtista artista) {
        ArtistaJpaController ctrArtista = new ArtistaJpaController(fact);
        Artista oArtista = ctrArtista.findArtista(artista.getNickname());
        Collection<Album> listAlbumArtista = oArtista.getListAlbum();
        return listAlbumArtista;
    }

    public Collection<Album> consultarAlbumPorGenero(dataGenero genero) {
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
    public Collection<ListaReproduccion> consultarListaRep(boolean cliente, String id) {
        //el bool cliente se toma de la entrada, cuando el admin dice si la lista a consultar es de genero o artista
        //retorna en la variable lista la colección de listas de reproduccion a mostrar en pantalla

        Collection<ListaReproduccion> lista = null;
        if (cliente) { //string id de cliente (nickname)
            //retornar listas de reproduccion del cliente seleccionado
            ClienteJpaController cli = new ClienteJpaController(fact);
            Cliente c = cli.findCliente(id);
            lista.addAll((Collection<? extends ListaReproduccion>) c.getListasReprParticular());
        } else { //string nombreGenero
            //retornar listas de reproduccion del genero seleccionado
            GeneroJpaController gen = new GeneroJpaController(fact);
            Genero g = gen.findGenero(id);
            // lista.addAll(0, (Collection<? extends ListaReproduccion>) g.getListasReprGenero());
        }
        return lista;
    }

    public void eliminarFavorito(boolean tema, boolean lista, boolean album, String nickCliente, String idElemento) {
    //eliminar tema/lista/album de los favoritos de un cliente
    //selecciono un favorito y saco el elemento de la lista que corresponda
    /*  FavoritosJpaController fav = new FavoritosJpaController(fact);
    
    Favoritos f = fav.findFavoritos(nickCliente);
    
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
    }*/
    }

    public void agregarFavorito(boolean tema, boolean lista, boolean album, String idCliente, String idElemento) {
        ExtJpaFavoritos fav = new ExtJpaFavoritos(fact);
        ClienteJpaController clictrl = new ClienteJpaController(fact);
        Cliente oCliente = clictrl.findCliente(idCliente);
        if (tema) {//Si voy a agregar un tema
            TemasJpaController temactrl = new TemasJpaController(fact);
            Temas oTema = temactrl.findTemas(idElemento);//Busco el tema
            try {
                fav.agregarTemaFav(oTema, oCliente);    //Agrego el tema
            } catch (PreexistingEntityException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (lista) {
            ListaReproduccionJpaController listactrl = new ListaReproduccionJpaController(fact);
            ListaReproduccion oLista = listactrl.findListaReproduccion(idElemento);
            try {
                fav.agregarListaFav(oLista, oCliente);
            } catch (PreexistingEntityException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (album) {
            AlbumJpaController albctrl = new AlbumJpaController(fact);
            Album oAlbum = albctrl.findAlbum(idElemento);
            try {
                fav.agregarAlbumFav(oAlbum, oCliente);
            } catch (PreexistingEntityException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void dejarDeSeguirUsuario(String nickCliente, String nickUsr) {
        try {
            UsuarioJpaController usrCtrl = new UsuarioJpaController(fact);
            ExtUsuario usr = new ExtUsuario(fact);
            Cliente c = (Cliente) usrCtrl.findUsuario(nickCliente);
            Usuario u = usrCtrl.findUsuario(nickUsr);
            //c.removeFromSeguidos(u);
            usr.quitarSeguidor(u,c);
        } catch (PreexistingEntityException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void seguirUsuario(String nickCliente, String nickUsr) {

        try {
            UsuarioJpaController usrCtrl = new UsuarioJpaController(fact);
            ExtUsuario usr = new ExtUsuario(fact);
            Cliente c = (Cliente) usrCtrl.findUsuario(nickCliente);
            Usuario u = usrCtrl.findUsuario(nickUsr);
            //c.addToSeguidos(u);            
            usr.agregarSeguidor(u,c);
        } catch (PreexistingEntityException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

    public void publicarLista(String idUsr, String nombreLista) {
        ClienteJpaController cliCtrl = new ClienteJpaController(fact);
        Cliente c = cliCtrl.findCliente(idUsr);
        ListaParticular li = null; //= c.listasReprParticular.get(nombreLista);
        li.setEsPrivada(true);
    }

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = null;
        ClienteJpaController cliCtrl = new ClienteJpaController(fact);
        clientes = cliCtrl.findClienteEntities();
        return clientes;
    }

    public List<Artista> listarArtistas() {
        List<Artista> artista = null;
        ArtistaJpaController cliCtrl = new ArtistaJpaController(fact);
        artista = cliCtrl.findArtistaEntities();
        return artista;
    }

    public List<Genero> listarGeneros() {
        List<Genero> g = null;
        GeneroJpaController gCtrl = new GeneroJpaController(fact);
        g = gCtrl.findGeneroEntities();
        return g;
    }

    public List<Genero> getListGenero(String nombre) {
        List<Genero> genero = null;
        Genero g = new Genero();
        GeneroJpaController genCtrl = new GeneroJpaController(fact);
        g = genCtrl.findGenero(nombre);

        genero = g.getListHijos();
        return genero;
    }

    public Album buscarAlbum(String nombre) {
        Album a = null;
        AlbumJpaController crlA = new AlbumJpaController(fact);
        a = crlA.findAlbum(nombre);
        return a;
    }

    public List<Album> listarAlbum() {
        List<Album> album = null;
        AlbumJpaController crlA = new AlbumJpaController(fact);
        album = crlA.findAlbumEntities();
        return album;
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> lUsr = null;
        UsuarioJpaController crlU = new UsuarioJpaController(fact);
        lUsr = crlU.findUsuarioEntities();
        return lUsr;
    }

    public Cliente getCli(String nickname) {
        Cliente c = null;
        ClienteJpaController crlU = new ClienteJpaController(fact);
        c = crlU.findCliente(nickname);
        return c;
    }

    public List<Temas> listarTemas() {
        List<Temas> temas = null;
        TemasJpaController crlT = new TemasJpaController(fact);
        temas = crlT.findTemasEntities();
        return temas;
    }

    public Temas getTema(String name) {
        Temas t = null;
        TemasJpaController crlT = new TemasJpaController(fact);
        t = crlT.findTemas(name);
        return t;
    }

    public ListaReproduccion getlr(String name) {
        ListaReproduccion lr = null;
        ListaReproduccionJpaController crllr = new ListaReproduccionJpaController(fact);
        lr = crllr.findListaReproduccion(name);
        return lr;
    }

    public Genero buscarGenero(String nombre) {
        ExtJpaGenero crl = new ExtJpaGenero(fact);
        return crl.findGenero(nombre);
    }

    public List<ListaDefecto> listarDefecto() {
        List<ListaDefecto> ld = null;
        ListaDefectoJpaController crlld = new ListaDefectoJpaController(fact);
        ld = crlld.findListaDefectoEntities();
        return ld;
    }
    
    public List<ListaReproduccion> listarListaRepr()
    {
    ListaReproduccionJpaController ctrl = new ListaReproduccionJpaController(fact);
    return ctrl.findListaReproduccionEntities();
    }
    

    
    public void cargarDatos(){
       
        dataFecha fecha = new dataFecha(1,1,1980);
        dataUsuario u1 = new dataUsuario("ji","Julio","Iglesias","ji@tecnopotify.java" ,fecha,"",""); 
        dataUsuario u2 = new dataUsuario("ei","Enrique","Iglesias","ei@tecnopotify.java" ,fecha, "","");
        dataUsuario u3 = new dataUsuario("rm","Ricky","Martin","rm@tecnopotify.java" ,fecha, "","");
        dataUsuario u4 = new dataUsuario("er","El","Reja","er@tecnopotify.java" ,fecha, "","");
        crearArtista("axaxaxa", "www.ji.com", u1);
        crearArtista("sxsxsxx", "www.ei.com", u2);
        crearArtista("dxdxdxx", "www.rm.com", u3);
        crearArtista("ffxfxfx", "www.er.com", u4);
        dataUsuario u5 = new dataUsuario("discoteishon","Carlos","Nuñez","cn@tecnopotify.java" ,fecha,"",""); 
        dataUsuario u6 = new dataUsuario("md","Melany","Dolgay","md@tecnopotify.java" ,fecha, "","");
        dataUsuario u7 = new dataUsuario("db","Diego","Barreto","db@tecnopotify.java" ,fecha, "","");
        crearCliente(u5);
        crearCliente(u6);
        crearCliente(u7);
        dataGenero g1 = new dataGenero("Genero", "");
        dataGenero g2 = new dataGenero("Genero2", "Genero");
        dataGenero g3 = new dataGenero("Genero3", "Genero");
        Genero G1 = new Genero(g1);
        Genero G2 = new Genero(g2);
        Genero G3 = new Genero(g3);
         
        altaGenero(g1);
        altaGenero(g2);
        altaGenero(g3);
        dataAlbum a1 = new dataAlbum("album1", 1990, "");
        dataAlbum a2 = new dataAlbum("album2", 1991, "");
        dataAlbum a3 = new dataAlbum("album3", 1992, "");
        dataAlbum a4 = new dataAlbum("album4", 1993, "");
       
        crearAlbum(u1.getNickname(), a1);
        crearAlbum(u2.getNickname(), a2);
        crearAlbum(u3.getNickname(), a3);
        crearAlbum(u4.getNickname(), a4);
        dataTemas t1 = new dataTemas("tema1", "2:30", 1);
        dataTemas t2 = new dataTemas("tema2", "2:31", 2);
        dataTemas t3 = new dataTemas("tema3", "2:32", 3);
        dataTemas t4 = new dataTemas("tema4", "2:33", 4);
        dataTemas t5 = new dataTemas("tema5", "2:35", 1);
        dataTemas t6 = new dataTemas("tema6", "2:36", 2);
        dataTemas t7 = new dataTemas("tema7", "2:38", 3);
        dataTemas t8 = new dataTemas("tema8", "2:39", 4);
        Album A1 = new Album(a1);
 //       A1.getListGenero().add(G1);
        Album A2 = new Album(a2);
        //A2.getListGenero().add(G2);
        Album A3 = new Album(a3);
       // A3.getListGenero().add(G3);
        Album A4 = new Album(a4);
       // A4.getListGenero().add(G3);

        altaTema(t1, A1.getNombre());
        altaTema(t2, A1.getNombre());
        altaTema(t3, A1.getNombre());
        altaTema(t4, A1.getNombre());
        altaTema(t5, A2.getNombre());
        altaTema(t6, A2.getNombre());
        altaTema(t7, A3.getNombre());
        altaTema(t8, A4.getNombre());
        
        agregarFavorito(true,false,false,"discoteishon","tema1");
        agregarFavorito(true,false,false,"discoteishon","tema2");
        agregarFavorito(false,false,true,"discoteishon","album1");
        agregarFavorito(true,false,false,"md","tema3");
        agregarFavorito(false,false,true,"db","album3");
        
       
    }


}
