/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Artista;
import entidades.Estilo;
import java.io.IOException;
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
public class ArtistaManager extends HttpServlet {

    protected static ArrayList<Artista> artistas = new ArrayList<>();

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

        boolean isGet = request.getMethod().equals("GET");

        if (isGet) {
            String idArtista = request.getParameter("artista");
            int id = Integer.parseInt(idArtista);
            Artista artista = ArtistaManager.artistas.get(id);

            request.setAttribute("artista", artista);

        } else {
            String estilo = (String) request.getParameter("estilo");

            Artista artista = new Artista();
            artista.setNombre(request.getParameter("nombre"));

            if (estilo.equals("Rock")) {
                artista.setEstilo(Estilo.ROCK);
            } else if (estilo.equals("Pop")) {
                artista.setEstilo(Estilo.POP);
            } else if (estilo.equals("Folk")) {
                artista.setEstilo(Estilo.FOLK);
            }
            ArtistaManager.artistas.add(artista);

            artista.setId(ArtistaManager.artistas.indexOf(artista));
        }

        request.setAttribute("artistas", ArtistaManager.artistas);

        RequestDispatcher rd = request.getRequestDispatcher("vista_artista.jsp");
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
