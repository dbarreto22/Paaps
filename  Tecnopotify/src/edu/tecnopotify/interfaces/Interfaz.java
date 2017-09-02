package edu.tecnopotify.interfaces;

import edu.tecnopotify.datatypes.dataAlbum;
import edu.tecnopotify.datatypes.dataArtista;
import edu.tecnopotify.datatypes.dataGenero;
import edu.tecnopotify.datatypes.dataListaReproduccion;
import edu.tecnopotify.datatypes.dataTemas;
import edu.tecnopotify.datatypes.dataUsuario;
import edu.tecnopotify.entidades.Album;
import edu.tecnopotify.entidades.ListaParticular;
import edu.tecnopotify.entidades.Artista;
import edu.tecnopotify.entidades.Genero;
import edu.tecnopotify.entidades.ListaReproduccion;
import edu.tecnopotify.entidades.Cliente;
import java.util.Date;
import java.util.List;


public interface Interfaz {
    
  
    public void crearCliente(dataUsuario usuario);
    public void crearArtista(String biografia, String link, List<Album> listAlbum,dataUsuario usuario);
    public void altaGenero(dataGenero genero);
    public void crearAlbum(String nickNameArtista,dataAlbum dtAlbum);
    public void altaTema(dataTemas tema);
   // public void seleccionarLista(String a);
    public List<ListaReproduccion> consultarListaRep(boolean cliente, String id);
    public List<Album> consultarAlbumPorArtista(dataArtista artista);
    public List<Album> consultarAlbumPorGenero(dataGenero genero); 
    public Album seleccionarAlbum(String id);
    public Artista seleccionarArtista(String nombreArtista);//
    public Cliente seleccionarCliente(String nickname);
    public void eliminarFavorito(boolean tema, boolean lista, boolean album, long idCliente, String idElemento);
    public void agregarFavorito(boolean tema, boolean lista, boolean album, long idCliente, String idElemento);
    public void dejarDeSeguirUsuario(String nickCliente, String nickUsr);
    public void seguirUsuario(String nickCliente, String nickUsr);
    public void publicarLista(String idUsr, String nombreLista);
    public ListaParticular seleccionarLista(String id);
    public void quitarTemaLista(String idTema, dataListaReproduccion listaR);
    public void agregarTemaLista(String idTema, dataListaReproduccion listaR);
    public void crearListaDefecto(dataListaReproduccion listaD);
    public void crearListaParticular(boolean privado, Cliente cliente, dataListaReproduccion listaP);
    public List <Genero> mostrarListaGenero();
    //public Cliente devolverCliente(String nickname);
    
}
