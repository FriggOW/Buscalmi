package com.browser.buscalmi;

public class Producto {

    private int id;
    private String nombre;
    private String precio;
    private String urlTienda;
    private String urlImagen;
    private String tienda;



    public Producto(String nombre1, String s, String url, String nombre, String precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(int id, String nombre, String precio, String urlTienda, String urlImagen, String tienda) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.urlTienda = urlTienda;
        this.urlImagen = urlImagen;
        this.tienda = tienda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getUrlTienda() {
        return urlTienda;
    }

    public void setUrlTienda(String urlTienda) {
        this.urlTienda = urlTienda;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }
}
