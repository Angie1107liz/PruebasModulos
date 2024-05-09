package com.sena.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.interfaces.Iproducto;
import com.sena.interfacesService.IproductoService.IproductosService;
import com.sena.model.productos;


@Service
public class productoservice implements IproductosService{
    
@Autowired
private Iproducto data;


@Override
public String save(productos productos) {
    data.save(productos);
    return productos.getId_producto();

}

@Override
public List<productos> findAll() {
    List <productos> listaProductos=
        (List<productos>) data.findAll();
    return listaProductos;
}

@Override
public List<productos> filtroProductos(String filtro) {
    List <productos> listaProductos = data.filtroProductos(filtro);
    return listaProductos;
}

@Override
public List<productos> filtroNombreProducto(String nombre_producto) {
    List <productos> listaProductos= data.filtroProductos(nombre_producto);
    return listaProductos;
}

@Override
public List<productos> filtroEstadoProducto(String estado) {
    List <productos> listaProductos=data.filtroProductos(estado);
    return listaProductos;
}

@Override
public Optional<productos> findOne(String id) {
    Optional<productos> productos=data.findById(id);
    return productos;
}

@Override
public int delete(String id_producto) {
    var productos=data.findById(id_producto).get();
    productos.setEstado("inactivo");
    data.save(productos);
    return 0;
}


    

}



