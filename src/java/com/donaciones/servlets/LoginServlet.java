/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donaciones.servlets;

import com.donaciones.dao.Conexion;
import com.donaciones.dao.UsuarioDAO;
import com.donaciones.entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daniel
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final String userID = "dan865";
    private final String password = "da10";

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
        UsuarioDAO usuarioDAO = new UsuarioDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        Usuario usuario;
        try {
            usuario = usuarioDAO.autenticar(user, pass);
            if (user.equals(usuario.getUsuario()) && pass.equals(usuario.getPassword())) {
                Cookie loginCookie = new Cookie("user", user);
                Cookie perfilCookie = new Cookie("perfil", usuario.getPerfil());
                //setting cookie to expiry in 30 mins
                loginCookie.setMaxAge(30 * 60);
                perfilCookie.setMaxAge(30 * 60);
                response.addCookie(loginCookie);
                response.addCookie(perfilCookie);
                response.sendRedirect("RegistrarJornada.jsp");
                System.out.println("entro");
                //request.getRequestDispatcher("Inicio.jsp").forward(request, response);
            } else {

                System.out.println("No entro");
                request.setAttribute("mensaje", "Usuario y/o contraseña incorrectos");
                request.getRequestDispatcher("Login.jsp").forward(request, response);

            }
        } catch (Exception ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("mensaje", " Usuario y/o contraseña incorrectos");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
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
