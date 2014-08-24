package com.donaciones.dao;

import com.donaciones.entities.Bolsa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para hacer el CRUD de bolsas de sangre dentro de la base de datos.
 * @author Daniel Rúa Madrid
 * @version 1.0
 * @since 23/05/2014
 */
public class BolsaDAO extends BaseDAO{

    /**
     * Constructor para iniciar la conexión a la base de datos.
     * @param connectionManager Manejador de la conexión.
     */
    public BolsaDAO(Conexion connectionManager) {
        super(connectionManager);
    }
    
    /**
     * Crea una bolsa de sangre dentro de la base de datos.
     * @param bolsa Objeto de tipo bolsa con los datos de la bolsa de sangre.
     * @throws Exception Excepcion al intentar insertar la bolsa de sangre.
     */
    public void crearBolsa(Bolsa bolsa)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("INSERT INTO BOLSA(codigo_bol, jornada_don_bol, grupo_sanguineo_bol, rh_bol, fecha_donacion_bol, fecha_venci_bol, cantidad_sangre_bol, "
                    + "estado_bol, observaciones_bol) VALUES(?,?,?,?,?,?,?,?,?)");
            System.out.println("rh: "+bolsa.getRh());
            ps.setString(1, bolsa.getCodigo());
            ps.setString(2, bolsa.getCodigo_jornada());
            ps.setString(3, bolsa.getGrupo_sanguineo());
            ps.setString(4, bolsa.getRh());
            ps.setString(5, bolsa.getFecha_donacion());
            ps.setString(6, bolsa.getFecha_vencimiento());
            ps.setInt(7, bolsa.getCantidad_sangre());
            ps.setString(8, bolsa.getEstado());
            ps.setString(9, bolsa.getObservaciones());
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(BolsaDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al crear bolsa",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BolsaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }        
    }
    
    /**
     * Busca y devuelve una bolsa de sangre.
     * @param codigo Código de la bolsa de sangre a buscar.
     * @return La bolsa de sangre con los datos, sino se encuentra devuelve null.
     * @throws Exception Error en el momento de buscar una bolsa de sangre.
     */
    public Bolsa buscarBolsa(String codigo)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("SELECT * FROM BOLSA WHERE codigo_bol=?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Bolsa(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7),  rs.getString(9), rs.getString(8));
            }
        } catch (Exception e) {
            Logger.getLogger(BolsaDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al buscar bolsa",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BolsaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
        return null;
    }
    
    /**
     * Modifica una bolsa de sangre, creada previamente.
     * @param bolsa Objeto de tipo bolsa con los datos de la bolsa de sangre.
     * @throws Exception Excepción al momento de modificar la bolsa de sangre.
     */
    public void modificarBolsa(Bolsa bolsa)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("UPDATE BOLSA SET grupo_sanguineo_bol=?, rh_bol=?, fecha_donacion_bol=?, "
                    + "fecha_venci_bol=?, cantidad_sangre_bol=?, observaciones_bol=?,jornada_don_bol=?, estado_bol=? WHERE codigo_bol=?");
            ps.setString(1, bolsa.getGrupo_sanguineo());
            ps.setString(2, bolsa.getRh());
            ps.setString(3, bolsa.getFecha_donacion());
            ps.setString(4, bolsa.getFecha_vencimiento());
            ps.setInt(5, bolsa.getCantidad_sangre());
            ps.setString(6, bolsa.getObservaciones());
            ps.setString(7, bolsa.getCodigo_jornada());
            ps.setString(8, bolsa.getEstado());
            ps.setString(9, bolsa.getCodigo());
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(BolsaDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al modificar bolsa",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BolsaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
    }
    
    
    public List<Bolsa> getBolsas()throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs;
        List<Bolsa> listBolsas = null;
        try {
            listBolsas = new LinkedList<>();
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("SELECT * FROM BOLSA");
            rs = ps.executeQuery();
            while (rs.next()) {                
                listBolsas.add(new Bolsa(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9)));
            }
            return listBolsas;
        } catch (Exception e) {
            Logger.getLogger(BolsaDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al listar Bolsas",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BolsaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
        
    }

}
