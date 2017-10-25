/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serlvets;

import edu.tecnopotify.datatypes.dataArtista;
import edu.tecnopotify.datatypes.dataCliente;
import edu.tecnopotify.datatypes.dataFecha;
import edu.tecnopotify.datatypes.dataListaParticular;
import edu.tecnopotify.datatypes.dataListaReproduccion;
import edu.tecnopotify.datatypes.dataUsuario;
import edu.tecnopotify.entidades.Album;
import edu.tecnopotify.entidades.Artista;
import edu.tecnopotify.entidades.Cliente;
import edu.tecnopotify.entidades.Favoritos;
import edu.tecnopotify.entidades.ListaParticular;
import edu.tecnopotify.entidades.ListaReproduccion;
import edu.tecnopotify.entidades.Temas;
import edu.tecnopotify.entidades.Usuario;
import edu.tecnopotify.fabrica.Fabrica;
import edu.tecnopotify.interfaces.IControlador;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

public class ServletUsr extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Fabrica fabrica = Fabrica.getInstance();
    IControlador crl = fabrica.getInstancia();
    private static final long serialVersionUID = 1L;
    private ServletFileUpload uploader = null;
    private String fileDirStr = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, org.apache.tomcat.util.http.fileupload.FileUploadException {

        response.setContentType("text/html;charset=UTF-8");
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String comando = request.getParameter("comando");
        if (comando != null && comando.equals("mostrarCliente")) {

            String nick = (String) request.getSession().getAttribute("user");
            Usuario usr = crl.getUsuario(nick);
            if (usr.getClass().getName().contains("Cliente")) {
                Cliente cli = crl.getCli(nick);

                request.setAttribute("nickName", cli.getNickname());
                request.setAttribute("nombre", cli.getNombre());
                request.setAttribute("apellido", cli.getApellido());
                request.setAttribute("mail", cli.getMail());
                request.setAttribute("imagen", cli.getImagen());
                request.setAttribute("dia", cli.getF_nac().getDia());
                request.setAttribute("mes", cli.getF_nac().getMes());
                request.setAttribute("anio", cli.getF_nac().getAnio());

                if (cli.getSuscripcion().status.equals("VIGENTE")) {
                    List<Usuario> seguidores = cli.getLstSeguidos();
                    Iterator<Usuario> itS = seguidores.iterator();
                    List<String> nickSeg = new ArrayList<>();
                    while (itS.hasNext()) {
                        nickSeg.add(itS.next().getNickname());
                    }
                    request.setAttribute("litseg", nickSeg);
                }

                List<ListaParticular> repPropia = cli.getListasReprParticular();
                Iterator<ListaParticular> itR = repPropia.iterator();
                List<String> nickRepPropia = new ArrayList<>();
                while (itR.hasNext()) {
                    nickRepPropia.add(itR.next().getNombre());
                }
                request.setAttribute("repPropia", nickRepPropia);
                Favoritos fav = cli.getFav();
                if (fav != null) {
                    List<Album> album = fav.getListAlbum();
                    Iterator<Album> itAlb = album.iterator();
                    List<String> nickAlbum = new ArrayList<>();

                    while (itAlb.hasNext()) {
                        nickAlbum.add(itAlb.next().getNombre());
                    }
                    request.setAttribute("album", nickAlbum);

                    List<ListaReproduccion> listRep = fav.getListRep();
                    Iterator<ListaReproduccion> itListRep = listRep.iterator();
                    List<String> nickLrep = new ArrayList<>();
                    while (itListRep.hasNext()) {
                        nickLrep.add(itAlb.next().getNombre());
                    }

                    request.setAttribute("listRep", nickLrep);
                }

                RequestDispatcher despachador = request.getRequestDispatcher("/mostrarC.jsp");
                despachador.forward(request, response);

            } else if (usr.getClass().getName().contains("Artista")) {
                Artista art = crl.seleccionarArtista(nick);

                request.setAttribute("nickName", art.getNickname());
                request.setAttribute("nombre", art.getNombre());
                request.setAttribute("apellido", art.getApellido());
                request.setAttribute("mail", art.getMail());
                request.setAttribute("imagen", art.getImagen());
                request.setAttribute("biografia", art.getBiografia());
                request.setAttribute("link", art.getLink());
                request.setAttribute("dia", art.getF_nac().getDia());
                request.setAttribute("mes", art.getF_nac().getMes());
                request.setAttribute("anio", art.getF_nac().getAnio());

                List<Album> albumArt = art.getListAlbum();
                Iterator<Album> itA = albumArt.iterator();
                List<String> nomAl = new ArrayList<>();
                while (itA.hasNext()) {
                    nomAl.add(itA.next().getNombre());
                }

                request.setAttribute("albumArt", nomAl);

                RequestDispatcher despachador = request.getRequestDispatcher("/mostrarArtista.jsp");
                despachador.forward(request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        String comando = request.getParameter("comando");

        Fabrica fabrica = Fabrica.getInstance();
        crl = fabrica.getInstancia();
        if (comando != null && comando.equals("altaCliente")) {
            //Procesar el formulario  
            String nickName = request.getParameter("nickname");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String mail = request.getParameter("mail");
            int dia = request.getIntHeader("dia");
            int mes = request.getIntHeader("mes");
            int anio = request.getIntHeader("anio");
            dataFecha fecha = new dataFecha(dia, mes, anio);
            String contrasenia = request.getParameter("contrasenia");
            dataUsuario cli = new dataCliente(nickName, nombre, apellido, mail,
                    fecha, "", contrasenia);

            crl.crearCliente(cli);

            request.setAttribute("id", nickName);
            request.setAttribute("comando", "altaCli");

            RequestDispatcher despachador = request.getRequestDispatcher("/subirImg.jsp");
            despachador.forward(request, response);

        } else if (comando != null && comando.equals("altaArtista")) {
            //Procesar el formulario  
            String nickName = request.getParameter("nickname");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String mail = request.getParameter("mail");
            int dia = request.getIntHeader("dia");
            int mes = request.getIntHeader("mes");
            int anio = request.getIntHeader("anio");
            dataFecha fecha = new dataFecha(dia, mes, anio);
            String contrasenia = request.getParameter("contrasenia");
            String imagen = "";
            String biografia = request.getParameter("biografia");
            String link = request.getParameter("link");
            dataUsuario art = new dataArtista(biografia, link, nickName, nombre, apellido, mail,
                    fecha, contrasenia, "");
            crl.crearArtista(biografia, link, art);
            String altaArt = "altaArt";

            request.setAttribute("id", nickName);
            request.setAttribute("comando", altaArt);

            RequestDispatcher despachador = request.getRequestDispatcher("/subirImg.jsp");
            despachador.forward(request, response);
        }

        if (comando != null && comando.equals("mostrarClienteGuest")) {

            String nick = request.getParameter("ArtistaSelect");
            Usuario usr = crl.getUsuario(nick);
            if (usr.getClass().getName().contains("Artista")) {
                Artista art = crl.seleccionarArtista(nick);

                request.setAttribute("nickName", art.getNickname());
                request.setAttribute("nombre", art.getNombre());
                request.setAttribute("apellido", art.getApellido());
                request.setAttribute("mail", art.getMail());
                request.setAttribute("imagen", art.getImagen());
                request.setAttribute("biografia", art.getBiografia());
                request.setAttribute("link", art.getLink());
                request.setAttribute("dia", art.getF_nac().getDia());
                request.setAttribute("mes", art.getF_nac().getMes());
                request.setAttribute("anio", art.getF_nac().getAnio());

                List<Album> albumArt = art.getListAlbum();
                Iterator<Album> itA = albumArt.iterator();
                List<String> nomAl = new ArrayList<>();
                while (itA.hasNext()) {
                    nomAl.add(itA.next().getNombre());
                }

                request.setAttribute("albumArt", nomAl);

                RequestDispatcher despachador = request.getRequestDispatcher("/mostrarArtista.jsp");
                despachador.forward(request, response);

            } else if (usr.getClass().getName().contains("Cliente")) {

                Cliente c = crl.getCli(nick);
                request.setAttribute("nickName", c.getNickname());
                request.setAttribute("imagen", c.getImagen());

                List<ListaParticular> lp = c.getListasReprParticular();
                Iterator<ListaParticular> it = lp.iterator();
                List<String> lpS = new ArrayList<>();
                while (it.hasNext()) {
                    if (!it.next().isEsPrivada()) {
                        lpS.add(it.next().getNombre());
                    }
                }
                request.setAttribute("lpS", lpS);
                RequestDispatcher despachador = request.getRequestDispatcher("/clienteguest.jsp");
                despachador.forward(request, response);
            }
        }

        if (comando != null && comando.equals("listaRep")) {

            String nombreL = request.getParameter("nombre");
            String nick = (String) request.getSession().getAttribute("user");
            Cliente cli = crl.getCli(nick);
            dataListaReproduccion listaP = new dataListaReproduccion(nombreL, "");
            crl.crearListaParticular(true, nick, listaP);

            request.setAttribute("id", nombreL);

            RequestDispatcher despachador = request.getRequestDispatcher("/subirImg.jsp");
            despachador.forward(request, response);

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
