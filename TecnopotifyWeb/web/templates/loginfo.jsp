<%@page import="edu.tecnopotify.entidades.Suscripcion.estado"%>
<%@page import="edu.tecnopotify.entidades.Cliente"%>
<%@page import="edu.tecnopotify.entidades.Usuario"%>
<%@page import="edu.tecnopotify.fabrica.Fabrica"%>
<%@page import="edu.tecnopotify.interfaces.IControlador"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    IControlador crl;
    Fabrica fabrica = Fabrica.getInstance();
    crl = fabrica.getInstancia();
    
    String user = (String) session.getAttribute("user");
    String comando ="mostrarCliente";
    
%> 

<li><a href="<%= request.getContextPath()%>/usuarios?comando=<%=comando%>">Bienvenido <%= user %>!</a></li>
<li><a href="<%= request.getContextPath() %>/autenticar?comando=logout">LogOut</a></li>

<%    if ((user != null) && !user.isEmpty() && user.getClass().getName().contains("Cliente")) {
    Cliente cli = crl.seleccionarCliente(user);
    if (cli.getSuscripcion().status == estado.PENDIENTE) {
%>
<li>Solicitud pendiente<br/><ui><a href="/contratarSuscripcion.jsp">Contratar suscripción</a></ui></li>
<%
    }
    if (cli.getSuscripcion().status == estado.VIGENTE) {
%>
<li>Solicitud vigente</li>
<%
    }
    if (cli.getSuscripcion().status == estado.CANCELADA) {
%>
<li>Solicitud cancelada<br/><ui><a href="/contratarSuscripcion.jsp">Contratar suscripción</a></ui></li>
<%
    }
    if (cli.getSuscripcion().status == estado.VENCIDA) {
%>
<li>Solicitud vencida<br/><ui><a href="/contratarSuscripcion.jsp">Contratar suscripción</a></ui></li>
<%
    }
%>

    <%
    } else {
    %>
<li><a href="<%= request.getContextPath()%>/login.jsp">Login</a></li>
    <%
        }
    %>
