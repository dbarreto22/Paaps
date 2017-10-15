<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesión</title>
    </head>
    <body>
        <jsp:include page="/templates/csss.jsp" />
        <jsp:include page="/templates/scripts.jsp" />
        <jsp:include page="/templates/header.jsp" />
        <div class="container">
            <form class="form-signin" method="POST"
                  action="<%= request.getContextPath()%>/autenticar">
                <h2 class="form-signin-heading">Iniciar sesión</h2>
             

                <label for="fuser" class="sr-only">NickName</label>
                <input type="text" id="fuser" class="form-control" 
                       placeholder="NickName o Email" required autofocus name="user">
                <label for="fpass" class="sr-only">Contraseña</label>
                <input type="password" id="fpass" class="form-control" 
                       placeholder="Contraseña" required name="pass">
                <input type="hidden"  name="comando" value="login">
                <button class="btn btn-lg btn-primary btn-block" 
                         type="submit">Sign in</button>
            </form>

        </div> <!-- /container -->



        
    </body>
</html>
