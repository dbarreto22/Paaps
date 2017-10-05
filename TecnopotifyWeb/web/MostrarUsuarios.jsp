<%-- 
    Document   : MostrarPersonas
    Created on : 19/09/2016, 07:15:42 PM
    Author     : emi
--%>

<%@page import="edu.tecnopotify.entidades.Usuario"%>
<%@page import="java.util.List"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="/templates/csss.jsp" />
    </head>
    <body>
        <jsp:include page="/templates/header.jsp" />

        <h1>Hello World!</h1>

        <ol>
            <%
                List<Usuario> list = (List<Usuario>) request.getAttribute("usuarios");
            %>

            <%
                for (Usuario u : list) {
            %>
            <li><a href="<%= request.getContextPath()%>/usuario?comando=verPerfil&idUsuario=<%= u.getNickname() %>"><%= u.toString()%></a> 
            </li>
            <%
                }
            %>
        </ol>

        <ol>
            <c:forEach var="usuario" items="${usuarios}">
                <li> - ${usuario.toString()}</li>
                </c:forEach>
        </ol>

        <jsp:include page="/templates/scripts.jsp" />
    </body>
</html>
