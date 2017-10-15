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
                <li class="active"><a href="<%= request.getContextPath()%>">Home</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Usuarios <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="<%= request.getContextPath()%>/AltaCliente.jsp">Crear Cliente</a></li>
                        <li><a href="<%= request.getContextPath()%>/altaArtista.jsp">Crear Artista</a></li>
                        <li><a href="<%= request.getContextPath()%>/mostrarCliente.jsp">Mostrar datos de Cliente</a></li>
                        <li><a href="<%= request.getContextPath()%>/mostrarArtista.jsp">Mostrar datos de Artista</a></li>
                        <li><a href="<%= request.getContextPath()%>/seguirUsuario.jsp">Seguir Usuario</a></li>
                        <li><a href="<%= request.getContextPath()%>/dejarDeSeguirUsuario.jsp">Dejar de Seguir Usuario</a></li>
                    </ul>
                </li>
                <li class="Album">
                            <a href="#" class="Album" data-toggle="dropdown"
                               role="button" aria-haspopup="true" aria-expanded="false">Album <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="<%= request.getContextPath()%>Album/AltaAlbum.jsp">Crear album</a></li>
                                <li><a href="#">Opcion3</a></li>
                                <li><a href="#">Opcion4</a></li>
                                <li role="separator" class="divider"></li>
                                <li class="dropdown-header">Nav header</li>
                                <li><a href="#">Separated link</a></li>
                                <li><a href="#">One more separated link</a></li>
                            </ul>
                        </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <form class="form-inline" style="margin-top: 10px; margin-right: 5px;">
                        <div class="form-group">
                            <input type="text" class="form-control" id="buscar-query" name="fquery" placeholder="Buscar..." onblur="buscarAjax()">
                        </div>
                        <button type="button" class="btn btn-default" onclick="buscarAjax()" >Buscar algo</button>
                    </form>
                </li>
                <jsp:include page="/templates/loginfo.jsp"/>        

            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>