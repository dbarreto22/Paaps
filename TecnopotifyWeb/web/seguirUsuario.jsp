<%-- 
    Document   : seguirUsuario
    Created on : Oct 14, 2017, 10:20:14 PM
    Author     : menan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seguir Usuario</title>
    </head>
    <body>
        <div class ="container">
            <form action="<%= request.getContextPath()%>/seguirUsuario?comando=seguirUsuario"
                  method="post" enctype = "multipart/form-data">
                <label for="male"><%=request.getSession().getAttribute("user")%></label> <br>
                <input type="hidden"  name="usr" 
                       value="<%=request.getSession().getAttribute("user")%>" />
                <input type="checkbox" name="Dejar de seguir" value="Si"/>Dejar de seguir usuario?<br/>
                <input type="hidden"  name="comando" value="seguirUsuario" />
                <input type="text" name="usrASeguir" /><br>
                <input type="submit" value="Enviar" />
            </form>
        </div>
    </body>
</html>
