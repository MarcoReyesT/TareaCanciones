<%-- 
    Document   : vista_artista
    Created on : May 31, 2017, 6:02:38 PM
    Author     : marco
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ArtistaManager" method="post">
            <fieldset>
                <legend>Gestion Artista:</legend>

                Nombre:
                <input type="text" name="nombre" value="${artista.nombre}" required/><br>

                Estilo: &nbsp; &nbsp;
                <select name="estilo" size="1">
                    <option value="Rock">Rock</option>
                    <option value="Pop">Pop</option>
                    <option value="Folk">Folk</option>
                </select><br><br>

                <input type="reset" value="Cancelar" />
                <input type="submit" value="Guardar" />
            </fieldset>
        </form>

        <table border="1">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Estilo</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cantidad" items="${artistas}">
                    <tr>
                        <td>${cantidad.nombre}</td>

                        <td>${cantidad.estilo}</td>

                        <td>
                            <a href="ArtistaManager?artista=${cantidad.id}&accion=editar">Editar</a>
                            <a href="ArtistaManager?artista=${cantidad.id}&accion=borrar">Borrar</a>
                            <a href="CancionManager?artista=${cantidad.id}">Canciones</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>


    </body>
</html>
