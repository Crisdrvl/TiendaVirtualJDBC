
package com.tiendavirtual.model;

public class Producto {

    private int idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private int idCategoria;
    private boolean activo;

    public Producto(int idProducto, String nombre, String descripcion,
                    double precio, int stock, int idCategoria, boolean activo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.idCategoria = idCategoria;
        this.activo = activo;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
