/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donaciones.dao;

import com.donaciones.entities.Municipio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel
 */
public class MunicipioDAO extends BaseDAO{

    public MunicipioDAO(Conexion connectionManager) {
        super(connectionManager);
    }
    
    public List<Municipio> getMunicipios()throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs;
        List<Municipio> listMunicipios;
        try {
            connection = connectionManager.conectar();
            listMunicipios = new LinkedList<>();
            ps = connection.prepareStatement("SELECT * FROM MUNICIPIO");
            rs = ps.executeQuery();
            while (rs.next()) {                
                listMunicipios.add(new Municipio(rs.getInt(1), rs.getInt(2), rs.getString(3)));
            }
            return listMunicipios;
        } catch (Exception e) {
            Logger.getLogger(MunicipioDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al listar municipios",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MunicipioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
    }
    
    public List<Municipio> getMunicipiosDepartamento(int id)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs;
        List<Municipio> listMunicipios;
        try {
            connection = connectionManager.conectar();
            listMunicipios = new LinkedList<>();
            ps = connection.prepareStatement("SELECT * FROM MUNICIPIO WHERE departamento_id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {                
                listMunicipios.add(new Municipio(rs.getInt(1), rs.getString(2)));
            }
            return listMunicipios;
        } catch (Exception e) {
            Logger.getLogger(MunicipioDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al listar municipios-departamento",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MunicipioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
    }
   
    
}
