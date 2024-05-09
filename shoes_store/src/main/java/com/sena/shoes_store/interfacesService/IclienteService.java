package com.sena.shoes_store.interfacesService;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sena.shoes_store.model.cliente;


@Service
public interface IclienteService {
    public String save (cliente cliente);
	public List<cliente>findAll();
	public List<cliente> filtroCliente(String filtro);
	public List<cliente> filtroNombreCliente(String primer_nombre);
    public List<cliente> filtroCiudadCliente(String ciudad);
    public List<cliente> filtroEstadoCliente(String estado);
	public Optional<cliente> findOne(String id);
	public int delete(String id);
}
// administra los datos del cliente 

