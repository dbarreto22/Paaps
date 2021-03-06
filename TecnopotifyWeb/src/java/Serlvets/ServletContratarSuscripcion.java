/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serlvets;

import edu.tecnopotify.entidades.Cliente;
import edu.tecnopotify.entidades.Suscripcion;
import edu.tecnopotify.entidades.Usuario;
import edu.tecnopotify.fabrica.Fabrica;
import edu.tecnopotify.interfaces.IControlador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author menan
 */
public class ServletContratarSuscripcion extends HttpServlet {

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
        
        //Solo se puede entrar con suscripcion pendiente o vencida, son los únicos estados que permiten pasar a una suscripción vigente
        //FALTA CONTROL PREVIO DE SUSCRIPCIÓN PERO NO ME TOMA LA OPCIÓN DEL COMBO
        String comando = request.getParameter("comando");
        String nickUsr = (String) request.getSession().getAttribute("user");
        
        String suscrContratar = "VIGENTE";
        String pago = "";
        if (request.getParameter("suscripcionSemanal")!=null && request.getParameter("suscripcionMensual")==null && request.getParameter("suscripcionAnual")==null){
            pago = "SEMANAL";
        }
        if (request.getParameter("suscripcionSemanal")==null && request.getParameter("suscripcionMensual")!=null && request.getParameter("suscripcionAnual")==null){
            pago = "MENSUAL";
        }
        if (request.getParameter("suscripcionSemanal")==null && request.getParameter("suscripcionMensual")==null && request.getParameter("suscripcionAnual")!=null){
            pago = "ANUAL";
        }
        if (comando != null && comando.equals("contratarSuscripcion")){
            crl.modificarSuscripcion(nickUsr, suscrContratar, pago); 
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
