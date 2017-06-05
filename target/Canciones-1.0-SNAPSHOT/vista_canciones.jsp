<%-- 
    Document   : vista_canciones
    Created on : May 31, 2017, 6:17:57 PM
    Author     : marco
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Canciones</title>
    </head>
    <body>
        <form action="CancionManager" method="POST">

            <fieldset>
                <legend>Gestion Cancion:</legend>

                Artista:
                <input type="text" name="nombreArtista" value="${artista.nombre}" disabled/><br><br>

                Cancion:
                <input type="text" name="nombre" value="${cancion.nombre}" required/><br><br>

                Duración:
                <input type="number" name="duracion" value="${cancion.duracion}" required/><br><br>
                <input type="text" name="artista" value="${artista.id}" hidden/><br>

                <a href="ArtistaManager?"><input type="button" value="Cancelar" /></a>
                
                <input type="submit" value="Guardar" />


            </fieldset>
        </form>

        <br>
        <table border="1">
            <thead>
                <tr>
                    <th>Cancion</th>
                    <th>Duracion</th>
                    <th>Opciones</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="aux" items="${canciones}">
                <tr>
                    <td>${aux.nombre}</td>

                    <td>${aux.duracion}</td>

                    <td>
                        <a href="CancionManager?artista=${artista.id}&cancion=${aux.id}&accion=editar">Editar</a>
                        <a href="CancionManager?artista=${artista.id}&cancion=${aux.id}&accion=borrar">Borrar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
