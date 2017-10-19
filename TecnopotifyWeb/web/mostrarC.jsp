<%-- 
    Document   : mostrarC
    Created on : 18/10/2017, 07:17:14 PM
    Author     : diego-lucia
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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



        <form   method = "post" >
            <input type="hidden"  name="comando" value="mostrarCliente" />
            <div class="container">
                <h4>Nombre: </h4>
                <input type="text"  value =<%= request.getAttribute("nombre")%> /> <br/>
                <h4>Apellido </h4>
                <input type="text"  value =<%= request.getAttribute("apellido")%> /> <br/>
                <h4>Mail: </h4>
                <input type="text"  value =<%= request.getAttribute("mail")%> /> <br/>
                <h4>Imagen: </h4>
                <img type="text"  src="<%= request.getAttribute("imagen")%>" /> <br/>


            </div>
        </form>   

        <jsp:include page="/templates/scripts.jsp" />
    </body>
</html>
