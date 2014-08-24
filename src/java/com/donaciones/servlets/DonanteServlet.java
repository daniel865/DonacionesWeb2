/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donaciones.servlets;

import com.donaciones.dao.Conexion;
import com.donaciones.dao.DonanteDAO;
import com.donaciones.entities.Donante;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "DonanteServlet", urlPatterns = {"/DonanteServlet"})
public class DonanteServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        if (("Guardar").equals(accion)) {
            DonanteDAO donanteDAO = new DonanteDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String tipo_doc = request.getParameter("tipo_doc");
            String nro_doc = request.getParameter("nro_doc");
            String nombres = request.getParameter("nombres");
            String primer_apellido = request.getParameter("primer_apellido");
            String segundo_apellido = request.getParameter("segundo_apellido");
            String telefono = request.getParameter("telefono");
            Long.parseLong(telefono);
            String direccion = request.getParameter("direccion");
            String departamento = request.getParameter("departamento");
            String municipio = request.getParameter("municipio");
            String genero = request.getParameter("genero");
            String correo = request.getParameter("correo");
            String fecha_nacimiento = request.getParameter("fecha_nacimiento");
            String fecha_ultdonacion = request.getParameter("fec_ultdonacion");
            Date fec_nacimiento2 = null;
            Date fec_ultdonacion2 = null;
            try {
                java.util.Date fec_nacimiento = formatter.parse(fecha_nacimiento);
                java.util.Date fec_ultdonacion = formatter.parse(fecha_ultdonacion);
                fec_nacimiento2 = new Date(fec_nacimiento.getTime());
                fec_ultdonacion2 = new Date(fec_ultdonacion.getTime());
            } catch (ParseException ex) {
                Logger.getLogger(DonanteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            String enfermedades = request.getParameter("enfermedades");
            String habitos = request.getParameter("habitos");
            String nom_responsable = request.getParameter("nom_responsable");
            String tel_responsable = request.getParameter("tel_responsable");
            Long.parseLong(tel_responsable);
            String estado = request.getParameter("estado");
            try {
                donanteDAO.crearDonante(new Donante(tipo_doc, nro_doc, nombres, primer_apellido, segundo_apellido, Long.parseLong(telefono), direccion, correo, fec_nacimiento2, fec_ultdonacion2, enfermedades, habitos, nom_responsable, Long.parseLong(tel_responsable), genero, departamento, municipio, estado));
                request.setAttribute("mensaje", "Donante creado correctament");
            } catch (Exception e) {
                Logger.getLogger(DonanteServlet.class.getName()).log(Level.SEVERE, null, e);
                request.setAttribute("mensaje", e.getMessage());
                request.setAttribute("tipo_doc", tipo_doc);
                request.setAttribute("nro_doc", nro_doc);
                request.setAttribute("nombres", nombres);
                request.setAttribute("primer_apellido", primer_apellido);
                request.setAttribute("segundo_apellido", segundo_apellido);
                request.setAttribute("telefono", telefono);
                request.setAttribute("direccion", direccion);
                request.setAttribute("departamento", departamento);
                request.setAttribute("municipio", municipio);
                request.setAttribute("genero", genero);
                request.setAttribute("correo", correo);
                request.setAttribute("fecha_nacimiento", fecha_nacimiento);
                request.setAttribute("fec_ultdonacion", fecha_ultdonacion);
                request.setAttribute("enfermedades", enfermedades);
                request.setAttribute("habitos", habitos);
                request.setAttribute("nom_responsable", nom_responsable);
                request.setAttribute("tel_responsable", tel_responsable);
                request.setAttribute("estado", estado);
            }
            request.getRequestDispatcher("RegistrarDonante.jsp").forward(request, response);
        } else {
            if (("Consultar").equals(accion)) {
                DonanteDAO donanteDAO = new DonanteDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
                String id_donante = request.getParameter("buscar_don");
                Donante donante;
                try {
                    donante = donanteDAO.buscarDonante(id_donante);
                    request.setAttribute("mensaje", "El donante fue encontrado");
                    request.setAttribute("tipo_doc", donante.getTipo_documento());
                    request.setAttribute("nro_doc", donante.getNro_identificacion());
                    request.setAttribute("nombres", donante.getNombres());
                    request.setAttribute("primer_apellido", donante.getApellido1());
                    request.setAttribute("segundo_apellido", donante.getApellido2());
                    request.setAttribute("telefono", donante.getTelefono());
                    request.setAttribute("direccion", donante.getDireccion());
                    request.setAttribute("departamento", donante.getDepartamento());
                    request.setAttribute("municipio", donante.getMunicipio());
                    request.setAttribute("genero", donante.getGenero());
                    request.setAttribute("correo", donante.getCorreo());
                    request.setAttribute("fecha_nacimiento", donante.getFec_naciminiento());
                    request.setAttribute("fec_ultdonacion", donante.getFec_donacion());
                    request.setAttribute("enfermedades", donante.getEnfermedades());
                    request.setAttribute("habitos", donante.getHabitos());
                    request.setAttribute("nom_responsable", donante.getNombre_rep());
                    request.setAttribute("tel_responsable", donante.getTelefono_rep());
                    request.setAttribute("estado", donante.getEstado());
                    request.getRequestDispatcher("RegistrarDonante.jsp").forward(request, response);
                } catch (Exception e) {
                    Logger.getLogger(DonanteServlet.class.getName()).log(Level.SEVERE, null, e);
                    request.setAttribute("mensaje", "El donante no exite");
                    request.getRequestDispatcher("RegistrarDonante.jsp").forward(request, response);
                }
            } else {
                if (("Modificar").equals(accion)) {
                    DonanteDAO donanteDAO = new DonanteDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String tipo_doc = request.getParameter("tipo_doc");
                    String nro_doc = request.getParameter("nro_doc");
                    String nombres = request.getParameter("nombres");
                    String primer_apellido = request.getParameter("primer_apellido");
                    String segundo_apellido = request.getParameter("segundo_apellido");
                    String telefono = request.getParameter("telefono");
                    Long.parseLong(telefono);
                    String direccion = request.getParameter("direccion");
                    String departamento = request.getParameter("departamento");
                    String municipio = request.getParameter("municipio");
                    String genero = request.getParameter("genero");
                    String correo = request.getParameter("correo");
                    String fecha_nacimiento = request.getParameter("fecha_nacimiento");
                    String fecha_ultdonacion = request.getParameter("fec_ultdonacion");
                    Date fec_nacimiento2 = null;
                    Date fec_ultdonacion2 = null;
                    try {
                        java.util.Date fec_nacimiento = formatter.parse(fecha_nacimiento);
                        java.util.Date fec_ultdonacion = formatter.parse(fecha_ultdonacion);
                        fec_nacimiento2 = new Date(fec_nacimiento.getTime());
                        fec_ultdonacion2 = new Date(fec_ultdonacion.getTime());
                    } catch (ParseException ex) {
                        Logger.getLogger(DonanteServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String enfermedades = request.getParameter("enfermedades");
                    String habitos = request.getParameter("habitos");
                    String nom_responsable = request.getParameter("nom_responsable");
                    String tel_responsable = request.getParameter("tel_responsable");
                    Long.parseLong(tel_responsable);
                    String estado = request.getParameter("estado");
                    try {
                        donanteDAO.modificarDonante(new Donante(tipo_doc, nro_doc, nombres, primer_apellido, segundo_apellido, Long.parseLong(telefono), direccion, correo, fec_nacimiento2, fec_ultdonacion2, enfermedades, habitos, nom_responsable, Long.parseLong(tel_responsable), genero, departamento, municipio, estado));
                        request.setAttribute("mensaje", "Donante modificado correctamente");
                    } catch (Exception e) {
                        Logger.getLogger(DonanteServlet.class.getName()).log(Level.SEVERE, null, e);
                        request.setAttribute("mensaje", e.getMessage());
                        request.setAttribute("tipo_doc", tipo_doc);
                        request.setAttribute("nro_doc", nro_doc);
                        request.setAttribute("nombres", nombres);
                        request.setAttribute("primer_apellido", primer_apellido);
                        request.setAttribute("segundo_apellido", segundo_apellido);
                        request.setAttribute("telefono", telefono);
                        request.setAttribute("direccion", direccion);
                        request.setAttribute("departamento", departamento);
                        request.setAttribute("municipio", municipio);
                        request.setAttribute("genero", genero);
                        request.setAttribute("correo", correo);
                        request.setAttribute("fecha_nacimiento", fecha_nacimiento);
                        request.setAttribute("fec_ultdonacion", fecha_ultdonacion);
                        request.setAttribute("enfermedades", enfermedades);
                        request.setAttribute("habitos", habitos);
                        request.setAttribute("nom_responsable", nom_responsable);
                        request.setAttribute("tel_responsable", tel_responsable);
                        request.setAttribute("estado", estado);
                    }
                    request.getRequestDispatcher("RegistrarDonante.jsp").forward(request, response);
                }
            }
        }

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
