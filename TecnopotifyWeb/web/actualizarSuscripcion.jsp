<%-- 
    Document   : actualizarSuscripcion
    Created on : 22/10/2017, 09:57:57 PM
    Author     : menan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Suscripción</title>
    </head>
    <body>
        <jsp:include page="/templates/csss.jsp" />
        <jsp:include page="/templates/scripts.jsp" />
        <jsp:include page="/templates/header.jsp" />
        <div class ="container">
            <input type="hidden"  name="usr" 
                   value="<%=request.getSession().getAttribute("user")%>" />
            <h2>Contratar suscripción</h2>
            <input type="hidden"  name="comando" value="contratarSuscripcion">

            <!--El caso de uso consiste en actualizar el estado de una suscripción existente
    en el sistema. El Sistema lista las suscripciones realizadas por el cliente que
    previamente inició sesión. El Cliente tendrá la opción de modificar desde
    el estado “Pendiente” a "Cancelada" y desde el estado "Vencida" a
    "Cancelada" o "Vigente", registrándose la fecha del cambio (según la decha
    del sistema). En otro caso no se puede realizar la modificación.-->
            <%
                if (request.getSession().getAttribute("user") != null) {
            %>
            <form action="<%= request.getContextPath()%>/contratarSuscripcion?comando=contratarSuscripcion"
                  method="post">
                <label for="male">Usuario en línea: <%=request.getSession().getAttribute("user")%></label> <br/><br/>
                <!--SUSCRIPCION ACTUAL-->
                <label>Suscripción: <%=request.getAttribute("susc")%></label> <br/>
                <%
                    if (request.getAttribute("susc") == "VIGENTE") {
                %>
                <label>Suscripción: <%=request.getAttribute("pago")%></label> <br/><br/>
                <%
                    }
                %>
                <input type="checkbox" name="suscripcionSemanal" value="Si"/>SEMANAL<br/>
                <input type="checkbox" name="suscripcionMensual" value="Si"/>MENSUAL<br/>
                <input type="checkbox" name="suscripcionAnual" value="Si"/>ANUAL<br/>

                <input type="hidden"  name="comando" value="contratarSuscripcion">
                <input type="submit" value="Enviar" />
            </form>
            <%
            } else {
            %>
            <h3>No hay usuario con sesión inciada!</h3>
            <a href="login.jsp">Iniciar sesión</a>
            <%
                }
            %>
        </div>
    </body>
</html>
