<%-- 
    Document   : altaTema
    Created on : 12/10/2017, 11:48:14 PM
    Author     : Carlox
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="capa">
            <div class="container">
            <form action="<%= request.getContextPath()%>/Servlets/ServletALbum.java"  METHOD = "post" onsubmit="return validarDatos()">
                <div class ="container">
                    Posicion:
                    <input type="number" name=" Pos1" />
                    Nombre Tema: 
                    <input type="text" name=" nombreAlbum1" />
                    Archivo: 
                    <input type="file" 
                           id="audioFile" name="faudio1" 
                           accept="audio/*" />
                    <p class="help-block">Subir cualquier tipo de imagenes.</p>
                </div> <br>
                <div class ="container">
                    Posicion:
                    <input type="number" name=" Pos2" />
                    Nombre Tema: 
                    <input type="text" name=" nombreAlbum2" />
                    Archivo: 
                    <input type="file" 
                           id="audioFile" name="audio2" 
                           accept="audio/*" />
                    <p class="help-block">Subir cualquier tipo de imagenes.</p>
                </div> <br>
                <div class ="container">
                    Posicion:
                    <input type="number" name=" Pos3" />
                    Nombre Tema: 
                    <input type="text" name=" nombreAlbum3" />
                    Archivo: 
                    <input type="file" 
                           id="audioFile" name="faudio3" 
                           accept="audio/*" />
                    <p class="help-block">Subir cualquier tipo de imagenes.</p>
                </div> <br>
                <div class ="container">
                    Posicion:
                    <input type="number" name=" Pos4" />
                    Nombre Tema: 
                    <input type="text" name=" nombreAlbum4" />
                    Archivo: 
                    <input type="file" 
                           id="audioFile" name="audio4" 
                           accept="audio/*" />
                    <p class="help-block">Subir cualquier tipo de imagenes.</p>
                </div> <br>
                <div class ="container">
                    Posicion:
                    <input type="number" name=" Pos5" />
                    Nombre Tema: 
                    <input type="text" name=" nombreAlbum5" />
                    Archivo: 
                    <input type="file" 
                           id="audioFile" name="faudio5" 
                           accept="audio/*" />
                    <p class="help-block">Subir cualquier tipo de imagenes.</p>
                </div> <br>
                <div class ="container">
                    Posicion:
                    <input type="number" name=" Pos6" />
                    Nombre Tema: 
                    <input type="text" name=" nombreAlbum6" />
                    Archivo: 
                    <input type="file" 
                           id="audioFile" name="audio6" 
                           accept="audio/*" />
                    <p class="help-block">Subir cualquier tipo de imagenes.</p>
                </div> <br>
                <div class ="container">
                    Posicion:
                    <input type="number" name=" Pos7" />
                    Nombre Tema: 
                    <input type="text" name=" nombreAlbum7" />
                    Archivo: 
                    <input type="file" 
                           id="audioFile" name="faudio7" 
                           accept="audio/*" />
                    <p class="help-block">Subir cualquier tipo de imagenes.</p>
                </div> <br>
                <div class ="container">
                    Posicion:
                    <input type="number" name=" Pos8" />
                    Nombre Tema: 
                    <input type="text" name=" nombreAlbum8" />
                    Archivo: 
                    <input type="file" 
                           id="audioFile" name="audio8" 
                           accept="audio/*" />
                    <p class="help-block">Subir cualquier tipo de imagenes.</p>
                </div> <br>
                <div class ="container">
                    Posicion:
                    <input type="number" name=" Pos9" />
                    Nombre Tema: 
                    <input type="text" name=" nombreAlbum9" />
                    Archivo: 
                    <input type="file" 
                           id="audioFile" name="faudio9" 
                           accept="audio/*" />
                    <p class="help-block">Subir cualquier tipo de imagenes.</p>
                </div> <br>
                <div class ="container">
                    Posicion:
                    <input type="number" name=" Pos10" />
                    Nombre Tema: 
                    <input type="text" name=" nombreAlbum10" />
                    Archivo: 
                    <input type="file" 
                           id="audioFile" name="audio10" 
                           accept="audio/*" />
                    <p class="help-block">Subir cualquier tipo de imagenes.</p>
                </div> <br>
                <div class ="container">
                    Posicion:
                    <input type="number" name=" Pos11" />
                    Nombre Tema: 
                    <input type="text" name=" nombreAlbum11" />
                    Archivo: 
                    <input type="file" 
                           id="audioFile" name="faudio11" 
                           accept="audio/*" />
                    <p class="help-block">Subir cualquier tipo de imagenes.</p>
                </div> <br>
            </form>
            </div>
            <jsp:include page="/templates/scripts.jsp" />
        </div>
    </body>
</html>
