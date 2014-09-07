package com.donaciones.servlets;

import com.donaciones.dao.Conexion;
import com.donaciones.dao.DepartamentoDAO;
import com.donaciones.dao.JornadaDAO;
import com.donaciones.dao.MunicipioDAO;
import com.donaciones.entities.Departamento;
import com.donaciones.entities.Jornada;
import com.donaciones.entities.Municipio;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author daniel
 */
@WebServlet(name = "JornadaServlet", urlPatterns = {"/JornadaServlet"})
public class JornadaServlet extends HttpServlet {

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
        response.setContentType("text/html");

        String accion = request.getParameter("accion");
        accion = accion == null ? "Inicio" : accion;

        boolean load = false;

        System.out.println("Entro Servlet");
        obtenerDepartamentos(request, response);

        if ("Guardar".equals(accion)) {
            JornadaDAO jornadaDAO = new JornadaDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
            System.out.println("Entro Guardar Sevlet");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String codigo = request.getParameter("codigo");
            String descripcion = request.getParameter("descripcion");
            String fecha_programada = request.getParameter("fecha_programada");
            String departamento = request.getParameter("departamento");
            String municipio = request.getParameter("municipio");
            String direccion = request.getParameter("direccion");
            String donantes = request.getParameter("donantes");
            String sangre_a1 = request.getParameter("sangre_a1");
            String sangre_a2 = request.getParameter("sangre_a2");
            String sangre_ab1 = request.getParameter("sangre_ab1");
            String sangre_ab2 = request.getParameter("sangre_ab2");
            String sangre_b1 = request.getParameter("sangre_b1");
            String sangre_b2 = request.getParameter("sangre_b2");
            String sangre_o1 = request.getParameter("sangre_o1");
            String sangre_o2 = request.getParameter("sangre_o2");
            String observaciones = request.getParameter("observaciones");
            String estado = request.getParameter("estado");
            try {
                jornadaDAO.crearJornada(new Jornada(codigo, descripcion, fecha_programada, departamento, municipio, direccion, Integer.parseInt(donantes), Integer.parseInt(sangre_a1), Integer.parseInt(sangre_a2),
                        Integer.parseInt(sangre_ab1), Integer.parseInt(sangre_ab2), Integer.parseInt(sangre_b1), Integer.parseInt(sangre_b2), Integer.parseInt(sangre_o1), Integer.parseInt(sangre_o2),
                        estado, observaciones));
                request.setAttribute("mensaje", "Jornada Almacenada Correctamente");
            } catch (Exception e) {
                Logger.getLogger(JornadaServlet.class.getName()).log(Level.SEVERE, null, e);
                request.setAttribute("mensaje", "Error al crear la jornada");
                request.setAttribute("codigo", codigo);
                request.setAttribute("descripcion", descripcion);
                request.setAttribute("fecha_programada", fecha_programada);
                request.setAttribute("departamento", departamento);
                request.setAttribute("municipio", municipio);
                request.setAttribute("direccion", direccion);
                request.setAttribute("donantes", donantes);
                request.setAttribute("sangre_a1", sangre_a1);
                request.setAttribute("sangre_a2", sangre_a2);
                request.setAttribute("sangre_ab1", sangre_ab1);
                request.setAttribute("sangre_ab2", sangre_ab2);
                request.setAttribute("sangre_b1", sangre_b1);
                request.setAttribute("sangre_b2", sangre_b2);
                request.setAttribute("sangre_o1", sangre_o1);
                request.setAttribute("sangre_o2", sangre_o2);
                request.setAttribute("observaciones", observaciones);
                request.setAttribute("estado", estado);
            }
            request.getRequestDispatcher("RegistrarJornada.jsp").forward(request, response);
        } else if ("Consultar".equals(accion)) {
            JornadaDAO jornadaDAO = new JornadaDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
            String id_jor = request.getParameter("buscar_jor");
            Jornada jornada;
            try {
                jornada = jornadaDAO.buscarJornada(id_jor);
                System.out.println("Onservaciones: " + jornada.getObservaciones());
                request.setAttribute("mensaje", "La jornada fue encontrada");
                request.setAttribute("codigo", jornada.getCodigo());
                request.setAttribute("descripcion", jornada.getDescripcion());
                request.setAttribute("fecha_programada", jornada.getFecha());
                request.setAttribute("departamento", jornada.getDepartamento());
                request.setAttribute("municipio", jornada.getMunicipio());
                request.setAttribute("direccion", jornada.getDireccion());
                request.setAttribute("donantes", Integer.toString(jornada.getCant_donantes()));
                request.setAttribute("sangre_a1", Integer.toString(jornada.getSangre_a1()));
                request.setAttribute("sangre_a2", Integer.toString(jornada.getSangre_a2()));
                request.setAttribute("sangre_ab1", Integer.toString(jornada.getSangre_ab1()));
                request.setAttribute("sangre_ab2", Integer.toString(jornada.getSangre_ab2()));
                request.setAttribute("sangre_b1", Integer.toString(jornada.getSangre_b1()));
                request.setAttribute("sangre_b2", Integer.toString(jornada.getSangre_b2()));
                request.setAttribute("sangre_o1", Integer.toString(jornada.getSangre_o1()));
                request.setAttribute("sangre_o2", Integer.toString(jornada.getSangre_o2()));
                request.setAttribute("observaciones", jornada.getObservaciones());
                request.setAttribute("estado", jornada.getEstado());
                request.getRequestDispatcher("RegistrarJornada.jsp").forward(request, response);
            } catch (Exception e) {
                Logger.getLogger(JornadaServlet.class.getName()).log(Level.SEVERE, null, e);
                request.setAttribute("mensaje", "La jornada no fue encontrada");
                request.getRequestDispatcher("RegistrarJornada.jsp").forward(request, response);
            }
        } else if ("Modificar".equals(accion)) {
            JornadaDAO jornadaDAO = new JornadaDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String codigo = request.getParameter("codigo");
            String descripcion = request.getParameter("descripcion");
            String fecha_programada = request.getParameter("fecha_programada");
            String departamento = request.getParameter("departamento");
            String municipio = request.getParameter("municipio");
            String direccion = request.getParameter("direccion");
            String donantes = request.getParameter("donantes");
            String sangre_a1 = request.getParameter("sangre_a1");
            String sangre_a2 = request.getParameter("sangre_a2");
            String sangre_ab1 = request.getParameter("sangre_ab1");
            String sangre_ab2 = request.getParameter("sangre_ab2");
            String sangre_b1 = request.getParameter("sangre_b1");
            String sangre_b2 = request.getParameter("sangre_b2");
            String sangre_o1 = request.getParameter("sangre_o1");
            String sangre_o2 = request.getParameter("sangre_o2");
            String observaciones = request.getParameter("observaciones");
            String estado = request.getParameter("estado");
            try {
                jornadaDAO.modificarJornada(new Jornada(codigo, descripcion, fecha_programada, departamento, municipio, direccion, Integer.parseInt(donantes), Integer.parseInt(sangre_a1), Integer.parseInt(sangre_a2),
                        Integer.parseInt(sangre_ab1), Integer.parseInt(sangre_ab2), Integer.parseInt(sangre_b1), Integer.parseInt(sangre_b2), Integer.parseInt(sangre_o1), Integer.parseInt(sangre_o2),
                        estado, observaciones));
                request.setAttribute("mensaje", "Jornada modificada correctamente");

            } catch (Exception e) {
                Logger.getLogger(JornadaServlet.class.getName()).log(Level.SEVERE, null, e);
                request.setAttribute("mensaje", "Error al Modificar la jornada");
                request.setAttribute("codigo", codigo);
                request.setAttribute("descripcion", descripcion);
                request.setAttribute("fecha_programada", fecha_programada);
                request.setAttribute("departamento", departamento);
                request.setAttribute("municipio", municipio);
                request.setAttribute("direccion", direccion);
                request.setAttribute("donantes", donantes);
                request.setAttribute("sangre_a1", sangre_a1);
                request.setAttribute("sangre_a2", sangre_a2);
                request.setAttribute("sangre_ab1", sangre_ab1);
                request.setAttribute("sangre_ab2", sangre_ab2);
                request.setAttribute("sangre_b1", sangre_b1);
                request.setAttribute("sangre_b2", sangre_b2);
                request.setAttribute("sangre_o1", sangre_o1);
                request.setAttribute("sangre_o2", sangre_o2);
                request.setAttribute("observaciones", observaciones);
                request.setAttribute("estado", estado);
            }
            request.getRequestDispatcher("RegistrarJornada.jsp").forward(request, response);
        } else if ("Eliminar".equals(accion)) {
            JornadaDAO jornadaDAO = new JornadaDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String codigo = request.getParameter("codigo");
            String descripcion = request.getParameter("descripcion");
            String fecha_programada = request.getParameter("fecha_programada");
            String departamento = request.getParameter("departamento");
            String municipio = request.getParameter("municipio");
            String direccion = request.getParameter("direccion");
            String donantes = request.getParameter("donantes");
            String sangre_a1 = request.getParameter("sangre_a1");
            String sangre_a2 = request.getParameter("sangre_a2");
            String sangre_ab1 = request.getParameter("sangre_ab1");
            String sangre_ab2 = request.getParameter("sangre_ab2");
            String sangre_b1 = request.getParameter("sangre_b1");
            String sangre_b2 = request.getParameter("sangre_b2");
            String sangre_o1 = request.getParameter("sangre_o1");
            String sangre_o2 = request.getParameter("sangre_o2");
            String observaciones = request.getParameter("observaciones");
            String estado = request.getParameter("estado");
            try {
                jornadaDAO.modificarJornada(new Jornada(codigo, descripcion, fecha_programada, departamento, municipio, direccion, Integer.parseInt(donantes), Integer.parseInt(sangre_a1), Integer.parseInt(sangre_a2),
                        Integer.parseInt(sangre_ab1), Integer.parseInt(sangre_ab2), Integer.parseInt(sangre_b1), Integer.parseInt(sangre_b2), Integer.parseInt(sangre_o1), Integer.parseInt(sangre_o2),
                        estado, observaciones));
                request.setAttribute("mensaje", "Jornada modificada correctamente");

            } catch (Exception e) {
                Logger.getLogger(JornadaServlet.class.getName()).log(Level.SEVERE, null, e);
                request.setAttribute("mensaje", "Error al Modificar la jornada");
                request.setAttribute("codigo", codigo);
                request.setAttribute("descripcion", descripcion);
                request.setAttribute("fecha_programada", fecha_programada);
                request.setAttribute("departamento", departamento);
                request.setAttribute("municipio", municipio);
                request.setAttribute("direccion", direccion);
                request.setAttribute("donantes", donantes);
                request.setAttribute("sangre_a1", sangre_a1);
                request.setAttribute("sangre_a2", sangre_a2);
                request.setAttribute("sangre_ab1", sangre_ab1);
                request.setAttribute("sangre_ab2", sangre_ab2);
                request.setAttribute("sangre_b1", sangre_b1);
                request.setAttribute("sangre_b2", sangre_b2);
                request.setAttribute("sangre_o1", sangre_o1);
                request.setAttribute("sangre_o2", sangre_o2);
                request.setAttribute("observaciones", observaciones);
                request.setAttribute("estado", estado);
            }
            request.getRequestDispatcher("RegistrarJornada.jsp").forward(request, response);
        } else if ("Inicio".equals(accion)) {
            request.getRequestDispatcher("RegistrarJornada.jsp").forward(request, response);
        } else if ("Reporte Jornada".equals(accion)) {
            JornadaDAO jornadaDAO = new JornadaDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
            System.out.println("Entro Reporte Jornada");
            String codigo = request.getParameter("codigo");
            Jornada jornada;

            try {
                jornada = jornadaDAO.buscarJornada(codigo);

                if (jornada != null) {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bd_donaciones", "dba_donaciones", "donaciones");

                    ServletOutputStream servletOutputStream = response.getOutputStream();
                    File reportFile = new File(getServletConfig().getServletContext().getRealPath("WEB-INF/ReporteJornada.jasper"));
                    byte[] bytes = null;

                    HashMap parametros = new HashMap();
                    parametros.put("cod_jor", codigo);

                    bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parametros, connection);

                    response.setContentType("application/pdf");
                    response.setContentLength(bytes.length);

                    servletOutputStream.write(bytes, 0, bytes.length);
                    servletOutputStream.flush();
                    servletOutputStream.close();
                } else {
                    request.setAttribute("mensaje", "La Jormada no existe");
                    request.getRequestDispatcher("ReporteJornada.jsp").forward(request, response);
                }

            } catch (Exception e) {
                e.printStackTrace();
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
        /*
         try {
         MunicipioDAO municipioDAO = new MunicipioDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));

         String selectedValue = request.getParameter("value");
         System.out.println("Departamento: " + request.getParameter("departamento"));
         System.out.println("Valor: " + request.getParameter("value"));
         List<Municipio> listMunDep = municipioDAO.getMunicipiosDepartamento(Integer.parseInt(selectedValue));
         Map<String, String> options = new HashMap<>();
         for (int i = 0; i < listMunDep.size(); i++) {
         Municipio municipio = listMunDep.get(i);
         options.put(Integer.toString(municipio.getId()), municipio.getNombre());
         }
         System.out.println(options.toString());
         String json = new Gson().toJson(options);
         response.setContentType("application/json");
         response.setCharacterEncoding("UTF-8");
         response.getWriter().write(json);
         request.setAttribute("listMunicipios", listMunDep);
         } catch (Exception ex) {
         Logger.getLogger(JornadaServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
         */
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

    public void obtenerDepartamentos(HttpServletRequest request, HttpServletResponse servletResponse) {
        DepartamentoDAO departamentoDAO = new DepartamentoDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
        List<Departamento> listDepartamentos = null;
        try {
            listDepartamentos = departamentoDAO.getDepartamentos();
            request.setAttribute("listDepartamentos", listDepartamentos);
            request.setAttribute("load", true);
        } catch (Exception e) {
            Logger.getLogger(JornadaServlet.class.getName()).log(Level.SEVERE, null, e);
        }

    }

}
