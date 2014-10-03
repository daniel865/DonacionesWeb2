package com.donaciones.dao;

import com.donaciones.entities.Donante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para hacer el CRUD de los donantes.
 * @author Daniel Rúa Madrid
 * @version 1.0
 * @since 23/05/2014
 */
public class DonanteDAO extends BaseDAO {
    
    /**
     * Constructor para iniciar la conexión a la base de datos.
     * @param connectionManager Manejador de la Conexión.
     */
    public DonanteDAO(Conexion connectionManager) {
        super(connectionManager);
    }
    
    /**
     * Crea un donantes dentro de la base de datos
     * @param donante Objeto de tipo donante con los datos del donante
     * @throws Exception Error al intentar insertar el donante
     */
    public void crearDonante(Donante donante) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("INSERT INTO DONANTE(tipodocumentto_don, nroidentificacion_don, nombres_don, apellido1_don, apellido2_don,telefono_don,"
                    + "direccion_don, departamento_don, municipio_don, correo_don, fec_nac_don, fec_doc_don, enfermedades_don, habitos_don, nom_res_don,"
                    + "tel_res_don, genero_don, estado_don) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, donante.getTipo_documento());
            ps.setString(2, donante.getNro_identificacion());
            ps.setString(3, donante.getNombres());
            ps.setString(4, donante.getApellido1());
            ps.setString(5, donante.getApellido2());
            ps.setString(6, donante.getTelefono());
            ps.setString(7, donante.getDireccion());
            ps.setInt(8, donante.getDepartamento());
            ps.setInt(9, donante.getMunicipio());
            ps.setString(10, donante.getCorreo());
            ps.setString(11, donante.getFec_naciminiento());
            ps.setString(12, donante.getFec_donacion());
            ps.setInt(13, donante.getEnfermedades());
            ps.setInt(14, donante.getHabitos());
            ps.setString(15, donante.getNombre_rep());
            ps.setString(16, donante.getTelefono_rep());
            ps.setString(17, donante.getGenero());
            ps.setString(18, donante.getEstado());
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(DonanteDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al crear donante", e);
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DonanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
    }
    
    /**
     * Busca un donante registrado dentro de la base de datos
     * @param identificacion Número de identificación del donante a buscar
     * @return Objeto de tipo donante con los datos del donante
     * @throws Exception Excepción al intentar buscar el donante.
     */
    public Donante buscarDonante(String identificacion)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("SELECT * FROM DONANTE WHERE nroidentificacion_don=?");
            ps.setString(1, identificacion);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Donante(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), 
                        rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(13), rs.getInt(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18));
            }
        } catch (Exception e) {
            Logger.getLogger(DonanteDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al buscar donante", e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DonanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
        return null;
    }
    
    /**
     * Modifica los datos de un donante dentro de la base de datos
     * @param donante Objeto de tipo donante con todos los datos del donante
     * @throws Exception Excepción al intentar modificar el donante en la base de datos.
     */
    public void modificarDonante(Donante donante)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("UPDATE DONANTE SET tipodocumentto_don=?,nombres_don=?,apellido1_don=?,apellido2_don=?,telefono_don=?,"
                    + "direccion_don=?,departamento_don=?,municipio_don=?,correo_don=?,fec_nac_don=?,fec_doc_don=?,enfermedades_don=?,habitos_don=?,nom_res_don=?,tel_res_don=?,"
                    + "genero_don=?,estado_don=? WHERE nroidentificacion_don=?");
            ps.setString(1, donante.getTipo_documento());
            ps.setString(2, donante.getNro_identificacion());
            ps.setString(3, donante.getNombres());
            ps.setString(4, donante.getApellido1());
            ps.setString(5, donante.getApellido2());
            ps.setString(6, donante.getTelefono());
            ps.setString(7, donante.getDireccion());
            ps.setInt(8, donante.getDepartamento());
            ps.setInt(9, donante.getMunicipio());
            ps.setString(10, donante.getCorreo());
            ps.setString(11, donante.getFec_naciminiento());
            ps.setString(12, donante.getFec_donacion());
            ps.setInt(13, donante.getEnfermedades());
            ps.setInt(14, donante.getHabitos());
            ps.setString(15, donante.getNombre_rep());
            ps.setString(16, donante.getTelefono_rep());
            ps.setString(17, donante.getGenero());
            ps.setString(18, donante.getEstado());
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(DonanteDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al modificar donante", e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DonanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
}
