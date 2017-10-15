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
        <div class="container">
            <h1>Alta Cliente</h1>
        </div>

        <form action="<%= request.getContextPath()%>/AltaCliente.jsp"  METHOD = "post" onsubmit="return validarDatos()" enctype = "multipart/form-data">
            <input type="hidden"  name="comando" value="AltaCliente" />
            <div class="container">
                <label>Nickname: </label>
                <input type="text" name=" nickname" id="nickname" /><br />
                Contraseña:
                <input type="password" name="contrasenia" id ="contrasenia"/> <br />
                Ingrese Contraseña nuevamente:
                <input type="password" name="validarContrasenia" id = "validarContrasenia"/> <br />
                Ingrese Nombre:
                <input type="text" name="nombre" /> <br />
                Ingrese Apellido:
                <input type="text" name="apellido" /> <br />
                Ingrese Fecha de Nacimiento:<br />
                Dia 
                <input type="number" name="dia" />
                Mes
                <input type="number" name="mes" />
                Año
                <input type="number" name="anio" /> <br />  
                    <div class="form-group">
                        <label for="imgFile" class="col-sm-2 control-label">Imagen</label>
                        <div class="col-sm-10">
                            <input type="file" id="imgFile" name="fimg" accept="image/*" />
                            <p class="help-block">Subir cualquier tipo de imagenes.</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                        </div>
                    </div>
                <input type="submit" value="Enviar" />
            </div>
        </form> 
            

        <jsp:include page="/templates/scripts.jsp" />
    </body>
</html>
