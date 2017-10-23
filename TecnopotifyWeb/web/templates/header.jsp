<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Tecnopotify!</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="<%= request.getContextPath()%>">Home</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Usuarios <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="<%= request.getContextPath()%>/AltaCliente.jsp">Crear Cliente</a></li>
                        <li><a href="<%= request.getContextPath()%>/altaArtista.jsp">Crear Artista</a></li>
                        <li><a href="<%= request.getContextPath()%>/Guest.jsp">Mostrar datos de Usuarios</a></li>
                            <% String comando = "mostrarCliente"; %>
                            <%
                                if (request.getSession().getAttribute("user") != null) {
                            %>
                        <li><a href="<%= request.getContextPath()%>/usuarios?comando=<%=comando%>"  >Dats Usuario Logueado</a></li>                
                        <li><a href="<%= request.getContextPath()%>/seguirUsuario.jsp">Seguir/Dejar de seguir Usuario</a></li>
                        <li><a href="<%= request.getContextPath()%>/contratarSuscripcion.jsp">Contratar Suscripción</a></li>
                        <li><a href="<%= request.getContextPath()%>/actualizarSuscripcion.jsp">Actualizar Suscripción</a></li>

                        <%      }
                        %>
                    </ul>
                </li>
                <li class="Album">
                    <a href="#" class="Album" data-toggle="dropdown"
                       role="button" aria-haspopup="true" aria-expanded="false">Album <span class="caret"></span></a>
                        <% if(request.getSession().getAttribute("user") != null ) {%>
                     <ul class="dropdown-menu">
                        <li><a href="<%= request.getContextPath()%>/Album/AltaAlbum.jsp">Crear album</a></li>
                        <li><a href="<%= request.getContextPath()%>/Album">
                                album</a></li>
                        <li><a href="#">Opcion4</a></li>
                        <%}%>                                                    
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">

                <jsp:include page="/templates/loginfo.jsp"/>      

            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>