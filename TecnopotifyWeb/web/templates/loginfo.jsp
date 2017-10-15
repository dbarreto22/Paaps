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
   

    if ((user != null) && !user.isEmpty()) {
%>
<li><a href="#">Bienvenido <%= user %>!</a></li>
<li><a href="<%= request.getContextPath()%>/autenticar?comando=logout">LogOut</a></li>
    <%
    } else {
    %>
<li><a href="<%= request.getContextPath()%>/login.jsp">Login</a></li>
    <%
        }
    %>
