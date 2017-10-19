<%-- 
    Document   : mostrarArtista
    Created on : 09/10/2017, 07:50:20 PM
    Author     : diego-lucia
--%>

<%@page import="edu.tecnopotify.entidades.Artista"%>
<%@page import="edu.tecnopotify.entidades.Usuario"%>
<%@page import="edu.tecnopotify.fabrica.Fabrica"%>
<%@page import="edu.tecnopotify.interfaces.IControlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos Artista</title>
        <jsp:include page="/templates/csss.jsp" />
    </head>
    <body>
        <jsp:include page="/templates/header.jsp" />

        <h1>Datos Artista</h1>

        <form   method = "post" >
            <input type="hidden"  name="comando" value="mostrarArtista" />
            <div class="container">
                <h4>Nombre: </h4>
                <input type="text"  value =<%= request.getAttribute("nombre")%> /> <br/>
                <h4>Apellido </h4>
                <input type="text"  value =<%= request.getAttribute("apellido")%> /> <br/>
                <h4>Mail: </h4>
                <input type="text"  value =<%= request.getAttribute("mail")%> /> <br/>
                <h4>Biografia: </h4>
                <input type="text"  value =<%= request.getAttribute("biografia")%> /> <br/>
                <h4>Link: </h4>
                <input type="text"  value =<%= request.getAttribute("link")%> /> <br/>
                
                
                <h4>Imagen: </h4>
                <img type="text"  src="<%= request.getAttribute("imagen")%>" /> <br/>


            </div>
        </form> 
        </div>

        <jsp:include page="/templates/scripts.jsp" />
    </body>
</html>
