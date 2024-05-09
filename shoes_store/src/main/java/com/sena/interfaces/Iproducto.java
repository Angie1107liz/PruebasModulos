package com.sena.interfaces;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sena.model.productos;


@Repository
public interface Iproducto  extends CrudRepository <productos,String>{

            @Query("SELECT p FROM productors p WHERE"
            
            + "p.id_producto LIKE %?1% OR"
            + "p.nombre_producto LIKE %?1% OR "
			+ "p.descripcion LIKE %?1% OR "
			+ "p.cantidad LIKE %?1% OR "
			+ "p.precio_decimal LIKE %?1% OR "
			+ "p.porcentaje_iva LIKE %?1% OR "
			+ "p.porcentaje_descuento LIKE %?1% OR "
			+ "p.estado LIKE %?1% OR")

    
        List <productos> filtroProductos(String filtro);

        @Query ("SELECT p FROM cliente p  "
					+"WHERE  p.nombre_producto=?1  "
			
			
			)
			List<productos> filtroNombreProducto(String nombre_producto);

        default List<productos> filtroEstadoProducto(String estado) {
            List <productos> listaProductos=filtroProductos(estado);
            return listaProductos;
        }

}
// nos da funciones mas alla del crud, nos ayuda a filtrar, tambien nos permite buscar
    


    

