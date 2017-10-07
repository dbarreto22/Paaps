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

        <script type ="text/javascript">
            function validarDatos() {
                var esCorrecto = true;

                var nickname = $('#nickname').val();
                if (nickname == '') {
                    alert("Ingrese dato");
                    esCorrecto = false;
                }

                var valcontrasenia = $('#valContrasenia').val();
                if (valcontrasenia == '') {
                    alert("Ingrese dato");
                    esCorrecto = false;
                }

                var contrasenia = $('#contrasenia').val();
                if (contrasenia == '') {
                    alert("Ingrese dato");
                    esCorrecto = false;
                }


                if (contrasenia != valcontrasenia) {
                    alert("Contraseña incorrecta, Ingrese nuevamente");
                    esCorrecto = false;
                }

                return esCorrecto;

            }
        </script>


        <h1>Alta Cliente</h1>

        <form action="<%= request.getContextPath()%>/altaCliente"  onsubmit="return validarDatos()">
            <input type="hidden"  name="comando" value="altaCliente" />
            Nombre: <br>
            <input type="text" name=" nickname" /><br>
            Contraseña: <br>
            <input type="text" name="contrasenia" /> <br>
            Ingrese Contraseña nuevamente: <br>
            <input type="text" name="validar Contrasenia" /> <br>
            Ingrese Nombre: <br>
            <input type="text" name="nombre" /> <br>
            Ingrese Apellido: <br>
            <input type="text" name="apellido" /> <br>
            Ingrese Fecha de Nacimiento:
            Dia 
            <input type="number" name="dia" />
            Mes
            <input type="number" name="mes" />
            Año
            <input type="number" name="anio" /> <br>
            <input type="button" name="imagen" />

            
            <input type="submit" value="Enviar" />
            <input>
        </form> 



        <jsp:include page="/templates/scripts.jsp" />
    </body>
</html>
