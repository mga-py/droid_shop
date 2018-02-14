package com.jesusgonzalez.droidshop;

/**
 * Created by administrador on 8/02/18.
 */

public class LineaPedido {
    //Atributos
    private Integer id;
    private String codLineaPedido;
    private int idPedido;
    private int idProducto;
    private String descripcion;
    private int unidades;
    private double iva;
    private double pvp;

    //Constructores
    public LineaPedido() {
    }

    public LineaPedido(Integer id, String codLineaPedido, int idPedido, int idProducto, String descripcion, int unidades, double iva, double pvp) {
        this.id = id;
        this.codLineaPedido = codLineaPedido;
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.unidades = unidades;
        this.iva = iva;
        this.pvp = pvp;
    }

    //Getter and Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodLineaPedido() {
        return codLineaPedido;
    }

    public void setCodLineaPedido(String codLineaPedido) {
        this.codLineaPedido = codLineaPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getPvp() {
        return pvp;
    }

    public void setPvp(double pvp) {
        this.pvp = pvp;
    }
}
