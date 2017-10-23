<%-- 
    Document   : mostrarAlbum
    Created on : 22/10/2017, 11:13:58 PM
    Author     : diego-lucia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta Cliente</title>
        <jsp:include page="/templates/csss.jsp" />
    </head>
    <body>
        <jsp:include page="/templates/header.jsp" />
        <div class="container">
            <h1>Datos Album</h1>
        </div>
    </head>
    <body>
        <form   method = "post" >
            <input type="hidden"  name="comando" value="mostrarArtista" />
            <div class="container">
                <h6>Nombre: </h6>
                <input type="text"  value =<%= request.getAttribute("nombre")%> /> <br/>
                <h6>Año Creacion: </h6>
                <input type="text"  value =<%= request.getAttribute("nombre")%> /> <br/>
                <h6>Generos </h6>
                <input type="text"  value =<%= request.getAttribute("apellido")%> /> <br/>
        
        
        
        
        
        <jsp:include page="/templates/scripts.jsp" />
    </body>
</html>
