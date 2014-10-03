package com.donaciones.entities;

/**
 * Clase encargada de crear la entidad Hospital
 * @author Daniel Rúa Madrid
 * @version 1.0
 * @since 20/05/2014
 * 
 */
public class Hospital {
    
    private String nit;
    private String tipo;
    private String razon_social;
    private String nivel;
    private int departamento;
    private int municipio;
    private String direccion;
    private String telefono;
    private String nombre_representante;
    private String telefono_representante;
    private String correo_representante;
    private String estado;

    /**
     * Constructor para crear la entidad hospital
     * @param nit Nit del Hospital
     * @param tipo Tipo de Hospital 
     * @param razon_social Razón Social del Hospital
     * @param nivel Nivel del hospital
     * @param departamento Departamento donde se encuentra el Hospital
     * @param municipio Municipio donde se encuentra el Hospital
     * @param direccion Dirección del Hospital
     * @param telefono Teléfono del Hospital
     * @param nombre_representante Nombre del representante del hospital
     * @param telefono_representante Teléfono del representante del hospital
     * @param correo_representante Correo del representante del hospital
     * @param estado Estado del hospital
     */
    public Hospital(String nit, String tipo, String razon_social, String nivel, int departamento, int municipio, String direccion, String telefono, String nombre_representante, String telefono_representante, String correo_representante, String estado) {
        this.nit = nit;
        this.tipo = tipo;
        this.razon_social = razon_social;
        this.nivel = nivel;
        this.departamento = departamento;
        this.municipio = municipio;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombre_representante = nombre_representante;
        this.telefono_representante = telefono_representante;
        this.correo_representante = correo_representante;
        this.estado = estado;
    }

    /**
     * Obtiene el estado del hospital
     * @return Estado del hospital
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Asigna un valor de estado para el hospital
     * @param estado Estado del hospital
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el valor del nit del hospital
     * @return Nit del hospital
     */
    public String getNit() {
        return nit;
    }

    /**
     * Asigna un valor para el nit del hospital
     * @param nit Nit del hospital
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * Obtiene el valor del tipo de hospital
     * @return Tipo de Hospital
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Asigna un valor para el tipo de hospital
     * @param tipo Tipo de hospital
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el valor de la razón social del hospital
     * @return Razón social del hospital
     */
    public String getRazon_social() {
        return razon_social;
    }

    /**
     * Asigna un valor a la razón social del hospital
     * @param razon_social Razón social del hospital
     */
    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    /**
     * Obtiene el valor del nivel del hospital
     * @return Nivel del hospital
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * Asigna un valor al nivel del hospital
     * @param nivel Nivel del hospital
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    /**
     * Obtiene el valor del departamento del hospital
     * @return Nombre del Departamento
     */
    public int getDepartamento() {
        return departamento;
    }

    /**
     * Asigna un valor al departamento del hospital
     * @param departamento Nombre del departamento del hospital
     */
    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    /**
     * Obtiene el valor del municipio del hospital
     * @return Nombre del municipio del hospital
     */
    public int getMunicipio() {
        return municipio;
    }

    /**
     * Asigna un valor al municipio del hospital
     * @param municipio Municipio del hospital
     */
    public void setMunicipio(int municipio) {
        this.municipio = municipio;
    }

    /**
     * Obtiene el valor de la dirección hospital
     * @return Nombre del Hospital
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Asigna un valor para la dirección del hospital
     * @param direccion Dirección del hospital
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el valor del teléfono del hospital
     * @return Número de teléfono del hospital
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Asigna un valor para el número de teléfono del hospital
     * @param telefono Número de tel´éfono del hospital
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtinene el valor del nombre del representante del hospital
     * @return Nombre del representante
     */
    public String getNombre_representante() {
        return nombre_representante;
    }

    /**
     * Asigna un valor para el nombre del representante del hospital
     * @param nombre_representante Nombre del representante del hospital
     */
    public void setNombre_representante(String nombre_representante) {
        this.nombre_representante = nombre_representante;
    }

    /**
     * Obtiene el valor del número de teléfono del representante
     * @return 
     */
    public String getTelefono_representante() {
        return telefono_representante;
    }

    /**
     *
     * @param telefono_representante
     */
    public void setTelefono_representante(String telefono_representante) {
        this.telefono_representante = telefono_representante;
    }

    /**
     *
     * @return
     */
    public String getCorreo_representante() {
        return correo_representante;
    }

    /**
     *
     * @param correo_representante
     */
    public void setCorreo_representante(String correo_representante) {
        this.correo_representante = correo_representante;
    }

    
    
}
