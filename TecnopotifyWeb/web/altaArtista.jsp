<%-- 
    Document   : altaArtista
    Created on : 08/10/2017, 07:13:23 PM
    Author     : diego-lucia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta Artista</title>
        <jsp:include page="/templates/csss.jsp" />
    </head>
    <body>
        <jsp:include page="/templates/header.jsp" />
        <DIV ALIGN=center>
            <h1>Alta Artista</h1>
        </DIV>

        <form action="<%= request.getContextPath()%>/altaArtista"  METHOD = "post" onsubmit="return validarDatos()">
            <input type="hidden"  name="comando" value="altaArtista" />
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
            Ingrese Biografia:
            <input type="text" name="biografia" /> <br>
            Ingrese Link:
            <input type="text" name="link" /> <br>
            <input type="submit" value="Enviar" />
           </div>
        </form> 
        <jsp:include page="/templates/scripts.jsp" />
    </body>
</html>
