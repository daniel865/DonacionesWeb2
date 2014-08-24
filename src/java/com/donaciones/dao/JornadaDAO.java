package com.donaciones.dao;

import com.donaciones.entities.Jornada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase encargada de hacer el CRUD de las jornadas dentro de la base de datos.
 * @author Daniel Rúa Madrid
 * @version 1.0
 * @since 20/05/2014
 */
public class JornadaDAO extends BaseDAO{

    /**
     * Constructor para iniciar la conexión a la base de datos.
     * @param connectionManager Manejador de la conexión a la base de datos
     */
    public JornadaDAO(Conexion connectionManager) {
        super(connectionManager);
    }
    
    /**
     * Crea una jornada dentro de la base de datos
     * @param jornada Objeto de tipo jornada con los datos de la jornada
     * @throws Exception Excepción al intentar crear una jornada en la base de datos.
     */
    public void crearJornada(Jornada jornada)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("INSERT INTO JORNADA(codigo_jor, descripcion_jor, fecha_jor, departamento_jor, municipio_jor,"
                    + "direccion_jor, cantidad_donantes_jor, sangre_a1_jor, sangre_a2_jor, sangre_ab1_jor, sangre_ab2_jor,  "
                    + "sangre_b1_jor, sangre_b2_jor, sangre_o1_jor, sangre_o2_jor, estado_jor, observaciones_jor) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, jornada.getCodigo());
            ps.setString(2, jornada.getDescripcion());
            ps.setString(3, jornada.getFecha());
            ps.setString(4, jornada.getDepartamento());
            ps.setString(5, jornada.getMunicipio());
            ps.setString(6, jornada.getDireccion());
            ps.setInt(7, jornada.getCant_donantes());
            ps.setInt(8, jornada.getSangre_a1());
            ps.setInt(9, jornada.getSangre_a2());
            ps.setInt(10, jornada.getSangre_ab1());
            ps.setInt(11, jornada.getSangre_ab2());
            ps.setInt(12, jornada.getSangre_b1());
            ps.setInt(13, jornada.getSangre_b2());
            ps.setInt(14, jornada.getSangre_o1());
            ps.setInt(15, jornada.getSangre_o2());
            ps.setString(16, jornada.getEstado());
            ps.setString(17, jornada.getObservaciones());
            ps.execute();           
        } catch (Exception e) {
            Logger.getLogger(JornadaDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al crear jornada",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JornadaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
    }
    
    /**
     * Busca una jornada dentro de la base de datos
     * @param codigo Código de la jornada a buscar
     * @return Objeto de tipo jornda con los datos de la jornada
     * @throws Exception Excepción al intentar buscar la jornda
     */
    public Jornada buscarJornada(String codigo)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {
            connection = connectionManager.conectar();
            ps =connection.prepareStatement("SELECT * FROM JORNADA WHERE codigo_jor=?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Jornada(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getString(16), rs.getString(17));
            }
        } catch (Exception e) {
            Logger.getLogger(JornadaDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al buscar jornada",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JornadaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
        return null;
    }
    
    /**
     * Modifica una jornada dentro de la base de datos
     * @param jornada Objeto de tipo jornada con los datos de la jornada
     * @throws Exception Excepción al intentar modificar la jornada
     */
    public void modificarJornada(Jornada jornada)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("UPDATE JORNADA SET descripcion_jor=?, fecha_jor=?, departamento_jor=?, municipio_jor=?,"
                    + "direccion_jor=?, cantidad_donantes_jor=?, sangre_a1_jor=?, sangre_a2_jor=?, sangre_ab1_jor=?, sangre_ab2_jor=?,"
                    + "sangre_b1_jor=?, sangre_b2_jor=?, sangre_o1_jor=?, sangre_o2_jor=?, estado_jor=?, observaciones_jor=? "
                    + "WHERE codigo_jor=?");
            ps.setString(1, jornada.getDescripcion());
            ps.setString(2, jornada.getFecha());
            ps.setString(3, jornada.getDepartamento());
            ps.setString(4, jornada.getMunicipio());
            ps.setString(5, jornada.getDireccion());
            ps.setInt(6, jornada.getCant_donantes());
            ps.setInt(7, jornada.getSangre_a1());
            ps.setInt(8, jornada.getSangre_a2());
            ps.setInt(9, jornada.getSangre_ab1());
            ps.setInt(10, jornada.getSangre_ab2());
            ps.setInt(11, jornada.getSangre_b1());
            ps.setInt(12, jornada.getSangre_b2());
            ps.setInt(13, jornada.getSangre_o1());
            ps.setInt(14, jornada.getSangre_o2());
            ps.setString(15, jornada.getEstado());
            ps.setString(16, jornada.getObservaciones());
            ps.setString(17, jornada.getCodigo());
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(JornadaDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al modificar jornada",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JornadaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
    }
    
    /**
     * Lista todas las jornadas dentro de la base de datos
     * @return List con todas las jornadas registradas
     * @throws Exception Excepción al intentar listar las jornadas
     */
    public List<Jornada> listarJornadas()throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {
            connection = connectionManager.conectar();
            List<Jornada> listJornadas = new LinkedList<Jornada>();
            ps = connection.prepareStatement("SELECT * FROM jornada");
            rs = ps.executeQuery();
            while (rs.next()) {                
                listJornadas.add(new Jornada(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), 
                    rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getString(16), rs.getString(17)));
            }
            return listJornadas;
        } catch (Exception e) {
            Logger.getLogger(JornadaDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al listar jornadas",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JornadaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
    }

    
    
    
}
