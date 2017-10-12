<%-- 
    Document   : AltaAlbum
    Created on : 08/10/2017, 09:29:12 PM
    Author     : Carlox
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="edu.tecnopotify.entidades.Artista"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta album</title>
    </head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="/templates/csss.jsp" />
    </head>
    <body>
        <%
            List<Artista> lstArtista= (List<Artista>)request.getAttribute("lstArtista");
        %>    
        <h1> Alta album </h1>
        <jsp:include page="/templates/header.jsp" />
        <form action="<%= request.getContextPath()%>/altaCliente"  onsubmit="return validarDatos()">
            <div class ="container">
            Artista <br>
            <select name ="cboArtistas" id="cboArtistas">
                <option value="0">Seleccione...</option>
                <%if(lstArtista!=null){%>
                    <% for (Artista oArtista : lstArtista){ %>
                        <option value="<%= oArtista.getNickname() %>"><%= oArtista.getNickname() %></option>
                    <% }%>
                <%}%>
            </select>   <br>
            <input type="hidden"  name="comando" value="altaAlbum" />
            Nombre album: <br>
            <input type="text" name=" nombreAlbum" /><br>
            Año: <br>
            <input type="number" name="anio" /> <br>
            Ingrese una imagen: <br> <br>
            <input type="submit" value="Enviar" />
            <input>
            </div>
        </form> 
</html>
