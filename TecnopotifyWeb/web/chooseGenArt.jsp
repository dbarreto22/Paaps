<%-- 
    Document   : mostrarAlbum
    Created on : 17/10/2017, 10:38:33 PM
    Author     : diego-lucia
--%>

<%@page import="edu.tecnopotify.entidades.Artista"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="edu.tecnopotify.entidades.Genero"%>
<%@page import="java.util.List"%>
<%@page import="edu.tecnopotify.entidades.Usuario"%>
<%@page import="edu.tecnopotify.interfaces.IControlador"%>
<%@page import="edu.tecnopotify.fabrica.Fabrica"%>
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

        <%
            Fabrica fabrica = Fabrica.getInstance();
            IControlador crl = fabrica.getInstancia();
            List<Genero> generos = crl.listarGeneros();
            Iterator<Genero> itG = generos.iterator();
            List<Artista> artistas = crl.listarArtistas();
            Iterator<Artista> itA = artistas.iterator();

        %>

        <form action="/Tecnopotify/usuarios?comando=elegirGenero" method = "post" >
            <input type="hidden"  name="comando" value="elegirGenero" />

            <div class="container">
                <select id="GeneroSelect" name="generoSelect">
                    <option value=""> </option>
                    <% if (generos != null) {
                            for (Genero gen : generos) {%>
                    <option value="<%=gen.getNombre()%>"><%=gen.getNombre()%></option>
                    <%}
                    } else {%>
                    <h6> No hay Generos ingresados </h6>
                    <%}%>
                </select>
                <input type="submit" value="Aceptar"
                       </form>
                
                
        <form action="/Tecnopotify/usuarios?comando=elegirArtista" method = "post" >
                    <input type="hidden"  name="comando" value="elegirArtista" />
                    <div class="container">
                        <select id="artistaSelect" name="artistaSelect">
                            <option value=""> </option>
                            <% if (artistas != null) {
                                for (Artista art : artistas) {%>
                            <option value="<%=art.getNombre()%>"><%=art.getNombre()%></option>
                            <%}
                        } else {%>
                            <h6> No hay Generos ingresados </h6>
                            <%}%>
                        </select>
                        <input type="submit" value="Aceptar"
                    </div>

                </form>

                <jsp:include page="/templates/scripts.jsp" />
                </body>
                </html>
