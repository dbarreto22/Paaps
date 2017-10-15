<%-- 
    Document   : mostrarCliente
    Created on : 09/10/2017, 05:34:04 PM
    Author     : diego-lucia
--%>

<%@page import="edu.tecnopotify.entidades.Artista"%>
<%@page import="java.awt.PageAttributes.MediaType"%>
<%@page import="edu.tecnopotify.entidades.Cliente"%>
<%@page import="java.lang.String"%>
<%@page import="edu.tecnopotify.fabrica.Fabrica"%>
<%@page import="edu.tecnopotify.interfaces.IControlador"%>
<%@page import="edu.tecnopotify.entidades.Usuario"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos Cliente</title>
        <jsp:include page="/templates/csss.jsp" />
    </head>
    <body>
        <jsp:include page="/templates/header.jsp" />
        <div class="container">
            <h1>Datos Cliente</h1>
        </div>


        <%-- <input type="hidden"  name="comando" value="mostrarCliente.jsp" />--%>
        <div class="container">
            <%
                IControlador crl;
                Fabrica fabrica = Fabrica.getInstance();
                crl = fabrica.getInstancia();
                String nick = (String) request.getSession().getAttribute("user");
                //String nick = (String) session.getAttribute("user");
                Usuario usr = crl.getUsuario(nick);
                String nombre = usr.getNombre();
                String apellido = usr.getApellido();
                int dia = usr.getF_nac().getDia();
                int mes = usr.getF_nac().getMes();
                int anio = usr.getF_nac().getAnio();
                String mail = usr.getMail();
               

            %>
            <div class="container">

                <h3>Nombre: </h3>
                <input type="text"  value =<%= nombre%> /> <br/>
                <h3>Apellido: </h3>
                <input type="text" name="apellido" value =<%= apellido%> /> <br/>
                <h3>Fecha de Nacimiento: </h3> <br/>
                <input type="text" name="dia" value =<%= dia%> />
                /
                <input type="text" name="mes" value =<%= mes%> />
                /
                <input type="text" name="anio" value =<%= anio%> /> <br/>
                <h3>Mail:</h3>
                <input type="text" name="mail" value =<%= mail%> /> <br/>
                <h3>Imagen:</h3>
                <div class="container" style="margin-top: 60px">
                    <img 
                        src="<%= request.getContextPath() + "/imagenes/" + request.getAttribute("imagen")%>" />

                </div> 
            </div>




            <jsp:include page="/templates/scripts.jsp" />
    </body>
</html>
