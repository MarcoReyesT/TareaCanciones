<%-- 
    Document   : vista_canciones
    Created on : May 31, 2017, 6:17:57 PM
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Canciones</title>
    </head>
    <body>
        <form action="CancionManager" method="post">

            <fieldset>
                <legend>Gestion Cancion:</legend>

                Artista:
                <input type="text" name="artista" value="${artista.nombre}" disabled/><br><br>

                Cancion:
                <input type="text" name="cancion" value="" required/><br><br>

                Duración:
                <input type="number" name="duracion" value="" /><br><br>


                <input type="submit" value="Cancelar" />
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
            <c:forEach var="cantidad" items="${artistas}">
                <tr>
                    <td>${cantidad.nombre}</td>

                    <td>${cantidad.estilo}</td>

                    <td>
                        <a href="CancionManager?artista=${cantidad.id}">Editar</a>
                        <a href="CancionManager?artista=${cantidad.id}">Borrar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
