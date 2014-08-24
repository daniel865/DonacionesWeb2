/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donaciones.entities;

import java.sql.Date;

/**
 *
 * @author daniel
 */
public class Jornada {
    
    private String codigo;
    private String descripcion;
    private String fecha;
    private String departamento;
    private String municipio;
    private String direccion;
    private int cant_donantes;
    private int sangre_a1;
    private int sangre_a2;
    private int sangre_ab1;
    private int sangre_ab2;
    private int sangre_b1;
    private int sangre_b2;
    private int sangre_o1;
    private int sangre_o2;
    private String estado;
    private String observaciones;

    public Jornada(String codigo, String descripcion, String fecha, String departamento, String municipio, String direccion, int cant_donantes, int sangre_a1, int sangre_a2, int sangre_ab1, int sangre_ab2, int sangre_b1, int sangre_b2, int sangre_o1, int sangre_o2, String estado, String observaciones) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.departamento = departamento;
        this.municipio = municipio;
        this.direccion = direccion;
        this.cant_donantes = cant_donantes;
        this.sangre_a1 = sangre_a1;
        this.sangre_a2 = sangre_a2;
        this.sangre_ab1 = sangre_ab1;
        this.sangre_ab2 = sangre_ab2;
        this.sangre_b1 = sangre_b1;
        this.sangre_b2 = sangre_b2;
        this.sangre_o1 = sangre_o1;
        this.sangre_o2 = sangre_o2;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCant_donantes() {
        return cant_donantes;
    }

    public void setCant_donantes(int cant_donantes) {
        this.cant_donantes = cant_donantes;
    }

    public int getSangre_a1() {
        return sangre_a1;
    }

    public void setSangre_a1(int sangre_a1) {
        this.sangre_a1 = sangre_a1;
    }

    public int getSangre_a2() {
        return sangre_a2;
    }

    public void setSangre_a2(int sangre_a2) {
        this.sangre_a2 = sangre_a2;
    }

    public int getSangre_ab1() {
        return sangre_ab1;
    }

    public void setSangre_ab1(int sangre_ab1) {
        this.sangre_ab1 = sangre_ab1;
    }

    public int getSangre_ab2() {
        return sangre_ab2;
    }

    public void setSangre_ab2(int sangre_ab2) {
        this.sangre_ab2 = sangre_ab2;
    }

    public int getSangre_b1() {
        return sangre_b1;
    }

    public void setSangre_b1(int sangre_b1) {
        this.sangre_b1 = sangre_b1;
    }

    public int getSangre_b2() {
        return sangre_b2;
    }

    public void setSangre_b2(int sangre_b2) {
        this.sangre_b2 = sangre_b2;
    }

    public int getSangre_o1() {
        return sangre_o1;
    }

    public void setSangre_o1(int sangre_o1) {
        this.sangre_o1 = sangre_o1;
    }

    public int getSangre_o2() {
        return sangre_o2;
    }

    public void setSangre_o2(int sangre_o2) {
        this.sangre_o2 = sangre_o2;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    
}
