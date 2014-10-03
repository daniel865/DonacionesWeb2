/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donaciones.servlets;

import com.donaciones.dao.Conexion;
import com.donaciones.dao.HospitalDAO;
import com.donaciones.entities.Hospital;
import java.io.IOException;
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
@WebServlet(name = "HospitalServlet", urlPatterns = {"/HospitalServlet"})
public class HospitalServlet extends HttpServlet {

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

        String accion = request.getParameter("accion");
        accion = accion == null ? "Inicio" : accion;

        if ("Inicio".equals(accion)) {
            request.getRequestDispatcher("RegistrarHospital.jsp").forward(request, response);
        } else if ("Guardar".equals(accion)) {
            HospitalDAO hospitalDAO = new HospitalDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
            System.out.println("Entro Guardar");
            String tipo = request.getParameter("tipo");
            String nit = request.getParameter("nit");
            String razon = request.getParameter("razon");
            String direccion = request.getParameter("direccion");
            String departamento = request.getParameter("departamento");
            String municipio = request.getParameter("municipio");
            String telefono = request.getParameter("telefono");
            String representante = request.getParameter("representante");
            String tel_representante = request.getParameter("tel_representante");
            String correo_representante = request.getParameter("correo_representante");
            String nivel = request.getParameter("nivel");
            String estado = request.getParameter("estado");
            try {
                hospitalDAO.crearHospital(new Hospital(nit, tipo, razon, nivel, Integer.parseInt(departamento), Integer.parseInt(municipio), direccion, telefono, representante, 
                        tel_representante, correo_representante, estado));
                request.setAttribute("mensaje", "El hospital fue guardado correctamente");
            } catch (Exception e) {
                Logger.getLogger(Hospital.class.getName()).log(Level.SEVERE, null, e);
                request.setAttribute("mensaje", e.getMessage());
                request.setAttribute("tipo", tipo);
                request.setAttribute("nit", nit);
                request.setAttribute("razon", razon);
                request.setAttribute("direccion", direccion);
                request.setAttribute("departamento", departamento);
                request.setAttribute("municipio", municipio);
                request.setAttribute("telefono", telefono);
                request.setAttribute("representante", representante);
                request.setAttribute("tel_representante", tel_representante);
                request.setAttribute("correo_representante", correo_representante);
                request.setAttribute("nivel", nivel);
                request.setAttribute("estado", estado);
            }
            request.getRequestDispatcher("RegistrarHospital.jsp").forward(request, response);
        }else if ("Consultar".equals(accion)){
            HospitalDAO hospitalDAO = new HospitalDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
            String buscar_hos = request.getParameter("buscar_hos");
            Hospital hospital;
            try {
                hospital = hospitalDAO.consultarHospital(buscar_hos);
                request.setAttribute("mensaje", "El hospital fue encontrado correcatmente");
                request.setAttribute("tipo", hospital.getTipo());
                request.setAttribute("nit", hospital.getNit());
                request.setAttribute("razon", hospital.getRazon_social());
                request.setAttribute("direccion", hospital.getDireccion());
                request.setAttribute("departamento", Integer.toString(hospital.getDepartamento()));
                request.setAttribute("municipio", Integer.toString(hospital.getMunicipio()) );
                request.setAttribute("telefono", hospital.getTelefono());
                request.setAttribute("representante", hospital.getNombre_representante());
                request.setAttribute("tel_representante", hospital.getTelefono_representante());
                request.setAttribute("correo_representante", hospital.getCorreo_representante());
                request.setAttribute("nivel", hospital.getNivel());
                request.setAttribute("estado", hospital.getEstado());
            } catch (Exception e) {
                Logger.getLogger(Hospital.class.getName()).log(Level.SEVERE, null, e);
                request.setAttribute("mensaje", "El hospital no fue encontrado");
            }
            request.getRequestDispatcher("RegistrarHospital.jsp").forward(request, response);
        }else if ("Buscar".equals(accion)){
            HospitalDAO hospitalDAO = new HospitalDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
            String buscar_hos = request.getParameter("buscar_hos");
            Hospital hospital;
            try {
                hospital = hospitalDAO.buscarHospital(buscar_hos);
                request.setAttribute("mensaje", "El hospital fue encontrado correcatmente");
                request.setAttribute("tipo", hospital.getTipo());
                request.setAttribute("nit", hospital.getNit());
                request.setAttribute("razon", hospital.getRazon_social());
                request.setAttribute("direccion", hospital.getDireccion());
                request.setAttribute("departamento", Integer.toString(hospital.getDepartamento()));
                request.setAttribute("municipio", Integer.toString(hospital.getMunicipio()) );
                request.setAttribute("telefono", hospital.getTelefono());
                request.setAttribute("representante", hospital.getNombre_representante());
                request.setAttribute("tel_representante", hospital.getTelefono_representante());
                request.setAttribute("correo_representante", hospital.getCorreo_representante());
                request.setAttribute("nivel", hospital.getNivel());
                request.setAttribute("estado", hospital.getEstado());
            } catch (Exception e) {
                Logger.getLogger(Hospital.class.getName()).log(Level.SEVERE, null, e);
                request.setAttribute("mensaje", "El hospital no fue encontrado");
            }
            request.getRequestDispatcher("RegistrarHospital.jsp").forward(request, response);
        }else if ("Modificar".equals(accion)){
            HospitalDAO hospitalDAO = new HospitalDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
            String tipo = request.getParameter("tipo");
            String nit = request.getParameter("nit");
            String razon = request.getParameter("razon");
            String direccion = request.getParameter("direccion");
            String departamento = request.getParameter("departamento");
            String municipio = request.getParameter("municipio");
            String telefono = request.getParameter("telefono");
            String representante = request.getParameter("representante");
            String tel_representante = request.getParameter("tel_representante");
            String correo_representante = request.getParameter("correo_representante");
            String nivel = request.getParameter("nivel");
            String estado = request.getParameter("estado");
            try {
                hospitalDAO.modificarHospital(new Hospital(nit, tipo, razon, nivel, Integer.parseInt(departamento), Integer.parseInt(municipio), direccion, telefono, representante, 
                        tel_representante, correo_representante, estado));
                request.setAttribute("mensaje", "El hospital fue modificado correctamente");
            } catch (Exception e) {
                Logger.getLogger(Hospital.class.getName()).log(Level.SEVERE, null, e);
                request.setAttribute("mensaje", e.getMessage());
                request.setAttribute("tipo", tipo);
                request.setAttribute("nit", nit);
                request.setAttribute("razon", razon);
                request.setAttribute("direccion", direccion);
                request.setAttribute("departamento", departamento);
                request.setAttribute("municipio", municipio);
                request.setAttribute("telefono", telefono);
                request.setAttribute("representante", representante);
                request.setAttribute("tel_representante", tel_representante);
                request.setAttribute("correo_representante", correo_representante);
                request.setAttribute("nivel", nivel);
                request.setAttribute("estado", estado);
            }
            request.getRequestDispatcher("RegistrarHospital.jsp").forward(request, response);
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
