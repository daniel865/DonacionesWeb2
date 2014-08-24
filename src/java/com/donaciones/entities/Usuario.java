/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donaciones.entities;
/**
 *
 * @author Daniel
 */
public class Usuario {
    
    private String nro_Identificacion;
    private String nombres;
    private String apellido1;
    private String apellido2;
    private String usuario;
    private String correo;
    private String password;
    private String perfil;
    private String estado;

    public Usuario(String nro_Identificacion, String nombres, String apellido1, String apellido2, String usuario, String correo, String password, String perfil, String estado) {
        this.nro_Identificacion = nro_Identificacion;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.usuario = usuario;
        this.correo = correo;
        this.password = password;
        this.perfil = perfil;
        this.estado = estado;
    }

    public Usuario(String nro_Identificacion, String nombres, String apellido1, String usuario, String correo, String password, String perfil, String estado) {
        this.nro_Identificacion = nro_Identificacion;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.usuario = usuario;
        this.correo = correo;
        this.password = password;
        this.perfil = perfil;
        this.estado = estado;
    }
    
    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNro_Identificacion() {
        return nro_Identificacion;
    }

    public void setNro_Identificacion(String nro_Identificacion) {
        this.nro_Identificacion = nro_Identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    
    
}
