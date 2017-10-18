/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serlvets;

import edu.tecnopotify.datatypes.dataArtista;
import edu.tecnopotify.datatypes.dataCliente;
import edu.tecnopotify.datatypes.dataFecha;
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
    private IControlador crl;
    private static final long serialVersionUID = 1L;
    private ServletFileUpload uploader = null;
    private String fileDirStr = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, org.apache.tomcat.util.http.fileupload.FileUploadException {
        init();

        response.setContentType("text/html;charset=UTF-8");
        Fabrica fabrica = Fabrica.getInstance();
        crl = fabrica.getInstancia();
        crl.cargarDatos();
        String comando = request.getParameter("comando");

        String nick = (String) request.getSession().getAttribute("user");
        Usuario usr = crl.getUsuario(nick);

        if (usr.equals(crl.getCli(nick)) && comando != null && comando.equals("mostrarCliente")) {
            //Procesar el formulario 

            request.setAttribute("nombre", usr.getNombre());
            /*request.setAttribute("apellido", usr.getApellido());
                    request.setAttribute("mail", usr.getMail());
                    request.setAttribute("dia", usr.getF_nac().getDia());
                    request.setAttribute("mes", usr.getF_nac().getMes());
                    request.setAttribute("anio", usr.getF_nac().getAnio());*/
            RequestDispatcher despachador = request.getRequestDispatcher("/mostrarCliente.jsp");
            despachador.forward(request, response);

        } else if (comando != null && comando.equals("mostrarArtista")) {
            //Procesar el formulario 
            List<Artista> artistas = crl.listarArtistas();
            Iterator<Artista> it = artistas.iterator();
            while (it.hasNext()) {
                request.setAttribute("combo", it.next().getNickname());
            }
            String nickName = request.getParameter("combo");
            Artista art = crl.seleccionarArtista(nickName);
            request.setAttribute("nombre", art.getNombre());
            request.setAttribute("apellido", art.getApellido());
            request.setAttribute("mail", art.getMail());
            request.setAttribute("dia", art.getF_nac().getDia());
            request.setAttribute("mes", art.getF_nac().getMes());
            request.setAttribute("anio", art.getF_nac().getAnio());
            request.setAttribute("imagen", art.getImagen());
            request.setAttribute("biografia", art.getBiografia());
            request.setAttribute("link", art.getLink());

        }


        /* try (PrintWriter out = response.getWriter()) {
        /* TODO output your page here. You may use following sample code.
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet prueba</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet prueba at " + request.getContextPath() + "</h1>");
        out.println("<ol>");
        for (Usuario usuario : usuarios) {
        System.out.println("<li>" + usuario.getNombre() + "</li>");
        }
        out.println("</ol>");
        out.println("</body>");
        out.println("</html>");
        
        }*/
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
    public void init() throws ServletException {
        String rootPath = System.getProperty("user.home");
        String relativePath = "ServletUsr-servlet";
        fileDirStr = rootPath + File.separator + relativePath;
        File filesDir = new File(fileDirStr);
        if (!filesDir.exists()) {
            filesDir.mkdirs();
        }

        DiskFileItemFactory fileFactory = new DiskFileItemFactory();
        fileFactory.setRepository(filesDir);
        this.uploader = new ServletFileUpload(fileFactory);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*String fileName = URLDecoder.decode(request.getPathInfo().substring(1), "UTF-8");
        System.out.println("Nombre:" + fileName);
        
        //        String fileName = request.getParameter("fileName");
        if (fileName == null || fileName.equals("")) {
        throw new ServletException("Debe cargar una Imagen");
        }
        File file = new File(fileDirStr + File.separator + fileName);
        if (!file.exists()) {
        throw new ServletException("La imagen no existe.");
        }
        System.out.println("Ubicacion::" + file.getAbsolutePath());
        ServletContext ctx = getServletContext();
        InputStream fis = new FileInputStream(file);
        String mimeType = ctx.getMimeType(file.getAbsolutePath());
        
        response.setContentType(mimeType != null ? mimeType
        : "application/octet-stream");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition",
        "attachment; filename=\"" + fileName + "\"");
        
        ServletOutputStream os = response.getOutputStream();
        byte[] bufferData = new byte[1024];
        int read = 0;
        while ((read = fis.read(bufferData)) != -1) {
        os.write(bufferData, 0, read);
        }
        os.flush();
        os.close();
        fis.close();
        System.out.println("Archivo descargado correctamente");*/
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
                    fecha, contrasenia, "");

            crl.crearCliente(cli);
            request.setAttribute("nickName", nickName);

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
            dataUsuario art = new dataArtista(biografia, link, nickName, nombre, apellido, mail, fecha, contrasenia, imagen);
            crl.crearArtista(biografia, link, art);
            String altaArt = "altaArt";

            request.setAttribute("id", nickName);
            request.setAttribute("comando", altaArt);

            RequestDispatcher despachador = request.getRequestDispatcher("/subirImg.jsp");
            despachador.forward(request, response);
        } else {

            String nick = (String) request.getSession().getAttribute("user");
            Usuario usr = crl.getUsuario(nick);
            if (usr.getClass().equals("Cliente")) {
                Cliente cli = crl.getCli(nick);

                request.setAttribute("nombre", cli.getNombre());
                request.setAttribute("apellido", cli.getApellido());
                request.setAttribute("mail", cli.getMail());
                request.setAttribute("dia", cli.getF_nac().getDia());
                request.setAttribute("mes", cli.getF_nac().getMes());
                request.setAttribute("anio", cli.getF_nac().getAnio());
                request.setAttribute("mail", cli.getMail());
                request.setAttribute("suscrpcion", cli.getSuscripcion().getStatus());
                String nickFav;
                List<Temas> temas = cli.getFav().getListTemas();
                List<Album> albums = cli.getFav().getListAlbum();
                List<ListaReproduccion> listRfav = cli.getFav().getListRep();
                List<ListaParticular> listRpropia = cli.getListasReprParticular();
                List<Usuario> listSeguidos = cli.getLstSeguidos();
                Iterator it = temas.iterator();
                
                request.setAttribute("temas", temas);
                request.setAttribute("albums", albums);
                request.setAttribute("listR", listRfav);
                request.setAttribute("listRpropia", listRpropia);
                request.setAttribute("seguidos", listSeguidos);
                

                
                RequestDispatcher despachador = request.getRequestDispatcher("/mostrarCliente.jsp");
                despachador.forward(request, response);

            }else if(usr.getClass().equals("Artista")) {
                Artista art = crl.seleccionarArtista(nick);
                request.setAttribute("nombre", art.getNombre());
                request.setAttribute("apellido", art.getApellido());
                request.setAttribute("mail", art.getMail());
                request.setAttribute("dia", art.getF_nac().getDia());
                request.setAttribute("mes", art.getF_nac().getMes());
                request.setAttribute("anio", art.getF_nac().getAnio());
                
            }

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
