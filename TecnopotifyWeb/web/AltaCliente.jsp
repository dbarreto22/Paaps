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
        <title>Alta Cliente</title>
        <jsp:include page="/templates/csss.jsp" />
    </head>
    <body>
        <jsp:include page="/templates/header.jsp" />

        <h1>Alta Cliente</h1>

        <form action="<%= request.getContextPath()%>/altaCliente"  METHOD = "post" onsubmit="return validarDatos()">
            <input type="hidden"  name="comando" value="altaCliente" />
            <div class="container">
            Nickname:
            <input type="text" name=" nickname" /><br>
            Contraseña:
            <input type="password" name="contrasenia" /> <br>
            Ingrese Contraseña nuevamente:
            <input type="password" name="validarContrasenia" /> <br>
            Ingrese Nombre:
            <input type="text" name="nombre" /> <br>
            Ingrese Apellido:
            <input type="text" name="apellido" /> <br>
            Ingrese Fecha de Nacimiento:<br>
            Dia 
            <input type="number" name="dia" />
            Mes
            <input type="number" name="mes" />
            Año
            <input type="number" name="anio" /> <br>
            Elija Imagen:
            <input type="button" name="imagen" /> <br>
            
            <input type="submit" value="Enviar" />
            </<div>
        </form> 



        <jsp:include page="/templates/scripts.jsp" />
    </body>
</html>
