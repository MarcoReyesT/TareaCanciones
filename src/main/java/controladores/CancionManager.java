/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Artista;
import entidades.Cancion;
import entidades.Estilo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marco
 */
public class CancionManager extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean isPost = request.getMethod().equals("POST");

        String idArtista = request.getParameter("artista");
        //el objeto artista se destruye en el archivo jsp vista_artista
        //por lo que es necesario utilizar un identificador
        int id = Integer.parseInt(idArtista);
        
        if (!isPost) {

            request.setAttribute("artista", ArtistaManager.artistas.get(id));

            String accion = request.getParameter("accion");
            if (accion != null) {
                String idCancion = request.getParameter("cancion");
                int cid = Integer.parseInt(idCancion);
                if (accion.equals("borrar")) {
                    ArtistaManager.artistas.get(id).getCanciones().remove(cid);
                    for (int i = 0; i < ArtistaManager.artistas.get(id).getCanciones().size(); i++) {
                        ArtistaManager.artistas.get(id).getCanciones().get(i).setId(i);
                    }
                } else if (accion.equals("editar")) {
                    request.setAttribute("cancion", ArtistaManager.artistas.get(id).getCanciones().get(cid));
                }
            }

        } else {
            Cancion cancion = new Cancion();
            cancion.setNombre(request.getParameter("nombre"));
            cancion.setDuracion(Double.parseDouble(request.getParameter("duracion")));
            ArtistaManager.artistas.get(id).agregarCancion(cancion);
            cancion.setId(ArtistaManager.artistas.get(id).getCanciones().indexOf(cancion));
            request.setAttribute("artista", ArtistaManager.artistas.get(id));
            
        }
        
        request.setAttribute("canciones", ArtistaManager.artistas.get(id).getCanciones());

        RequestDispatcher rd = request.getRequestDispatcher("vista_canciones.jsp");
        rd.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
