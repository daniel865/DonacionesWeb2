package com.donaciones.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 * Clase para conectarse con la base de especificando usuario, contraseña y 
 * ubicación.
 * @author Daniel Rúa Madrid
 * @version 1.0 
 * @since 23/05/2014
 */

public class Conexion {
    
    String user;  //Usuario para conectarse a la base de datos.
    String password; //Contraseña de la base de datos.
    String url; //Dirección de la base de datos.

    /**
     * Constructor para inicial el usuario, la contraseña y la ubicación
     * de la base de datos.
     * @param user
     * @param password
     * @param url
     */
    public Conexion(String user, String password, String url) {
        this.user = user;
        this.password = password;
        this.url = url;
    }
    
    /**
     * Crea la conexión a la base de datos
     * @return DriveManager encargado de obtener la conexión.
     * @throws Exception Excepción al intentar conectar a la base de datos.
     */
    public Connection conectar()throws Exception{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new Exception("No se pudo establecer la conexión",e);
        }
    }
    
    /**
     * Cierra la conexión a la base de datos.
     * @param connection Conexión que se va a cerrar.
     * @throws Exception Excepción al intentar cerrar la conexión.
     */
    public void cerrar(Connection connection)throws Exception{
        try {
            if ( connection!=null && !connection.isClosed() ){
                connection.close();
            }
        } catch (Exception e) {
            System.out.println("No es posible cerrar la conexión");
        }
    }
    
}
