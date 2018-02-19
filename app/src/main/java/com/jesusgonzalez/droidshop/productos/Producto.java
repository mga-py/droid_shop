package com.jesusgonzalez.droidshop.productos;

/**
 * Created by Chusgome on 14/02/2018.
 */

public class Producto {
    //Atributos
    private Integer id;
    private String codigoProducto;
    private String descripcion;
    private int idProveedor;
    private double precioCoste;
    private double iva;
    private String codigoBarras;
    private int stockActual;
    private int stockMinimo;
    private int stockMaximo;
    private String rutaFoto;
    private boolean activo;

    //Constructores
    public Producto() {
    }

    public Producto(Integer id, String codigoProducto, String descripcion, int idProveedor, double precioCoste, double iva, String codigoBarras, int stockActual, int stockMinimo, int stockMaximo, String rutaFoto, boolean activo) {
        this.id = id;
        this.codigoProducto = codigoProducto;
        this.descripcion = descripcion;
        this.idProveedor = idProveedor;
        this.precioCoste = precioCoste;
        this.iva = iva;
        this.codigoBarras = codigoBarras;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.stockMaximo = stockMaximo;
        this.rutaFoto = rutaFoto;
        this.activo = activo;
    }

    //Getter and Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public double getPrecioCoste() {
        return precioCoste;
    }

    public void setPrecioCoste(double precioCoste) {
        this.precioCoste = precioCoste;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(int stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
