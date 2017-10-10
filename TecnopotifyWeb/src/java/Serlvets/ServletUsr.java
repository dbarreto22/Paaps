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
import edu.tecnopotify.entidades.Artista;
import edu.tecnopotify.entidades.Cliente;
import edu.tecnopotify.entidades.Usuario;
import edu.tecnopotify.fabrica.Fabrica;
import edu.tecnopotify.interfaces.IControlador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "ServletUsr", urlPatterns = { "/usuarios/*" })
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Servlet Usuario");
        response.setContentType("text/html;charset=UTF-8");
        Fabrica fabrica = Fabrica.getInstance();
        crl = fabrica.getInstancia();
        crl.cargarDatos();
        String comando = request.getParameter("comando");

        if (comando != null && comando.equals("AltaCliente")) {
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
            dataUsuario cli = new dataCliente(nickName, nombre, apellido, mail, fecha, contrasenia, imagen);
            crl.crearCliente(cli);
        }
        if (comando != null && comando.equals("altaArtista")) {
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
        }

        if (comando != null && comando.equals("mostrarCliente")) {
            //Procesar el formulario 
            List<Cliente> clientes = crl.listarClientes();
            Iterator<Cliente> it = clientes.iterator();
            ArrayList<String> options = new ArrayList<>();
            while (it.hasNext()) {
                options.add(it.next().getNickname());
            }
            request.setAttribute("combo", options);
            String nickName = request.getParameter("seleccion");
            Cliente cli = crl.getCli(nickName);
            request.setAttribute("nombre", cli.getNombre());
            request.setAttribute("apellido", cli.getApellido());
            request.setAttribute("mail", cli.getMail());
            request.setAttribute("dia", cli.getF_nac().getDia());
            request.setAttribute("mes", cli.getF_nac().getMes());
            request.setAttribute("anio", cli.getF_nac().getAnio());
            request.setAttribute("imagen", cli.getImagen());
        }

        if (comando != null && comando.equals("mostrarArtista")) {
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
