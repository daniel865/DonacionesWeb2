/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donaciones.entities;

/**
 *
 * @author daniel
 */
public class Municipio {
    
    private int id;
    private int id_dep;
    private String nombre;

    public Municipio(int id, int id_dep, String nombre) {
        this.id = id;
        this.id_dep = id_dep;
        this.nombre = nombre;
    }

    public Municipio(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_dep() {
        return id_dep;
    }

    public void setId_dep(int id_dep) {
        this.id_dep = id_dep;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return "Municipio{" + "id=" + id + ", id_dep=" + id_dep + ", nombre=" + nombre + '}';
    }
    
}
