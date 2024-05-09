package com.sena.shoes_store.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sena.shoes_store.model.cliente;





@SuppressWarnings("unused")
@Repository
public interface Icliente {
      @Query("SELECT c FROM cliente c WHERE "
            + "c.id_cliente LIKE %?1% OR "
            + "c.tipo_documento LIKE %?1% OR "
            + "c.numero_documento LIKE %?1% OR "
            + "c.primer_nombre LIKE %?1% OR "
            + "c.segundo_nombre LIKE %?1% OR "
            + "c.primer_apellido LIKE %?1% OR "
            + "c.segundo_apellido LIKE %?1% OR "
            + "c.celular LIKE %?1% OR "
            + "c.direccion LIKE %?1% OR "
            + "c.ciudad LIKE %?1% OR "
            + "c.correo_electronico LIKE %?1% OR"
            + "c.estado LIKE %?1%")
    List<cliente> filtroCliente(String filtro); // More descriptive name

    @Query("SELECT c FROM cliente c WHERE c.primer_nombre = ?1")
    List<cliente> filtroNombreCliente(String primerNombre); // More descriptive name

    void save(Object cliente);

    List<cliente> findAll();

    Optional<cliente> findById(String id_cliente);
}


    
    

