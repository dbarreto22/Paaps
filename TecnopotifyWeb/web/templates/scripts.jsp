<%-- 
    Document   : scripts
    Created on : 21/09/2016, 06:41:04 PM
    Author     : emi
--%>

<%@page import="edu.tecnopotify.entidades.Usuario"%>
<%@page import="edu.tecnopotify.fabrica.Fabrica"%>
<%@page import="edu.tecnopotify.interfaces.IControlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="<%= request.getContextPath()%>/bower_components/jquery/dist/jquery.js" type="text/javascript" ></script>
<script src="<%= request.getContextPath()%>/bower_components/bootstrap/dist/js/bootstrap.js" type="text/javascript" ></script>
<script>
    function buscarAjax() {
        var queryStr = $("#buscar-query").val();
        $.get("<%= request.getContextPath()%>/buscar?query=" + queryStr, function (data) {
            console.info("El texto buscado fue... " + data);
        });
    }
</script>

<script>
    function validarDatos() {
        var esCorrecto = true;

        var nickname = $('#nickname').val();
        if (nickname === '') {
            alert("Ingrese Nickname");
            esCorrecto = false;
        }

        var valcontrasenia = $('#validarContrasenia').val();
        if (valcontrasenia === '') {
            alert("Ingrese Contraseña");
            esCorrecto = false;
        }

        var contrasenia = $('#contrasenia').val();
        if (contrasenia === '') {
            alert("Ingrese Contraseña");
            esCorrecto = false;
        }

        if (contrasenia != valcontrasenia) {
            alert("Contraseña incorrecta, Ingrese nuevamente");
            esCorrecto = false;
        }
        return esCorrecto;
    }
</script>


</script>
