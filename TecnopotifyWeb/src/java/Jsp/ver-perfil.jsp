<%-- 
    Document   : basico
    Created on : 20/09/2016, 12:41:06 PM
    Author     : emi
--%>

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
<%
                String usuario = (String) request.getAttribute("usuarios");
            %>
        <div class="container">
            <H1>Perfil de usuario con id <%= usuario %></H1>

            

        </div> <!-- /container -->
        <jsp:include page="/templates/scripts.jsp" />
    </body>
</html>
