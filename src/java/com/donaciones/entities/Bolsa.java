package com.donaciones.entities;

import java.sql.Date;

/**
 * Clase encargda de crear las entidades de tipo Bolsa
 * @author Daniel Rúa Madrid
 * @version 1.0
 * @since 20/05/2014
 */
public class Bolsa {
    
    private String codigo;
    private String codigo_jornada;
    private String grupo_sanguineo;
    private String rh;
    private String fecha_donacion;
    private String fecha_vencimiento;
    private int cantidad_sangre;
    private String observaciones;
    private String estado;

    /**
     * Constructor de la entidad Bolsa
     * @param codigo Código de la bolsa de sangre
     * @param codigo_jornada  Código de la jornada de donación
     * @param grupo_sanguineo Grupo sanguineo de la bolsa de sangre
     * @param rh Tipo de RH 
     * @param fecha_donacion Fecha de donación de la bolsa de sangre
     * @param fecha_vencimiento Fecha de vencimiento de la bolsa de sangre
     * @param cantidad_sangre Cantidad de sangre de la bolsa
     * @param observaciones Observaciones de la bolsa de sangre
     * @param estado Estado de la bolsa de sangre
     */
    public Bolsa(String codigo, String codigo_jornada, String grupo_sanguineo, String rh, String fecha_donacion, String fecha_vencimiento, int cantidad_sangre, String observaciones, String estado) {
        this.codigo = codigo;
        this.codigo_jornada = codigo_jornada;
        this.grupo_sanguineo = grupo_sanguineo;
        this.rh = rh;
        this.fecha_donacion = fecha_donacion;
        this.fecha_vencimiento = fecha_vencimiento;
        this.cantidad_sangre = cantidad_sangre;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    

    /**
     * Retorna un valor del estado
     * @return Estado de la bolsa
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Asigna un valor al estado
     * @param estado Valor del estado de la bolsa
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Retorna el código de la bolsa de sangre.
     * @return Código de la bolsa
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Asigna un código a la bolsa
     * @param codigo Código de la bolsa
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna el código de la jornada de donación
     * @return Código de la jornada de donación
     */
    public String getCodigo_jornada() {
        return codigo_jornada;
    }

    /**
     * Asigna un valor al código de la jornada
     * @param codigo_jornada Código de la jornada
     */
    public void setCodigo_jornada(String codigo_jornada) {
        this.codigo_jornada = codigo_jornada;
    }

    /**
     * Retorna el grupo sanguineo de la bolsa de sangre
     * @return Grupo sanguineo de la bolsa de sangre
     */
    public String getGrupo_sanguineo() {
        return grupo_sanguineo;
    }

    /**
     * Asigna un grupo sanguineo a la bolsa de sangre
     * @param grupo_sanguineo Grupo Sanguineo de la bolsa de sangre
     */
    public void setGrupo_sanguineo(String grupo_sanguineo) {
        this.grupo_sanguineo = grupo_sanguineo;
    }

    /**
     * Retorna el RH de la bolsa de sangre
     * @return Rh de la bolsa
     */
    public String getRh() {
        return rh;
    }

    /**
     * Asigna un valor al RH de la bolsa
     * @param rh Rh de la bolsa
     */
    public void setRh(String rh) {
        this.rh = rh;
    }

    /**
     * Retorna la fecha de donacion
     * @return Fecha de donación de la bolsa
     */
    public String getFecha_donacion() {
        return fecha_donacion;
    }

    /**
     * Asigna un valor a la fecha de donación
     * @param fecha_donacion Feha de donación de la bolsa
     */
    public void setFecha_donacion(String fecha_donacion) {
        this.fecha_donacion = fecha_donacion;
    }

    /**
     * Retorna la fecha de vencimiento de la bolsa de sangre
     * @return Fecha de Vencimiento de la bolsa
     */
    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    /**
     * Asigna un valor a la fecha de vencimiento
     * @param fecha_vencimiento Fecha de Vencimiento de la bolsa
     */
    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    /**
     * Retorna la cantidad de sangre de la bolsa
     * @return Cantidad de Sangre
     */
    public int getCantidad_sangre() {
        return cantidad_sangre;
    }

    /**
     * Asigna una cantidad de sangre a la bolsa
     * @param cantidad_sangre Cantidad de Sangre
     */
    public void setCantidad_sangre(int cantidad_sangre) {
        this.cantidad_sangre = cantidad_sangre;
    }

    /**
     * Retorna las observaciones de la bolsa de sangre
     * @return Observaciones de la bolsa
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Asigna las observaciones a la bolsa de sangre
     * @param observaciones Observaciones de la bolsa
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Bolsa{" + "codigo=" + codigo + ", codigo_jornada=" + codigo_jornada + ", grupo_sanguineo=" + grupo_sanguineo + ", rh=" + rh + ", fecha_donacion=" + fecha_donacion + ", fecha_vencimiento=" + fecha_vencimiento + ", cantidad_sangre=" + cantidad_sangre + ", observaciones=" + observaciones + ", estado=" + estado + '}';
    }

    
    
}
