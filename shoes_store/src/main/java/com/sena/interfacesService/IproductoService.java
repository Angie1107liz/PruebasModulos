package com.sena.interfacesService;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sena.model.productos;


public interface IproductoService {



@Service
public interface IproductosService {
    
    public String save (productos productos);
	public List<productos>findAll();
	public List<productos> filtroProductos(String filtro);
	public List<productos> filtroNombreProducto(String nombre_producto);
    public List<productos> filtroEstadoProducto(String estado);
	public Optional<productos> findOne(String id);
	public int delete(String id);
}

public void save(Object producto);

public Object findAll();

public Object filtroProductos(String filtro);

public Object findOne(String id);

public int delete(String id_producto);

public List<productos> filtroNombreProducto(String nombre_producto);

}
