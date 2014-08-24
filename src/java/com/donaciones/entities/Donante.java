package com.donaciones.entities;

import java.sql.Date;

/**
 * Clase encargada de crear la entidad Donante
 * @author Daniel Rúa Madrid
 * @version 1.0
 * @since 20/05/2014
 */
public class Donante {
    
    private String tipo_documento;
    private String nro_identificacion;
    private String nombres;
    private String apellido1;
    private String apellido2;
    private long telefono;
    private String direccion;
    private String correo;
    private Date fec_naciminiento;
    private Date fec_donacion;
    private String enfermedades;
    private String habitos;
    private String nombre_rep;
    private long telefono_rep;
    private String genero;
    private String departamento;
    private String municipio;
    private String estado;

    /**
     * Constructor que crea la entidad Donante
     * @param tipo_documento Tipo de Documento
     * @param nro_identificacion Número de Identificación
     * @param nombres Nombres del Donante
     * @param apellido1 Primer Apellido
     * @param apellido2 Segundo Apellido
     * @param telefono Teléfono del Donante
     * @param direccion Dirección del Donante
     * @param correo Correo del Donante
     * @param fec_naciminiento Fecha de Nacimiento del Donante
     * @param fec_donacion Fecha de Donación del Donante
     * @param enfermedades Enfermedades del Donante
     * @param habitos Hábitos del Donante
     * @param nombre_rep Nombre del Responsable
     * @param telefono_rep Teléfono del Responsable
     * @param genero Género del Donante
     * @param departamento Departemaneto de Nacimiento
     * @param municipio Municipio de Nacimiento
     * @param estado Estado del Donante
     */
    public Donante(String tipo_documento, String nro_identificacion, String nombres, String apellido1, String apellido2, long telefono, String direccion, String correo, Date fec_naciminiento, Date fec_donacion, String enfermedades, String habitos, String nombre_rep, long telefono_rep, String genero, String departamento, String municipio, String estado) {
        this.tipo_documento = tipo_documento;
        this.nro_identificacion = nro_identificacion;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.fec_naciminiento = fec_naciminiento;
        this.fec_donacion = fec_donacion;
        this.enfermedades = enfermedades;
        this.habitos = habitos;
        this.nombre_rep = nombre_rep;
        this.telefono_rep = telefono_rep;
        this.genero = genero;
        this.departamento = departamento;
        this.municipio = municipio;
        this.estado = estado;
    }

  

    
    /**
     * Retorna el estado del donante
     * @return Estado del donante
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Asigna un valor al estado del donante
     * @param estado Estado para asignar el donante
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Retorna el tipo de documento del donante
     * @return String con el tipo de documento
     */
    public String getTipo_documento() {
        return tipo_documento;
    }

    /**
     * Asigna un valor al tipo de documento del donante
     * @param tipo_documento Tipo de documento
     */
    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    /**
     * Obtiene el Número de identificación del donante
     * @return String con el número de identificación
     */
    public String getNro_identificacion() {
        return nro_identificacion;
    }

    /**
     * Asigna un valor al número de identificación
     * @param nro_identificacion Número de identificación
     */
    public void setNro_identificacion(String nro_identificacion) {
        this.nro_identificacion = nro_identificacion;
    }

    /**
     * Obtiene los nombre(s) del donantes
     * @return Nombres del donante
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Asigna los nombres del donantes
     * @param nombres Nombres del donante
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene el primer apellido del donante
     * @return Primer Apellido
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * Asigna el primer apellido del donante
     * @param apellido1 Primer Apellido
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * Obtiene el segundo apellido del donante
     * @return Segundo Apellido
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * Asigna el segundo apellido del donante
     * @param apellido2 Segundo Apellido
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * Obtiene el teléfono del donante
     * @return Número de teléfono
     */
    public long getTelefono() {
        return telefono;
    }

    /**
     * Asigna un valor al número de teléfono del donantes
     * @param telefono Número de Teléfono
     */
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la dirección del donante
     * @return Dirección del donante
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Asigna la dirección del donante
     * @param direccion Dirección del donante
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el correo del donante
     * @return Correo electrónico
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Asigna el correo electrónico del donantes
     * @param correo Correo electrónico
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la fecha de nacimiento del donante
     * @return Fecha de Nacimiento
     */
    public Date getFec_naciminiento() {
        return fec_naciminiento;
    }

    /**
     * Asigna la fecha de nacimiento del donante
     * @param fec_naciminiento Fecha de Nacimiento
     */
    public void setFec_naciminiento(Date fec_naciminiento) {
        this.fec_naciminiento = fec_naciminiento;
    }

    /**
     * Obtiene la última fecha de donación del donante
     * @return Fecha de donación
     */
    public Date getFec_donacion() {
        return fec_donacion;
    }

    /**
     * Asigna la fecha de donación del donante
     * @param fec_donacion Fecha de donación
     */
    public void setFec_donacion(Date fec_donacion) {
        this.fec_donacion = fec_donacion;
    }

    /**
     * Obtiene las enfermedades del donante
     * @return Enfermedades del donante
     */
    public String getEnfermedades() {
        return enfermedades;
    }

    /**
     * Asigna las enfermedades al donates
     * @param enfermedades Enfermedades
     */
    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    /**
     * Obtiene los hábitos del donante
     * @return Hábitos del donante
     */
    public String getHabitos() {
        return habitos;
    }

    /**
     * Asigna los hábitos del donante
     * @param habitos Hábitos del donante
     */
    public void setHabitos(String habitos) {
        this.habitos = habitos;
    }

    /**
     * Obtiene el nombre del responsable del donante
     * @return Nombre del Responsable
     */
    public String getNombre_rep() {
        return nombre_rep;
    }

    /**
     * Asigna el nombre del responsable del donante
     * @param nombre_rep Nombre del responsable
     */
    public void setNombre_rep(String nombre_rep) {
        this.nombre_rep = nombre_rep;
    }

    /**
     * Obtiene el teléfono del responsable del donante
     * @return Teléfono del responsable
     */
    public long getTelefono_rep() {
        return telefono_rep;
    }

    /**
     * Asigna el teléfono del responsable del donante
     * @param telefono_rep Teléfono del responsable
     */
    public void setTelefono_rep(long telefono_rep) {
        this.telefono_rep = telefono_rep;
    }

    /**
     * Obtiene el género del donante
     * @return Género del donante
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Asigna un valor para el género del donante
     * @param genero Género del donante
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene el departamento del donantes
     * @return Departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Asigna un valor para el departamento del donante
     * @param departamento Departamento
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Obtiene el municipio del donante
     * @return Municipio Donante
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * Asigna un valo para el municipio del donante
     * @param municipio Municipio donante
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    
    
    
}
