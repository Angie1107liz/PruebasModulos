package com.sena.shoes_store.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.shoes_store.interfaces.Iproducto;
import com.sena.shoes_store.interfacesService.IproductoService;
import com.sena.shoes_store.model.productos;




@Service
public class productoservice implements IproductoService{
    
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

@Override
public void save(Object producto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'save'");
}


    

}



