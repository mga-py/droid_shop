package com.jesusgonzalez.droidshop;

import java.util.Date;

/**
 * Created by Chusgome on 14/02/2018.
 */

public class Pedido {
    //Atributos
    private Integer id;
    private String codigoPedido;
    private int idEmpleadoEmpaqueta;
    private String empresaTransporte;
    private Date fechaPedido;
    private Date fechaEnvio;
    private Date fechaEnrega;
    private Date fechaPago;
    private int idFactura;
    private boolean facturado;
    private String metodoPago;
    private boolean activo;
    private int idUsuario;

    //Constructores
    public Pedido() {
    }

    public Pedido(Integer id, String codigoPedido, int idEmpleadoEmpaqueta, String empresaTransporte, Date fechaPedido, Date fechaEnvio, Date fechaEnrega, Date fechaPago, int idFactura, boolean facturado, String metodoPago, boolean activo, int idUsuario) {
        this.id = id;
        this.codigoPedido = codigoPedido;
        this.idEmpleadoEmpaqueta = idEmpleadoEmpaqueta;
        this.empresaTransporte = empresaTransporte;
        this.fechaPedido = fechaPedido;
        this.fechaEnvio = fechaEnvio;
        this.fechaEnrega = fechaEnrega;
        this.fechaPago = fechaPago;
        this.idFactura = idFactura;
        this.facturado = facturado;
        this.metodoPago = metodoPago;
        this.activo = activo;
        this.idUsuario = idUsuario;
    }

    //Getter and Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public int getIdEmpleadoEmpaqueta() {
        return idEmpleadoEmpaqueta;
    }

    public void setIdEmpleadoEmpaqueta(int idEmpleadoEmpaqueta) {
        this.idEmpleadoEmpaqueta = idEmpleadoEmpaqueta;
    }

    public String getEmpresaTransporte() {
        return empresaTransporte;
    }

    public void setEmpresaTransporte(String empresaTransporte) {
        this.empresaTransporte = empresaTransporte;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Date getFechaEnrega() {
        return fechaEnrega;
    }

    public void setFechaEnrega(Date fechaEnrega) {
        this.fechaEnrega = fechaEnrega;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public boolean isFacturado() {
        return facturado;
    }

    public void setFacturado(boolean facturado) {
        this.facturado = facturado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
