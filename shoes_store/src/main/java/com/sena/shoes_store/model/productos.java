package com.sena.shoes_store.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity (name="productos")

public class productos {
    @Id 
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_producto", nullable = false, length = 36)
	private String id_producto;

	@Column(name = "nombre_producto", nullable = false, length = 45)
	private String nombre_producto;

	@Column(name = "descripcion", nullable = false, length = 45)
	private String descripcion;
	
	
	@Column (name = "cantidad", nullable = false, length = 45)
	private String cantidad;
	
	@Column(name = "precio_decimal", nullable = true, length = 60)
	private String precio_decimal;
	
	@Column(name = "porcentaje_iva", nullable = true, length = 2)
	private String porcentaje_iva;
	
	@Column(name = "porcentaje_descuento", nullable = true, length = 2)
	private String porcentaje_descuento;
	
	@Column(name = "estado", nullable = false, length = 10)
	private String estado;
	
	
	public productos() {
		super();
	}


    public productos(String id_producto, String nombre_producto, String descripcion, String cantidad,
            String precio_decimal, String porcentaje_iva, String porcentaje_descuento, String estado) {

        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio_decimal = precio_decimal;
        this.porcentaje_iva = porcentaje_iva;
        this.porcentaje_descuento = porcentaje_descuento;
        this.estado = estado;
    }


    public String getId_producto() {
        return id_producto;
    }


    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }


    public String getNombre_producto() {
        return nombre_producto;
    }


    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getCantidad() {
        return cantidad;
    }


    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }


    public String getPrecio_decimal() {
        return precio_decimal;
    }


    public void setPrecio_decimal(String precio_decimal) {
        this.precio_decimal = precio_decimal;
    }


    public String getPorcentaje_iva() {
        return porcentaje_iva;
    }


    public void setPorcentaje_iva(String porcentaje_iva) {
        this.porcentaje_iva = porcentaje_iva;
    }


    public String getPorcentaje_descuento() {
        return porcentaje_descuento;
    }


    public void setPorcentaje_descuento(String porcentaje_descuento) {
        this.porcentaje_descuento = porcentaje_descuento;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

    
}