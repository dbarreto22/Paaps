package edu.tecnopotify.interfaces;



import edu.tecnopotify.entidades.Genero;
import edu.tecnopotify.entidades.ListaReproduccion;
import edu.tecnopotify.datatypes.dataUsuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;


public class Controlador implements Interfaz {
    
    //Handler manejador = Handler.getInstance();
    
    public int altaUsuario(dataUsuario usuario){
        
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
        if (manejador.generos.contains(g)){
        return 0;
    }
    else{
        manejador.generos.add(g);  
        return 1;
    }
    }

    //cambiar nombre.
    public int altaAlbum(String nombreArtista) {
        return 0;
    }
    
    public void datosAlbum(String nombre, int anioCreado, String imagen) {

    }
    
    public void altaTema(String nombre, String duracion, int posicion) {
       Temas T = new Temas(nombre, duracion,posicion);
        if (manejador.listaTemas.containsKey(nombre)){ //si existe el tema
            System.out.println("El Tema ya existe");
        }
        else{
            manejador.listaTemas.put(nombre, T);  
        }
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

    public Artista seleccionarArtista(String nombreArtista) {
        Artista ar = (Artista) manejador.listaUsuarios.get(nombreArtista);
        return ar;
    }
    
    public Cliente seleccionarCliente(String nickname) {
        Cliente cli = (Cliente) manejador.listaUsuarios.get(nickname);
        return cli;
    }

    public void eliminarFavorito(boolean b, boolean c, boolean d, String a) {

    }

    
    public void agregarFavorito(boolean b, boolean c, boolean d, String a) {

    }
    
    public int dejarDeSeguirUsuario(String nickCliente, String nickUsr) {
        //cliente es el que desea dejar el seguimiento
        Cliente cliente = seleccionarCliente(nickCliente);
        cliente.seguidos.remove(nickUsr);
        return 0;
    }

    public int seguirUsuario(String nickCliente, String nickUsr) {
        Cliente cliee = seleccionarCliente(nickCliente);
        Usuario usr = manejador.listaUsuarios.get(nickUsr);
        cliee.seguidos.put(nickUsr, usr);
        return 0;
    }
    
    public int publicarLista(String nickname, String nombreLista) {
        ListaParticular lis = seleccionarLista(nickname, nombreLista);
        lis.setEsPrivada(true);
        return 0;
    }
    
    public ListaParticular seleccionarLista(String nickname, String nombreLista) {
        Cliente cli = (Cliente) manejador.listaUsuarios.get(nickname);
        ListaParticular lis = cli.listasReprParticular.get(nombreLista);
        return lis;
    }

    public void quitarTemaLista(String nombreTema, ListaReproduccion lista) {
        //ya deberia saber la lista, o sea que se le pasa la lista por parametro
        lista.listaTemas.remove(nombreTema);
    }
    
    public void agregarTemaLista(String nombreTema, ListaReproduccion lista) {
        lista.listaTemas.put(nombreTema, manejador.listaTemas.get(nombreTema));

    }
    
    public void mostrarListaGenero() {
        int i = 1;
        Iterator<Genero> it = manejador.generos.iterator();
        while (it.hasNext()) {
            System.out.println(i + "-" + it.next());
            i ++;
        }
    }
    
    public void crearListaDefecto(Genero genero,String nombreLista,String imagen){
        ListaDefecto listaD = new ListaDefecto(genero,nombreLista,imagen);  
        //Iterator<Genero> ite = manejador.generos.iterator().equals(genero); LINEA AL PEDO
        genero.listasReprGenero.put(nombreLista, listaD);
    }

    public Cliente devolverCliente(String nickname){
        int i = 1;
        Cliente aux = new Cliente();
        Iterator<String> it = manejador.listaUsuarios.keySet().iterator();
        while (it.hasNext()) {
            if (manejador.listaUsuarios.containsKey(nickname)) {
                aux = (Cliente) manejador.listaUsuarios.get(it);
            }
        }
        return aux;
    }
    
    public void crearListaParticular(boolean privado, Cliente cliente, String nombreLista,String imagen){
        ListaParticular listaP = new ListaParticular(privado,cliente,nombreLista,imagen);  
        cliente.listasReprParticular.put(nombreLista,listaP);
    }
    
    public int crearListaRep(boolean defecto, String nombreLista, String imagen){
        if(defecto){
            Genero aux = new Genero();
            Scanner sc = new Scanner(System.in);
            System.out.println("Elija Genero");
            mostrarListaGenero();
            int generoPos = sc.nextInt();
            aux = manejador.generos.get(generoPos-1);
            crearListaDefecto(aux, nombreLista, imagen); 
            return 1;
        }else{
           Scanner sc = new Scanner(System.in);
           System.out.println("Ingrese Nickname"); 
           String nickname = sc.nextLine();
           Cliente aux = devolverCliente(nickname);
           boolean privado = true;
           crearListaParticular(privado,aux,nombreLista,imagen);
           return 2;
        }
    }

    
    public void crearLista(String b, boolean a) {

    }

    @Override
    public void quitarTemaLista(String nombreTema, ListaReproduccion lista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarTemaLista(String nombreTema, ListaReproduccion lista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearListaDefecto(Genero genero, String nombreLista, String imagen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}