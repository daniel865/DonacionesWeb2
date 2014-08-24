package com.donaciones.dao;

/**
 * Clase encargada de administrar la conexión a la base de datos, por medio
 * de un connectionManager, hereda la conexión a todas las clases que
 * extienden de ella.
 * @author Daniel Rúa Madrid
 * @version 1.0
 * @since 23/05/2014
 */

public class BaseDAO {
    
    /**
     * Atributo de tipo conexion, que se encarga de establecer y administrar
     * la conexión con la base de datos.
     */
    protected Conexion connectionManager;

    /**
     * Constructor que se encarga de iniciar la conexión a la base de datos.
     * @param connectionManager Manejador de la conexión de la base de datos.
     */
    public BaseDAO(Conexion connectionManager) {
        this.connectionManager = connectionManager;
    }
    
}
