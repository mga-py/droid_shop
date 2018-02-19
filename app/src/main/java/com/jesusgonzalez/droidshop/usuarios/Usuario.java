package com.jesusgonzalez.droidshop.usuarios;

/**
 * Created by Chusgome on 14/02/2018.
 */

public class Usuario {
    //Atributos
    private Integer id;
    private String codigoCliente;
    private String nif;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String numeroCuenta;
    private String rol;
    private boolean activo;

    //Constructores
    public Usuario() {
    }

    public Usuario(Integer id, String codigoCliente, String nif, String nombre, String apellido1, String apellido2, String numeroCuenta, String rol, boolean activo) {
        this.id = id;
        this.codigoCliente = codigoCliente;
        this.nif = nif;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.numeroCuenta = numeroCuenta;
        this.rol = rol;
        this.activo = activo;
    }

    //Getter and Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
