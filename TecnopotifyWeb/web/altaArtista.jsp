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

        <form action="<%= request.getContextPath()%>/altaArtista.jsp" METHOD = "post" onsubmit="return validarDatos()" enctype = "multipart/form-data">
            <input type="hidden"  name="comando" value="altaArtista" />
            <div class="container">
            Nickname:
            <input type="text" name="nickname" id ="nickname"/><br>
            Contraseña:
            <input type="password" name="contrasenia" id="contrasenia" /> <br>
            Ingrese Contraseña nuevamente:
            <input type="password" name="validarContrasenia" id ="validarContrasenia" /> <br>
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
