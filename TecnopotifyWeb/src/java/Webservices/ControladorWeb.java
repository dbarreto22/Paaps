/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webservices;

import edu.tecnopotify.interfaces.Album;
import edu.tecnopotify.interfaces.Artista;
import edu.tecnopotify.interfaces.Cliente;
import edu.tecnopotify.interfaces.Genero;
import edu.tecnopotify.interfaces.ListaParticular;
import edu.tecnopotify.interfaces.ListaReproduccion;
import edu.tecnopotify.interfaces.Temas;
import edu.tecnopotify.interfaces.Usuario;
import edu.tecnopotify.interfaces.ControladorService;
import edu.tecnopotify.interfaces.Controlador;
/**
 *
 * @author Carlox
 */
public class ControladorWeb {
        private static ControladorService service;
        private static Controlador port;
    ControladorWeb()
    {
        service = new edu.tecnopotify.interfaces.ControladorService();
        port = service.getControladorPort();
    }

    private static void agregarFavorito(boolean arg0, boolean arg1, boolean arg2, java.lang.String arg3, java.lang.String arg4) {
        port.agregarFavorito(arg0, arg1, arg2, arg3, arg4);
    }

    private static void agregarTemaLista(java.lang.String arg0, edu.tecnopotify.interfaces.DataListaReproduccion arg1) {
        port.agregarTemaLista(arg0, arg1);
    }

    private static void altaGenero(edu.tecnopotify.interfaces.DataGenero arg0) {
        port.altaGenero(arg0);
    }

    private static void altaTema(edu.tecnopotify.interfaces.DataTemas arg0, java.lang.String arg1) {
        port.altaTema(arg0, arg1);
    }

    private static Album buscarAlbum(java.lang.String arg0) {
        return port.buscarAlbum(arg0);
    }

    private static Genero buscarGenero(java.lang.String arg0) {
        return port.buscarGenero(arg0);
    }

    private static Usuario buscarUsrMail(java.lang.String arg0) {
        return port.buscarUsrMail(arg0);
    }

    private static void crearAlbum(java.lang.String arg0, edu.tecnopotify.interfaces.DataAlbum arg1) {
        port.crearAlbum(arg0, arg1);
    }

    private static void crearArtista(java.lang.String arg0, java.lang.String arg1, edu.tecnopotify.interfaces.DataUsuario arg2) {
        port.crearArtista(arg0, arg1, arg2);
    }

    private static void crearCliente(edu.tecnopotify.interfaces.DataUsuario arg0) {
        port.crearCliente(arg0);
    }

    private static void crearListaDefecto(edu.tecnopotify.interfaces.DataListaReproduccion arg0, java.lang.String arg1) {
        port.crearListaDefecto(arg0, arg1);
    }

    private static void crearListaParticular(boolean arg0, java.lang.String arg1, edu.tecnopotify.interfaces.DataListaReproduccion arg2) {
        port.crearListaParticular(arg0, arg1, arg2);
    }

    private static void dejarDeSeguirUsuario(java.lang.String arg0, java.lang.String arg1) {
        port.dejarDeSeguirUsuario(arg0, arg1);
    }

    private static void eliminarFavorito(boolean arg0, boolean arg1, boolean arg2, java.lang.String arg3, java.lang.String arg4) {
        port.eliminarFavorito(arg0, arg1, arg2, arg3, arg4);
    }

    private static Cliente getCli(java.lang.String arg0) {
        return port.getCli(arg0);
    }

    private static Temas getTema(java.lang.String arg0) {
        return port.getTema(arg0);
    }

    private static Usuario getUsuario(java.lang.String arg0) {
        return port.getUsuario(arg0);
    }

    private static ListaReproduccion getlr(java.lang.String arg0) {
        return port.getlr(arg0);
    }

    private static void modificarSuscripcion(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) {
        port.modificarSuscripcion(arg0, arg1, arg2);
    }

    private static String obtenerEstadoSuscripcion(java.lang.String arg0) {
        return port.obtenerEstadoSuscripcion(arg0);
    }

    private static String obtenerPagoSuscripcion(java.lang.String arg0) {
        return port.obtenerPagoSuscripcion(arg0);
    }

    private static void publicar() {
        port.publicar();
    }

    private static void publicarLista(java.lang.String arg0, java.lang.String arg1) {
        port.publicarLista(arg0, arg1);
    }

    private static void quitarTemaLista(java.lang.String arg0, edu.tecnopotify.interfaces.DataListaReproduccion arg1) {
        port.quitarTemaLista(arg0, arg1);
    }

    private static void seguirUsuario(java.lang.String arg0, java.lang.String arg1) {
        port.seguirUsuario(arg0, arg1);
    }

    private static Album seleccionarAlbum(java.lang.String arg0) {
        return port.seleccionarAlbum(arg0);
    }

    private static Artista seleccionarArtista(java.lang.String arg0) {
        return port.seleccionarArtista(arg0);
    }

    private static Artista seleccionarArtistaPorNombre(java.lang.String arg0) {
        return port.seleccionarArtistaPorNombre(arg0);
    }

    private static Cliente seleccionarCliente(java.lang.String arg0) {
        return port.seleccionarCliente(arg0);
    }

    private static ListaParticular seleccionarLista(java.lang.String arg0) {
        return port.seleccionarLista(arg0);
    }

    private static void setImage(edu.tecnopotify.interfaces.Album arg0) {
        port.setImage(arg0);
    }

    private static void setImageArt(edu.tecnopotify.interfaces.Artista arg0) {
        port.setImageArt(arg0);
    }

    private static void setImageCli(edu.tecnopotify.interfaces.Cliente arg0) {
        port.setImageCli(arg0);
    }

    private static void setTema(edu.tecnopotify.interfaces.Temas arg0) {
        port.setTema(arg0);
    }
    
    
    
}
