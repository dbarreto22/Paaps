/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serlvets;

import edu.tecnopotify.entidades.Cliente;
import edu.tecnopotify.entidades.Suscripcion;
import static edu.tecnopotify.entidades.Suscripcion_.status;
import edu.tecnopotify.entidades.Usuario;
import edu.tecnopotify.fabrica.Fabrica;
import edu.tecnopotify.interfaces.IControlador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author menan
 */
public class ServletSeguirUsuario extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        Fabrica fabrica = Fabrica.getInstance();
        crl = fabrica.getInstancia();
        String comando = request.getParameter("comando");
        String nickUsr = (String) request.getSession().getAttribute("user");
        
        //Suscripción creada para comparar estados
        Suscripcion suscr = new Suscripcion();
        suscr.setStatus("VIGENTE");
        
        Usuario cl = crl.getUsuario(nickUsr);
        if ((Cliente) cl != null) {
            Cliente cliente = (Cliente) cl;
            if (comando != null && comando.equals("seguirUsuario") && (cliente.getSuscripcion().status == suscr.getStatus())) {
                String usrSeguido = request.getParameter("usrASeguir");
                boolean dejarSeguir = (!"Si".equals(request.getParameter("Dejar de seguir").toString()));
                if (dejarSeguir) {
                    crl.dejarDeSeguirUsuario(nickUsr, usrSeguido);
                } else {
                    crl.seguirUsuario(nickUsr, usrSeguido);
                }
            }
        }
        request.getRequestDispatcher("/ppal.jsp").forward(request, response);
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
