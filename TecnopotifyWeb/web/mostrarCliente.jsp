<%-- 
    Document   : mostrarCliente
    Created on : 09/10/2017, 05:34:04 PM
    Author     : diego-lucia
--%>

<%@page import="com.sun.corba.se.spi.presentation.rmi.StubAdapter.request
        (Object, String, 
        boolean)"%>
<%@page import="edu.tecnopotify.entidades.Temas"%>
<%@page import="java.util.List"%>
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

            <div class="container">
                <% List<String> temas = (ArrayList) request.getAttribute("temas");
                    Iterator<String> itT = temas.iterator();
                    List<String> albums = (ArrayList) request.getAttribute("albums");
                    Iterator<String> itA = albums.iterator();
                    List<String> listRepFav = (ArrayList) request.getAttribute("listRFav");
                    Iterator<String> itRepFav = listRepFav.iterator();
                    List<String> listRepProp = (ArrayList) request.getAttribute("listRpropia");
                    Iterator<String> itRepProp = listRepProp.iterator();
                    List<String> listseg = (ArrayList) request.getAttribute("seguidos");
                    Iterator<String> itSeg = listseg.iterator();
                %>  

                <h3>Nombre: </h3>
                <input type="text"  value =<%= request.getAttribute("nombre")%> /> <br/>
                <h3>Apellido: </h3>
                <input type="text" value =<%= request.getAttribute("apellido")%> /> <br/>
                <h3>Fecha de Nacimiento: </h3> <br/>
                <input type="text"  value =<%= request.getAttribute("dia")%> />
                /
                <input type="month"  value =<%= request.getAttribute("mes")%> />
                /
                <input type="text"  value =<%= request.getAttribute("anio")%> /> <br/>
                <h3>Mail:</h3>
                <input type="text"  value =<%= request.getAttribute("mail")%> /> <br/>
                <h3>Imagen:</h3>
                <div class="container" style="margin-top: 60px">
                    <img src="<%= request.getAttribute("imagen")%>" />
                </div> 
                <h3>Tipo de Suscripcion:</h3>
                <input type="text"  value =<%= request.getAttribute("suscripcion")%> /> <br/>


                <h3>Temas Favoritos:</h3>   
                <table>
                    <% while (itT.hasNext()) {%>
                    <tr>
                        <td><%= itT.next()%></td>                        
                    </tr>
                    <%}%>
                </table> <br/>

                <h3>Albums Favoritos:</h3>   
                <table>
                    <% while (itA.hasNext()) {%>
                    <tr>
                        <td><a href= "<%= request.getContextPath()%>/mostrarAlbum.jsp">itA.next()</a></td>                                    
                    </tr>
                    <%}%>
                </table> <br/>

                <h3>Lista Reproduccion Favoritos:</h3>   
                <table>
                    <% while (itRepFav.hasNext()) {%>
                    <tr>
                        <td><%= itRepFav.next()%></td>                        
                    </tr>
                    <%}%>
                </table> <br/>

                <h3>Lista Reproduccion Propia:</h3>   
                <table>
                    <% while (itRepProp.hasNext()) {%>
                    <tr>
                        <td><%= itRepProp.next()%></td>                        
                    </tr>
                    <%}%>
                </table> <br/>

                <h3>Lista de Seguidos:</h3>   
                <table>
                    <% while (itSeg.hasNext()) {%>
                    <tr>
                        <td><%= itSeg.next()%></td>                        
                    </tr>
                    <%}%>
                </table> <br/>


            </div>




            <jsp:include page="/templates/scripts.jsp" />
    </body>
</html>
