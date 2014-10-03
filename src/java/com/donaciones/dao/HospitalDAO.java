package com.donaciones.dao;

import com.donaciones.entities.Hospital;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase encargada de realizar el CRUD del hospital en la base de datos.
 * @author Daniel Rúa Madrid
 * @version 1.0
 * @since 20/05/2014
 */
public class HospitalDAO extends BaseDAO{

    /**
     * Constructor para iniciar la conexión a la base de datos.
     * @param connectionManager Manejador de la conexión a la base de datos.
     */
    public HospitalDAO(Conexion connectionManager) {
        super(connectionManager);
    }
    
    /**
     * Crea un Hospital dentro de la base de datos.
     * @param hospital Objeto de tipo hospital con los datos del hospital.
     * @throws Exception Excepción al intentar crear un hospital
     */
    public void crearHospital(Hospital hospital)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("INSERT INTO HOSPITAL(nit_hos,tipo_hos,razon_social_hos,nivel_hos,departamento_hos,"
                    + "municipio_hos,direccion_hos,telefono_hos,nombre_rep_hos,tel_rep_hos,correo_rep_hos,estado_hos) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, hospital.getNit());
            ps.setString(2, hospital.getTipo());
            ps.setString(3, hospital.getRazon_social());
            ps.setString(4, hospital.getNivel());
            ps.setInt(5, hospital.getDepartamento());
            ps.setInt(6, hospital.getMunicipio());
            ps.setString(7, hospital.getDireccion());
            ps.setString(8, hospital.getTelefono());
            ps.setString(9, hospital.getNombre_representante());
            ps.setString(10, hospital.getTelefono_representante());
            ps.setString(11, hospital.getCorreo_representante());
            ps.setString(12, hospital.getEstado());
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(HospitalDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al crear hospital",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(HospitalDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
    }
    
    /**
     * Busca un hospital dentro de la base de datos
     * @param nit Nit del hospital que se quiere buscar
     * @return Objeto de tipo hospital con todos los datos del hospital
     * @throws Exception Excepción al intentar buscar el hospital
     */
    public Hospital consultarHospital(String nit)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("SELECT * FROM HOSPITAL WHERE nit_hos=?");
            ps.setString(1, nit);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Hospital(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), 
                        rs.getString(10), rs.getString(11), rs.getString(12));  
            }
        } catch (Exception e) {
            Logger.getLogger(HospitalDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al consultar hospital",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(HospitalDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
        return null;
    }
    
    public Hospital buscarHospital(String razon_social) throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("SELECT * FROM HOSPITAL WHERE razon_social_hos=?");
            ps.setString(1, razon_social);
            rs = ps.executeQuery();
            while (rs.next()) {                
                return new Hospital(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), 
                        rs.getString(10), rs.getString(11), rs.getString(12));
            }
        } catch (Exception e) {
            Logger.getLogger(HospitalDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al buscar hospital",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(HospitalDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
        return null;
    }
    
    /**
     * Modifica un hospital dento de la base de datos
     * @param hospital Objeto de tipo hospital con los datos del hospital
     * @throws Exception Excepción al intentar modificar el hospital
     */
    public void modificarHospital(Hospital hospital)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("UPDATE HOSPITAL SET tipo_hos=?,razon_social_hos=?,nivel_hos=?,departamento_hos=?,municipio_hos=?,direccion_hos=?,"
                    + "telefono_hos=?,nombre_rep_hos=?,tel_rep_hos=?,correo_rep_hos=?,estado_hos=? WHERE nit_hos=?");
            ps.setString(1, hospital.getTipo());
            ps.setString(2, hospital.getRazon_social());
            ps.setString(3, hospital.getNivel());
            ps.setInt(4, hospital.getDepartamento());
            ps.setInt(5, hospital.getMunicipio());
            ps.setString(6, hospital.getDireccion());
            ps.setString(7, hospital.getTelefono());
            ps.setString(8, hospital.getNombre_representante());
            ps.setString(9, hospital.getTelefono_representante());
            ps.setString(10, hospital.getCorreo_representante());
            ps.setString(11, hospital.getEstado());
            ps.setString(12, hospital.getNit());
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(HospitalDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al buscar hospital",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(HospitalDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
    }
    

    
    
}
