<%-- 
    Document   : AltaAlbum
    Created on : 08/10/2017, 09:29:12 PM
    Author     : Carlox
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="edu.tecnopotify.entidades.Artista"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta album</title>
    </head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <jsp:include page="/templates/csss.jsp" />
</head>
<body>
    <h1> Alta album </h1>
    <jsp:include page="/templates/header.jsp" />
    <form action="<%= request.getContextPath()%>/Album"
          method="get">
        <div class ="container">
            Artista:
            <label for="male"><%=request.getSession().getAttribute("user")%></label> <br>
            <input type="hidden"  name="usr" 
                   value="<%=request.getSession().getAttribute("user")%>" />
            <input type="hidden"  name="comando" value="altaAlbum" />
            Nombre album: <br>
            <input type="text" name="nombreAlbum" /><br>
            Año: <br>
            <input type="number" name="anio" /> <br>
            Ingrese una imagen: <br> <br>
            <div class="form-group">
                <label for="imgFile" class="col-sm-2 control-label">Imagen</label>
                <div class="col-sm-10">
                    <input type="file" 
                           id="imgFile" name="fimg" 
                           accept="image/*" />
                    <p class="help-block">Subir cualquier tipo de imagenes.</p>
                </div>
            </div>
            <input type="submit" value="Enviar" />
            <input>
        </div>
    </form> <%--<form class="form-horizontal" 
              action="<%= request.getContextPath() %>/imagenes"  
              method = "post" enctype = "multipart/form-data">  
            <div class="form-group">
                <label for="imgFile" class="col-sm-2 control-label">Imagen</label>
                <div class="col-sm-10">
                    <input type="file" 
                           id="imgFile" name="fimg" 
                           accept="image/*" />
                    <p class="help-block">Subir cualquier tipo de imagenes.</p>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Enviar</button>
                </div>
            </div>
        </form>--%>
</html>
