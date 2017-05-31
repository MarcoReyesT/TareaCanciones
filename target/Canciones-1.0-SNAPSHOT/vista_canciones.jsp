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
        <form action="ServletCancion" method="post">

            <fieldset>
                <legend>Gestion Cancion:</legend>

                Artista:
                <input type="text" name="artista" value="${artista.nombre}" /><br><br>

                Cancion:
                <input type="text" name="cancion" value="" /><br><br>
                
                Duración:
                <input type="text" name="duracion" value="" /><br><br>


                <input type="submit" value="Cancelar" />
                <input type="submit" value="Guardar" />


            </fieldset>
        </form>

        <br>
        <table border="1">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Estilo</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </body>
</html>
