<%-- 
    Document   : mostrarCliente
    Created on : 09/10/2017, 05:34:04 PM
    Author     : diego-lucia
--%>

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

        <h1>Datos Cliente</h1>

        <form action="<%= request.getContextPath()%>/mostrarArtista">
            <input type="hidden"  name="comando" value="mostrarArtista" />
            <div class="container">
            <select>
            Elija Nickname: <br>
            <input type="combobox" name="combo" /><br>
            </select>
            <input type="submit" value="Enviar" />
            Nombre:
            <input type="text" name="nombre" /> <br>
            Apellido:
            <input type="text" name="apellido" /> <br>
            Fecha de Nacimiento:<br>
            Dia 
            <input type="number" name="dia" />
            Mes
            <input type="number" name="mes" />
            Año
            <input type="number" name="anio" /> <br>
            Imagen:
            <input type="button" name="imagen" /> <br>
            Biografia:
            <input type="text" name="biografia" /> <br>
            Link:
            <input type="text" name="link" /> <br>
            </div>
        </form> 



        <jsp:include page="/templates/scripts.jsp" />
    </body>
</html>
