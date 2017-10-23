<%-- 
    Document   : ConsultarAlbum
    Created on : 21/10/2017, 10:13:32 PM
    Author     : Carlox
--%>


<%@page import="edu.tecnopotify.entidades.Artista"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.tecnopotify.entidades.Genero"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="/templates/csss.jsp" />
        <jsp:include page="/templates/scripts.jsp" />
    </head>
    <body>
        <jsp:include page="/templates/header.jsp" />
        <h1>Consultar Album</h1>
        <form name="FormCombos" method="post">
            <div>
                <% List<Genero> lstGenero = (List<Genero>)request.getAttribute("lstGenero");
                    List<Artista> lstArtista = (List<Artista>)request.getAttribute("lstArtista"); %>
                    Genero:
                <select id="GeneroSelect" name="GeneroSelect"
                        onchange="ComboG()">
                       <option value=""> </option>
                       <% if (lstGenero != null)
                            for (Genero genero : lstGenero) {%>
                                <option value="<%=genero.getNombre()%>"><%=genero.getNombre()%></option>
                            <%}%>>
                </select>
                Album:
                <select id="ArtistaSelect" name="ArtistaSelect"
                        onchange="ComboA()">
                       <option value=""> </option>
                       <% if (lstGenero != null)
                            for (Artista artista : lstArtista) {%>
                                <option value="<%=artista.getNickname()%>"><%=artista.getNombre()%></option>
                            <%}%>>
                </select>
            </div>
        </form>
    </body>
</html>
