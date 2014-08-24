/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donaciones.dao;

import com.donaciones.entities.Departamento;
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
public class DepartamentoDAO extends BaseDAO{

    public DepartamentoDAO(Conexion connectionManager) {
        super(connectionManager);
    }
    
    public List<Departamento> getDepartamentos()throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs;
        List<Departamento> listDepartamentos;
        try {
            connection = connectionManager.conectar();
            listDepartamentos = new LinkedList<>();
            ps = connection.prepareStatement("SELECT * FROM DEPARTAMENTO");
            rs = ps.executeQuery();
            while (rs.next()) {                
                listDepartamentos.add(new Departamento(rs.getString(1), rs.getString(2)));
            }
            return listDepartamentos;
        } catch (Exception e) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Errror al listar Departamentos");
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
